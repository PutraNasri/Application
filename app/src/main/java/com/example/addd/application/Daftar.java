package com.example.addd.application;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Daftar extends AppCompatActivity {




    EditText name,noktp,username,password,email,nohp ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);
        name =(EditText)findViewById(R.id.nama);
        noktp =(EditText)findViewById(R.id.noktp);
        username=(EditText)findViewById(R.id.username);
        password=(EditText)findViewById(R.id.password);
        email=(EditText)findViewById(R.id.email);
        nohp=(EditText)findViewById(R.id.nohp);

    }
    public void onClicklogin(View view) {
        String namalengkap = name.getText().toString();
        String ktp = noktp.getText().toString();
        String user = username.getText().toString();
        String pass= password.getText().toString();
        String emaill=email.getText().toString();
        String nohpp = nohp.getText().toString();

        Intent hasilIntent = new Intent(this, Menu_Laporan.class);
        startActivity(hasilIntent);
    }


}

