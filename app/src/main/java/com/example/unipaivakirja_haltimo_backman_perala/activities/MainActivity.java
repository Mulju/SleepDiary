package com.example.unipaivakirja_haltimo_backman_perala.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.unipaivakirja_haltimo_backman_perala.R;
import com.example.unipaivakirja_haltimo_backman_perala.classes.Constants;

public class MainActivity extends AppCompatActivity {
    // Määritellään nappi
    Button jatka;

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
    }
}