package com.example.pankathon;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

import static com.example.pankathon.Helper.extractEggs;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String COOKER = "COOKER";
    public static final String SETTINGS = "SETTINGS";
    public static final String EGG = "EGG";
    private Ustensil whisk;
    private Uri whisktUri;
    private String whiskString;
    private Uri etchebestUri;
    private Ustensil eggOven;
    private Uri eggOventUri;
    private String eggOvenString;
    private Uri panUri;
    private Ustensil pan;
    private String panString;
    private String etchebestString;
    private Cooker etchebest;
    public Settings settings;
    private Egg randomEgg;
    private ArrayList<Egg> listFightingEggs = new ArrayList<>();
    public static final String RETURN_SETTINGS = "RETURN_SETTINGS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonEasterEgg = findViewById(R.id.ibEasterEgg);
        buttonEasterEgg.setVisibility(View.VISIBLE);
        buttonEasterEgg.setBackgroundColor(Color.TRANSPARENT);
        findViewById(R.id.ibOcean).setOnClickListener(this);
        findViewById(R.id.ibDesert).setOnClickListener(this);
        findViewById(R.id.ibforest).setOnClickListener(this);
        findViewById(R.id.ibCastle).setOnClickListener(this);
        findViewById(R.id.ibSky).setOnClickListener(this);
        findViewById(R.id.ibListButton).setOnClickListener(this);
        buttonEasterEgg.setOnClickListener(this);

        ustensilInitialisation();
        chiefInitialisation();
        eggInitialisation();
        Intent intent = getIntent();
        settings = intent.getParcelableExtra(RETURN_SETTINGS);
        if(settings == null) {
            settings = new Settings(0, null);
        }


    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ibOcean:
                settings.setWorld(1);
                toActivityFight(settings);
                break;
            case R.id.ibDesert:
                settings.setWorld(2);
                toActivityFight(settings);
                break;
            case R.id.ibforest:
                settings.setWorld(3);
                toActivityFight(settings);
                break;

            case R.id.ibCastle:
                    settings.setWorld(4);
                    if(settings.getEggCaught().size() >= 4) {
                        toActivityFight(settings);
                    }
                    else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setTitle("Forbidden !");
                        builder.setMessage("You haven't enough eggs to go into the castle !");
                        builder.setPositiveButton("Accept", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }
                    break;
            case R.id.ibSky:
                settings.setWorld(5);
                toActivityFight(settings);
                break;
            case R.id.ibListButton:
                Intent goToListView = new Intent(MainActivity.this, ListViewScore.class);
                goToListView.putExtra(RETURN_SETTINGS, (Parcelable) settings );
                startActivity(goToListView);
                break;
            case R.id.ibEasterEgg:
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
                int life = 500;
                randomEgg = new Egg(id, name, color, caliber, farming, country, rarity, bastienString, power, life);
                listFightingEggs.clear();
                listFightingEggs.add(randomEgg);
                settings.setWorld(6);
                toActivityFight(settings);
                break;
        }
    }

    private void ustensilInitialisation() {
        whisktUri = Uri.parse("android.resource://com.example.pankathon/drawable/whisk_picture");
        whiskString = whisktUri.toString();
        whisk = new Ustensil("Infernal Whisk", 20, whiskString);
        eggOventUri = Uri.parse("android.resource://com.example.pankathon/drawable/eggoven");
        eggOvenString = eggOventUri.toString();
        eggOven= new Ustensil("Devil Egg Oven", 40, eggOvenString);
        panUri = Uri.parse("android.resource://com.example.pankathon/drawable/pan");
        panString = panUri.toString();
        pan= new Ustensil("Pan of Doom", 35, panString);
    }

    private void chiefInitialisation() {
        etchebestUri = Uri.parse("android.resource://com.example.pankathon/drawable/etchebestpicture");
        etchebestString = etchebestUri.toString();
        etchebest = new Cooker("Chief Etchebest", 100, etchebestString, whisk, 45);
        etchebest.getUstensil().add(eggOven);
        etchebest.getUstensil().add(pan);
    }

    private void eggInitialisation() {
        extractEggs(MainActivity.this, new Helper.EggListener() {
            @Override
            public void onEggLoaded(List<Egg> eggList) {

                for (int i=0; i<3;i++) {
                    randomEgg = Helper.randomEgg((ArrayList<Egg>) eggList);
                    listFightingEggs.add(randomEgg);
                }


            }
        });
    }

    public void toActivityFight(Settings settings) {
        Intent toActivityFight = new Intent(MainActivity.this, Fight.class);
        toActivityFight.putExtra(COOKER, (Parcelable) etchebest);
        toActivityFight.putExtra(SETTINGS, (Parcelable) settings);
        toActivityFight.putExtra(EGG, listFightingEggs);
        startActivity(toActivityFight);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}



