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
import com.samir.andrew.stmarkkidneycenter.interfaces.InterfaceGetDataFromFirebase;
import com.samir.andrew.stmarkkidneycenter.singleton.SingletonKidneyCenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VascularAccessHistoryActivity extends BaseActivity implements InterfaceGetDataFromFirebase {

    //region fields

    List<String> stringList;
    AdapterPastDiseasesHistory adapterPastDiseasesHistory;

    //endregion

    //region views
    @BindView(R.id.rvPastDiseases)
    RecyclerView rvPastDiseases;

    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_past_diseases_history);
        getActionBar().setDisplayHomeAsUpEnabled(true);


        ButterKnife.bind(this);

        HandleGetDataFromFirebase.getInstance(this).setGetDataFromFirebaseInterface(this);
//        getBaseActivity();
        DatabaseReference myRefData = myRef.child("patients")
                .child(SingletonKidneyCenter.getInstance().getPersonId())
                .child("previousDialysis");

        HandleGetDataFromFirebase.getInstance(this).callGet("test", myRefData);

        stringList = new ArrayList<>();
        adapterPastDiseasesHistory = new AdapterPastDiseasesHistory(stringList, this);
        rvPastDiseases.setLayoutManager(new GridLayoutManager(this, 1));
        rvPastDiseases.setAdapter(adapterPastDiseasesHistory);

    }
    //region calls
    @Override
    public void onGetDataFromFirebase(DataSnapshot dataSnapshot, String flag)
    {
        for (DataSnapshot snapshot : dataSnapshot.getChildren())
        {
            String textToShow = snapshot.getValue(String.class);
//            stringList.setId(snapshot.getKey());
            adapterPastDiseasesHistory.addItem(textToShow);
        }
    }

    //endregion

}
