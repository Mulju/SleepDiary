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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unigraafi);

        // Etsitään graaphi elementti
        graphView = (GraphView) findViewById(R.id.graph);

        // Graaphi ei piirry, ellei ole täytetty seitsemää yötä
        if (YoData.getInstance().getYot().size() >= 7) {
            LineGraphSeries<DataPoint> series = new LineGraphSeries<>(getDataPoint());
            graphView.addSeries(series);
        }


    }

    private DataPoint[] getDataPoint(){
        // Haetaan seitsemän viimeisimmän yön nukutut tunnit
        int nukututTunnit1 = YoData.getInstance().getYot().get(YoData.getInstance().getYot().size() - 1).getNukututTunnit();
        int nukututTunnit2 = YoData.getInstance().getYot().get(YoData.getInstance().getYot().size() - 2).getNukututTunnit();
        int nukututTunnit3 = YoData.getInstance().getYot().get(YoData.getInstance().getYot().size() - 3).getNukututTunnit();
        int nukututTunnit4 = YoData.getInstance().getYot().get(YoData.getInstance().getYot().size() - 4).getNukututTunnit();
        int nukututTunnit5 = YoData.getInstance().getYot().get(YoData.getInstance().getYot().size() - 5).getNukututTunnit();
        int nukututTunnit6 = YoData.getInstance().getYot().get(YoData.getInstance().getYot().size() - 6).getNukututTunnit();
        int nukututTunnit7 = YoData.getInstance().getYot().get(YoData.getInstance().getYot().size() - 7).getNukututTunnit();

        // Asetetaan data pisteet nukuttujen tuntien perusteella
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

