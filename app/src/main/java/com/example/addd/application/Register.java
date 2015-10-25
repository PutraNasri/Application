package com.example.addd.application;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Register  extends Activity {
    EditText etname ,etemail , etusername , etpassword, etconfirm_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etusername = (EditText)findViewById(R.id.TFusername_register);
        etpassword = (EditText)findViewById(R.id.TFpassword_register);
        etname = (EditText)findViewById(R.id.TFname_register);
        etemail = (EditText)findViewById(R.id.TFemail_register);
        etconfirm_password = (EditText)findViewById(R.id.TFconfirm_password_register);

    }

    public void onLoginClick(View view)
    {
        Intent intent = new Intent(Register.this , MainActivity.class);
        startActivity(intent);
    }

    public void onRegisterClick(View view){
        String name = etname.getText().toString();
        String email = etemail.getText().toString();
        String username = etusername.getText().toString();
        String password = etpassword.getText().toString();
        String confirm_password = etconfirm_password.getText().toString();



        if(password.equals(confirm_password))
        {
            Contact contact = new Contact(name ,email , username,password);
            ServerRequests serverRequests = new ServerRequests(this);
            serverRequests.storeDataInBackground(contact , new GetUserCallback() {
                @Override
                public void done(Contact returnedContact) {

                    AlertDialog.Builder a_builder = new AlertDialog.Builder(Register.this);
                    a_builder.setMessage("Akun Anda Telah di Daftarkan")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                    Intent intent = new Intent(Register.this, MainActivity.class);
                                    startActivity(intent);

                                }
                            });
                    AlertDialog alert = a_builder.create();
                    alert.setTitle("Info");
                    alert.show();


                }
            });
        }
        else{
            Toast.makeText(this, "Passwords don't match! Enter again!", Toast.LENGTH_LONG).show();
        }

    }



}

