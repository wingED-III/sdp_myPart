package com.example.myapplication.Listview;

import android.widget.Button;

public class MyBlock {
    private int statinID;
    private int type;
    private String location;
    private String descript;
    private Button button;
    private int imageID;

    public MyBlock(int statinID, int type, String location, String descript, int imageID) {
        this.statinID = statinID;
        this.type = type;
        this.location = location;
        this.descript = descript;
        this.imageID = imageID;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public Button getButton() {
        return button;
    }


    public int getStatinID() {
        return statinID;
    }

    public int getType() {
        return type;
    }

    public void setButton(Button button) {
        this.button = button;

    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

}
