package com.example.unipaivakirja_haltimo_backman_perala.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.unipaivakirja_haltimo_backman_perala.R;

public class TiettyUni extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tietty_uni);

        Intent intent = getIntent();
        String message = intent.getStringExtra(Unesi.EXTRA_MESSAGE);


        TextView textView = findViewById(R.id.textView_tiettyUni);
        textView.setText(message);
    }
}