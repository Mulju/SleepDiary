/*
 * @(#)Unigraafi 11.10.2021
 *
 * Copyright ryhmä Pikakassa
 *
 */

package com.example.unipaivakirja_haltimo_backman_perala.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.unipaivakirja_haltimo_backman_perala.R;
import com.example.unipaivakirja_haltimo_backman_perala.classes.YoData;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

/**
 * Tämä luokka on graafin piirtämistä varten.
 * Luokka sisältää graafin alustamisen ja graafin pisteiden hakemisen
 * YoData -luokasta.
 *
 * @version 1.0 11.10.2021
 * @author Samuli Haltimo, Sami Bäckman, Pyry Perälä
 */

public class Unigraafi extends AppCompatActivity {
    // Alustetaan graafi ja graafin pisteet
    GraphView graphView;
    LineGraphSeries<DataPoint> series;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unigraafi);

        // Etsitään graafin view-elementti
        graphView = (GraphView) findViewById(R.id.graph);
        // Määritetään mitkä pisteet graafi piirtää data()-metodin avulla
        series = new LineGraphSeries<DataPoint>(data());
        // Lisätään pisteet graafiin
        graphView.addSeries(series);
    }

    /**
     * Tässä metodissa asetetaan DataPoint-olioon graafin piirtoa varten halutut pisteet.
     * Metodissa myös toteutus, jolla graafiin piirtyy maksimissaan 20 data pistettä.
     *
     * @return palauttaa DataPoint-olion, joka sisältää halutut datapisteet.
     */
    public DataPoint[] data(){
        /** X-akselin pituutta hallinnoiva muuttuja. */
        int x_axis;
        /** Muuttuja, jolla liikutetaan listan indeksiä, mikäli listassa yli 20 alkiota. */
        int offSet;

        // Tarkistetaan onko YoData-singletonin listassa yli 20 alkiota.
        if (YoData.getInstance().getYot().size() > 20) {
            x_axis = 20;
            offSet = YoData.getInstance().getYot().size() - 20;
        } else {
            x_axis = YoData.getInstance().getYot().size();
            offSet = 0;
        }

        // Luodaan DataPoint-olio, johon talletetaan x_axis muuttujan määräämän verran datapisteitä.
        DataPoint[] dataPisteet = new DataPoint[x_axis];
        // For-lause, jolla käydään YoData-luokan listasta nukuttuja tunteja,
        // ja lisätään ne datapisteiksi.
        for (int i = 0 + offSet; i < x_axis; i++){
            DataPoint yksittäinenPiste = new DataPoint(i, YoData.getInstance().getYot().get(i).getNukututTunnit());
            dataPisteet[i] = yksittäinenPiste;
        }
        return dataPisteet;
    }
}