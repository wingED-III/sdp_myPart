package com.example.myapplication.BusPack;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class MiniBusActivity extends AppCompatActivity {
    ListView ListView2;
    List<Bus> minibusList = new ArrayList<>();
    private ArrayList<UniversityItem> nUniversityList;
    private UniversityAdapter nAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minibus);

        initList2();

        nAdapter = new UniversityAdapter(this,nUniversityList);

        prepareData2();

        final Spinner spinnerUniversity2 = findViewById(R.id.spinner_university2);
        spinnerUniversity2.setAdapter(nAdapter);

        spinnerUniversity2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ListView2 = (ListView)findViewById(R.id.list_item2);
        ListAdapter adapter = new ListAdapter(MiniBusActivity.this,minibusList);
        ListView2.setAdapter(adapter);
        ListView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(MiniBusActivity.this,"Position = "+position,Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MiniBusActivity.this,ShowDetailActivity.class);
                intent.putExtra("image",minibusList.get(position).getResId());
                intent.putExtra("bus",minibusList.get(position).getBus());
                intent.putExtra("description",minibusList.get(position).getDescription());

                startActivity(intent);
            }
        });

    }
    public void  initList2(){
        nUniversityList = new ArrayList<>();
        nUniversityList.add(new UniversityItem("KMITL",R.drawable.kmitl));
        nUniversityList.add(new UniversityItem("MU",R.drawable.mu));
        nUniversityList.add(new UniversityItem("TNI",R.drawable.tni));
        nUniversityList.add(new UniversityItem("SPU",R.drawable.spu));
        nUniversityList.add(new UniversityItem("TU",R.drawable.tu));
        nUniversityList.add(new UniversityItem("CU",R.drawable.cu));
    }
    public  void prepareData2(){
        int resId2[] = {R.drawable.minibus111,R.drawable.minibus555,R.drawable.minibus777};
        String minibus[] = {"สาย 111","สาย 555","สาย 777"};
        String description2[] = {getString(R.string.minibus111),getString(R.string.minibus555),getString(R.string.minibus777)};

        int dataSize2 = resId2.length;
        for (int i=0;i<dataSize2;i++){
            Bus minibusl = new Bus(resId2[i], minibus[i],description2[i]);
            minibusList.add(minibusl);
        }

    }
}
