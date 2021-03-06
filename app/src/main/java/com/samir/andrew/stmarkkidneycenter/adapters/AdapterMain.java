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
import com.samir.andrew.stmarkkidneycenter.activities.PatientActivity;
import com.samir.andrew.stmarkkidneycenter.models.PersonalData;
import com.samir.andrew.stmarkkidneycenter.singleton.SingletonKidneyCenter;

import java.util.List;


public class AdapterMain extends RecyclerView.Adapter<AdapterMain.MyViewHolder> {

    private List<PersonalData> adapterList;
    private Activity activity;


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvRvItemMain;

        public MyViewHolder(View view) {
            super(view);

            tvRvItemMain = view.findViewById(R.id.tvRvItemMain);

            tvRvItemMain.setOnClickListener(this);


        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.tvRvItemMain:

                    SingletonKidneyCenter.getInstance().setPersonId(adapterList.get(getAdapterPosition()).getId());
//                    activity.startActivity(new Intent(activity, PatientActivity.class));
                    Intent yourIntent = new Intent(activity, PatientActivity.class);
                    Bundle b = new Bundle();
                    b.putSerializable("user", adapterList.get(getAdapterPosition()));
                    yourIntent.putExtras(b); //pass bundle to your intent
                    activity.startActivity(yourIntent);

                    break;
            }
        }
    }

    public AdapterMain(List<PersonalData> adapterList, Activity activity) {
        this.adapterList = adapterList;
        this.activity = activity;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item_main, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {


        PersonalData personalData = adapterList.get(position);


        holder.tvRvItemMain.setText(personalData.getName());
    }

    @Override
    public int getItemCount() {
        return adapterList.size();
    }


    //region helper methods

    public void addItem(PersonalData item) {
        insertItem(item, adapterList.size());
        notifyDataSetChanged();
    }

    public void insertItem(PersonalData item, int position) {
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

    public void addAll(List<PersonalData> items) {
        clearAllListData();
        int startIndex = adapterList.size();
        adapterList.addAll(items);
        notifyItemRangeInserted(startIndex, items.size());
    }

    public List<PersonalData> getAllData() {
        return adapterList;
    }


    //endregion

}

