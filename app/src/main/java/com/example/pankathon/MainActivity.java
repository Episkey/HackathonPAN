package com.example.pankathon;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String COOKER ="COOKER";
    public static final String SETTINGS ="SETTINGS";
    public static final String EGG ="EGG";
    private Ustensil whisk;
    private Uri whisktUri;
    private String whiskString;
    private Uri etchebestUri;
    private String etchebestString;
    private Cooker etchebest;
    private Settings settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ustensilInitialisation();
        chiefInitialisation();
    }

    private void ustensilInitialisation(){
        whisktUri = Uri.parse("android.resource://com.example.arena/drawable/whiskPicture");
        whiskString = whisktUri.toString();
        whisk = new Ustensil( "Infernal Whisk", 20, whiskString);
    }

    private void chiefInitialisation(){
        etchebestUri = Uri.parse("android.resource://com.example.arena/drawable/etchebestPicture");
        etchebestString = etchebestUri.toString();
        etchebest = new Cooker("Chief Etchebest", 100, etchebestString,whisk,45);
    }

    private void eggInitialisation(){
        Helper.extractEggs(this, new Helper.EggListener() {
            @Override
            public void onEggLoaded(List<Egg> eggList) {

            }
        };)
    }

    public void toActivityFight(){
        Intent toActivityFight = new Intent(MainActivity.this, Fight.class);
        toActivityFight.putExtra(COOKER, (Parcelable) etchebest );
        toActivityFight.putExtra(SETTINGS, (Parcelable) settings );
        startActivity(toActivityFight);
    }

}



