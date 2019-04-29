package com.example.myapplication.Listview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public abstract class abs_Myadapter extends ArrayAdapter {
    private Context mContext;
    private ArrayList<MyBlock> myBlockArrayList;
    private int mLayout;
    private String url;

    public abs_Myadapter(Context context, int layout, ArrayList<MyBlock> myBlockArrayList) {
        super(context, layout, myBlockArrayList);
        this.myBlockArrayList = myBlockArrayList;
        this.mContext = context;
        this.mLayout = layout;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (view == null) {
            view = inflater.inflate(mLayout, parent, false);
        }

        MyBlock block = myBlockArrayList.get(position);

        ImageView img = (ImageView) view.findViewById(R.id.location_Img);
        img.setImageDrawable(block.getImage_drawble());

        TextView tvName = (TextView) view.findViewById(R.id.spotname);
        tvName.setText(block.getLocation());

        TextView tvDesc = (TextView) view.findViewById(R.id.info);
        tvDesc.setText(block.getDescript());

        final String URL = "https://google.com/search?q=" + block.getLocation();
        block.setButton((Button) view.findViewById(R.id.ggMap));
        block.getButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                url = URL;
                openWeb();
            }
        });


        return view;
    }

    public abstract void openWeb();

    public String getUrl() {
        return url;
    }
}