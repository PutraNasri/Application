package com.example.addd.application;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void onClicklogin(View view) {


        Intent hasilIntent = new Intent(this, Daftar.class);
        startActivity(hasilIntent);
    }
    public void onClicksignup(View view) {


        Intent hasilIntent = new Intent(this, Daftar.class);
        startActivity(hasilIntent);
    }
}
