package com.example.myapplication.BusPack;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends BaseAdapter {

    private Context context;
    private List<Bus> busList = new ArrayList<>();

    ListAdapter(Context context,List<Bus> busList){
        this.context = context;
        this.busList = busList;
    }
    @Override
    public int getCount() {
        if(busList==null)
            return 0;
        return busList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.list_item,parent,false);

        ImageView imageView = (ImageView)view.findViewById(R.id.image);
        TextView carBus =(TextView)view.findViewById(R.id.carBus);
       // TextView price = (TextView)view.findViewById(R.id.price);

        imageView.setImageResource(busList.get(position).getResId());
        carBus.setText(busList.get(position).getBus());
        //price.setText(busList.get(position).getDescription());

        return view;
    }
}
