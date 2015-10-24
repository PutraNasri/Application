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




    EditText e_name,e_noktp,e_username,e_password,e_email,e_nohp ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);
        e_name =(EditText)findViewById(R.id.nama);
        e_noktp =(EditText)findViewById(R.id.noktp);
        e_username=(EditText)findViewById(R.id.username);
        e_password=(EditText)findViewById(R.id.password);
        e_email=(EditText)findViewById(R.id.email);
        e_nohp=(EditText)findViewById(R.id.nohp);

    }
    public void onClickdaftar(View view) {
        String nama = e_name.getText().toString();
        String noktp = e_noktp.getText().toString();
        String username = e_username.getText().toString();
        String password= e_password.getText().toString();
        String email=e_email.getText().toString();
        String nohp = e_nohp.getText().toString();

       Contact contact;
        contact = new Contact(nama,noktp,username,password,email,nohp);
        ServerRequests serverRequests =new ServerRequests(this);
        serverRequests.storeDataInBackground(contact, new GetUserCallback() {
            @Override
            public void done(Contact returnedContact) {
                Intent hasilIntent = new Intent(Daftar.this, MainActivity.class);
                startActivity(hasilIntent);
            }
        });
    }


}

