package com.samir.andrew.stmarkkidneycenter.activities;

import android.os.Bundle;
import android.app.Activity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.samir.andrew.stmarkkidneycenter.FirebaseHandler.HandleGetDataFromFirebase;
import com.samir.andrew.stmarkkidneycenter.R;
import com.samir.andrew.stmarkkidneycenter.interfaces.InterfaceGetDataFromFirebase;

public class MainActivity extends BaseActivity implements InterfaceGetDataFromFirebase {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HandleGetDataFromFirebase.getInstance(this).setGetDataFromFirebaseInterface(this);
//        getBaseActivity();
        DatabaseReference myRefData = myRef.child("patients");

        HandleGetDataFromFirebase.getInstance(this).callGet("test", myRefData);
    }

    @Override
    public void onGetDataFromFirebase(DataSnapshot dataSnapshot, String flag) {

    }
}
