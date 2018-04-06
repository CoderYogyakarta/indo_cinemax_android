package com.coderYogyakarta.fragment_box_office;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.coderYogyakarta.indo_cinemax_box_office.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class HomeFragment extends Fragment {


    @BindView(R.id.collapsing_homeboxOffice)
    CollapsingToolbarLayout collapsingToolbarLayout;

    @BindView(R.id.appbar)
    AppBarLayout appBarHome;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this,view);
        initCollapsingToolbar(view);
        try {
         //   Glide.with(this).load(R.drawable.cover).into(imageBackdrop);
        }catch (Exception e){
            e.printStackTrace();
        }

        return view;
    }


    private void initCollapsingToolbar(View view) {
        collapsingToolbarLayout.setTitle(" ");
        appBarHome.setExpanded(true);

// hiding & showing the title when toolbar expanded & collapsed
        appBarHome.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbarLayout.setVisibility(View.VISIBLE);
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbarLayout.setTitle(" ");
                    isShow = false;
                }
            }
        });
    }


}
