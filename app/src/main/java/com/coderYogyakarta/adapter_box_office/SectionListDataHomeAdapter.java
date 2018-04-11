package com.coderYogyakarta.adapter_box_office;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.coderYogyakarta.indo_cinemax_box_office.R;
import com.coderYogyakarta.model_box_office.SingleContentHomeModel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SectionListDataHomeAdapter extends RecyclerView.Adapter<SectionListDataHomeAdapter.SingleContentRowHolder> {

    private ArrayList<SingleContentHomeModel> contentModel;
    private Context mContext;

    public SectionListDataHomeAdapter(ArrayList<SingleContentHomeModel> contentModel, Context mContext) {
        this.contentModel = contentModel;
        this.mContext = mContext;
    }

    @Override
    public SingleContentRowHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_single_card_home, null);
        SingleContentRowHolder singleContentRowHolder = new SingleContentRowHolder(view);
        return singleContentRowHolder;
    }

    @Override
    public void onBindViewHolder(SingleContentRowHolder holder, int position) {
        SingleContentHomeModel singleContentHomeModel = contentModel.get(position);
        holder.tvTitle.setText(singleContentHomeModel.getNameFilm());
    }

    @Override
    public int getItemCount() {

        return (null != contentModel ? contentModel.size() : 0);
    }

    public class SingleContentRowHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvTitleSingleItemHome)
        protected TextView tvTitle;

        @BindView(R.id.itemSingleImageHome)
        protected ImageView contentImage;



        public SingleContentRowHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);


        }
//        @Nullable
//        @OnClick(R.id.btnMoreHome)
//        public void OnclickMore() {
//            Toast.makeText(itemView.getContext(), tvTitle.getText(), Toast.LENGTH_SHORT).show();
//        }

    }
}
