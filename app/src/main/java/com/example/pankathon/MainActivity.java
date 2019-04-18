package com.example.pankathon;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

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

                break;
            case R.id.ibDesert:

                break;
            case R.id.ibforest:

                break;
            case R.id.ibCastle:

                break;
            case R.id.ibSky:

                break;
        }
    }
}
