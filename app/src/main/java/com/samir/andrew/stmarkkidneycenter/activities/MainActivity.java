package com.samir.andrew.stmarkkidneycenter.activities;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.samir.andrew.stmarkkidneycenter.FirebaseHandler.HandleAddDataToFirebase;
import com.samir.andrew.stmarkkidneycenter.FirebaseHandler.HandleGetDataFromFirebase;
import com.samir.andrew.stmarkkidneycenter.R;
import com.samir.andrew.stmarkkidneycenter.adapters.AdapterMain;
import com.samir.andrew.stmarkkidneycenter.interfaces.InterfaceAddDataToFirebase;
import com.samir.andrew.stmarkkidneycenter.interfaces.InterfaceGetDataFromFirebase;
import com.samir.andrew.stmarkkidneycenter.models.ModelPerson;
import com.samir.andrew.stmarkkidneycenter.models.PersonalData;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements InterfaceGetDataFromFirebase, InterfaceAddDataToFirebase {
    //region fields

    List<PersonalData> personalDataList;
    AdapterMain adapterMain;

    //endregion

    //region views
    @BindView(R.id.rvMain)
    RecyclerView rvMain;

    //endregion

    //region life cycle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        HandleGetDataFromFirebase.getInstance(this).setGetDataFromFirebaseInterface(this);

        HandleAddDataToFirebase.getInstance(this).setClickDialogListener(this);
//        getBaseActivity();
        DatabaseReference myRefData = myRef.child("patients");

        HandleGetDataFromFirebase.getInstance(this).callGet("test", myRefData);
   /*     PersonalData personalData =new PersonalData();
        personalData.setName("hg");
        ModelPerson modelPerson=new ModelPerson();
        modelPerson.setPersonalData(personalData);
        HandleAddDataToFirebase.getInstance(this).callAddProfileData("gf",modelPerson);
   */
        personalDataList = new ArrayList<>();
        adapterMain = new AdapterMain(personalDataList, this);
        rvMain.setLayoutManager(new GridLayoutManager(this, 1));
        rvMain.setAdapter(adapterMain);
    }

    //endregion

    //region calls
    @Override
    public void onGetDataFromFirebase(DataSnapshot dataSnapshot, String flag) {
        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
            PersonalData personalData = snapshot.child("personalData").getValue(PersonalData.class);
            personalData.setId(snapshot.getKey());
            adapterMain.addItem(personalData);
        }
    }

    @Override
    public void onDataAddedSuccess(String flag) {

    }

    @Override
    public void onDataAddedFailed(String flag) {

    }

    @Override
    public void onDataAddedRepeated(String flag) {

    }


    private void showAddPersonDialoge() {

        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog_add_person);

        TextView tvDialogAction = (TextView) dialog.findViewById(R.id.tvDialogAction);
        final TextView tvDialogBack = (TextView) dialog.findViewById(R.id.tvDialogBack);
        final EditText edtAnotherFather = (EditText) dialog.findViewById(R.id.edtAnotherFather);


        tvDialogAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            /*    if (edtAnotherFather.getText().toString().length() > 0) {

                    textDropdownFather.setText(edtAnotherFather.getText().toString());

                } else {
                    edtAnotherFather.setError(getString(R.string.empty_field));
                }*/

                dialog.dismiss();
            }
        });

        tvDialogBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();


    }

    //endregion
}
