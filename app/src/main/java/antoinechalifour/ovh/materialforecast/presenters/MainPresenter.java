package antoinechalifour.ovh.materialforecast.presenters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import antoinechalifour.ovh.materialforecast.views.MainView;
import antoinechalifour.ovh.materialforecast.views.fragments.MainFragment;
import antoinechalifour.ovh.materialforecast.views.fragments.RefreshingFragment;

/**
 * Created by antoine on 20/06/15.
 */
public class MainPresenter {
    private MainView mView;
    private Fragment mRefreshingFragment = new RefreshingFragment();
    private Fragment mMainFragment = new MainFragment();

    public MainPresenter(MainView view) {
        mView = view;
        navigate(Fragments.MAIN);
    }

    private void navigate(Fragments which) {
        switch (which) {
            case REFRESHING:
                replaceFragment(mRefreshingFragment);
                break;
            case MAIN:
                replaceFragment(mMainFragment);
                break;
        }
    }

    private void replaceFragment(Fragment newFragment) {
        ((FragmentActivity) mView).getSupportFragmentManager()
                .beginTransaction()
                .replace(mView.getFragmentContainerId(), newFragment)
                .commit();
    }

    private enum Fragments {
        REFRESHING,
        MAIN
    }
}
