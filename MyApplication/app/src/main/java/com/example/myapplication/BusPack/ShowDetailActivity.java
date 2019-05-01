package com.example.myapplication.BusPack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;

public class ShowDetailActivity extends AppCompatActivity {

    private ImageView image;
    private TextView tvBus,tvDescription;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail);

        image = (ImageView) findViewById(R.id.image);
        tvBus = (TextView)findViewById(R.id.tvBus);
        tvDescription = (TextView)findViewById(R.id.tvdescription);

        int resId = getIntent().getIntExtra("image",0);
        String bus = getIntent().getStringExtra("bus");
        String description = getIntent().getStringExtra("description");

        image.setImageResource(resId);
        tvBus.setText(bus);
        tvDescription.setText(description);

        //Log.d("Bus","resId ="+resId);
        //Log.d("Bus","bus ="+bus);
        //Log.d("Bus","description ="+description);
    }
}
