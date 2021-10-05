package com.example.unipaivakirja_haltimo_backman_perala.layouts;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.text.format.DateFormat;

import com.example.unipaivakirja_haltimo_backman_perala.R;
import com.jjoe64.graphview.DefaultLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.helper.DateAsXAxisLabelFormatter;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Unigraafi extends AppCompatActivity {

    GraphView graphView;
    LineGraphSeries<DataPoint> series;
    SimpleDateFormat sdf = new SimpleDateFormat("d.M");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unigraafi);

        graphView = (GraphView) findViewById(R.id.graph);
        series = new LineGraphSeries<>(getDataPoint());
        graphView.addSeries(series);

        graphView.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter()
        {
            @Override
            public String formatLabel(double value, boolean isValueX) {
                if(isValueX){
                    return sdf.format(new Date((long) value));
                } else {
                    return super.formatLabel(value, isValueX);
                }
            }
        });

    }
    private DataPoint[] getDataPoint() {
        DataPoint[] dp = new DataPoint[]
                {
                        new DataPoint(new Date().getTime(), 7),
                        new DataPoint(new Date().getTime(), 8),
                        new DataPoint(new Date().getTime(), 9),
                        new DataPoint(new Date().getTime(), 6),
                        new DataPoint(new Date().getTime(), 5),
                        new DataPoint(new Date().getTime(), 6),
                        new DataPoint(new Date().getTime(), 7),
                        new DataPoint(new Date().getTime(), 8),
                        new DataPoint(new Date().getTime(), 9),
                        new DataPoint(new Date().getTime(), 10),
                };
        return dp;
    }
}