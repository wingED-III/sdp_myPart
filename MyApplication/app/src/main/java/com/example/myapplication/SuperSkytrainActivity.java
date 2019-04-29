package com.example.myapplication;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.myapplication.Defination.myConstatnt;
import com.example.myapplication.Filter.SearchFilter;
import com.example.myapplication.Listview.MyBlock;
import com.example.myapplication.Listview.abs_Myadapter;
import com.example.myapplication.javaSQL.SqliteHelper;

import java.io.IOException;
import java.util.ArrayList;

abstract class SuperSkytrainActivity extends AppCompatActivity {
    private ArrayList<MyBlock> blockList = new ArrayList<>();
    private ArrayList<MyBlock> allBlock = new ArrayList<>();
    private SqliteHelper myDB;
    private SearchFilter searchFilter = new SearchFilter();
    private Myadapter myadapter;

    protected ListView listView;
    protected Spinner spinner;

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
    }

    ;


    protected void constructListView(Context context, String tableName, int TRANSPORT_CONSTANT, int listviewID) {
        this.spinner.setSelection(0);
        this.listView = findViewById(listviewID);
        myDB = new SqliteHelper(getBaseContext(), tableName);
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

        Cursor line = myDB.getTable();
        line.moveToFirst();
        do {
            int stationID = line.getInt(line.getColumnIndex("station_id")) - TRANSPORT_CONSTANT - 1;  //spinner start at 0
            int type = line.getInt(line.getColumnIndex("type"));

            String location = line.getString(line.getColumnIndex("location"));
            String availTime =  line.getString(line.getColumnIndex("available_time"));
            String descript = line.getString(line.getColumnIndex("description")) + "\n\n"+"เวลาทำการ: "+ availTime;
           // int imageID = this.getResources().getIdentifier(location,"id",this.getPackageName());
           // Log.d("Construct", "imageID= "+imageID);
            MyBlock myBlock = new MyBlock(stationID, type, location, descript,0);

            blockList.add(myBlock);
        } while (line.moveToNext());

        allBlock.addAll(blockList);
        myadapter = new Myadapter(context, R.layout.btsspot_01, blockList);
        listView.setAdapter(myadapter);
    }


    protected void doSearch() {
        //Toast.makeText(this, this.searchFilter.toString(), Toast.LENGTH_SHORT).show();
        searchFilter.filtering(blockList, allBlock);
        myadapter.notifyDataSetChanged();
        System.gc();
    }

    protected void whenSpinnerSelected() {
        this.searchFilter.setSelectedStation(this.spinner.getSelectedItemPosition());
        Toast.makeText(this, "id = " + this.spinner.getSelectedItemPosition(), Toast.LENGTH_SHORT).show();
    }

    protected void whenClick(View v) {
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

}
