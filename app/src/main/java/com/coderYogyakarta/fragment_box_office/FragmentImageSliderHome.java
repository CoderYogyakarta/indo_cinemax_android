package com.coderYogyakarta.fragment_box_office;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.coderYogyakarta.indo_cinemax_box_office.R;;


public class FragmentImageSliderHome extends Fragment {


    public FragmentImageSliderHome() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_image_slider_home, container, false);
    }

}
