package com.samir.andrew.stmarkkidneycenter.application;

import android.app.Application;

import com.google.firebase.database.FirebaseDatabase;

public class application extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
//        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
//        DatabaseReference scoresRef = FirebaseDatabase.getInstance().getReference("users/" + FirebaseAuth.getInstance().getUid() + "/tickets");

//        scoresRef.keepSynced(true);
    }
}
