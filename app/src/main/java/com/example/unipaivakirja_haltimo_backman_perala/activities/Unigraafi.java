package com.example.unipaivakirja_haltimo_backman_perala.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.unipaivakirja_haltimo_backman_perala.R;
import com.example.unipaivakirja_haltimo_backman_perala.classes.YoData;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class Unigraafi extends AppCompatActivity {

    GraphView graphView;
    LineGraphSeries<DataPoint> series;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unigraafi);

        // Etsitään graaphi elementti
        graphView = (GraphView) findViewById(R.id.graph);

        series= new LineGraphSeries<DataPoint>(data());
        graphView.addSeries(series);
    }

    public DataPoint[] data(){
        int x_axis;
        int offSet;
        if (YoData.getInstance().getYot().size() > 20) {
            x_axis = 20;
            offSet = YoData.getInstance().getYot().size() - 20;
        } else {
            x_axis = YoData.getInstance().getYot().size();
            offSet = 0;
        }

        DataPoint[] dataPisteet = new DataPoint[x_axis];
        for (int i = 0 + offSet; i < x_axis; i++){
            DataPoint yksittäinenPiste = new DataPoint(i, YoData.getInstance().getYot().get(i).getNukututTunnit());
            dataPisteet[i] = yksittäinenPiste;
        }
        return dataPisteet;
    }
}

