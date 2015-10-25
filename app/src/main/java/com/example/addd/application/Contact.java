package com.example.addd.application;

/**
 * Created by addd on 10/24/2015.
 */
public class Contact {
    String name , email , username , password , nama , noktp , jumlah , pekerjaan , gaji;

    public Contact(String name , String email , String username , String password)
    {
        this.name = name;
        this.email = email ;
        this.username = username;
        this.password = password;

    }



    public Contact(String username , String password)
    {
        this.username = username;
        this.password = password;
    }
}