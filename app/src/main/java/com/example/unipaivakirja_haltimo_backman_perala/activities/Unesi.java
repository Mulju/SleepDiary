/*
 * @(#)Unesi 11.10.2021 versio 1.0
 *
 * Copyright ryhmä Pikakassa
 *
 */

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

/*
 * Tässä luokassa annetut unet näkyvät listviewna, josta voi katsoa tietyn yön unet, nukutut tunnit ja
 * asiat joita käyttäjä teki ennen nukkumaan menoa, kun käyttäjä klikkaa jotain päivämäärää listassa.
 *
 *
 * @version 1.0 11.10.2021
 * @author Samuli Haltimo, Sami Bäckman, Pyry Perälä
 */

public class Unesi extends AppCompatActivity {

    //määritellään listview ja extramessaget
    private ListView lvUnet;
    public static final String EXTRA_MESSAGE = "com.example.unipaivakirja.MESSAGE";
    public static final String EXTRA_MESSAGE2 = "com.example.unipaivakirja.MESSAGE2";
    public static final String EXTRA_MESSAGE3 = "com.example.unipaivakirja.MESSAGE3";

    /*
     * onCreatessa hankitaan id listviewille, luodaan listview ja intent, OnItemClickListener ja
     * arrayadapter
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unesi);
        // annetaan id listviewille, ja luodaan listview ja intent
        lvUnet = findViewById(R.id.listView_unet);
        Intent intent = new Intent(this, TiettyUni.class);

        //tehdään arrayadapter listviewille
        lvUnet.setAdapter(new ArrayAdapter<Yo>(this,
                R.layout.listview_layout,
                YoData.getInstance().getYot()));

        //tehdään OnItemClickListener joka vie käyttäjän uuteen näkymään joka sisältää aikaisemmin annetut tiedot
        lvUnet.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                String message = YoData.getInstance().getYot().get(i).getNahdytUnet();
                intent.putExtra(EXTRA_MESSAGE, message);
                String message2 = YoData.getInstance().getYot().get(i).getEnnenNukkumaan();
                intent.putExtra(EXTRA_MESSAGE2, message2);
                String message3 = Integer.toString(YoData.getInstance().getYot().get(i).getNukututTunnit());
                intent.putExtra(EXTRA_MESSAGE3, message3);

                startActivity(intent);
            }
        });
    }

}