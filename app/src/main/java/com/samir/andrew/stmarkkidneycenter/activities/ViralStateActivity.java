package com.samir.andrew.stmarkkidneycenter.activities;

import android.os.Bundle;
import android.app.Activity;

import com.samir.andrew.stmarkkidneycenter.R;

public class ViralStateActivity extends BaseActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viral_state);
        getActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
