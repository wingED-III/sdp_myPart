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

public class MRT extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    class Myadapter extends abs_Myadapter {
        Myadapter(Context context, int layout, ArrayList<MyBlock> myBlockArrayList) {
            super(context, layout, myBlockArrayList);
        }

        @Override
        public void openWeb() {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(getUrl()));
            startActivity(intent);
        }

        @Override
        public void openMap(LocationCoordinate locationCoordinate) {
            Intent intent = new Intent(MRT.this, MapsActivity.class);

            intent.putExtra("lati_start", locationCoordinate.getStart_longtitude());
            intent.putExtra("longi_start", locationCoordinate.getStart_longtitude());
            intent.putExtra("lati_dest", locationCoordinate.getDest_latitude());
            intent.putExtra("longi_dest", locationCoordinate.getDest_longtitude());
            Log.d("TESSSSSSSSSSSSSTTTTT", "openMap: "+ locationCoordinate.getStart_longtitude());
            startActivity(intent);
        }
    }

    ;

    private SearchFilter searchFilter = new SearchFilter();
    private Myadapter myadapter;
    private ListView listView;
    private ArrayList<MyBlock> blockList;
    private ArrayList<MyBlock> allBlock = new ArrayList<>();

    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mrt);

        // Spinner
        spinner = findViewById(R.id.items);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.mrt, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        spinner.setSelection(0);
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

        SqliteHelper myDB = new SqliteHelper(this, "MRT_TABLE");

        listView = (ListView) findViewById(R.id.mrtLV);
        blockList = new ArrayList<>();

        /* M ------------------ */

        try {
            myDB.createDB();
        } catch (IOException e) {
            throw new Error("Cannot Create Database");
        }
        try {
            myDB.openDB();

        } catch (SQLiteException e) {
            throw e;
        }
        //---------Skytrain class-------//
        Cursor line = myDB.getTable();
        line.moveToFirst();
        do {
            int stationID = line.getInt(line.getColumnIndex("station_id")) - myConstatnt.MRT_CONST - 1; //spinner start at 0
            int type = line.getInt(line.getColumnIndex("type"));

            String location = line.getString(line.getColumnIndex("location"));
            String availTime = line.getString(line.getColumnIndex("available_time"));
            String descript = line.getString(line.getColumnIndex("description")) + "\n\n" + "เวลาทำการ: " + availTime;

            double lat_start = line.getDouble(line.getColumnIndex("start_latitude"));
            double long_start = line.getDouble(line.getColumnIndex("start_longitude"));
            double lat_dest = line.getDouble(line.getColumnIndex("dest_latitude"));
            double long_dest = line.getDouble(line.getColumnIndex("dest_longitude"));


            LocationCoordinate coordinate = new LocationCoordinate(lat_start, lat_dest, long_start, long_dest);
            //Log.d("Latintude", "start: "+lat_start);
            Drawable drawable = null;
            try {
                // get input stream
                InputStream ims = getAssets().open("bts_asset/" + location + ".jpg");
                // load image as Drawable
                drawable = Drawable.createFromStream(ims, null);
                //Log.d("aSDAA", "executeeeeeeeeeeee: ");
            } catch (IOException ex) {
                Log.e("View", "Image from Asset ", ex);
            }

            MyBlock myBlock = new MyBlock(stationID, type, location, descript, drawable, coordinate);

            blockList.add(myBlock);
        } while (line.moveToNext());

        allBlock.addAll(blockList);
        //---------in Skytrain class-------//

        myadapter = new Myadapter(getBaseContext(), R.layout.btsspot_01, blockList);
        listView.setAdapter(myadapter);

        /*  ----------------------*/

    }

    // Spinner
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
        this.searchFilter.setSelectedStation(this.spinner.getSelectedItemPosition());
        Toast.makeText(this, "id = " + this.spinner.getSelectedItemPosition(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    //----------------------------------------------------------
    // RadioButton & Search button
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.marketCB:
                Toast.makeText(this, "market_checked", Toast.LENGTH_SHORT).show();
                this.searchFilter.setTypeLocation(1);
                break;
            case R.id.restaurantCB:
                Toast.makeText(this, "restaurant_checked", Toast.LENGTH_SHORT).show();
                this.searchFilter.setTypeLocation(3);
                break;
            case R.id.natureCB:
                Toast.makeText(this, "nature_checked", Toast.LENGTH_SHORT).show();
                this.searchFilter.setTypeLocation(2);
                break;
            case R.id.shoppingCB:
                Toast.makeText(this, "shopping_checked", Toast.LENGTH_SHORT).show();
                this.searchFilter.setTypeLocation(4);
                break;
            case R.id.othersCB:
                Toast.makeText(this, "others_checked", Toast.LENGTH_SHORT).show();
                this.searchFilter.setTypeLocation(5);
                break;
            case R.id.searchButton:
                Toast.makeText(this, "search_clicked", Toast.LENGTH_SHORT).show();
                //Toast.makeText(this, this.searchFilter.toString(), Toast.LENGTH_SHORT).show();
                searchFilter.filtering(blockList, allBlock);
                myadapter.notifyDataSetChanged();
                System.gc();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        System.gc();
        finish();
    }
}
