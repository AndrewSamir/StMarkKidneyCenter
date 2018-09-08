package com.samir.andrew.stmarkkidneycenter.activities;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;

import com.samir.andrew.stmarkkidneycenter.R;
import com.samir.andrew.stmarkkidneycenter.models.PersonalData;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class PatientActivity extends Activity {


    PersonalData personalData;

    //region life cycle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient);
        getActionBar().setDisplayHomeAsUpEnabled(true);

        ButterKnife.bind(this);

        Intent i = getIntent();
        Bundle bundle = i.getExtras();
        if (bundle != null)
            personalData = (PersonalData) bundle.getSerializable("user");
    }

    //endregion

    //region clicks

    @OnClick(R.id.btnMainActivityPersonalData)
    void onClickbtnMainActivityPersonalData(View view) {
        Intent yourIntent = new Intent(this, PersonalDataActivity.class);
        Bundle b = new Bundle();
        b.putSerializable("user", personalData);
        yourIntent.putExtras(b); //pass bundle to your intent
        startActivity(yourIntent);
    }

    @OnClick(R.id.btnMainActivityBloodTransfusion)
    void onClickbtnMainActivityBloodTransfusion(View view) {
        startActivity(new Intent(PatientActivity.this, BloodTransfusionActivity.class));
    }

    @OnClick(R.id.btnMainActivityMedicalHistory)
    void onClickbtnMainActivityMedicalHistory(View view) {
        startActivity(new Intent(PatientActivity.this, MedicalHistoryActivity.class));
    }

    @OnClick(R.id.btnMainActivityPastDiseasesHistory)
    void onClickbtnMainActivityPastDiseasesHistory(View view) {
        startActivity(new Intent(PatientActivity.this, PastDiseasesHistoryActivity.class));
    }

    @OnClick(R.id.btnMainActivityPreviousDialysis)
    void onClickbtnMainActivityPreviousDialysis(View view) {
        startActivity(new Intent(PatientActivity.this, PreviousDialysisActivity.class));
    }

    @OnClick(R.id.btnMainActivityTreatment)
    void onClickbtnMainActivityTreatment(View view) {
        startActivity(new Intent(PatientActivity.this, TreatmentActivity.class));
    }

    @OnClick(R.id.btnMainActivityVascularAccessHistory)
    void onClickbtnMainActivityVascularAccessHistory(View view) {
        startActivity(new Intent(PatientActivity.this, VascularAccessHistoryActivity.class));
    }

    @OnClick(R.id.btnMainActivityViralState)
    void onClickbtnMainActivityViralState(View view) {
        startActivity(new Intent(PatientActivity.this, ViralStateActivity.class));
    }
    //endregion

}
