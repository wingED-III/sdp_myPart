package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.myapplication.Filter.SearchFilter;
import com.example.myapplication.Listview.*;
import com.example.myapplication.R;
import com.example.myapplication.javaSQL.SqliteHelper;

import java.io.IOException;
import java.util.ArrayList;

import com.example.myapplication.Defination.myConstatnt;

public class SuperUnivActitivity extends AppCompatActivity {

    private ArrayList<MyBlock> blockList = new ArrayList<>();
    private ArrayList<MyBlock> allBlock = new ArrayList<>();
    private SqliteHelper myDB;
    private SearchFilter searchFilter = new SearchFilter();
    private Myadapter myadapter;

    protected ListView listView;


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

    protected void constructListView(Context context, int UNIV_CONST, int listviewID) {
        this.listView = findViewById(listviewID);
        myDB = new SqliteHelper(getBaseContext(), "UNIV_TABLE");
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
            int uID = line.getInt(line.getColumnIndex("univ_id"));
            if (uID == UNIV_CONST) {
                int type = line.getInt(line.getColumnIndex("type"));

                String location = line.getString(line.getColumnIndex("location"));
                String availTime = line.getString(line.getColumnIndex("available_time"));
                String descript = line.getString(line.getColumnIndex("description")) + "\n\n" + "เวลาทำการ: " + availTime;

                MyBlock myBlock = new MyBlock(uID, type, location, descript);
                blockList.add(myBlock);
            }

        } while (line.moveToNext());

        allBlock.addAll(blockList);
        myadapter = new Myadapter(context, R.layout.btsspot_01, blockList);
        listView.setAdapter(myadapter);
    }
}
