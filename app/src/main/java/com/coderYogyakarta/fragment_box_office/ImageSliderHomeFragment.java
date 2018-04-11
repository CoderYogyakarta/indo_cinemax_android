package com.coderYogyakarta.fragment_box_office;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.coderYogyakarta.indo_cinemax_box_office.R;;import butterknife.BindView;
import butterknife.ButterKnife;


public class ImageSliderHomeFragment extends android.support.v4.app.Fragment {

    private static final String ARG_PARAM1="params";

    @BindView(R.id.imageSliderHome)
    ImageView imageSlideHome;

    private String imageUrls;
    public ImageSliderHomeFragment() {
        // Required empty public constructor
    }

    public static ImageSliderHomeFragment newInstance(String params){
        ImageSliderHomeFragment imageSliderHomeFragment =new ImageSliderHomeFragment();
        Bundle arga=new Bundle();
        arga.putString(ARG_PARAM1,params);
        imageSliderHomeFragment.setArguments(arga);
        return imageSliderHomeFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        imageUrls=getArguments().getString(ARG_PARAM1);
        View view= inflater.inflate(R.layout.fragment_image_slider_home, container, false);
        ButterKnife.bind(this,view);
        Glide.with(getActivity())
                .load(imageUrls)
                .placeholder(R.drawable.image_slider_1)
                .into(imageSlideHome);
        return view;

    }

}
