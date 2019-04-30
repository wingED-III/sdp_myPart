package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.myapplication.Defination.myConstatnt;
import com.example.myapplication.Listview.*;
import com.example.myapplication.javaSQL.SqliteHelper;
import com.example.myapplication.Filter.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MRT extends SuperSkytrainActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mrt);

        // Spinner
        this.spinner = findViewById(R.id.items);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.mrt, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        //spinner.setSelection(0);
        //----------------------------------------------

        // RadioButton
        RadioButton cbMarket = (RadioButton) findViewById(R.id.marketCB);
        RadioButton cbRestaurant = (RadioButton) findViewById(R.id.restaurantCB);
        RadioButton cbNature = (RadioButton) findViewById(R.id.natureCB);
        RadioButton cbShopping = (RadioButton) findViewById(R.id.shoppingCB);
        RadioButton cbOthers = (RadioButton) findViewById(R.id.othersCB);
        Button searchButton = (Button) findViewById(R.id.searchButton);

        cbMarket.setOnClickListener(this);
        cbRestaurant.setOnClickListener(this);
        cbNature.setOnClickListener(this);
        cbShopping.setOnClickListener(this);
        cbOthers.setOnClickListener(this);
        searchButton.setOnClickListener(this);

        RadioButton cbAll = (RadioButton) findViewById(R.id.allCB);
        cbAll.setOnClickListener(this);

        this.constructListView(getBaseContext(), "MRT_TABLE", myConstatnt.MRT_CONST, R.id.mrtLV);

    }

    // Spinner
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
        this.whenSpinnerSelected();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {
        this.whenClick(v);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        System.gc();
        finish();
    }
}
