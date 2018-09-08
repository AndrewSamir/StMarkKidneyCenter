package com.samir.andrew.stmarkkidneycenter.adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.samir.andrew.stmarkkidneycenter.R;
import com.samir.andrew.stmarkkidneycenter.models.ModelDateWithText;

import java.util.List;


public class AdapterViralState extends RecyclerView.Adapter<AdapterViralState.MyViewHolder> {

    private List<ModelDateWithText> adapterList;
    private Activity activity;


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView rvItemDate,rvItemText;

        public MyViewHolder(View view) {
            super(view);

            rvItemDate = view.findViewById(R.id.rvItemDate);
            rvItemText = view.findViewById(R.id.rvItemText);

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

    public AdapterViralState(List<ModelDateWithText> adapterList, Activity activity) {
        this.adapterList = adapterList;
        this.activity = activity;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item_data_text, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {


        ModelDateWithText modelDateWithText = adapterList.get(position);


        holder.rvItemDate.setText(modelDateWithText.getDate());
        holder.rvItemText.setText(modelDateWithText.getTxt());
    }

    @Override
    public int getItemCount() {
        return adapterList.size();
    }


    //region helper methods

    public void addItem(ModelDateWithText item) {
        adapterList.add(item);
        notifyDataSetChanged();
    }

    public void insertItem(ModelDateWithText item, int position) {
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

    public void addAll(List<ModelDateWithText> items) {
        clearAllListData();
        int startIndex = adapterList.size();
        adapterList.addAll(items);
        notifyItemRangeInserted(startIndex, items.size());
    }

    public List<ModelDateWithText> getAllData() {
        return adapterList;
    }


    //endregion

}

