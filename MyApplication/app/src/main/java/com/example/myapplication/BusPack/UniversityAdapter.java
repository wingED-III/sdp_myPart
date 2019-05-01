package com.example.myapplication.BusPack;

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

public class UniversityAdapter extends ArrayAdapter<UniversityItem> {

    public UniversityAdapter(Context context, ArrayList<UniversityItem>universityList)
    {
        super(context,0,universityList);

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
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.university_spinner,parent,false);
        }
        ImageView imageViewUni = convertView.findViewById(R.id.image_view_flag);
        TextView textViewName = convertView.findViewById(R.id.text_view_name);

        UniversityItem currentItem = getItem(position);

        if(currentItem != null){
            imageViewUni.setImageResource(currentItem.getmUniversityImage());
            textViewName.setText(currentItem.getmUnversityName());
        }

        return convertView;
    }
}
