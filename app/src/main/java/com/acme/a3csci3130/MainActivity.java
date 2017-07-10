package com.acme.a3csci3130;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Mishal Alnajdi
 * B00562408
 * Assignment 4
 */

/**
 * Class with a buttons to create a new BusinessData child
 * and also view a list of the existed BusinessData children from firebase
 */
public class MainActivity extends Activity {


    private ListView businessListView;
    private FirebaseListAdapter<BusinessData> firebaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Get the app wide shared variables
        MyApplicationData appData = (MyApplicationData)getApplication();

        //Set-up Firebase
        appData.firebaseDBInstance = FirebaseDatabase.getInstance();
        appData.firebaseReference = appData.firebaseDBInstance.getReference("businessList");

        //Get the reference to the UI contents
        businessListView = (ListView) findViewById(R.id.listView);

        //Set up the List View
       firebaseAdapter = new FirebaseListAdapter<BusinessData>(this, BusinessData.class,
                android.R.layout.simple_list_item_1, appData.firebaseReference) {
            @Override
            protected void populateView(View v, BusinessData model, int position) {
                TextView businessName = (TextView)v.findViewById(android.R.id.text1);
                businessName.setText(model.name);
            }
        };
        businessListView.setAdapter(firebaseAdapter);
        businessListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            // onItemClick method is called everytime a user clicks an item on the list
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                BusinessData business = (BusinessData) firebaseAdapter.getItem(position);
                showDetailView(business);


            }
        });
    }

    public void createbusinessButton(View v)
    {
        Intent intent=new Intent(this, CreateBusinessDataAcitivity.class);
        startActivity(intent);
    }


    private void showDetailView(BusinessData business)
    {

        Intent intent = new Intent(MainActivity.this, DetailViewActivity.class);
        intent.putExtra("BusinessData", business);
        startActivity(intent);



    }




}
