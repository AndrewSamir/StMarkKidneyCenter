package com.samir.andrew.stmarkkidneycenter.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class BaseActivity extends Activity {

    private static FirebaseDatabase database;
    protected static DatabaseReference myRef;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

            database = FirebaseDatabase.getInstance();
            myRef = database.getReference();
            myRef.keepSynced(true);

    }

    protected BaseActivity getBaseActivity() throws NullPointerException {
        return this;
    }
}
