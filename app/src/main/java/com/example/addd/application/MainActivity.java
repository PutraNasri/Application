package com.example.addd.application;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    EditText user,pass ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user =(EditText)findViewById(R.id.user);
        pass =(EditText)findViewById(R.id.pass);

    }
    public void onClicklogin(View view) {
String username = user.getText().toString();
        String password = pass.getText().toString();

        Intent hasilIntent = new Intent(this, Menu_Laporan.class);
        startActivity(hasilIntent);
    }
    public void onClicksignup(View view) {


        Intent hasilIntent = new Intent(this, Daftar.class);
        startActivity(hasilIntent);
    }
}
