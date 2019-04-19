package com.example.pankathon;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListViewScore extends AppCompatActivity {

    public static final String RETURN_SETTINGS = "RETURN_SETTINGS";
    public Settings settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_score);

        Intent intent = getIntent();
        settings = intent.getParcelableExtra(RETURN_SETTINGS);

        final List<Egg> eggList = new ArrayList<>();
        ListView eggListview = findViewById(R.id.svEgg);
        final AdapterListView adapter = new AdapterListView(ListViewScore.this,settings.getEggCaught());
        eggListview.setAdapter(adapter);

    }
}

