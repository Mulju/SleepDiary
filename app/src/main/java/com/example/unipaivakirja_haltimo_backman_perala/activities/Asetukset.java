package com.example.unipaivakirja_haltimo_backman_perala.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
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
    private ListView lvAsetukset;
    ArrayList<String> lista;

    // Testausta varten
    ArrayList<String> testiLista;
    private ListView lvTesti;
    ArrayAdapter adapterTesti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asetukset);

        // popupin listviewn testaus
        testiLista = new ArrayList<>();
        testiLista.add("Suomi");
        testiLista.add("English");
        testiLista.add("Svenska");
        adapterTesti = new ArrayAdapter<String>(this,
                R.layout.layout_lw_asetus,
                testiLista);



        lista = new ArrayList<>();
        // Testi Array listaa varten
        lista.add("Dark Mode");
        lista.add("Kieli");
        lista.add("Fontin koko");
        lista.add("DD.MM.YYYY");

        lvAsetukset = findViewById(R.id.listViewAsetukset);
        // Toistaiseksi String, joutuu todennäköisesti kirjoittaa Asetukset luokan
        // ja tekemään listanäkymän sen kautta
        lvAsetukset.setAdapter(new ArrayAdapter<String>(this,
                R.layout.layout_lw_asetus,
                lista));

        final LayoutInflater inflater = (LayoutInflater)this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;





        lvAsetukset.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        // Luodaan layoutissa määritellyn mukainen popup ikkuna
                        View popUpViewDarkMode = inflater.inflate(R.layout.popup_dark_mode, null);
                        PopupWindow pwDarkMode = new PopupWindow(popUpViewDarkMode, width, height, true);
                        // Asemoidaan luotu popup ikkuna keskelle näyttöä
                        pwDarkMode.showAtLocation(view, Gravity.CENTER, 0, 0);
                        break;
                    case 1:
                        View popUpViewKieli = inflater.inflate(R.layout.popup_kieli, null);
                        PopupWindow pwKieli = new PopupWindow(popUpViewKieli, width, height, true);
                        pwKieli.showAtLocation(view, Gravity.CENTER, 0, 0);

                        Log.d("testaus", "ennen findia");
                        lvTesti = popUpViewKieli.findViewById(R.id.lvTesti);
                        Log.d("testaus", "lvTestin arvo: ");
                        // Käytän samaa layouttia testilistallekkin
                        lvTesti.setAdapter(adapterTesti);
                        // Popupin sisäinen listview missä valitaan asetuksen arvo
                        lvTesti.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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