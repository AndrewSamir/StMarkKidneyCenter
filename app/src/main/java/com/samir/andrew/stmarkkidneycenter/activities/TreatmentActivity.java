package com.samir.andrew.stmarkkidneycenter.activities;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;

import com.samir.andrew.stmarkkidneycenter.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class TreatmentActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treatment);
        getActionBar().setDisplayHomeAsUpEnabled(true);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnTreatmentCurrent)
    public void onClickbtnTreatmentCurrent() {
        Intent intent = new Intent(TreatmentActivity.this, TreatmentDetailsActivity.class);
        intent.putExtra("intent", 0);
        startActivity(intent);
    }

    @OnClick(R.id.btnTreatmentPrevious)
    public void onClickbtnTreatmentPrevious() {
        Intent intent = new Intent(TreatmentActivity.this, TreatmentDetailsActivity.class);
        intent.putExtra("intent", 1);
        startActivity(intent);    }

}
