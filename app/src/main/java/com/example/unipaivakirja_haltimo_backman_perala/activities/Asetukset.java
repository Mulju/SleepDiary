/*
 * @(#)Asetukset 11.10.2021 versio 1.0
 *
 * Copyright ryhmä Pikakassa
 *
 */


package com.example.unipaivakirja_haltimo_backman_perala.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;

import com.example.unipaivakirja_haltimo_backman_perala.R;
import com.example.unipaivakirja_haltimo_backman_perala.classes.Constants;
import com.example.unipaivakirja_haltimo_backman_perala.classes.User;

import java.util.ArrayList;

/**
 * Tämä luokka on asetus näkymää varten.
 * Luokka sisältää toiminnallisuuden asetusten valintaan sekä tallennukseen.
 * Ajanpuutteen vuoksi, emme ehtineet toteuttaa asetusten vaihtamista.
 * Luokassa toteutettu myös popup toiminnallisuus asetus ikkunalle.
 *
 * @version 1.0 11.10.2021
 * @author Samuli Haltimo, Sami Bäckman, Pyry Perälä
 */

public class Asetukset extends AppCompatActivity {
    /** Listanäkymän view elementin alustus */
    private ListView lvAsetukset;
    /** ArrayList eri asetusten listanäkymää varte */
    ArrayList<String> listaAsetukset;

    /** ArrayList yksittäisen asetusten valintoja varten */
    ArrayList<String> listaAsetuksetDarkMode;
    ArrayList<String> listaAsetuksetKieli;
    ArrayList<String> listaAsetuksetFontti;
    ArrayList<String> listaAsetuksetDD;
    /** Yksittäisen asetuksen listanäkymän view elementin alustus */
    private ListView lvDarkMode;
    private ListView lvKieli;
    private ListView lvFontti;
    private ListView lvDD;
    /**
     * ArrayAdapterit yksittäisen asetuksen listanäkymälle
     * Määritelty tässä, koska alustamine on click listenerissä ei toimi
     */
    ArrayAdapter arrayAdapterDarkMode;
    ArrayAdapter arrayAdapterKieli;
    ArrayAdapter arrayAdapterFontti;
    ArrayAdapter arrayAdapterDD;

    /**
     * SharedPreferences olion alustus tallennusta varten,
     * ei käytetty ajan puutten vuoksi
     */
    SharedPreferences prefPut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /*
         * Asetus luokan on create metodi.
         * Kaikki toiminnallisuus on toteutettu tähän metodiin,
         * onClickListenerin asettamisen vuoksi.
         *  */

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asetukset);

        // Asetusten listanäkymää varten luodun listan alustus
        listaAsetukset = new ArrayList<>();
        listaAsetukset.add("Dark Mode");
        listaAsetukset.add("Kieli");
        listaAsetukset.add("Fontin koko");
        listaAsetukset.add("Päiväyksen muotoilu");
        // Haetaan listanäkymän view:n id
        lvAsetukset = findViewById(R.id.listViewAsetukset);
        // Asetetaan asetusten listanäkymälle adapteri
        lvAsetukset.setAdapter(new ArrayAdapter<String>(this,
                R.layout.layout_lw_asetus,
                listaAsetukset));

        // Yksittäistä asetusta varten luodun ArrayListin alustus
        // Perässä myös array adapterin luonti, sillä
        // sen luominen on clickin sisällä aiheutti errorin
        // Luominen ennen, ja sijoittaminen on clickissä sen sijaan toimi
        listaAsetuksetDarkMode = new ArrayList<>();
        listaAsetuksetDarkMode.add("System Default");
        listaAsetuksetDarkMode.add("Light Mode");
        listaAsetuksetDarkMode.add("Dark Mode");
        arrayAdapterDarkMode =  new ArrayAdapter(this,
                R.layout.layout_lw_asetus,
                listaAsetuksetDarkMode);

        listaAsetuksetKieli = new ArrayList<>();
        listaAsetuksetKieli.add("Suomi");
        listaAsetuksetKieli.add("English");
        listaAsetuksetKieli.add("Svenska");
        arrayAdapterKieli = new ArrayAdapter<String>(this,
                R.layout.layout_lw_asetus,
                listaAsetuksetKieli);

        listaAsetuksetFontti = new ArrayList<>();
        listaAsetuksetFontti.add("Iso fontti");
        listaAsetuksetFontti.add("Keskikokoinen fontti");
        listaAsetuksetFontti.add("Pieni fontti");
        arrayAdapterFontti = new ArrayAdapter(this,
                R.layout.layout_lw_asetus,
                listaAsetuksetFontti);

        listaAsetuksetDD = new ArrayList<>();
        listaAsetuksetDD.add("DD.MM.YYYY");
        listaAsetuksetDD.add("MM.DD.YYYY");
        arrayAdapterDD = new ArrayAdapter(this,
                R.layout.layout_lw_asetus,
                listaAsetuksetDD);

        // Alustetaan inflater
        // Inflaterillä luodaan popuppeja varten elementit
        final LayoutInflater inflater = (LayoutInflater)this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // Popuppia varten korkeus- ja leveysmitat
        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;

        // Haetaan shared preferences tallennusta varten
        prefPut = getSharedPreferences("Unitallennus", Activity.MODE_PRIVATE);
        // Haetaan myös editori
        SharedPreferences.Editor prefEditor = prefPut.edit();

        // Kaikki perässä tuleva on ensimmäisen listanäkymän onItemClickListener.
        // Tässä koodi listanäkymälle, missä käyttäjä valitsee,
        // mitä asetusta hän haluaa muokata.
        lvAsetukset.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                /**
                 * Käytetään hyväksi listan indeksiä i.
                 * Tämän avulla voidaan käyttää switch-case rakennetta
                 * ja valita oikean asetuksen.
                 *
                 * Tämä avaa kyseisen asetuksen popup-ikkunan.
                 */
                switch (i) {

                    // Käyttäjä valitsi valinnan Dark Mode
                    case 0:
                        // Luodaan layoutissa määritellyn mukainen popup ikkuna inflaterin avulla
                        View popUpViewDarkMode = inflater.inflate(R.layout.popup_dark_mode, null);
                        PopupWindow pwDarkMode = new PopupWindow(popUpViewDarkMode, width, height, true);

                        // Asetetaan popupille pieni noste (eli varjo)
                        // res.drawable.popup_background löytyy tiedosto millä luodaan popupin borderi
                        pwDarkMode.setElevation(20);

                        // Asemoidaan luotu popup ikkuna keskelle näyttöä
                        pwDarkMode.showAtLocation(view, Gravity.CENTER, 0, 0);

                        // Haetaan listanäkymän view olio
                        lvDarkMode = popUpViewDarkMode.findViewById(R.id.lvDarkMode);
                        // Asetetaan sille adapteri
                        lvDarkMode.setAdapter(arrayAdapterDarkMode);

                        // Asetetaan onItemClickListener popupin sisäiseen listanäkymään,
                        // missä valitaan kyseisen asetuksen arvo.
                        lvDarkMode.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                // Switch lause sisältää asetuksen mahdolliset valinnat
                                switch (i) {
                                    case 0:
                                        // Tallennetaan käyttäjän tekemä valinta User-singletoniin
                                        User.getInstance().setAsetusDarkMode(Constants.SYSTEM_DEFAULT);
                                        // Tallennetaan käyttäjän tekemä valinta shared preferenceihin
                                        prefEditor.putInt("Dark Mode", Constants.SYSTEM_DEFAULT);
                                        prefEditor.commit();
                                        // Valinnan tekeminen list viewissä tappaa popup ikkunan
                                        pwDarkMode.dismiss();
                                        break;
                                    case 1:
                                        User.getInstance().setAsetusDarkMode(Constants.LIGHT_MODE_ON);
                                        prefEditor.putInt("Dark Mode", Constants.LIGHT_MODE_ON);
                                        prefEditor.commit();
                                        pwDarkMode.dismiss();
                                        break;
                                    case 2:
                                        User.getInstance().setAsetusDarkMode(Constants.DARK_MODE_ON);
                                        prefEditor.putInt("Dark Mode", Constants.DARK_MODE_ON);
                                        prefEditor.commit();
                                        pwDarkMode.dismiss();
                                        break;
                                    default:
                                        User.getInstance().setAsetusDarkMode(Constants.SYSTEM_DEFAULT);
                                        prefEditor.putInt("Dark Mode", Constants.SYSTEM_DEFAULT);
                                        prefEditor.commit();
                                        break;
                                }
                            }
                        });
                        break;

                    // Valinta Kieli
                    case 1:
                        View popUpViewKieli = inflater.inflate(R.layout.popup_kieli, null);
                        PopupWindow pwKieli = new PopupWindow(popUpViewKieli, width, height, true);
                        pwKieli.setElevation(20);
                        pwKieli.showAtLocation(view, Gravity.CENTER, 0, 0);

                        lvKieli = popUpViewKieli.findViewById(R.id.lvKieli);
                        lvKieli.setAdapter(arrayAdapterKieli);

                        lvKieli.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                               switch (i) {
                                   case 0:
                                       User.getInstance().setAsetusKieli(Constants.LANG_FIN);
                                       prefEditor.putInt("Kieli", Constants.LANG_FIN);
                                       prefEditor.commit();
                                       pwKieli.dismiss();
                                       break;
                                   case 1:
                                       User.getInstance().setAsetusKieli(Constants.LANG_ENG);
                                       prefEditor.putInt("Kieli", Constants.LANG_ENG);
                                       prefEditor.commit();
                                       pwKieli.dismiss();
                                       break;
                                   case 2:
                                       User.getInstance().setAsetusKieli(Constants.LANG_SWE);
                                       prefEditor.putInt("Kieli", Constants.LANG_SWE);
                                       prefEditor.commit();
                                       pwKieli.dismiss();
                                       break;
                                   default:
                                       User.getInstance().setAsetusKieli(Constants.LANG_FIN);
                                       prefEditor.putInt("Kieli", Constants.LANG_FIN);
                                       prefEditor.commit();
                                       break;
                               }
                            }
                        });
                        break;

                    // Valinta Fontti koko
                    case 2:
                        View popUpViewFontti = inflater.inflate(R.layout.popup_fontti, null);
                        PopupWindow pwFontti = new PopupWindow(popUpViewFontti, width, height, true);
                        pwFontti.setElevation(20);
                        pwFontti.showAtLocation(view, Gravity.CENTER, 0, 0);

                        lvFontti = popUpViewFontti.findViewById(R.id.lvFontti);
                        lvFontti.setAdapter(arrayAdapterFontti);

                        lvFontti.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                switch (i) {
                                    case 0:
                                        User.getInstance().setAsetusFontSize(Constants.FONT_SIZE_LARGE);
                                        prefEditor.putInt("Fontti", Constants.FONT_SIZE_LARGE);
                                        prefEditor.commit();
                                        pwFontti.dismiss();
                                        break;
                                    case 1:
                                        User.getInstance().setAsetusFontSize(Constants.FONT_SIZE_MEDIUM);
                                        prefEditor.putInt("Fontti", Constants.FONT_SIZE_MEDIUM);
                                        prefEditor.commit();
                                        pwFontti.dismiss();
                                        break;
                                    case 2:
                                        User.getInstance().setAsetusFontSize(Constants.FONT_SIZE_SMALL);
                                        prefEditor.putInt("Fontti", Constants.FONT_SIZE_SMALL);
                                        prefEditor.commit();
                                        pwFontti.dismiss();
                                        break;
                                    default:
                                        User.getInstance().setAsetusFontSize(Constants.FONT_SIZE_MEDIUM);
                                        prefEditor.putInt("Fontti", Constants.FONT_SIZE_MEDIUM);
                                        prefEditor.commit();
                                        break;
                                }
                            }
                        });
                        break;

                    // Valinta Päiväyksen muotoilu
                    case 3:
                        View popUpViewDD = inflater.inflate(R.layout.popup_dd, null);
                        PopupWindow pwDD = new PopupWindow(popUpViewDD, width, height, true);
                        pwDD.setElevation(20);
                        pwDD.showAtLocation(view, Gravity.CENTER, 0, 0);

                        lvDD = popUpViewDD.findViewById(R.id.lvDD);
                        lvDD.setAdapter(arrayAdapterDD);

                        lvDD.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                switch (i) {
                                    case 0:
                                        User.getInstance().setAsetusDDMMYYYY(Constants.DD_MM_YYYY);
                                        prefEditor.putInt("DD", Constants.DD_MM_YYYY);
                                        prefEditor.commit();
                                        pwDD.dismiss();
                                        break;
                                    case 1:
                                        User.getInstance().setAsetusDDMMYYYY(Constants.MM_DD_YYYY);
                                        prefEditor.putInt("DD", Constants.MM_DD_YYYY);
                                        prefEditor.commit();
                                        pwDD.dismiss();
                                        break;
                                    default:
                                        User.getInstance().setAsetusDDMMYYYY(Constants.DD_MM_YYYY);
                                        prefEditor.putInt("DD", Constants.DD_MM_YYYY);
                                        prefEditor.commit();
                                        break;
                                }
                            }
                        });
                        break;

                    default:
                        break;
                }
            }
        });
    }
}