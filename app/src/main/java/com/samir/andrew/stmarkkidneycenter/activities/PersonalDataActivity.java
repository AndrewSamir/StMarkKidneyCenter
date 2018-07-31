package com.samir.andrew.stmarkkidneycenter.activities;

import android.os.Bundle;
import android.app.Activity;

import com.samir.andrew.stmarkkidneycenter.R;

public class PersonalDataActivity extends BaseActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_data);
        getActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
