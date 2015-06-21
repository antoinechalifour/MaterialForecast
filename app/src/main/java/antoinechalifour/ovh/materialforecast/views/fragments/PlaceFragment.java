package antoinechalifour.ovh.materialforecast.views.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import antoinechalifour.ovh.materialforecast.R;
import antoinechalifour.ovh.materialforecast.models.City;
import antoinechalifour.ovh.materialforecast.presenters.PlacePresenter;
import antoinechalifour.ovh.materialforecast.views.PlaceView;

/**
 * Created by antoine on 20/06/15.
 */
public class PlaceFragment extends Fragment implements PlaceView {
    public static final String TAG = PlaceFragment.class.getSimpleName();
    private RelativeLayout mContainer;
    private ImageView mPlacePicture;
    private TextView mPlaceTemperature;
    private TextView mPlaceName;

    private LinearLayout mLoader;
    private TextView mLoaderMessage;
    private ProgressBar mLoaderBar;

    private PlacePresenter mPresenter;

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_place, container, false);
        mContainer = (RelativeLayout) view.findViewById(R.id.place_container);
        mPlacePicture = (ImageView) view.findViewById(R.id.place_photo);
        mPlaceTemperature = (TextView) view.findViewById(R.id.place_temperature);
        mPlaceName = (TextView) view.findViewById(R.id.place_name);

        mLoader = (LinearLayout) view.findViewById(R.id.place_loader);
        mLoaderMessage = (TextView) view.findViewById(R.id.loading_message);
        mLoaderBar = (ProgressBar) view.findViewById(R.id.loading_loader);

        mLoaderMessage.setText("TEST");

        mPresenter = new PlacePresenter(this);

        return view;
    }

    @Override
    public Context getContext() {
        return getActivity();
    }

    @Override
    public void showLoading() {
        mContainer.setVisibility(View.INVISIBLE);
        mLoader.setVisibility(View.VISIBLE);
    }

    @Override
    public void showCity(final City city) {
        mPlaceTemperature.setText(city.getTemp() + "°");
        mPlaceName.setText(city.getName() + ", " + city.getCountry());

        mLoader.setVisibility(View.INVISIBLE);
        mContainer.setVisibility(View.VISIBLE);
    }
}
