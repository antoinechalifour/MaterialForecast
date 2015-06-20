package antoinechalifour.ovh.materialforecast.views.activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import antoinechalifour.ovh.materialforecast.R;
import antoinechalifour.ovh.materialforecast.adapters.MainAdapter;

/**
 * Created by antoine on 19/06/15.
 */
public class MainActivity extends AppCompatActivity {
    private TabLayout mTabLayout;
    private Toolbar mToolbar;
    private ViewPager mFragmentPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTabLayout = (TabLayout) findViewById(R.id.main_tablayout);
        mToolbar = (Toolbar) findViewById(R.id.main_toolbar);
        mFragmentPager = (ViewPager) findViewById(R.id.main_fragmentContainer);

        initToolbar();
        initTabs();
    }

    private void initToolbar() {
        mToolbar.setTitle(R.string.app_name);
    }

    private void initTabs() {
        MainAdapter adapter = new MainAdapter(getSupportFragmentManager(), this);
        mFragmentPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mFragmentPager);
    }
}
