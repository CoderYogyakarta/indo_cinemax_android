package com.coderYogyakarta.adapter_box_office;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 24/03/2018.
 */

public class HomeTabAdapeter extends FragmentPagerAdapter {
    private final List<Fragment> mFragmentList=new ArrayList<>();
    private final List<String> mFragmenTitletList=new ArrayList<>();

    public HomeTabAdapeter(FragmentManager fm) {
        super(fm);
    }

    public void addFragment(Fragment fragment,String title) {
        mFragmentList.add(fragment);
        mFragmenTitletList.add(title);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmenTitletList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }
}
