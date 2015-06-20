package antoinechalifour.ovh.materialforecast.views.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import antoinechalifour.ovh.materialforecast.R;

/**
 * Created by antoine on 20/06/15.
 */
public class PlaceFragment extends Fragment {
    private ImageView mPlacePicture;
    private TextView mPlaceTemperature;
    private TextView mPlaceName;

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_place, container, false);
        mPlacePicture = (ImageView) view.findViewById(R.id.place_photo);
        mPlaceTemperature = (TextView) view.findViewById(R.id.place_temperature);
        mPlaceName = (TextView) view.findViewById(R.id.place_name);

        return view;
    }
}
