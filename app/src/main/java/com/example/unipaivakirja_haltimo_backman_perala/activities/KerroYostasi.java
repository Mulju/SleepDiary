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
import com.example.unipaivakirja_haltimo_backman_perala.classes.YoData;

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
        //Tehdään sharedpreferences ja sen editori
        SharedPreferences prefPut = getSharedPreferences("Unitallennus", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefPut.edit();
        //määritellään muuttujat ottamalla arvot tekstikentistä
        String paivays = pvm.getText().toString();
        //käytetään splitstringia jotta saamme päivämäärän päivät kuukaudet ja vuodet erikseen
        String paivays2[] = paivays.split("\\.");

        String paiva = paivays2[0];
        String kuukausi = paivays2[1];
        String vuosi = paivays2[2];

        String tunnitGraafiin = tunnit.getText().toString();
        String tehdytAsiat = mitaTeit.getText().toString();
        String kerrotutUnet = unet.getText().toString();

        // luodaan int muuttujat pvm:stä ja tunneista if-lausetta varten
        int tunnit2 = Integer.parseInt(tunnitGraafiin);
        int paiva2 = Integer.parseInt(paiva);
        int kk2 = Integer.parseInt(kuukausi);
        int vuosi2 = Integer.parseInt(vuosi);

        // if-lause joka varmistaa ettei annetut arvot ole absurdeja
        if (tunnit2 > 14 || tunnit2 < 0 || vuosi2 < 2000 || paiva2 > 31 || paiva2 < 1 || kk2 > 12 || kk2 < 1) {

            // Tehdään toasti joka ilmoittaa että annetut tunnit ovat epäilyttäviä
            Toast.makeText(KerroYostasi.this, "Syötä validit arvot (tunnit 0-14, oikea pvm)", Toast.LENGTH_SHORT).show();

        } else {
            //tallennetaan muuttujat sharedpreferenceihin
            editor.putString("paiva", paiva);
            editor.putString("kuukausi", kuukausi);
            editor.putString("vuosi", vuosi);
            editor.putString("tunnitGraafiin", tunnitGraafiin);
            editor.putString("tehdytAsiat", tehdytAsiat);
            editor.putString("kerrotutUnet", kerrotutUnet);
            editor.commit();
            // Tehdään toasti joka ilmoittaa että data on tallenettu
            Toast.makeText(KerroYostasi.this, "Data tallennettu", Toast.LENGTH_SHORT).show();

            // luodaan uusi yö olio annetuista tiedoista ja kirjataan se "Unesi"-näkymään
            YoData.getInstance().getYot().add(new Yo((Integer.parseInt(paiva)), Integer.parseInt(kuukausi), Integer.parseInt(vuosi),
                    Integer.parseInt(tunnitGraafiin), kerrotutUnet, tehdytAsiat));
        }


    }

}