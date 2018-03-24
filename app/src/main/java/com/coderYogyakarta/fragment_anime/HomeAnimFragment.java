package com.coderYogyakarta.fragment_anime;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.coderYogyakarta.indo_cinemax_box_office.R;


public class HomeAnimFragment extends Fragment {

    public HomeAnimFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_anim, container, false);
    }

}
