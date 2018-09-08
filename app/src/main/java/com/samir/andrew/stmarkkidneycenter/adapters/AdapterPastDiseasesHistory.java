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


public class AdapterPastDiseasesHistory extends RecyclerView.Adapter<AdapterPastDiseasesHistory.MyViewHolder> {

    private List<String> adapterList;
    private Activity activity;


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView rvItemFreeText;

        public MyViewHolder(View view) {
            super(view);

            rvItemFreeText = view.findViewById(R.id.rvItemFreeText);

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

    public AdapterPastDiseasesHistory(List<String> adapterList, Activity activity) {
        this.adapterList = adapterList;
        this.activity = activity;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item_free_text, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {


        String textToShow = adapterList.get(position);


        holder.rvItemFreeText.setText(textToShow);
    }

    @Override
    public int getItemCount() {
        return adapterList.size();
    }


    //region helper methods

    public void addItem(String item) {
        adapterList.add(item);
        notifyDataSetChanged();
    }

    public void insertItem(String item, int position) {
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

    public void addAll(List<String> items) {
        clearAllListData();
        int startIndex = adapterList.size();
        adapterList.addAll(items);
        notifyItemRangeInserted(startIndex, items.size());
    }

    public List<String> getAllData() {
        return adapterList;
    }


    //endregion

}

