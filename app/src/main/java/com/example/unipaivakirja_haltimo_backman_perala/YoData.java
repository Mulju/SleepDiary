package com.example.unipaivakirja_haltimo_backman_perala;

import java.util.ArrayList;

public class YoData {
    private static final YoData ourInstance = new YoData();
    private ArrayList<Yo> yot;

    public static YoData getInstance() {
        return ourInstance;
    }

    private YoData() {
        yot = new ArrayList<>();
    }

    public void addYo(Yo yo) {
        yot.add(yo);
    }

    public ArrayList<Yo> getYot() {
        return yot;
    }
}
