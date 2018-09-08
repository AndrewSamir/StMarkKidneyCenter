package com.samir.andrew.stmarkkidneycenter.activities;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.samir.andrew.stmarkkidneycenter.FirebaseHandler.HandleGetDataFromFirebase;
import com.samir.andrew.stmarkkidneycenter.R;
import com.samir.andrew.stmarkkidneycenter.adapters.AdapterBlood;
import com.samir.andrew.stmarkkidneycenter.interfaces.InterfaceGetDataFromFirebase;
import com.samir.andrew.stmarkkidneycenter.models.ModelBloodTransfusion;
import com.samir.andrew.stmarkkidneycenter.singleton.SingletonKidneyCenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BloodTransfusionActivity extends BaseActivity implements InterfaceGetDataFromFirebase {

    //region fields

    List<ModelBloodTransfusion> modelBloodTransfusionList;
    AdapterBlood adapterBloodTransfusion;
    //endregion

    //region views

    @BindView(R.id.rvBloodTransfusion)
    RecyclerView rvBloodTransfusion;
    //endregion

    //region life cycle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_transfusion);
        getActionBar().setDisplayHomeAsUpEnabled(true);

        ButterKnife.bind(this);
        modelBloodTransfusionList = new ArrayList<>();
        adapterBloodTransfusion = new AdapterBlood(modelBloodTransfusionList, this);
        rvBloodTransfusion.setLayoutManager(new GridLayoutManager(this, 1));
rvBloodTransfusion.setAdapter(adapterBloodTransfusion);
        HandleGetDataFromFirebase.getInstance(this).setGetDataFromFirebaseInterface(this);

        DatabaseReference myRefData = myRef.child("patients")
                .child(SingletonKidneyCenter.getInstance().getPersonId())
                .child("bloodTransfusion");

        HandleGetDataFromFirebase.getInstance(this).callGet("test", myRefData);

    }

    @Override
    public void onGetDataFromFirebase(DataSnapshot dataSnapshot, String flag) {
        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
            ModelBloodTransfusion modelBloodTransfusion = snapshot.getValue(ModelBloodTransfusion.class);
            modelBloodTransfusion.setId(snapshot.getKey());
            adapterBloodTransfusion.addItem(modelBloodTransfusion);
        }
//            adapterBloodTransfusion.addAll(modelBloodTransfusionList);
    }

    //endregion

}
