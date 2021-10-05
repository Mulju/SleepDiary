package com.example.unipaivakirja_haltimo_backman_perala;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class KerroYostasi extends AppCompatActivity {

    EditText tunnit, mitaTeit, unet, pvm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kerro_yostasi);
    // määritellään edittext kentät
        pvm = findViewById(R.id.editText_pvm);
        tunnit = findViewById(R.id.editText_nukututTunnit);
        mitaTeit = findViewById(R.id.editText_mitaTeitEnnen);
        unet = findViewById(R.id.editText_millaisiaUnia);
    }

    // tehdään onClick metodi "Lähetä"-nappulalle, joka lähettää tekstikenttiin syötetyt tiedot eteenpäin
    public void sendMessage(View view) {
        SharedPreferences prefPut = getSharedPreferences("mee", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefPut.edit();
        String paivays = pvm.getText().toString();
        String tunnitGraafiin = tunnit.getText().toString();
        String tehdytAsiat = mitaTeit.getText().toString();
        String kerrotutUnet = unet.getText().toString();
        editor.putString("paivays", paivays);
        editor.putString("tunnitGraafiin", tunnitGraafiin);
        editor.putString("tehdytAsiat", tehdytAsiat);
        editor.putString("kerrotutUnet", kerrotutUnet);
        editor.commit();
    }

}