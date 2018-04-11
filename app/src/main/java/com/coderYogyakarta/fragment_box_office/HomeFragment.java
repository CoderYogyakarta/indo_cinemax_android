package com.coderYogyakarta.fragment_box_office;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.coderYogyakarta.adapter_box_office.RecycleViewDataHomeAdapter;
import com.coderYogyakarta.adapter_box_office.SliderPagerHomeAdapter;
import com.coderYogyakarta.adapter_box_office.sliderImage.SliderIndicatorImageHome;
import com.coderYogyakarta.adapter_box_office.sliderImage.SliderView;
import com.coderYogyakarta.indo_cinemax_box_office.R;
import com.coderYogyakarta.model_box_office.SectionDataHomeModel;
import com.coderYogyakarta.model_box_office.SingleContentHomeModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class HomeFragment extends Fragment {


    @BindView(R.id.sliderHomeView)
    SliderView sliderViewHome;

    @BindView(R.id.pageContainerHome)
    LinearLayout pageContainerHome;

    @BindView(R.id.collapsing_homeboxOffice)
    CollapsingToolbarLayout collapsingToolbarLayout;

    @BindView(R.id.appbar)
    AppBarLayout appBarHome;

    @BindView(R.id.recycle_viewHomeBoxOffoce)
    RecyclerView recyclerViewHome;

    private SliderPagerHomeAdapter sliderPagerHomeAdapterAdapter;
    private SliderIndicatorImageHome sliderIndicatorImageHome;
    private ArrayList<SectionDataHomeModel> sectionDataHomeModels;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);
        sectionDataHomeModels=new ArrayList<>();
        initCollapsingToolbar(view);

        createDummyData();

        recyclerViewHome.setHasFixedSize(true);
        RecycleViewDataHomeAdapter homeAdapter=new RecycleViewDataHomeAdapter(sectionDataHomeModels,getActivity());
        recyclerViewHome.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        recyclerViewHome.setAdapter(homeAdapter);
        try {
            setupSlider();
        } catch (Exception e) {
            e.printStackTrace();
        }
//        dicoba
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

//image slider hom box office
    private void setupSlider() {
        sliderViewHome.setDurationScroll(1000);
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(ImageSliderHomeFragment.newInstance("http://www.menucool.com/slider/prod/image-slider-1.jpg"));
        fragments.add(ImageSliderHomeFragment.newInstance("http://www.menucool.com/slider/prod/image-slider-2.jpg"));
        fragments.add(ImageSliderHomeFragment.newInstance("http://www.menucool.com/slider/prod/image-slider-3.jpg"));
        fragments.add(ImageSliderHomeFragment.newInstance("http://www.menucool.com/slider/prod/image-slider-4.jpg"));

        sliderPagerHomeAdapterAdapter = new SliderPagerHomeAdapter(getFragmentManager(), fragments);
        sliderViewHome.setAdapter(sliderPagerHomeAdapterAdapter);
        sliderIndicatorImageHome = new SliderIndicatorImageHome(getActivity(),pageContainerHome,R.drawable.indicator_circle,sliderViewHome);
        sliderIndicatorImageHome.setPageCount(fragments.size());
        sliderIndicatorImageHome.show();

    }

// for content home
    private void createDummyData(){
        for (int i=1;i<=20;i++){
            SectionDataHomeModel dm=new SectionDataHomeModel();
            dm.setHeaderTitle("Section "+1);
            ArrayList<SingleContentHomeModel> singleContentHomeModels=new ArrayList<>();
            for (int j=1;j<=20;j++){
                singleContentHomeModels.add(new SingleContentHomeModel("item"+j,"Url"+j));
            }
            dm.setAllContentSection(singleContentHomeModels);
            sectionDataHomeModels.add(dm);
        }
    }


}
