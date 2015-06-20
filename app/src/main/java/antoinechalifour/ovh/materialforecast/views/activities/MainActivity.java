package antoinechalifour.ovh.materialforecast.views.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import antoinechalifour.ovh.materialforecast.R;
import antoinechalifour.ovh.materialforecast.presenters.MainPresenter;
import antoinechalifour.ovh.materialforecast.views.MainView;

/**
 * Created by antoine on 19/06/15.
 */
public class MainActivity extends AppCompatActivity implements MainView {
    private FrameLayout mFragmentContainer;
    private MainPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFragmentContainer = (FrameLayout) findViewById(R.id.main_fragmentContainer);
        mPresenter = new MainPresenter(this);
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public int getFragmentContainerId() {
        return mFragmentContainer.getId();
    }
}
