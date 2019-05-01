package com.example.myapplication.BusPack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class BusActivity extends AppCompatActivity {

    ListView ListView;
    List<Bus> busList = new ArrayList<>();
    private  ArrayList<UniversityItem> mUniversityList;
    private UniversityAdapter mAdapter;
    int indexUni;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus);



        //method initlist ข้างล่าง
        initList();
        mAdapter = new UniversityAdapter(this,mUniversityList);
        //method preparedata ข้างล่าง
        prepareData();

        //Spinner
        final Spinner spinnerUniversity = findViewById(R.id.spinner_university);

        spinnerUniversity.setAdapter(mAdapter);

        spinnerUniversity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                UniversityItem clickedItem = (UniversityItem) parent.getItemAtPosition(position);
                String clickedUniName = clickedItem.getmUnversityName();
                //Toast.makeText(BusActivity.this,clickedUniName+" selected",Toast.LENGTH_SHORT).show();
                 indexUni = spinnerUniversity.getSelectedItemPosition();


                busList.clear();      prepareData();
                ListView.setVisibility(View.VISIBLE);
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
               // Toast.makeText(BusActivity.this,"Please Choose University",Toast.LENGTH_SHORT).show();
            }
        });
        //listview
        ListView = (ListView)findViewById(R.id.list_item);
        //adapter
        ListAdapter adapter = new ListAdapter(BusActivity.this,busList);
        ListView.setAdapter(adapter);
        //ตรวจสอบตอนคลิก
        ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override //คลิกแล้วไปอีกหน้า
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(BusActivity.this,"Position = "+position,Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(BusActivity.this,ShowDetailActivity.class);
                intent.putExtra("image",busList.get(position).getResId());
                intent.putExtra("bus",busList.get(position).getBus());
                intent.putExtra("description",busList.get(position).getDescription());

                startActivity(intent);


            }
        });



    }


    //เตรียมข้อมูล page
    private void prepareData() {
        int resId[] = {R.drawable.bus143,R.drawable.bus517};
        int resIdMU[] = {R.drawable.bus515,R.drawable.bus164,R.drawable.bus547,R.drawable.bus124,R.drawable.bus125,R.drawable.bus388};
        int resIdTNI[] = {R.drawable.bus133,R.drawable.bus11,R.drawable.bus206,R.drawable.bus517,R.drawable.bus92};
        int resIdSPU[] = {R.drawable.bus34,R.drawable.bus59,R.drawable.bus185,R.drawable.bus503,R.drawable.bus522,R.drawable.bus39,R.drawable.bus107,R.drawable.bus129,R.drawable.bus543,R.drawable.bus26,R.drawable.bus512,R.drawable.bus114};
        int resIdTU[] = {R.drawable.bus29,R.drawable.bus510,R.drawable.bus39,R.drawable.bus34,R.drawable.bus59,R.drawable.bus187};
        int resIdCU[] = {R.drawable.bus1,R.drawable.bus3,R.drawable.bus25,R.drawable.bus29,R.drawable.bus34,R.drawable.bus36,R.drawable.bus40,R.drawable.bus47,R.drawable.bus50,R.drawable.bus93,R.drawable.bus163,R.drawable.bus2,R.drawable.bus30,R.drawable.bus501,R.drawable.bus542,R.drawable.bus21,R.drawable.bus141,R.drawable.bus16,R.drawable.bus113,R.drawable.bus172,R.drawable.bus177,R.drawable.bus187,R.drawable.bus508,R.drawable.bus529};
        int resIdNULL[]={};



        String bus[] = {"สาย 143","สาย ปอ.517"};
        String busMU[] = {"สาย ปอ.515","สาย 164","สาย ปอ.547","สาย 124","สาย 125","สาย 388"};
        String busTNI[] = {"สาย 133","สาย 11","สาย 206","สาย ปอ.517","สาย ปอ.92"};
        String busSPU[] = {"สาย 34","สาย 59","สาย 185","สาย ปอ.503","สาย ปอ.522","สาย 39","สาย 107","สาย 129","สาย ปอ.543","สาย 26","สาย ปอ.512","สาย 114"};
        String busTU[] = {"สาย 29","สาย ปอ.510","สาย 39","สาย 34","สาย 59","สาย 187"};
        String busCU[] = {"สาย 1","สาย 3","สาย 25","สาย 29","สาย 34","สาย 36","สาย ปอ.40","สาย 47","สาย 50","สาย 93","สาย 163","สาย 2","สาย 30","สาย ปอ.501","สาย ปอ.542","สาย 21","สาย 141","สาย 16","สาย 113","สาย 172","สาย 177","สาย 187","สาย ปอ.508","สาย ปอ.529"};
        String busNULL[] = {};


        String description[] = {getString(R.string.bus143KMITL),getString(R.string.bus517KMITL)};
        String descriptionMU[] = {getString(R.string.bus515_164MU),getString(R.string.bus515_164MU),getString(R.string.bus547MU),getString(R.string.bus124MU),getString(R.string.bus125MU),getString(R.string.bus388MU)};
        String descriptionTNI[] = {getString(R.string.bus133TNI),getString(R.string.bus11_206TNI),getString(R.string.bus11_206TNI),getString(R.string.bus517TNI),getString(R.string.bus92TNI)};
        String descriptionSPU[] = {getString(R.string.bus34_59_185_503_522SPU),getString(R.string.bus34_59_185_503_522SPU),getString(R.string.bus34_59_185_503_522SPU),getString(R.string.bus34_59_185_503_522SPU),getString(R.string.bus34_59_185_503_522SPU),getString(R.string.bus39SPU),getString(R.string.bus107_129_543SPU),getString(R.string.bus107_129_543SPU),getString(R.string.bus107_129_543SPU),getString(R.string.bus26SPU),getString(R.string.bus512SPU),getString(R.string.bus114SPU)};
        String descroptionTU[] = {getString(R.string.bus29_510_39_34_59TUR),getString(R.string.bus29_510_39_34_59TUR),getString(R.string.bus29_510_39_34_59TUR),getString(R.string.bus29_510_39_34_59TUR),getString(R.string.bus29_510_39_34_59TUR),getString(R.string.bus187TUR)};
        String descriptionCU[] = {getString(R.string.bus1_2_21_25_29_30_34_36_47_50_55_93_103_141_163_501_542_พ3CU),getString(R.string.bus1_3_25_29_34_36_40_47_50_93_163_2_30_501_542CU),getString(R.string.bus1_3_25_29_34_36_40_47_50_93_163_2_30_501_542CU),getString(R.string.bus1_3_25_29_34_36_40_47_50_93_163_2_30_501_542CU),getString(R.string.bus1_3_25_29_34_36_40_47_50_93_163_2_30_501_542CU),getString(R.string.bus1_3_25_29_34_36_40_47_50_93_163_2_30_501_542CU),getString(R.string.bus1_3_25_29_34_36_40_47_50_93_163_2_30_501_542CU),getString(R.string.bus1_3_25_29_34_36_40_47_50_93_163_2_30_501_542CU),getString(R.string.bus1_3_25_29_34_36_40_47_50_93_163_2_30_501_542CU),getString(R.string.bus1_3_25_29_34_36_40_47_50_93_163_2_30_501_542CU),getString(R.string.bus1_3_25_29_34_36_40_47_50_93_163_2_30_501_542CU),getString(R.string.bus1_2_21_25_29_30_34_36_47_50_55_93_103_141_163_501_542_พ3CU),getString(R.string.bus1_2_21_25_29_30_34_36_47_50_55_93_103_141_163_501_542_พ3CU),getString(R.string.bus1_2_21_25_29_30_34_36_47_50_55_93_103_141_163_501_542_พ3CU),getString(R.string.bus1_2_21_25_29_30_34_36_47_50_55_93_103_141_163_501_542_พ3CU),getString(R.string.bus16_21_141CU),getString(R.string.bus16_21_141CU),getString(R.string.bus16_21_141CU),getString(R.string.bus25_29_34_36_40_47_50_93_113_172_177_187_501_508_529_542_21_141),getString(R.string.bus25_29_34_36_40_47_50_93_113_172_177_187_501_508_529_542_21_141),getString(R.string.bus25_29_34_36_40_47_50_93_113_172_177_187_501_508_529_542_21_141),getString(R.string.bus25_29_34_36_40_47_50_93_113_172_177_187_501_508_529_542_21_141),getString(R.string.bus25_29_34_36_40_47_50_93_113_172_177_187_501_508_529_542_21_141),getString(R.string.bus25_29_34_36_40_47_50_93_113_172_177_187_501_508_529_542_21_141)};
        String descriptionNULL[] = {};


            if(indexUni == 0) {
                int dataSize = resIdNULL.length;
                for (int i = 0; i < dataSize; i++) {
                    Bus busl = new Bus(resIdNULL[i], busNULL[i],descriptionNULL[i]);
                    busList.add(busl);
                }

                 dataSize = resId.length;
                for (int i = 0; i < dataSize; i++) {
                    Bus busl = new Bus(resId[i], bus[i],description[i]);
                    busList.add(busl);
                }
//                mAdapter.notifyDataSetChanged();
            }
            else if(indexUni ==1){
                int dataSize = resIdNULL.length;
                for (int i = 0; i < dataSize; i++) {
                    Bus busl = new Bus(resIdNULL[i], busNULL[i],descriptionNULL[i]);
                    busList.add(busl);
                }
                 dataSize = resIdMU.length;
                for (int i = 0; i < dataSize; i++) {
                    Bus busl = new Bus(resIdMU[i], busMU[i],descriptionMU[i]);
                    busList.add(busl);
                }
//                mAdapter.notifyDataSetChanged();
            }
            else if(indexUni ==2){
                int dataSize = resIdNULL.length;
                for (int i = 0; i < dataSize; i++) {
                    Bus busl = new Bus(resIdNULL[i], busNULL[i],descriptionNULL[i]);
                    busList.add(busl);
                }
                 dataSize = resIdTNI.length;
                for (int i = 0; i < dataSize; i++) {
                    Bus busl = new Bus(resIdTNI[i], busTNI[i],descriptionTNI[i]);
                    busList.add(busl);
                }
//                mAdapter.notifyDataSetChanged();
            }
            else if(indexUni ==3){
                int dataSize = resIdNULL.length;
                for (int i = 0; i < dataSize; i++) {
                    Bus busl = new Bus(resIdNULL[i], busNULL[i],descriptionNULL[i]);
                    busList.add(busl);
//                    mAdapter.notifyDataSetChanged();
                }
                 dataSize = resIdSPU.length;
                for (int i = 0; i < dataSize; i++) {
                    Bus busl = new Bus(resIdSPU[i], busSPU[i],descriptionSPU[i]);
                    busList.add(busl);
                }
//                mAdapter.notifyDataSetChanged();
            }
            else if(indexUni ==4){
                int dataSize = resIdNULL.length;
                for (int i = 0; i < dataSize; i++) {
                    Bus busl = new Bus(resIdNULL[i], busNULL[i],descriptionNULL[i]);
                    busList.add(busl);
                }
                 dataSize = resIdTU.length;
                for (int i = 0; i < dataSize; i++) {
                    Bus busl = new Bus(resIdTU[i], busTU[i],descroptionTU[i]);
                    busList.add(busl);
                }
//                mAdapter.notifyDataSetChanged();
            }
            else if(indexUni ==5){
                int dataSize = resIdNULL.length;
                for (int i = 0; i < dataSize; i++) {
                    Bus busl = new Bus(resIdNULL[i], busNULL[i],descriptionNULL[i]);
                    busList.add(busl);
                }
                 dataSize = resIdCU.length;
                for (int i = 0; i < dataSize; i++) {
                    Bus busl = new Bus(resIdCU[i], busCU[i],descriptionCU[i]);
                    busList.add(busl);
                }
//                mAdapter.notifyDataSetChanged();
            }




    }
    private void initList(){
        mUniversityList = new ArrayList<>();
        mUniversityList.add(new UniversityItem("KMITL",R.drawable.kmitl));
        mUniversityList.add(new UniversityItem("MU",R.drawable.mu));
        mUniversityList.add(new UniversityItem("TNI",R.drawable.tni));
        mUniversityList.add(new UniversityItem("SPU",R.drawable.spu));
        mUniversityList.add(new UniversityItem("TU",R.drawable.tu));
        mUniversityList.add(new UniversityItem("CU",R.drawable.cu));

    }
}
