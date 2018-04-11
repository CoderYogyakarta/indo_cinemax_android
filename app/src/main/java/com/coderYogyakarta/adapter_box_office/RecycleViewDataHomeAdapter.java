package com.coderYogyakarta.adapter_box_office;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.coderYogyakarta.indo_cinemax_box_office.R;
import com.coderYogyakarta.model_box_office.SectionDataHomeModel;
import com.github.rubensousa.gravitysnaphelper.GravitySnapHelper;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RecycleViewDataHomeAdapter extends RecyclerView.Adapter<RecycleViewDataHomeAdapter.ContentRowHolder> {

    private ArrayList<SectionDataHomeModel> sectionDataHomeModels;
    private Context mContext;
    private RecyclerView.RecycledViewPool mRecycledViewPool;
    private SnapHelper mSnapHelper;

    public RecycleViewDataHomeAdapter(ArrayList<SectionDataHomeModel> sectionDataHomeModels,
                                      Context mContext) {
        this.sectionDataHomeModels = sectionDataHomeModels;
        this.mContext = mContext;
        this.mRecycledViewPool = new RecyclerView.RecycledViewPool();
    }

    @Override
    public ContentRowHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_home, null);
        ContentRowHolder contentRowHolder = new ContentRowHolder(view);
        mSnapHelper = new GravitySnapHelper(Gravity.START);
        return contentRowHolder;
    }

    @Override
    public void onBindViewHolder(ContentRowHolder holder, int position) {
        final String sectionName = sectionDataHomeModels.get(position).getHeaderTitle();
        ArrayList singleSectionName = sectionDataHomeModels.get(position).getAllContentSection();
        holder.contentTitle.setText(sectionName);
        SectionListDataHomeAdapter adapter = new SectionListDataHomeAdapter(singleSectionName, mContext);
        holder.recyclerView.setHasFixedSize(true);
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL,
                false));
        holder.recyclerView.setAdapter(adapter);
        holder.recyclerView.setRecycledViewPool(mRecycledViewPool);
        holder.btnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Button More Clicked!" + sectionName, Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return (null != sectionDataHomeModels ? sectionDataHomeModels.size() : 0);
    }

    public class ContentRowHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.itemTitleHome)
        protected TextView contentTitle;

        @BindView(R.id.recycleViewListHome)
        protected RecyclerView recyclerView;

        @BindView(R.id.btnMoreHome)
        protected Button btnMore;


        public ContentRowHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }


    }
}
