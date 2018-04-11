package com.coderYogyakarta.fragment_anime;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.coderYogyakarta.indo_cinemax_box_office.R;


public class ImageSliderHomeAnimeFragment extends Fragment {


    public ImageSliderHomeAnimeFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_image_slider_home_anime, container, false);
    }

}
