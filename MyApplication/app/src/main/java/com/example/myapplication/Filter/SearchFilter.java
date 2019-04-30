package com.example.myapplication.Filter;

import com.example.myapplication.Listview.MyBlock;

import java.util.ArrayList;

public class SearchFilter {
    private int selectedStation = 0;
    private int typeLocation = 0;

    public SearchFilter() {
    }

    public int getSelectedStation() {
        return selectedStation;
    }

    public void setSelectedStation(int selectedStation) {
        this.selectedStation = selectedStation;
    }

    public int getTypeLocation() {
        return typeLocation;
    }

    public void setTypeLocation(int typeLocation) {
        this.typeLocation = typeLocation;
    }

    public void filtering(ArrayList<MyBlock> bufferList, ArrayList<MyBlock> allBlocksList) {
        bufferList.clear();
        if (this.selectedStation + this.typeLocation == 0) {
            bufferList.addAll(allBlocksList);
        } else {
            for (MyBlock block : allBlocksList) {
                if (block.getStatinID() == this.selectedStation || this.selectedStation == 0) {
                    if (block.getType() == this.typeLocation || this.typeLocation == 0) {
                        bufferList.add(block);
                    }
                }
            }
        }
    }

    @Override
    public String toString() {
        return
                "selectedStation=" + selectedStation +
                        "\ntypeLocation=" + typeLocation
                ;
    }
}
