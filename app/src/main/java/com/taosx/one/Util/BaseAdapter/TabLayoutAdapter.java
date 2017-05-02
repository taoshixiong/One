package com.taosx.one.Util.BaseAdapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by TAO_SX on 2017/4/27/027.
 */

public class TabLayoutAdapter  extends FragmentPagerAdapter {

    private List<Fragment> mFragments;
    private String[] titles;
    private FragmentManager fragmentManager;

    public TabLayoutAdapter(FragmentManager fm) {
        super(fm);
    }
    public TabLayoutAdapter(FragmentManager fm,String[] titles, List<Fragment> fragments) {
        super(fm);
        fragmentManager = fm;
        this.titles = titles;
        this.mFragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        for(int i=0;i<mFragments.size();i++) {
            fragmentManager.beginTransaction().hide(mFragments.get(i));
            fragmentManager.beginTransaction().commit();
        }

        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments == null ? 0 : mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

}
