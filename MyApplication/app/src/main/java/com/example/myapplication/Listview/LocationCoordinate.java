package com.example.myapplication.Listview;

public class LocationCoordinate {
    private double start_latitude;
    private double dest_latitude;
    private double start_longtitude;
    private double dest_longtitude;

    public LocationCoordinate() {
    }

    public LocationCoordinate(double start_latitude, double dest_latitude, double start_longtitude, double dest_longtitude) {
        this.start_latitude = start_latitude;
        this.dest_latitude = dest_latitude;
        this.start_longtitude = start_longtitude;
        this.dest_longtitude = dest_longtitude;
    }

    public double getStart_latitude() {
        return start_latitude;
    }

    public void setStart_latitude(double start_latitude) {
        this.start_latitude = start_latitude;
    }

    public double getDest_latitude() {
        return dest_latitude;
    }

    public void setDest_latitude(double dest_latitude) {
        this.dest_latitude = dest_latitude;
    }

    public double getStart_longtitude() {
        return start_longtitude;
    }

    public void setStart_longtitude(double start_longtitude) {
        this.start_longtitude = start_longtitude;
    }

    public double getDest_longtitude() {
        return dest_longtitude;
    }

    public void setDest_longtitude(double dest_longtitude) {
        this.dest_longtitude = dest_longtitude;
    }
}
