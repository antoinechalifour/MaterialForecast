package antoinechalifour.ovh.materialforecast.views.activities;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import antoinechalifour.ovh.materialforecast.R;

/**
 * Created by antoine on 19/06/15.
 */
public class SplashActivity extends AppCompatActivity {
    private TextView mTitleForecast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mTitleForecast = (TextView) findViewById(R.id.splash_title_forecast);

        initTitles();
    }

    private void initTitles(){
        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/geoma.otf");
        mTitleForecast.setTypeface(tf);
    }
}
