package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class university_KMITL extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_university__kmitl);

        Button buttonHome = findViewById(R.id.home_KMITL);
        buttonHome.setOnClickListener(this);
    }

    public void openHome(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.home_KMITL:
                openHome();
                //Toast.makeText(this, "market_checked", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}