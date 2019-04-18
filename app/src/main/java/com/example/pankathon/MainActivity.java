package com.example.pankathon;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
import android.view.View;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

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
    private Egg randomEgg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.ibOcean).setOnClickListener(this);
        findViewById(R.id.ibDesert).setOnClickListener(this);
        findViewById(R.id.ibforest).setOnClickListener(this);
        findViewById(R.id.ibCastle).setOnClickListener(this);
        findViewById(R.id.ibSky).setOnClickListener(this);
    }

    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.ibOcean:
                settings.setWorld(1);
                toActivityFight();
                break;
            case R.id.ibDesert:
                settings.setWorld(2);
                toActivityFight();
                break;
            case R.id.ibforest:
                settings.setWorld(3);
                toActivityFight();
                break;
            case R.id.ibCastle:
                settings.setWorld(4);
                toActivityFight();
                break;
            case R.id.ibSky:
                settings.setWorld(5);
                toActivityFight();
                break;
        }
        ustensilInitialisation();
        chiefInitialisation();
        eggInitialisation();
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
                randomEgg = Helper.randomEgg((ArrayList<Egg>) eggList);
            }
        });
    }

    public void toActivityFight(){
        Intent toActivityFight = new Intent(MainActivity.this, Fight.class);
        toActivityFight.putExtra(COOKER, (Parcelable) etchebest );
        toActivityFight.putExtra(SETTINGS, (Parcelable) settings );
        toActivityFight.putExtra(EGG, (Parcelable) randomEgg );
        startActivity(toActivityFight);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}



