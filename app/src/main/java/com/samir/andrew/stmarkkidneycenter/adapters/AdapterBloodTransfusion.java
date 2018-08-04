package com.samir.andrew.stmarkkidneycenter.adapters;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.samir.andrew.stmarkkidneycenter.R;
import com.samir.andrew.stmarkkidneycenter.models.ModelBloodTransfusion;

import java.util.List;


public class AdapterBloodTransfusion extends RecyclerView.Adapter<AdapterBloodTransfusion.MyViewHolder> {

    private List<ModelBloodTransfusion> adapterList;
    private Activity activity;


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvRvItemBloodTransfusionDate, tvRvItemBloodTransfusionBloodProduct,
                tvRvItemBloodTransfusionCauseOfTransfusion, tvRvItemBloodTransfusionComplications;

        public MyViewHolder(View view) {
            super(view);

            tvRvItemBloodTransfusionDate = view.findViewById(R.id.tvRvItemBloodTransfusionDate);
            tvRvItemBloodTransfusionBloodProduct = view.findViewById(R.id.tvRvItemBloodTransfusionBloodProduct);
            tvRvItemBloodTransfusionCauseOfTransfusion = view.findViewById(R.id.tvRvItemBloodTransfusionCauseOfTransfusion);
            tvRvItemBloodTransfusionComplications = view.findViewById(R.id.tvRvItemBloodTransfusionComplications);

//            tvRvItemMain.setOnClickListener(this);


        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {

            }
        }
    }

    public AdapterBloodTransfusion(List<ModelBloodTransfusion> adapterList, Activity activity) {
        this.adapterList = adapterList;
        this.activity = activity;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item_blood_transfusion, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        ModelBloodTransfusion modelBloodTransfusion = adapterList.get(position);

        holder.tvRvItemBloodTransfusionDate.setText(modelBloodTransfusion.getDate());
        holder.tvRvItemBloodTransfusionBloodProduct.setText(modelBloodTransfusion.getBloodProduct());
        holder.tvRvItemBloodTransfusionCauseOfTransfusion.setText(modelBloodTransfusion.getCauseOfTransfusion());
        holder.tvRvItemBloodTransfusionComplications.setText(modelBloodTransfusion.getCauseOfTransfusion());
    }

    @Override
    public int getItemCount() {
        return adapterList.size();
    }


    //region helper methods

    public void addItem(ModelBloodTransfusion item) {
        insertItem(item, adapterList.size());
        notifyDataSetChanged();
    }

    public void insertItem(ModelBloodTransfusion item, int position) {
        adapterList.add(position, item);
        notifyItemInserted(position);
    }

    public void removeItem(int position) {
        adapterList.remove(position);
        notifyItemRemoved(position);
    }

    public void clearAllListData() {
        int size = adapterList.size();
        adapterList.clear();
        notifyItemRangeRemoved(0, size);
    }

    public void addAll(List<ModelBloodTransfusion> items) {
//        clearAllListData();
        int startIndex = adapterList.size();
        adapterList.addAll(items);
        notifyItemRangeInserted(startIndex, items.size());
    }

    public List<ModelBloodTransfusion> getAllData() {
        return adapterList;
    }


    //endregion

}

