package com.example.addd.application;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    EditText user,pass ;
    LocalDatabase localDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user =(EditText)findViewById(R.id.user);
        pass =(EditText)findViewById(R.id.pass);
        localDatabase= new LocalDatabase(this);
    }
    public void onClicklogin(View view) {
        String username = user.getText().toString();
        String password = pass.getText().toString();

        Contact contact=new Contact(username, password);
        authenticate(contact);



    }
    private void authenticate(Contact contact){
        ServerRequests serverRequests = new ServerRequests(this);
        serverRequests.fetchDataInBackground(contact , new GetUserCallback() {
            @Override
            public void done(Contact returnedContact) {
if (returnedContact==null){
    AlertDialog.Builder builder =new AlertDialog.Builder(MainActivity.this);
    builder.setMessage("hana terdaftar");
    builder.setPositiveButton("ok",null);
    builder.show();

}else{

    localDatabase.storeData(returnedContact);
    localDatabase.setUserLoggedIn(true);
    Intent hasilIntent = new Intent(MainActivity.this, Menu_Laporan.class);
    startActivity(hasilIntent);
}
            }
        });



    }
    public void onClicksignup(View view) {


        Intent hasilIntent = new Intent(this, Daftar.class);
        startActivity(hasilIntent);
    }
}
