/*
 * @(#)MainActivity 11.10.2021 versio 1.0
 *
 * Copyright ryhmä Pikakassa
 *
 */

package com.example.unipaivakirja_haltimo_backman_perala.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.unipaivakirja_haltimo_backman_perala.classes.Yo;
import com.example.unipaivakirja_haltimo_backman_perala.classes.YoData;
import com.google.gson.Gson;

import com.example.unipaivakirja_haltimo_backman_perala.R;
import com.example.unipaivakirja_haltimo_backman_perala.classes.Constants;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

/*
 * Tämä luokka on sovelluksen aloitus ruutu.
 * Käyttäjä painaa "jatka"-nappia, joka vie hänet valikkoon
 * Tässä luokassa myös tallenetaan aiemmat datat
 *
 * @version 1.0 11.10.2021
 * @author Samuli Haltimo, Sami Bäckman, Pyry Perälä
 */

public class MainActivity extends AppCompatActivity {
    // Määritellään nappi ja YoData
    Button jatka;
    YoData data = YoData.getInstance();


    /*
     * onCreatessa luodaan intent ja tehdään "jatka"-nappulalle listeneri, joka avaa uuden intentin
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Määritellään intent Valikko-aktiviteetille
        Intent intent = new Intent(this, Valikko.class);

        // Haetaan Jatka-napille view ja asetetaan kuuntelija
        jatka = findViewById(R.id.button_aloitus);
        jatka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Napin painallus avaa uuden aktiviteetin
                startActivity(intent);
            }
        });

        //määritellään shared preference
        SharedPreferences prefGet = getSharedPreferences("Unitallennus", Activity.MODE_PRIVATE);

        // Haetaan YoData:n tallennettu json versio
        String json = prefGet.getString("json", "-1");

        // Tallennetaan tämän istunnnon YoData listaan aiemman istunnon lista
        // mikäli aiemmassa listassa oli jotakin
        if (!json.equals("-1")) {
            Gson gson = new Gson();
            TypeToken<List<Yo>> token = new TypeToken<List<Yo>>() {};
            List<Yo> tokenList = gson.fromJson(json,  token.getType());

            ArrayList<Yo> yoListaBack = new ArrayList<>(tokenList.size());
            yoListaBack.addAll(tokenList);

            for (int i = 0; i < yoListaBack.size(); i++) {
                YoData.getInstance().getYot().add(yoListaBack.get(i));
            }
        }
    }
}