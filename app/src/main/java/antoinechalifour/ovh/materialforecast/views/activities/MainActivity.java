package antoinechalifour.ovh.materialforecast.views.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import antoinechalifour.ovh.materialforecast.R;
import antoinechalifour.ovh.materialforecast.adapters.MainAdapter;
import antoinechalifour.ovh.materialforecast.presenters.MainPresenter;
import antoinechalifour.ovh.materialforecast.views.MainView;

/**
 * Created by antoine on 19/06/15.
 */
public class MainActivity extends AppCompatActivity implements MainView {
    private MainPresenter mPresenter;
    private TabLayout mTabLayout;
    private ViewPager mFragmentPager;
    private MainAdapter mMainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTabLayout = (TabLayout) findViewById(R.id.main_tablayout);
        mFragmentPager = (ViewPager) findViewById(R.id.main_viewpager);
        mPresenter = new MainPresenter(this);

        initTabs();
    }

    private void initTabs() {
        mMainAdapter = new MainAdapter(getSupportFragmentManager(), this);
        mFragmentPager.setAdapter(mMainAdapter);
        mTabLayout.setupWithViewPager(mFragmentPager);
    }

    @Override
    public Context getContext() {
        return this;
    }

}
