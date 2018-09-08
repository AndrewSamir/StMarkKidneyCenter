package com.samir.andrew.stmarkkidneycenter.activities;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.samir.andrew.stmarkkidneycenter.FirebaseHandler.HandleGetDataFromFirebase;
import com.samir.andrew.stmarkkidneycenter.R;
import com.samir.andrew.stmarkkidneycenter.adapters.AdapterMedicalHistory;
import com.samir.andrew.stmarkkidneycenter.interfaces.InterfaceGetDataFromFirebase;
import com.samir.andrew.stmarkkidneycenter.models.ModelMedicalHistory;
import com.samir.andrew.stmarkkidneycenter.singleton.SingletonKidneyCenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MedicalHistoryActivity extends BaseActivity implements InterfaceGetDataFromFirebase {

    //region fields

    List<ModelMedicalHistory> modelMedicalHistoryList;
    AdapterMedicalHistory adapterMedicalHistory;

    //endregion

    //region views
    @BindView(R.id.rvMedicalHistory)
    RecyclerView rvMedicalHistory;

    //endregion
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical_history);
        getActionBar().setDisplayHomeAsUpEnabled(true);

        ButterKnife.bind(this);

        HandleGetDataFromFirebase.getInstance(this).setGetDataFromFirebaseInterface(this);
//        getBaseActivity();
        DatabaseReference myRefData = myRef.child("patients")
                .child(SingletonKidneyCenter.getInstance().getPersonId())
                .child("medicalHistory");

        HandleGetDataFromFirebase.getInstance(this).callGet("test", myRefData);

        modelMedicalHistoryList = new ArrayList<>();
        adapterMedicalHistory = new AdapterMedicalHistory(modelMedicalHistoryList, this);
        rvMedicalHistory.setLayoutManager(new GridLayoutManager(this, 1));
        rvMedicalHistory.setAdapter(adapterMedicalHistory);
    }

    //region calls
    @Override
    public void onGetDataFromFirebase(DataSnapshot dataSnapshot, String flag) {
            ModelMedicalHistory modelMedicalHistory = dataSnapshot.getValue(ModelMedicalHistory.class);
            adapterMedicalHistory.addItem(modelMedicalHistory);

    }

    //endregion

}
