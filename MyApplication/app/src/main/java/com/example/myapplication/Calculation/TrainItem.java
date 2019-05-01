package com.example.myapplication.Calculation;

public class TrainItem {
    private String mTrainName;
    private int mTrainImage;

    public TrainItem(String TrainName,int TrainImage)
    {
        this.mTrainName = TrainName;
        this.mTrainImage = TrainImage;
    }
    public  String getmTrainName(){return mTrainName;}
    public int getmTrainImage(){return mTrainImage;}

}
