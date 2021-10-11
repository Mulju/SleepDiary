/*
 * @(#)TiettyUni 11.10.2021 versio 1.0
 *
 * Copyright ryhmä Pikakassa
 *
 */

package com.example.unipaivakirja_haltimo_backman_perala.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.unipaivakirja_haltimo_backman_perala.R;

/*
 * Tässä luokassa käyttäjä pystyy tarkastelemaan tietyn päivän nukuttuja tunetja, nähtyjä unia ja
 * ennen nukkumaanmenoa tehtyjä asioita
 *
 *
 * @version 1.0 11.10.2021
 * @author Samuli Haltimo, Sami Bäckman, Pyry Perälä
 */

public class TiettyUni extends AppCompatActivity {

    /*
     * onCreatessa määritellään textview id:t, asetetaan tekstikenttiin datat ja otetaan ne edellisestä intentistä
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tietty_uni);

        //otetaan tiedot edellisestä intentistä
        Intent intent = getIntent();
        String message = intent.getStringExtra(Unesi.EXTRA_MESSAGE);
        String message2 = intent.getStringExtra(Unesi.EXTRA_MESSAGE2);
        String message3 = intent.getStringExtra(Unesi.EXTRA_MESSAGE3);

        // luodaan tekstikentät ja syötetään niihin halutut tiedot
        TextView textView = findViewById(R.id.textView_tiettyUni);
        textView.setText(message);

        TextView textView2 = findViewById(R.id.textView_tiettyUni2);
        textView2.setText(message2);

        TextView textView3 = findViewById(R.id.textView_tiettyUni6);
        textView3.setText(message3);
    }
}