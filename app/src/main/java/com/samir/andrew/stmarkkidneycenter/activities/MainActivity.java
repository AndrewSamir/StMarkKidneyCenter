package com.samir.andrew.stmarkkidneycenter.activities;

import android.os.Bundle;
import android.app.Activity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.samir.andrew.stmarkkidneycenter.FirebaseHandler.HandleGetDataFromFirebase;
import com.samir.andrew.stmarkkidneycenter.R;
import com.samir.andrew.stmarkkidneycenter.adapters.AdapterMain;
import com.samir.andrew.stmarkkidneycenter.interfaces.InterfaceGetDataFromFirebase;
import com.samir.andrew.stmarkkidneycenter.models.ModelPersonalData;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements InterfaceGetDataFromFirebase
{
    //region fields

    List<ModelPersonalData> modelPersonalDataList;
    AdapterMain adapterMain;

    //endregion

    //region views
    @BindView(R.id.rvMain)
    RecyclerView rvMain;

    //endregion

    //region life cycle
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        HandleGetDataFromFirebase.getInstance(this).setGetDataFromFirebaseInterface(this);
//        getBaseActivity();
        DatabaseReference myRefData = myRef.child("patients");

        HandleGetDataFromFirebase.getInstance(this).callGet("test", myRefData);

        modelPersonalDataList = new ArrayList<>();
        adapterMain = new AdapterMain(modelPersonalDataList, this);
        rvMain.setLayoutManager(new GridLayoutManager(this, 1));
        rvMain.setAdapter(adapterMain);
    }

    //endregion

    //region calls
    @Override
    public void onGetDataFromFirebase(DataSnapshot dataSnapshot, String flag)
    {
        for (DataSnapshot snapshot : dataSnapshot.getChildren())
        {
            ModelPersonalData modelPersonalData = snapshot.child("personalData").getValue(ModelPersonalData.class);
            modelPersonalData.setId(snapshot.getKey());
            adapterMain.addItem(modelPersonalData);
        }
    }

    //endregion
}
