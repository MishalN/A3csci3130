package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Mishal Alnajdi
 * B00562408
 * Assignment 4
 *
 */


/**
 * Class to show the detailed view of each BusinessData child
 */
public class DetailViewActivity extends Activity {

    private Button upDate, delete;
    private EditText businessNumberField, nameField, primaryBusinessField, addressField, provinceField;;
    BusinessData receivedPersonInfo;
    private MyApplicationData appState;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);

        receivedPersonInfo = (BusinessData)getIntent().getSerializableExtra("BusinessData");
        appState = ((MyApplicationData) getApplicationContext());


        businessNumberField = (EditText) findViewById(R.id.bNum);
        nameField = (EditText) findViewById(R.id.name);
        primaryBusinessField = (EditText) findViewById(R.id.primary);
        addressField = (EditText) findViewById(R.id.address);
        provinceField = (EditText) findViewById(R.id.province);

        upDate = (Button) findViewById(R.id.updateButton);
        delete = (Button) findViewById(R.id.deleteButton);


        if(receivedPersonInfo != null){
            businessNumberField.setText(receivedPersonInfo.businessNumber);
            nameField.setText(receivedPersonInfo.name);
            primaryBusinessField.setText(receivedPersonInfo.primaryBusiness);
            addressField.setText(receivedPersonInfo.address);
            provinceField.setText(receivedPersonInfo.province);


        }
    }

    /**
     *  Method to update the BusinessData object
     *  on the firebase database by using the uid.
     *
     * @param v is the view that was clicked
     *
     */
    public void updateContact(View v){
        String businessID = receivedPersonInfo.uid;
        String bNum = businessNumberField.getText().toString();
        String name = nameField.getText().toString();
        String primary = primaryBusinessField.getText().toString();
        String address = addressField.getText().toString();
        String province = provinceField.getText().toString();
        BusinessData business = new BusinessData(businessID, bNum, name, primary, address, province);
        appState.firebaseReference.child(businessID).setValue(business);
        finish();
    }

    /**
     * Method to delete the BusinessData object
     *  from the firebase database by using the uid.
     *
     * @param v is the view that was clicked
     *
     */
    public void eraseContact(View v){
        appState.firebaseReference.child(receivedPersonInfo.uid).removeValue();
        finish();
    }
}
