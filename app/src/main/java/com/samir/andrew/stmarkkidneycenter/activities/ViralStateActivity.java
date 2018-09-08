package com.samir.andrew.stmarkkidneycenter.activities;

import android.os.Bundle;
import android.app.Activity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.samir.andrew.stmarkkidneycenter.FirebaseHandler.HandleGetDataFromFirebase;
import com.samir.andrew.stmarkkidneycenter.R;
import com.samir.andrew.stmarkkidneycenter.adapters.AdapterPastDiseasesHistory;
import com.samir.andrew.stmarkkidneycenter.adapters.AdapterViralState;
import com.samir.andrew.stmarkkidneycenter.interfaces.InterfaceGetDataFromFirebase;
import com.samir.andrew.stmarkkidneycenter.models.ModelDateWithText;
import com.samir.andrew.stmarkkidneycenter.singleton.SingletonKidneyCenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ViralStateActivity extends BaseActivity implements InterfaceGetDataFromFirebase {

    //region fields

    List<ModelDateWithText> stringListHBsAg;
    AdapterViralState adapterViralStateHBsAg;
    List<ModelDateWithText> stringListHCV;
    AdapterViralState adapterViralStateHCV;
    List<ModelDateWithText> stringListHIV;
    AdapterViralState adapterViralStateHIV;
    List<ModelDateWithText> stringListPCRHCV;
    AdapterViralState adapterViralStatePCRHCV;

    //endregion

    //region views
    @BindView(R.id.rvViralStateHbsag)
    RecyclerView rvViralStateHbsag;
    @BindView(R.id.rvViralStatePCRHCV)
    RecyclerView rvViralStatePCRHCV;
    @BindView(R.id.rvViralStateHIV)
    RecyclerView rvViralStateHIV;
    @BindView(R.id.rvViralStateHCV)
    RecyclerView rvViralStateHCV;

    //endregion
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viral_state);
        getActionBar().setDisplayHomeAsUpEnabled(true);


        ButterKnife.bind(this);

        HandleGetDataFromFirebase.getInstance(this).setGetDataFromFirebaseInterface(this);
//        getBaseActivity();
        DatabaseReference myRefData = myRef.child("patients")
                .child(SingletonKidneyCenter.getInstance().getPersonId())
                .child("viralState");

        HandleGetDataFromFirebase.getInstance(this).callGet("test", myRefData);

        stringListHBsAg = new ArrayList<>();
        adapterViralStateHBsAg = new AdapterViralState(stringListHBsAg, this);
        rvViralStateHbsag.setLayoutManager(new GridLayoutManager(this, 1));
        rvViralStateHbsag.setAdapter(adapterViralStateHBsAg);
        rvViralStateHbsag.setNestedScrollingEnabled(false);

        stringListHCV = new ArrayList<>();
        adapterViralStateHCV = new AdapterViralState(stringListHCV, this);
        rvViralStateHCV.setLayoutManager(new GridLayoutManager(this, 1));
        rvViralStateHCV.setAdapter(adapterViralStateHCV);
        rvViralStateHCV.setNestedScrollingEnabled(false);

        stringListHIV = new ArrayList<>();
        adapterViralStateHIV = new AdapterViralState(stringListHIV, this);
        rvViralStateHIV.setLayoutManager(new GridLayoutManager(this, 1));
        rvViralStateHIV.setAdapter(adapterViralStateHIV);
        rvViralStateHIV.setNestedScrollingEnabled(false);

        stringListPCRHCV = new ArrayList<>();
        adapterViralStatePCRHCV = new AdapterViralState(stringListPCRHCV, this);
        rvViralStatePCRHCV.setLayoutManager(new GridLayoutManager(this, 1));
        rvViralStatePCRHCV.setAdapter(adapterViralStatePCRHCV);
        rvViralStatePCRHCV.setNestedScrollingEnabled(false);


    }

    //region calls
    @Override
    public void onGetDataFromFirebase(DataSnapshot dataSnapshot, String flag) {
        for (DataSnapshot snapshotHBsAg : dataSnapshot.child("HBsAg").getChildren()) {


            String textToShow = snapshotHBsAg.getValue(String.class);
            ModelDateWithText modelDateWithText = new ModelDateWithText();
            modelDateWithText.setDate(snapshotHBsAg.getKey());
            modelDateWithText.setTxt(textToShow);

            adapterViralStateHBsAg.addItem(modelDateWithText);

        } for (DataSnapshot snapshotHBsAg : dataSnapshot.child("HCV").getChildren()) {


            String textToShow = snapshotHBsAg.getValue(String.class);
            ModelDateWithText modelDateWithText = new ModelDateWithText();
            modelDateWithText.setDate(snapshotHBsAg.getKey());
            modelDateWithText.setTxt(textToShow);

            adapterViralStateHCV.addItem(modelDateWithText);

        } for (DataSnapshot snapshotHBsAg : dataSnapshot.child("HIV").getChildren()) {


            String textToShow = snapshotHBsAg.getValue(String.class);
            ModelDateWithText modelDateWithText = new ModelDateWithText();
            modelDateWithText.setDate(snapshotHBsAg.getKey());
            modelDateWithText.setTxt(textToShow);

            adapterViralStateHIV.addItem(modelDateWithText);

        } for (DataSnapshot snapshotHBsAg : dataSnapshot.child("PCRHCV").getChildren()) {


            String textToShow = snapshotHBsAg.getValue(String.class);
            ModelDateWithText modelDateWithText = new ModelDateWithText();
            modelDateWithText.setDate(snapshotHBsAg.getKey());
            modelDateWithText.setTxt(textToShow);

            adapterViralStatePCRHCV.addItem(modelDateWithText);

        }
    }

    //endregion


}
