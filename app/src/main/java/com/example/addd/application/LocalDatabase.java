package com.example.addd.application;

import android.content.Context;
import android.content.SharedPreferences;
import android.provider.ContactsContract;

/**
 * Created by addd on 10/24/2015.
 */
public class LocalDatabase {
    public static final String SP_NAME = "UserDetails";
    SharedPreferences localDatabase;

    public  LocalDatabase (Context context)
    {
        localDatabase = context.getSharedPreferences(SP_NAME,0);

    }
    public  void storeData(Contact contact)
    {
SharedPreferences.Editor spEditor =localDatabase.edit();
        spEditor.putString("nama",contact.nama);
        spEditor.putString("noktp",contact.noktp);
        spEditor.putString("username",contact.username);
        spEditor.putString("password",contact.password);
        spEditor.putString("email",contact.email);
        spEditor.putString("nohp",contact.nohp);
spEditor.commit();


    }
    public Contact getLoggedInUser(){
       String nama =localDatabase.getString("nama","");
        String noktp=localDatabase.getString("noktp","");
        String username=localDatabase.getString("username","");
        String password = localDatabase.getString("password","");
        String email=localDatabase.getString("email", "");
        String nohp=localDatabase.getString("nohp", "");

        Contact storedContact = new Contact(nama,noktp,username,password,email,nohp);
        return storedContact;
    }

    public void setUserLoggedIn(boolean loggedIn){

        SharedPreferences.Editor spEditor = localDatabase.edit();
        spEditor.putBoolean("logedIn", loggedIn);
        spEditor.commit();

    }
    public boolean getUserLoggedIn()
    {
if(localDatabase.getBoolean("loggedIn", false))
    return true;
        else
    return false;
    }
    public void cleardata()
    {
SharedPreferences.Editor spEditor =localDatabase.edit();
        spEditor.clear();
        spEditor.commit();
    }
}
