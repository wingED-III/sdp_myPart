package com.example.myapplication.Calculation;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.ArrayList;

public class TrainAdapter extends ArrayAdapter<TrainItem> {

    public TrainAdapter(Context context, ArrayList<TrainItem> trainList) {
        super(context,0,trainList);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position,convertView,parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position,convertView,parent);
    }

    private View initView(int position,View convertView,ViewGroup parent)
    {
        if (convertView == null)
        {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.train_spinner,parent,false);
        }
        ImageView imageViewUni = convertView.findViewById(R.id.image_view_train);
        TextView textViewName = convertView.findViewById(R.id.text_view_train_name);

        TrainItem currentItem = getItem(position);

        if(currentItem != null){
            imageViewUni.setImageResource(currentItem.getmTrainImage());
            textViewName.setText(currentItem.getmTrainName());
        }

        return convertView;
    }
}
