package com.example.pankathon;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

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
    public Settings settings = new Settings(0, null);
    private Egg randomEgg;
    public static final String RETURN_SETTINGS = "RETURN_SETTINGS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.ibOcean).setOnClickListener(this);
        findViewById(R.id.ibDesert).setOnClickListener(this);
        findViewById(R.id.ibforest).setOnClickListener(this);
        findViewById(R.id.ibCastle).setOnClickListener(this);
        findViewById(R.id.ibSky).setOnClickListener(this);

        ustensilInitialisation();
        chiefInitialisation();
        eggInitialisation();
        if (!(settings.getWorld() == 0)) {
            Intent intent = getIntent();
            settings = intent.getParcelableExtra(RETURN_SETTINGS);

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
                toActivityFight(settings);
                break;
            case R.id.ibSky:
                settings.setWorld(5);
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
        eggOven= new Ustensil("Infernal Whisk", 40, eggOvenString);
        panUri = Uri.parse("android.resource://com.example.pankathon/drawable/pan");
        panString = panUri.toString();
        pan= new Ustensil("Infernal Whisk", 35, panString);
    }

    private void chiefInitialisation() {
        etchebestUri = Uri.parse("android.resource://com.example.pankathon/drawable/etchebestpicture");
        etchebestString = etchebestUri.toString();
        etchebest = new Cooker("Chief Etchebest", 100, etchebestString, whisk, 45);
    }

    private void eggInitialisation() {
        extractEggs(MainActivity.this, new Helper.EggListener() {
            @Override
            public void onEggLoaded(List<Egg> eggList) {
                randomEgg = Helper.randomEgg((ArrayList<Egg>) eggList);
                System.out.print(randomEgg.getName());
            }
        });
    }

    public void toActivityFight(Settings settings) {
        Intent toActivityFight = new Intent(MainActivity.this, Fight.class);
        toActivityFight.putExtra(COOKER, (Parcelable) etchebest);
        toActivityFight.putExtra(SETTINGS, (Parcelable) settings);
        toActivityFight.putExtra(EGG, (Parcelable) randomEgg);
        startActivity(toActivityFight);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}



