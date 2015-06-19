package antoinechalifour.ovh.materialforecast.services;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by antoine on 19/06/15.
 */
public class ServiceHelper {
    public static final String TAG = ServiceHelper.class.getSimpleName();
    private Context mContext;
    private static ServiceHelper mInstance = null;

    private ServiceHelper(final Context context) {
        mContext = context;
    }

    public static ServiceHelper getInstance(final Context context) {
        if (mInstance == null) {
            mInstance = new ServiceHelper(context);
        }
        return mInstance;
    }

    public boolean startService(String action) {
        return startService(action, null);
    }

    public boolean startService(String action, Bundle extras) {
        Log.d(TAG, "starting new service : " + action);
        Intent intent = null;
        if (action.equals(Actions.ACTION_WEATHER)) {
            intent = new Intent(mContext, WeatherService.class);
        }

        mContext.startService(intent);
        return true;
    }

    public enum Actions {
        ACTION_WEATHER,
        ACTION_PHOTO
    }
}
