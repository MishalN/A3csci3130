package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 *
 * Mishal Alnajdi
 * B00562408
 * Assignment 4
 *
 */

/**
 * Class take 6 parameters input from a user
 * and pass it as an BusinessData object
 * to the firebase database
 *
 */
public class CreateBusinessDataAcitivity extends Activity {

    private Button submitButton;
    private EditText businessNumberField, nameField, primaryBusinessField, addressField, provinceField;
    private MyApplicationData appState;

    /**
     *
     * @param savedInstanceState is a reference to a Bundle object
     *                           that is passed into the onCreate method
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_data_acitivity);

        //Get the app wide shared variables
        appState = ((MyApplicationData) getApplicationContext());

        submitButton = (Button) findViewById(R.id.submitButton);
        businessNumberField = (EditText) findViewById(R.id.bNum);
        nameField = (EditText) findViewById(R.id.name);
        primaryBusinessField = (EditText) findViewById(R.id.primary);
        addressField = (EditText) findViewById(R.id.address);
        provinceField = (EditText) findViewById(R.id.province);


    }

    /**
     *
     * @param v  is the view that was clicked
     *           to pass the BusinessData object
     *           to the firebase database.
     */
    public void submitInfoButton(View v) {
        //each entry needs a unique ID
        String businessID = appState.firebaseReference.push().getKey();
        String bNum = businessNumberField.getText().toString();
        String name = nameField.getText().toString();
        String primary = primaryBusinessField.getText().toString();
        String address = addressField.getText().toString();
        String province = provinceField.getText().toString();
        BusinessData business = new BusinessData(businessID, bNum, name, primary, address, province);

        appState.firebaseReference.child(businessID).setValue(business);

        finish();

    }
}
