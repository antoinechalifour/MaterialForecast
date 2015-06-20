package antoinechalifour.ovh.materialforecast.presenters;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import antoinechalifour.ovh.materialforecast.network.WeatherApi;
import antoinechalifour.ovh.materialforecast.services.ServiceHelper;
import antoinechalifour.ovh.materialforecast.views.MainView;
import antoinechalifour.ovh.materialforecast.views.fragments.MainFragment;
import antoinechalifour.ovh.materialforecast.views.fragments.RefreshingFragment;

/**
 * Created by antoine on 20/06/15.
 */
public class MainPresenter {
    public static final String TAG = MainPresenter.class.getSimpleName();
    private MainView mView;
    private Fragment mRefreshingFragment = new RefreshingFragment();
    private Fragment mMainFragment = new MainFragment();
    private Location mLastLocation;

    public MainPresenter(MainView view) {
        mView = view;

        Context context = mView.getContext();
        LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        mLastLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

        Bundle serviceExtras = new Bundle();
        ResultReceiver weatherReceiver = new WeatherResultReceiver(new Handler());
        serviceExtras.putParcelable("location", mLastLocation);
        serviceExtras.putParcelable("receiver", weatherReceiver);
        ServiceHelper.getInstance(context).startService(WeatherApi.TAG, serviceExtras);

        navigate(Fragments.MAIN);
    }

    private void navigate(Fragments which) {
        switch (which) {
            case REFRESHING:
                replaceFragment(mRefreshingFragment);
                break;
            case MAIN:
                replaceFragment(mMainFragment);
                break;
        }
    }

    private void replaceFragment(Fragment newFragment) {
        ((FragmentActivity) mView).getSupportFragmentManager()
                .beginTransaction()
                .replace(mView.getFragmentContainerId(), newFragment)
                .commit();
    }

    private enum Fragments {
        REFRESHING,
        MAIN
    }

    private class WeatherResultReceiver extends ResultReceiver {

        public WeatherResultReceiver(final Handler handler) {
            super(handler);
        }

        @Override
        protected void onReceiveResult(final int resultCode, final Bundle resultData) {
            Log.d(TAG, "gotResponse");
            String city = resultData.getString("city");
            String country = resultData.getString("country");
            double temp = resultData.getDouble("temp");

        }
    }
}
