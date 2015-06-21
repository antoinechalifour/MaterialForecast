package antoinechalifour.ovh.materialforecast.services;

import android.app.IntentService;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.os.ResultReceiver;

import com.squareup.okhttp.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import antoinechalifour.ovh.materialforecast.models.City;
import antoinechalifour.ovh.materialforecast.network.WeatherApi;

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
        Location location = intent.getParcelableExtra("location");
        ResultReceiver receiver = intent.getParcelableExtra("receiver");

        try {
            Response response = WeatherApi.getWeather(location.getLatitude(), location.getLongitude());
            Bundle result = new Bundle();

            JSONObject jsonResponse = new JSONObject(response.body().string());
            JSONObject jsonMain = jsonResponse.getJSONObject("main");
            String country = jsonResponse.getJSONObject("sys").getString("country");
            String name = jsonResponse.getString("name");
            double temp = jsonMain.getDouble("temp");
            double tempMin = jsonMain.getDouble("temp_min");
            double tempMax = jsonMain.getDouble("temp_max");

            int celcius = (int) (temp - 272.15);

            City city = new City(name, country, celcius);

            result.putParcelable("city", city);

            receiver.send(response.code(), result);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
