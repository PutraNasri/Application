package com.example.addd.application;

/**
 * Created by addd on 10/24/2015.
 */
public class Contact {
String nama , noktp , username , password ,email, nohp;
    public  Contact(String nama , String noktp , String username , String password , String email, String nohp)
    {
        this.nama=nama;
        this.noktp=noktp;
        this.username=username;
        this.password=password;
        this.email=email;
        this.nohp=nohp;

    }
    public Contact(String username, String password){
        this.username=username;
        this.password=password;
    }
}
