package com.example.myapplication.BusPack;

import java.util.ArrayList;
import java.util.List;

public class Bus {
    private String bus ;
    private String description;
    private int resId;
    private List<Bus> busList = new ArrayList<>();

    Bus(){

    }
    Bus(int resId,String bus,String description){
        this.resId = resId;
        this.bus = bus;
        this.description = description;
    }

    public String getBus() {
        return bus;
    }

    public void setBus(String bus) {
        this.bus = bus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public List<Bus> getBusList() {
        return busList;
    }

    public void setBusList(List<Bus> busList) {
        this.busList = busList;
    }
}