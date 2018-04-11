package com.coderYogyakarta.adapter_box_office;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;


import com.coderYogyakarta.fragment_box_office.ImageSliderHomeFragment;

import java.util.ArrayList;
import java.util.List;

public class SliderPagerHomeAdapter extends FragmentStatePagerAdapter {

    private static final String TAG = "SliderPagerHomeAdapter";
    List<Fragment> fragments = new ArrayList<>();

    public SliderPagerHomeAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        int index = position % fragments.size();

        return ImageSliderHomeFragment.newInstance(fragments.get(index).getArguments()
        .getString("params"));
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }
}
