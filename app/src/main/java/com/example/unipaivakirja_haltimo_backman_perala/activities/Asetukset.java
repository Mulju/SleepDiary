package com.example.unipaivakirja_haltimo_backman_perala.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
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
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;

import com.example.unipaivakirja_haltimo_backman_perala.R;
import com.example.unipaivakirja_haltimo_backman_perala.classes.Constants;
import com.example.unipaivakirja_haltimo_backman_perala.classes.User;

import java.util.ArrayList;

public class Asetukset extends AppCompatActivity {
    // listanäkymä eri asetuksille
    private ListView lvAsetukset;
    ArrayList<String> listaAsetukset;

    // lista näkymät yksittäisen asetuksen valinnoille
    ArrayList<String> listaAsetuksetDarkMode;
    ArrayList<String> listaAsetuksetKieli;
    ArrayList<String> listaAsetuksetFontti;
    ArrayList<String> listaAsetuksetDD;
    private ListView lvDarkMode;
    private ListView lvKieli;
    private ListView lvFontti;
    private ListView lvDD;
    ArrayAdapter arrayAdapterDarkMode;
    ArrayAdapter arrayAdapterKieli;
    ArrayAdapter arrayAdapterFontti;
    ArrayAdapter arrayAdapterDD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asetukset);

        // Asetusten listaa varten alustettava array
        listaAsetukset = new ArrayList<>();
        listaAsetukset.add("Dark Mode");
        listaAsetukset.add("Kieli");
        listaAsetukset.add("Fontin koko");
        listaAsetukset.add("DD.MM.YYYY");
        // Haetaan asetusten listalle näkymällä view-objekti
        lvAsetukset = findViewById(R.id.listViewAsetukset);
        // Asetetaan listalle adapteri
        lvAsetukset.setAdapter(new ArrayAdapter<String>(this,
                R.layout.layout_lw_asetus,
                listaAsetukset));


        // Yksittäisen asetuksen listanäkymän arrayn alustus
        // Perässä myös array adapterin luonti, sillä
        // sen luominen on clickin sisällä aiheutti errorin
        // Luominen ennen, ja sijoittaminen on clickissä sen sijaan toimi
        listaAsetuksetDarkMode = new ArrayList<>();
        listaAsetuksetDarkMode.add("System Default");
        listaAsetuksetDarkMode.add("Light Mode");
        listaAsetuksetDarkMode.add("Dark Mode");
        // Miksei array adapterille tule <String>?
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



        // Asetetaan asetusten listviewille on click listener
        lvAsetukset.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                // Käytetään hyväksi listan indeksi i
                // Tämän avulla voidaan käyttää switch-case rakennetta
                // ja valita oikean asetuksen popup-ikkuna
                switch (i) {
                    case 0:
                        // Luodaan layoutissa määritellyn mukainen popup ikkuna inflaterin avulla
                        // Root toistaiseksi null
                        View popUpViewDarkMode = inflater.inflate(R.layout.popup_dark_mode, null);
                        PopupWindow pwDarkMode = new PopupWindow(popUpViewDarkMode, width, height, true);
                        // Asemoidaan luotu popup ikkuna keskelle näyttöä
                        pwDarkMode.showAtLocation(view, Gravity.CENTER, 0, 0);
                        break;
                    case 1:
                        View popUpViewKieli = inflater.inflate(R.layout.popup_kieli, null);
                        PopupWindow pwKieli = new PopupWindow(popUpViewKieli, width, height, true);

                        // Asetetaan popupille pieni noste
                        // res.drawable.popup_background löytyy tiedosto millä luodaan popupin borderi
                        pwKieli.setElevation(20);
                        pwKieli.showAtLocation(view, Gravity.CENTER, 0, 0);


                        lvKieli = popUpViewKieli.findViewById(R.id.lvKieli);
                        // Käytän samaa layouttia listaAsetuksetKielillekkin
                        lvKieli.setAdapter(arrayAdapterKieli);
                        // Popupin sisäinen listview missä valitaan asetuksen arvo
                        lvKieli.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                               switch (i) {
                                   case 0:
                                       // Höhöö valitsi suomen
                                       User.getInstance().setAsetusKieli(Constants.LANG_FIN);
                                       break;
                                   case 1:
                                       User.getInstance().setAsetusKieli(Constants.LANG_ENG);
                                       break;
                                   case 2:
                                       User.getInstance().setAsetusKieli(Constants.LAND_SWE);
                               }
                            }
                        });

                        break;
                    case 2:
                        View popUpViewFontti = inflater.inflate(R.layout.popup_fontti, null);
                        PopupWindow pwFontti = new PopupWindow(popUpViewFontti, width, height, true);
                        pwFontti.showAtLocation(view, Gravity.CENTER, 0, 0);
                        break;
                    case 3:
                        View popUpViewDD = inflater.inflate(R.layout.popup_dd, null);
                        PopupWindow pwDD = new PopupWindow(popUpViewDD, width, height, true);
                        pwDD.showAtLocation(view, Gravity.CENTER, 0, 0);
                        break;
                    default:
                        break;
                }
            }
        });


    // Esimerkin mukainen koodi, popup_example on extra tiedosto toistaiseksi

    /*public void onButtonShowPopupWindowClick(View view) {

        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater)
                getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.popup_asetukset, null);

        // create the popup window
        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true; // lets taps outside the popup also dismiss it
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

        // show the popup window
        // which view you pass in doesn't matter, it is only used for the window tolken
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

        // dismiss the popup window when touched
        popupView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popupWindow.dismiss();
                return true;
            }
        });*/
    }
}