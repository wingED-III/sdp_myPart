package com.example.myapplication.Listview;

import android.graphics.drawable.Drawable;
import android.widget.Button;

public class MyBlock {
    private int statinID;
    private int type;
    private String location;
    private String descript;
    private Button googleButton;
    private Button mapButton;

    public Button getMapButton() {
        return mapButton;
    }

    public void setMapButton(Button mapButton) {
        this.mapButton = mapButton;
    }

    private Drawable image_drawble;
    private LocationCoordinate coordinate;

    public LocationCoordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(LocationCoordinate coordinate) {
        this.coordinate = coordinate;
    }

    public MyBlock(int statinID, int type, String location, String descript, Drawable image_drawble, LocationCoordinate coordinate) {
        this.statinID = statinID;
        this.type = type;
        this.location = location;
        this.descript = descript;
        this.image_drawble = image_drawble;
        this.coordinate = coordinate;
    }

    public MyBlock(int statinID, int type, String location, String descript, Drawable image_drawble) {
        this.statinID = statinID;
        this.type = type;
        this.location = location;
        this.descript = descript;
        this.image_drawble = image_drawble;
    }

    public Drawable getImage_drawble() {
        return image_drawble;
    }

    public void setImage_drawble(Drawable image_drawble) {
        this.image_drawble = image_drawble;
    }

    public Button getGoogleButton() {
        return googleButton;
    }


    public int getStatinID() {
        return statinID;
    }

    public int getType() {
        return type;
    }

    public void setGoogleButton(Button googleButton) {
        this.googleButton = googleButton;

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
