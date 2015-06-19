package antoinechalifour.ovh.materialforecast.services;

import android.app.IntentService;
import android.content.Intent;

/**
 * Created by antoine on 19/06/15.
 */
public class WeatherService extends IntentService {
    public static final String TAG = WeatherService.class.getSimpleName();

    public WeatherService() {
        super(TAG);
    }

    @Override
    protected void onHandleIntent(Intent intent) {

    }
}
