package com.example.unipaivakirja_haltimo_backman_perala.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.unipaivakirja_haltimo_backman_perala.R;
import com.example.unipaivakirja_haltimo_backman_perala.classes.Yo;
import com.example.unipaivakirja_haltimo_backman_perala.classes.YoData;

import java.util.ArrayList;

public class Unesi extends AppCompatActivity {

    private ListView lvUnet;
    public static final String EXTRA_MESSAGE = "com.example.unipaivakirja.MESSAGE";
    public static final String EXTRA_MESSAGE2 = "com.example.unipaivakirja.MESSAGE2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unesi);
        // määritellään listview ja intent
        lvUnet = findViewById(R.id.listView_unet);
        Intent intent = new Intent(this, TiettyUni.class);


        lvUnet.setAdapter(new ArrayAdapter<Yo>(this,
                R.layout.listview_layout,
                YoData.getInstance().getYot()));


        lvUnet.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                String message = YoData.getInstance().getYot().get(i).getNahdytUnet();
                intent.putExtra(EXTRA_MESSAGE, message);
                String message2 = YoData.getInstance().getYot().get(i).getEnnenNukkumaan();
                intent.putExtra(EXTRA_MESSAGE2, message2);

                startActivity(intent);
            }
        });
    }

}