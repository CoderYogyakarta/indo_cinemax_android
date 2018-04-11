package com.coderYogyakarta.adapter_box_office.sliderImage;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.support.annotation.DimenRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;

public class SliderIndicatorImageHome implements ViewPager.OnPageChangeListener {

    private Context context;
    private LinearLayout container;
    private int drawable;
    private int spacing;
    private int size;
    private ViewPager viewPager;
    private int pageCount;
    private int minitialPage = 0;

    private int defaultSizeInDp = 12;
    private int defaultSpacingInDp = 12;


    public SliderIndicatorImageHome(@NonNull Context context,
                                    @NonNull LinearLayout containerView,
                                    @NonNull int drawable,
                                    @NonNull ViewPager viewPager) {

        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        } else if (containerView == null) {
            throw new IllegalArgumentException("containerView cannot be null");
        } else if (viewPager == null) {
            throw new IllegalArgumentException("ViewPager cannot be null");
        } else if (viewPager.getAdapter() == null) {
            throw new IllegalArgumentException("ViewPager does not have an adapter set on it");
        }

        this.context = context;
        this.container = containerView;
        this.drawable = drawable;
        this.viewPager = viewPager;
    }

    public void setDrawable(@DrawableRes int drawable) {
        this.drawable = drawable;
    }

    public void setSpacing(@DimenRes int spacing) {
        this.spacing = spacing;
    }

    public void setSize(@DimenRes int size) {
        this.size = size;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void setMinitialPage(int minitialPage) {
        this.minitialPage = minitialPage;
    }


    public void show() {
        initIndicator();
        setIndicatorAsSelected(minitialPage);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                viewPager.setCurrentItem(1);
            }
        }, 2500);
    }

    private void initIndicator() {
        if (container == null || pageCount <= 0) {
            return;
        }

        viewPager.addOnPageChangeListener(this);
        Resources res = context.getResources();
        container.removeAllViews();

        for (int i = 0; i < pageCount; i++) {
            View view = new View(context);
            int dimen = size != 0 ? res.getDimensionPixelOffset(size) : ((int) res.getDisplayMetrics().density * defaultSizeInDp);
            int margin = spacing != 0 ? res.getDimensionPixelOffset(spacing) : ((int) res.getDisplayMetrics().density * defaultSpacingInDp);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(dimen, dimen);
            lp.setMargins(i == 0 ? 0 : margin, 0, 0, 0);
            view.setLayoutParams(lp);
            view.setBackgroundResource(drawable);
            view.setSelected(i == 0);
            container.addView(view);
        }
    }

    private void setIndicatorAsSelected(int index) {
        if (container == null) {
            return;
        }
        for (int i = 0; i < container.getChildCount(); i++) {
            View view = container.getChildAt(i);
            view.setSelected(i == index);
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        int index = position % pageCount;
        setIndicatorAsSelected(index);
        final int moveTo = position + 1;
        try {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    viewPager.setCurrentItem(moveTo);
                }
            }, 2500);
        } catch (Exception e) {

        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    public void cleanup() {
        viewPager.clearOnPageChangeListeners();
    }
}
