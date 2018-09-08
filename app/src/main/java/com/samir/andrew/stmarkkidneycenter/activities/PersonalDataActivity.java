package com.samir.andrew.stmarkkidneycenter.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.samir.andrew.stmarkkidneycenter.R;
import com.samir.andrew.stmarkkidneycenter.models.PersonalData;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PersonalDataActivity extends BaseActivity {

    //region fields

    PersonalData personalData;

    //endregion

    //region views

    @BindView(R.id.tvPersonalDataName)
    TextView tvPersonalDataName;

    @BindView(R.id.tvPersonalDataAddress)
    TextView tvPersonalDataAddress;

    @BindView(R.id.tvPersonalDataDateOfBirth)
    TextView tvPersonalDataDateOfBirth;

    @BindView(R.id.tvPersonalDataPhoneNumber)
    TextView tvPersonalDataPhoneNumber;

    //endregion

    //region life cycle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_data);
        getActionBar().setDisplayHomeAsUpEnabled(true);

        ButterKnife.bind(this);

        Intent i = getIntent();
        Bundle bundle = i.getExtras();
        personalData = (PersonalData) bundle.getSerializable("user");

        adjustView();
    }

    //endregion

    //region functions

    private void adjustView() {

        tvPersonalDataName.setText(personalData.getName());
        tvPersonalDataAddress.setText(personalData.getAddress());
        tvPersonalDataDateOfBirth.setText(personalData.getDateOfBirth());
        tvPersonalDataPhoneNumber.setText(personalData.getPhoneNumber());
    }

    //endregion
}
