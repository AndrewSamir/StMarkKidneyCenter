package com.samir.andrew.stmarkkidneycenter.activities;

import android.os.Bundle;
import android.app.Activity;

import com.samir.andrew.stmarkkidneycenter.R;

public class MedicalHistoryActivity extends BaseActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical_history);
        getActionBar().setDisplayHomeAsUpEnabled(true);
    }

}