package com.coderYogyakarta.fragment_box_office;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.coderYogyakarta.indo_cinemax_box_office.R;


public class A_zListFragment extends Fragment {

    public A_zListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_a_z_list, container, false);
    }

}
