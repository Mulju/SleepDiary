package com.example.unipaivakirja_haltimo_backman_perala.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.text.format.DateFormat;

import com.example.unipaivakirja_haltimo_backman_perala.R;
import com.example.unipaivakirja_haltimo_backman_perala.classes.Paivamaara;
import com.example.unipaivakirja_haltimo_backman_perala.classes.Yo;
import com.example.unipaivakirja_haltimo_backman_perala.classes.YoData;
import com.jjoe64.graphview.DefaultLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Unigraafi extends AppCompatActivity {

    GraphView graphView;
    LineGraphSeries<DataPoint> series;
    SimpleDateFormat sdf = new SimpleDateFormat("d.M");
    Paivamaara paivamaara;
    Yo yo;
    YoData data = YoData.getInstance();

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
        DataPoint[] dp = new DataPoint[]{};{
        int count = 0;
        while (data.getYot().size() > count) {
            int nukututTunnit = data.getYot().get(count).getNukututTunnit();
            new DataPoint(new Date().getTime(), nukututTunnit);
            count++;
        }
        };
        return dp;
    }
}

