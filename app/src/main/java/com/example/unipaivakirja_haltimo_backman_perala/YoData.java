package com.example.unipaivakirja_haltimo_backman_perala;

public class YoData {
    private static final YoData ourInstance = new YoData();

    public static YoData getInstance() {
        return ourInstance;
    }

    private YoData() {

    }
}
