package com.example.unipaivakirja_haltimo_backman_perala.classes;

import java.util.ArrayList;

public class YoData {
    private static final YoData ourInstance = new YoData();
    private ArrayList<Yo> yot;

    public static YoData getInstance() {
        return ourInstance;
    }

    private YoData() {


        yot = new ArrayList<>();
        yot.add(new Yo(1, 1, 1, 1, "hubba,", "bubba"));
        yot.add(new Yo(12, 1, 1, 1, "hubba2,", "bubba2"));
    }

    public void addYo(Yo yo) {
        this.yot.add(yo);
    }

    public ArrayList<Yo> getYot() {
        return yot;
    }
}
