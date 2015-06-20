package antoinechalifour.ovh.materialforecast.views.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import antoinechalifour.ovh.materialforecast.R;
import antoinechalifour.ovh.materialforecast.adapters.MainAdapter;

/**
 * Created by antoine on 20/06/15.
 */
public class MainFragment extends Fragment {
    private TabLayout mTabLayout;
    private ViewPager mFragmentPager;

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        mTabLayout = (TabLayout) view.findViewById(R.id.main_tablayout);
        mFragmentPager = (ViewPager) view.findViewById(R.id.main_viewpager);

        initTabs();

        return view;
    }

    private void initTabs() {
        MainAdapter adapter = new MainAdapter(getChildFragmentManager(), getActivity());
        mFragmentPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mFragmentPager);
    }
}
