package com.example.myapplication.Calculation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.ArrayList;

public class CostCal extends AppCompatActivity {
    Button bt,bc;
    Spinner st,ss1,ss2;
    TextView tc;
    int indexTrain,indexStation1,indexStation2;
    private ArrayList<TrainItem> mTrainList;
    private TrainAdapter mAdapter;
    ArrayAdapter<CharSequence> adapter,adapter2,adapter3,adapter4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_costcal);

        initList();
        mAdapter = new TrainAdapter(this,mTrainList);


        bt = (Button) findViewById(R.id.butt_train);
        bc = (Button) findViewById(R.id.butt_cal);
        st = (Spinner) findViewById(R.id.spinner_train);
        ss1 = (Spinner) findViewById(R.id.spinner_station1);
        ss2 = (Spinner) findViewById(R.id.spinner_station2);
        tc = (TextView) findViewById(R.id.priceCal);

        loadTrainName();

        st.setAdapter(mAdapter);
        st.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TrainItem clickedItem = (TrainItem) parent.getItemAtPosition(position);
                String clickedTrainName = clickedItem.getmTrainName();
                //Toast.makeText(CostCal.this,clickedTrainName+" selected",Toast.LENGTH_SHORT).show();
                indexTrain = st.getSelectedItemPosition();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void  OnClickTrain(View v)
    {
        ss1.setVisibility(View.VISIBLE);
        ss2.setVisibility(View.VISIBLE);
        bc.setVisibility(View.VISIBLE);
        loadTrainName();
    }
    public void OnClickCal(View v)
    {
        if (indexTrain == 0){
            ARLCal();
        }
        else if (indexTrain == 1){
            BTSCal();
        }
        else if (indexTrain == 2){
            MRTCal();
        }
        else if (indexTrain == 3){
            MRTPcal();
        }
        tc.setVisibility(View.VISIBLE);

    }
    public void initList()
    {
        mTrainList = new ArrayList<>();
        mTrainList.add(new TrainItem("ARL",R.drawable.arl));
        mTrainList.add(new TrainItem("BTS",R.drawable.bts));
        mTrainList.add(new TrainItem("MRT",R.drawable.mrt));
        mTrainList.add(new TrainItem("MRTสายสีม่วง",R.drawable.mrtp));
    }
    public void loadTrainName()
    {
        if (indexTrain == 0) {

            adapter = ArrayAdapter.createFromResource(this, R.array.arl_name, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            ss1.setAdapter(adapter);
            ss2.setAdapter(adapter);
        }
        else if(indexTrain ==1){
            adapter2 = ArrayAdapter.createFromResource(this, R.array.bts_name, android.R.layout.simple_spinner_item);
            adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            ss1.setAdapter(adapter2);
            ss2.setAdapter(adapter2);
        }
        else if (indexTrain == 2){
            adapter3 = ArrayAdapter.createFromResource(this, R.array.mrt_name, android.R.layout.simple_spinner_item);
            adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            ss1.setAdapter(adapter3);
            ss2.setAdapter(adapter3);
        }
        else if(indexTrain == 3){
            adapter4 = ArrayAdapter.createFromResource(this, R.array.mrtp_name, android.R.layout.simple_spinner_item);
            adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            ss1.setAdapter(adapter4);
            ss2.setAdapter(adapter4);
        }
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        ss1.setAdapter(adapter);
//        ss2.setAdapter(adapter);
        ss1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getBaseContext(),parent.getItemAtPosition(position)+" select",Toast.LENGTH_SHORT).show();
                indexStation1 = ss1.getSelectedItemPosition();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ss2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                indexStation2 = ss2.getSelectedItemPosition();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    public void ARLCal()
    {
        int ARLprice = Math.abs(indexStation2-indexStation1);
        if (ARLprice == 0 )
        {
            tc.setText("0 บาท");
        }
        else if (ARLprice == 1)
        {
            tc.setText("15 บาท");
        }
        else if (ARLprice == 2)
        {
            tc.setText("20 บาท");
        }
        else if (ARLprice == 3)
        {
            tc.setText("25 บาท");
        }
        else if (ARLprice == 4)
        {
            tc.setText("30 บาท");
        }
        else if (ARLprice == 5)
        {
            tc.setText("35 บาท");
        }
        else if (ARLprice == 6)
        {
            tc.setText("40 บาท");
        }
        else if(ARLprice==7)
        {
            tc.setText("45 บาท");
        }

    }
    public void BTSCal()
    {
        String [][] BTSprice = new String[][] {{"0","16","26","30","33","37","40","44","44","44","44","44","44","44","44","44","44","59","59","59","59","59","59","44","44","44","44","44","44","44","44","59","59","59","59"},
                {"16","0","23","26","30","33","37","40","44","44","44","44","44","44","44","44","44","59","59","59","59","59","59","44","44","44","44","44","44","44","44","59","59","59","59"},
                {"26","23","0","16","23","26","30","33","37","40","44","44","44","44","44","44","44","59","59","59","59","59","59","37","37","40","44","44","44","44","44","59","59","59","59"},
                {"30","26","16","0","16","23","26","30","33","37","40","44","44","44","44","44","44","59","59","59","59","59","59","33","33","37","40","44","44","44","44","59","59","59","59"},
                {"33","30","26","16","0","16","23","26","30","33","37","40","44","44","44","44","44","59","59","59","59","59","59","30","30","33","37","44","40","44","44","59","59","59","59"},
                {"37","33","30","26","16","0","16","23","26","30","33","37","40","44","44","44","44","59","59","59","59","59","59","26","26","30","33","40","37","44","44","59","59","59","59"},
                {"40","37","33","30","26","16","0","16","23","26","30","33","37","40","44","44","44","59","59","59","59","59","59","23","23","26","30","37","40","44","44","59","59","59","59"},
                {"44","40","37","33","30","26","16","0","16","23","26","30","33","37","40","44","44","59","59","59","59","59","59","16","16","23","26","33","37","40","44","59","59","59","59"},
                {"44","44","40","37","33","30","26","16","0","16","23","26","30","33","37","40","44","59","59","59","59","59","59","23","23","26","30","37","40","44","44","59","59","59","59"},
                {"44","44","40","37","33","30","26","23","16","0","16","23","26","30","33","37","40","55","55","55","55","55","55","26","26","30","33","40","44","44","44","59","59","59","59"},
                {"44","44","44","40","37","33","30","26","23","16","0","16","23","26","30","33","37","52","52","52","52","52","52","30","30","33","37","44","44","44","44","59","59","59","59"},
                {"44","44","44","44","40","37","33","30","26","23","16","0","16","23","26","30","33","52","52","52","52","52","52","33","33","37","40","44","44","44","44","59","59","59","59"},
                {"44","44","44","44","44","40","37","33","30","26","23","16","0","16","23","26","30","52","52","52","52","52","52","37","37","40","44","44","44","44","44","59","59","59","59"},
                {"44","44","44","44","44","44","40","37","33","30","26","23","16","0","16","23","26","41","41","41","41","41","41","40","40","44","44","44","44","44","44","59","59","59","59"},
                {"44","44","44","44","44","44","44","40","37","33","30","26","23","16","0","16","23","38","38","38","38","38","38","44","44","44","44","44","44","44","59","59","59","59","59"},
                {"44","44","44","44","44","44","44","44","40","37","33","30","26","23","16","0","16","31","31","31","31","31","31","44","44","44","44","44","44","44","44","59","59","59","59"},
                {"44","44","44","44","44","44","44","44","44","40","37","33","30","26","23","16","0","15","15","15","15","15","15","44","44","44","44","44","44","44","59","59","59","59","59"},
                {"59","59","59","59","59","59","59","59","59","55","52","48","45","41","38","31","15","0","15","15","15","15","15","59","59","59","59","59","59","59","59","59","59","59","59"},
                {"59","59","59","59","59","59","59","59","59","55","52","48","45","41","38","31","15","15","0","15","15","15","15","59","59","59","59","59","59","59","59","59","59","59","59"},
                {"59","59","59","59","59","59","59","59","59","55","52","48","45","41","38","31","15","15","15","0","15","15","15","59","59","59","59","59","59","59","59","59","59","59","59"},
                {"59","59","59","59","59","59","59","59","59","55","52","48","45","41","38","31","15","15","15","15","0","15","15","59","59","59","59","59","59","59","59","59","59","59","59"},
                {"59","59","59","59","59","59","59","59","59","55","52","52","52","41","38","31","15","15","15","15","15","0","15","59","59","59","59","59","59","59","59","59","59","59","59"},
                {"59","59","59","59","59","59","59","59","59","55","52","52","52","41","38","31","15","15","15","15","15","0","0","59","59","59","59","59","59","59","59","59","59","59","59"},
                {"44","44","37","33","30","26","23","16","23","26","30","33","37","40","44","44","44","59","59","59","59","59","59","0","23","26","30","37","40","44","44","59","59","59","59"},
                {"44","44","37","33","30","26","23","16","23","26","30","33","37","40","44","44","44","59","59","59","59","59","59","23","0","16","23","30","33","37","40","55","55","55","55"},
                {"44","44","40","37","33","30","26","23","26","30","33","37","40","44","44","44","44","59","59","59","59","59","59","26","16","0","16","30","30","33","37","52","52","52","52"},
                {"44","44","44","40","37","33","30","26","30","33","37","40","44","44","44","44","44","59","59","59","59","59","59","30","23","16","0","26","26","30","33","48","48","48","48"},
                {"44","44","44","44","44","40","37","33","37","40","44","44","44","44","44","44","44","59","59","59","59","59","59","37","30","30","26","0","16","23","26","41","41","41","41"},
                {"44","44","44","44","40","37","40","37","40","44","44","44","44","44","44","44","44","59","59","59","59","59","59","40","33","30","26","16","0","16","16","31","31","31","31"},
                {"44","44","44","44","44","44","44","40","44","44","44","44","44","44","44","44","44","59","59","59","59","59","59","44","37","33","30","23","16","0","16","31","31","31","31"},
                {"44","44","44","44","44","44","44","44","44","44","44","44","44","44","59","44","59","59","59","59","59","59","59","44","40","37","33","26","16","16","0","15","15","15","15"},
                {"59","59","59","59","59","59","59","59","59","59","59","59","59","59","59","59","59","59","59","59","59","59","59","59","55","52","48","41","31","31","15","0","15","15","15"},
                {"59","59","59","59","59","59","59","59","59","59","59","59","59","59","59","59","59","59","59","59","59","59","59","59","55","52","48","41","31","31","15","15","0","15","15"},
                {"59","59","59","59","59","59","59","59","59","59","59","59","59","59","59","59","59","59","59","59","59","59","59","59","55","52","48","41","31","31","15","15","15","0","15"},
                {"59","59","59","59","59","59","59","59","59","59","59","59","59","59","59","59","59","59","59","59","59","59","59","59","55","52","48","41","31","31","15","15","15","15","0"}};
        String btsprice = BTSprice[indexStation1][indexStation2];
        tc.setText(btsprice+" บาท");
    }
    public void MRTCal()
    {
        int MRTprice = Math.abs(indexStation2-indexStation1);
        if (MRTprice == 0 )
        {
            tc.setText("0 บาท");
        }
        else if (MRTprice == 1)
        {
            tc.setText("16 บาท");
        }
        else if (MRTprice == 2)
        {
            tc.setText("19 บาท");
        }
        else if (MRTprice == 3)
        {
            tc.setText("21 บาท");
        }
        else if (MRTprice == 4)
        {
            tc.setText("23 บาท");
        }
        else if (MRTprice == 5)
        {
            tc.setText("26 บาท");
        }
        else if (MRTprice == 6)
        {
            tc.setText("28 บาท");
        }
        else if(MRTprice ==7)
        {
            tc.setText("30 บาท");
        }
        else if(MRTprice ==8)
        {
            tc.setText("33 บาท");
        }
        else if(MRTprice ==9)
        {
            tc.setText("35 บาท");
        }
        else if(MRTprice ==10)
        {
            tc.setText("37 บาท");
        }
        else if(MRTprice ==11)
        {
            tc.setText("40 บาท");
        }
        else if(MRTprice ==12)
        {
            tc.setText("42 บาท");
        }
        else if(MRTprice ==13)
        {
            tc.setText("42 บาท");
        }
        else if(MRTprice ==14)
        {
            tc.setText("42 บาท");
        }
        else if(MRTprice ==15)
        {
            tc.setText("42 บาท");
        }
        else if(MRTprice ==16)
        {
            tc.setText("42 บาท");
        }
        else if(MRTprice ==17)
        {
            tc.setText("42 บาท");
        }
        else if(MRTprice ==18)
        {
            tc.setText("42 บาท");
        }
    }
    public void  MRTPcal()
    {
        int row = indexStation1;
        int column = indexStation2;
        String [][] MRTPprice = new String[][]{ {"16","17","20","23","25","28","30","32","35","38","41","42","42","42","42","42"},
                                                {"17","14","17","20","22","25","27","29","32","35","38","40","42","42","42","42"},
                                                {"20","17","14","17","19","22","24","26","29","32","35","37","39","42","42","42"},
                                                {"23","20","17","14","16","19","21","23","26","29","32","34","36","39","42","42"},
                                                {"25","22","19","16","14","17","19","21","24","27","30","32","34","37","40","42"},
                                                {"28","25","22","19","17","14","16","18","21","24","27","29","31","34","37","40"},
                                                {"30","27","24","21","19","16","14","16","19","22","25","27","29","32","35","38"},
                                                {"32","29","26","23","21","18","16","14","17","20","23","25","27","30","33","36"},
                                                {"35","32","29","27","24","21","19","17","14","17","20","22","24","27","30","33"},
                                                {"38","35","32","29","27","24","22","20","17","14","17","19","21","24","27","30"},
                                                {"41","38","35","32","30","27","25","23","20","17","14","16","18","21","24","27"},
                                                {"42","40","37","34","32","29","27","25","22","19","16","14","16","19","22","25"},
                                                {"42","42","39","36","34","31","29","27","24","21","18","16","14","17","20","23"},
                                                {"42","42","42","39","37","34","32","30","27","24","21","19","17","14","17","20"},
                                                {"42","42","42","42","40","37","35","33","30","27","24","22","20","17","14","17"},
                                                {"42","42","42","42","42","40","38","36","33","30","27","25","23","20","17","14"},
                                              };
        String Mrtprice = MRTPprice[row][column];
        tc.setText(Mrtprice+" บาท");


    }
}
