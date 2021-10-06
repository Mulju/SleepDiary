package com.example.unipaivakirja_haltimo_backman_perala.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.unipaivakirja_haltimo_backman_perala.R;

public class Valikko extends AppCompatActivity {
    // määritellään nappulat
    Button kerroyostasi, unesi, unigraafi, asetukset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_valikko);

        // määritellään jokaiselle nappulalle oma intent
        Intent intentKerroYostasi = new Intent(this, KerroYostasi.class);
        Intent intentUnesi = new Intent(this, Unesi.class);
        Intent intentUnigraafi = new Intent(this, Unigraafi.class);
        Intent intentAsetukset = new Intent(this, Asetukset.class);

        // määritellään id:t
        kerroyostasi = findViewById(R.id.button_kerroyo);
        unesi = findViewById(R.id.button_unesi);
        unigraafi = findViewById(R.id.button_unigraafi);
        asetukset = findViewById(R.id.button_asetukset);

        // tehdään jokaiselle nappulalle onClickListener, joka avaa uuden näkymän
        kerroyostasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intentKerroYostasi);
            }
        });
        unesi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intentUnesi);
            }
        });
        unigraafi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intentUnigraafi);
            }
        });
        asetukset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intentAsetukset);
            }
        });
    }

}