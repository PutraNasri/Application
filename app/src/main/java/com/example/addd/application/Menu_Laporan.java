package com.example.addd.application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Menu_Laporan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu__laporan);
    }


    public void onClickdarurat(View view) {


        Intent hasilIntent = new Intent(this, FormLaporan.class);
        startActivity(hasilIntent);
    }

    public void onClicktidakmampu(View view) {


        Intent hasilIntent = new Intent(this, Laporan_wargatidakmampu.class);
        startActivity(hasilIntent);
    }
}
