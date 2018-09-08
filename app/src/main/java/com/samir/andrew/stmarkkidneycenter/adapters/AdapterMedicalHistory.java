package com.samir.andrew.stmarkkidneycenter.adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.samir.andrew.stmarkkidneycenter.R;
import com.samir.andrew.stmarkkidneycenter.models.ModelMedicalHistory;

import java.util.List;


public class AdapterMedicalHistory extends RecyclerView.Adapter<AdapterMedicalHistory.MyViewHolder> {

    private List<ModelMedicalHistory> adapterList;
    private Activity activity;


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView rvItemMedicalHistory;

        public MyViewHolder(View view) {
            super(view);

            rvItemMedicalHistory = view.findViewById(R.id.rvItemMedicalHistory);

           // tvRvItemMain.setOnClickListener(this);


        }

        @Override
        public void onClick(View v) {
            /*switch (v.getId()) {
                case R.id.tvRvItemMain:

                    SingletonKidneyCenter.getInstance().setPersonId(adapterList.get(getAdapterPosition()).getId());
//                    activity.startActivity(new Intent(activity, PatientActivity.class));
                    Intent yourIntent = new Intent(activity, PatientActivity.class);
                    Bundle b = new Bundle();
                    b.putSerializable("user", adapterList.get(getAdapterPosition()));
                    yourIntent.putExtras(b); //pass bundle to your intent
                    activity.startActivity(yourIntent);

                    break;
            }*/
        }
    }

    public AdapterMedicalHistory(List<ModelMedicalHistory> adapterList, Activity activity) {
        this.adapterList = adapterList;
        this.activity = activity;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item_medical_history, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {


        ModelMedicalHistory modelMedicalHistory = adapterList.get(position);


        holder.rvItemMedicalHistory.setText(modelMedicalHistory.getHTN());
    }

    @Override
    public int getItemCount() {
        return adapterList.size();
    }


    //region helper methods

    public void addItem(ModelMedicalHistory item) {
        insertItem(item, adapterList.size());
        notifyDataSetChanged();
    }

    public void insertItem(ModelMedicalHistory item, int position) {
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

    public void addAll(List<ModelMedicalHistory> items) {
        clearAllListData();
        int startIndex = adapterList.size();
        adapterList.addAll(items);
        notifyItemRangeInserted(startIndex, items.size());
    }

    public List<ModelMedicalHistory> getAllData() {
        return adapterList;
    }


    //endregion

}

