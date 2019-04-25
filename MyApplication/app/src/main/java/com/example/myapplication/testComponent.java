package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;
import java.util.List;
import java.util.ArrayList;

public class testComponent extends AppCompatActivity implements AdapterView.OnItemSelectedListener,View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_component);

        // Spinner
        Spinner spinner = findViewById(R.id.items);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.bts,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        //----------------------------------------------

        // RadioButton
        RadioButton cbMarket = (RadioButton) findViewById(R.id.marketCB);
        RadioButton cbRestaurant = (RadioButton) findViewById(R.id.restaurantCB);
        RadioButton cbNature = (RadioButton) findViewById(R.id.natureCB);
        RadioButton cbShopping = (RadioButton) findViewById(R.id.shoppingCB);
        RadioButton cbOthers = (RadioButton) findViewById(R.id.othersCB) ;
        Button searchButton  = (Button)findViewById(R.id.searchButton);

        cbMarket.setOnClickListener(this);
        cbRestaurant.setOnClickListener(this);
        cbNature.setOnClickListener(this);
        cbShopping.setOnClickListener(this);
        cbOthers.setOnClickListener(this);
        searchButton.setOnClickListener(this);

    }
    // Spinner
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),text,Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    //----------------------------------------------------------
    // RadioButton & Search button
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.marketCB:
                Toast.makeText(this, "market_checked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.restaurantCB:
                Toast.makeText(this, "restaurant_checked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.natureCB:
                Toast.makeText(this, "nature_checked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.shoppingCB:
                Toast.makeText(this, "shopping_checked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.othersCB:
                Toast.makeText(this, "others_checked", Toast.LENGTH_SHORT).show();
                break;

            case R.id.searchButton:
                Toast.makeText(this, "search_clicked", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
