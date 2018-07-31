package com.samir.andrew.stmarkkidneycenter.activities;

import android.os.Bundle;
import android.app.Activity;

import com.samir.andrew.stmarkkidneycenter.R;

public class TreatmentActivity extends BaseActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treatment);
        getActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
