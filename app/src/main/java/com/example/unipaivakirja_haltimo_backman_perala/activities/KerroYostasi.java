package com.example.unipaivakirja_haltimo_backman_perala.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.unipaivakirja_haltimo_backman_perala.R;
import com.example.unipaivakirja_haltimo_backman_perala.classes.Yo;

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
        SharedPreferences prefPut = getSharedPreferences("Unitallennus", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefPut.edit();
        String paivays = pvm.getText().toString();
        String paivays2[] = paivays.split("\\.");

        String paiva = paivays2[0];
        String kuukausi = paivays2[1];
        String vuosi = paivays2[2];

        String tunnitGraafiin = tunnit.getText().toString();
        String tehdytAsiat = mitaTeit.getText().toString();
        String kerrotutUnet = unet.getText().toString();

        // if-lause joka varmistaa ettei annetut tunnit ole absurdeja

        if (!tunnitGraafiin.equals("0") && !tunnitGraafiin.equals("1") && !tunnitGraafiin.equals("2") && !tunnitGraafiin.equals("3") &&
                !tunnitGraafiin.equals("4") && !tunnitGraafiin.equals("5") && !tunnitGraafiin.equals("6") &&
                !tunnitGraafiin.equals("7") && !tunnitGraafiin.equals("8") && !tunnitGraafiin.equals("9") &&
                !tunnitGraafiin.equals("10") && !tunnitGraafiin.equals("11") && !tunnitGraafiin.equals("12") && !tunnitGraafiin.equals("13")
                && !tunnitGraafiin.equals("14")) {

            Toast.makeText(KerroYostasi.this, "Syötä validit arvot (tunnit 0-14)", Toast.LENGTH_SHORT).show();

        } else {
            editor.putString("paiva", paiva);
            editor.putString("kuukausi", kuukausi);
            editor.putString("vuosi", vuosi);
            editor.putString("tunnitGraafiin", tunnitGraafiin);
            editor.putString("tehdytAsiat", tehdytAsiat);
            editor.putString("kerrotutUnet", kerrotutUnet);
            editor.commit();
            Toast.makeText(KerroYostasi.this, "Data tallennettu", Toast.LENGTH_SHORT).show();
            
        }


    }

}