/*
 * @(#)Asetukset 11.10.2021 versio 1.0
 *
 * Copyright ryhmä Pikakassa
 *
 */


package com.example.unipaivakirja_haltimo_backman_perala.classes;

import java.util.ArrayList;

/**
 * Tässä luokassa on toteutettu Singleton olio YoData.
 * Tähän singletoniin on tallennettuna kaikki käyttäjän syötteestä luodut Yo-oliot.
 *
 * @version 1.0 11.10.2021
 * @author Samuli Haltimo, Sami Bäckman, Pyry Perälä
 */

public class YoData {
    private static final YoData ourInstance = new YoData();
    private ArrayList<Yo> yot;

    public static YoData getInstance() {
        return ourInstance;
    }

    /**
     * YoData Singletonin konstruktori
     */
    private YoData() {
        yot = new ArrayList<>();

    }

    /**
     * Getteri singletonissa olevaa listaa varten.
     * @return palauttaa listan Yo-olioihin.
     */
    public ArrayList<Yo> getYot() {
        return yot;
    }
}
