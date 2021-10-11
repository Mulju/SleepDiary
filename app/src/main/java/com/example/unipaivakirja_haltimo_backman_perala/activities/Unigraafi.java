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
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(getDataPoint());
        graphView.addSeries(series);

    }

    private DataPoint[] getDataPoint(){
        int nukututTunnit1 = YoData.getInstance().getYot().get(YoData.getInstance().getYot().size() - 1).getNukututTunnit();
        int nukututTunnit2 = YoData.getInstance().getYot().get(YoData.getInstance().getYot().size() - 2).getNukututTunnit();
        int nukututTunnit3 = YoData.getInstance().getYot().get(YoData.getInstance().getYot().size() - 3).getNukututTunnit();
        int nukututTunnit4 = YoData.getInstance().getYot().get(YoData.getInstance().getYot().size() - 4).getNukututTunnit();
        int nukututTunnit5 = YoData.getInstance().getYot().get(YoData.getInstance().getYot().size() - 5).getNukututTunnit();
        int nukututTunnit6 = YoData.getInstance().getYot().get(YoData.getInstance().getYot().size() - 6).getNukututTunnit();
        int nukututTunnit7 = YoData.getInstance().getYot().get(YoData.getInstance().getYot().size() - 7).getNukututTunnit();

        DataPoint[] dp = new DataPoint[]{
                new DataPoint(0, nukututTunnit1),
                new DataPoint(1, nukututTunnit2),
                new DataPoint(2, nukututTunnit3),
                new DataPoint(3, nukututTunnit4),
                new DataPoint(4, nukututTunnit5),
                new DataPoint(5, nukututTunnit6),
                new DataPoint(6, nukututTunnit7),
        };
        return (dp);
    }

}

