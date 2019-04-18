package com.example.pankathon;

import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    public static final String COOKER ="COOKER";
    private Ustensil whisk;
    private Uri whisktUri;
    private String whiskString;
    private Uri etchebestUri;
    private String etchebestString;
    private Cooker etchebest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ustensilInizialization();
        chiefInizialization();
    }

    private void ustensilInizialization(){
        whisktUri = Uri.parse("android.resource://com.example.arena/drawable/whiskPicture");
        whiskString = whisktUri.toString();
        whisk = new Ustensil( "Infernal Whisk", 20, whiskString);
    }

    private void chiefInizialization(){
        etchebestUri = Uri.parse("android.resource://com.example.arena/drawable/etchebestPicture");
        etchebestString = etchebestUri.toString();
        etchebest = new Cooker("Chief Etchebest", 100, etchebestString,whisk,45);
    }

    public void toActivityFight(){
        Intent toActivityFight = new Intent(MainActivity.this, Fight.class);
        toActivityFight.putExtra(COOKER, (Parcelable) etchebest );
        startActivity(toActivityFight);
    }
}



