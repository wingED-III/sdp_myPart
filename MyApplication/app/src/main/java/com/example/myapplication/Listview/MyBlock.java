package com.example.myapplication.Listview;

import android.widget.Button;

public class MyBlock {
    private int statinID;
    private int type;
    private String location;
    private String descript;
    private Button button;

    public Button getButton() {
        return button;
    }

    public MyBlock(int statinID, int type, String location, String descript) {
        this.statinID = statinID;
        this.type = type;
        this.location = location;
        this.descript = descript;
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
