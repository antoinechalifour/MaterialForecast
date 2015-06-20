package antoinechalifour.ovh.materialforecast.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import antoinechalifour.ovh.materialforecast.R;
import antoinechalifour.ovh.materialforecast.views.fragments.PlaceFragment;
import antoinechalifour.ovh.materialforecast.views.fragments.SavedPlacesFragment;

/**
 * Created by antoine on 20/06/15.
 */
public class MainAdapter extends FragmentPagerAdapter {
    private Fragment[] mFragments = {
            new PlaceFragment(),
            new SavedPlacesFragment()
    };
    private Context mContext;

    public MainAdapter(final FragmentManager fm, Context context) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(final int position) {
        return mFragments[position];
    }

    @Override
    public int getCount() {
        return mFragments.length;
    }

    @Override
    public CharSequence getPageTitle(final int position) {
        switch (position) {
            case 0:
                return mContext.getResources().getString(R.string.fragment_place_title);
            case 1:
                return mContext.getResources().getString(R.string.fragment_saved_title);
            default:
                return "";
        }
    }
}
