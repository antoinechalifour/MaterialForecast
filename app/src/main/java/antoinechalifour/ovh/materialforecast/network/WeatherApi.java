package antoinechalifour.ovh.materialforecast.network;

import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * Created by antoine on 19/06/15.
 */
public class WeatherApi {
    public static final String TAG = WeatherApi.class.getSimpleName();
    public static final String SERVER_URI = "http://api.openweathermap.org/data/2.5/";
    public static final String WEATHER_SUFFIX = "weather";
    public static final String FORECAST_SUFFIX = "forecast";


    public Response getWeather(final int lat, final int lon) throws IOException {
        String q = "?lat=" + lat + "&lon=" + lon;
        final Request request = new Request.Builder().url(SERVER_URI + WEATHER_SUFFIX + q).build();

        return NetworkManager.HTTP_CLIENT.newCall(request).execute();
    }

    public Response getForecast(int lat, int lon) throws IOException {
        String q = "?lat" + lat + "&lon=" + lon;
        final Request request = new Request.Builder().url(SERVER_URI + FORECAST_SUFFIX + q).build();

        return NetworkManager.HTTP_CLIENT.newCall(request).execute();
    }
}
