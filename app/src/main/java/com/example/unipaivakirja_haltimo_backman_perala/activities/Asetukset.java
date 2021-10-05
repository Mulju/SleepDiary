package com.example.unipaivakirja_haltimo_backman_perala.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;

import com.example.unipaivakirja_haltimo_backman_perala.R;

import java.util.ArrayList;

public class Asetukset extends AppCompatActivity {
    private ListView lvAsetukset;
    ArrayList<String> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asetukset);

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

        /*final LayoutInflater inflater = (LayoutInflater)this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View popUpView = inflater.inflate(R.layout.popup_example, null);

        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;

        buttonPopUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupWindow pw = new PopupWindow(popUpView, width, height, true);

                pw.showAtLocation(view, Gravity.LEFT, 0, 0);
                pw.update(8, -70, 150, 270);

                ImageButton img = (ImageButton) popUpView.findViewById(R.id.home);
                img.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.d("moro", "toimii");
                    }
                });
            }
        });
    }*/


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