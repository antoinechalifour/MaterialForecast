package antoinechalifour.ovh.materialforecast.presenters;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.util.Log;

import antoinechalifour.ovh.materialforecast.models.City;
import antoinechalifour.ovh.materialforecast.network.WeatherApi;
import antoinechalifour.ovh.materialforecast.services.ServiceHelper;
import antoinechalifour.ovh.materialforecast.views.PlaceView;

/**
 * Created by antoine on 21/06/15.
 */
public class PlacePresenter {
    public static final String TAG = PlacePresenter.class.getSimpleName();
    private PlaceView mView;
    private Location mLastLocation;

    public PlacePresenter(PlaceView view) {
        mView = view;

        initLocation();
    }

    private void initLocation() {
        Context context = mView.getContext();
        LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        mLastLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

        Bundle serviceExtras = new Bundle();
        ResultReceiver weatherReceiver = new WeatherResultReceiver(new Handler());
        serviceExtras.putParcelable("location", mLastLocation);
        serviceExtras.putParcelable("receiver", weatherReceiver);
        ServiceHelper.getInstance(context).startService(WeatherApi.TAG, serviceExtras);
    }

    private class WeatherResultReceiver extends ResultReceiver {

        public WeatherResultReceiver(final Handler handler) {
            super(handler);
        }

        @Override
        protected void onReceiveResult(final int resultCode, final Bundle resultData) {
            Log.d(TAG, "gotResponse");
            City city = resultData.getParcelable("city");
            mView.showCity(city);
        }
    }
}
