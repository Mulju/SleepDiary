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

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    // Määritellään nappi
    Button jatka;
    YoData data = YoData.getInstance();

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

        SharedPreferences prefGet = getSharedPreferences("Unitallennus", Activity.MODE_PRIVATE);
        String paiva = prefGet.getString("paiva", "0");
        String kuukausi = prefGet.getString("kuukausi", "0");
        String vuosi = prefGet.getString("vuosi", "0");
        String tunnitGraafiin = prefGet.getString("tunnitGraafiin", "0");
        String tehdytAsiat = prefGet.getString("tehdytAsiat", "0");
        String kerrotutUnet = prefGet.getString("kerrotutUnet", "0");
        

        ArrayList<Yo> yoLista = new ArrayList<Yo>();
        Gson gson = new Gson();
        String json = gson.toJson(yoLista);

        ArrayList<Yo> yoListaBack = gson.fromJson(json, ArrayList.class);


    }
}