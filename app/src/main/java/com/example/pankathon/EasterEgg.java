package com.example.pankathon;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class EasterEgg extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easter_egg);

        String id = "0";
        String name = "Bastien";
        String color = "white";
        String caliber = "12";
        int farming = 2;
        String country = "x";
        String rarity = "Ultimate boss";
        Uri bastienUri = Uri.parse("android.resource://com.example.pankathon/drawable/bastien");
        String bastienString = bastienUri.toString();
        String power = "Android master";
        int life = 10000;
        Egg bastien = new Egg(id, name, color, caliber, farming, country, rarity, bastienString, power, life);
    }


}
