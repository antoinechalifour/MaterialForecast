package antoinechalifour.ovh.materialforecast.network;

import com.squareup.okhttp.OkHttpClient;

import java.util.concurrent.TimeUnit;

/**
 * Created by antoine on 19/06/15.
 */
public class NetworkManager {
    public static final String TAG = NetworkManager.class.getSimpleName();
    public static final OkHttpClient HTTP_CLIENT = new OkHttpClient();
    public static final int CONNECT_TIMEOUT = 10;

    static {
        HTTP_CLIENT.setConnectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS);
    }
}
