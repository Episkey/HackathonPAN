package com.example.pankathon;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

import static com.example.pankathon.MainActivity.COOKER;
import static com.example.pankathon.MainActivity.EGG;
import static com.example.pankathon.MainActivity.SETTINGS;

public class Fight extends AppCompatActivity {

    private TextView lifeCooker;
    private TextView lifeEgg;
    private TextView ustensilName;
    private TextView cookerName;
    private static TextView displayText;
    private ImageView eggPicture;
    private ImageView cookerPicture;
    private ImageView ustensilPicture;
    private Button ustensilButton;
    private Cooker etchebest;
    private Egg randomEgg;
    private Settings settings;



    static boolean victory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fight);

        lifeCooker = findViewById(R.id.tvCookerLife);
        lifeEgg = findViewById(R.id.tvEggLife);
        ustensilName = findViewById(R.id.tvUstensilName);
        cookerName = findViewById(R.id.tvCookerName);
        eggPicture = findViewById(R.id.ivEggPicture);
        cookerPicture =findViewById(R.id.ivCookerPicture);
        ustensilPicture =findViewById(R.id.ivUstensilPicture);
        displayText = findViewById(R.id.tvDialog);

        fromActivityFight()
        presentation();
        initialization();
        round();

    }

    private void fromActivityFight(){
        Intent receiveMainActivity = getIntent();
        settings = receiveMainActivity.getParcelableExtra(SETTINGS);
        etchebest  = receiveMainActivity.getParcelableExtra(COOKER);
        randomEgg = receiveMainActivity.getParcelableExtra(EGG);
    }

    private void initialization(){


        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {



                        Uri ustensilView = Uri.parse(etchebest.getUstensil().get(0).getPicture());
                        Uri eggView = Uri.parse(randomEgg.getPicture());
                        Uri cookerView = Uri.parse(etchebest.getPicture());

                        Bitmap bitmap = null;
                        try {

                            bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), ustensilView);

                        } catch (IOException e) {

                            e.printStackTrace();
                        }

                        ustensilPicture.setImageBitmap(bitmap);


                        bitmap = null;

                        try {

                            bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), eggView);

                        } catch (IOException e) {

                            e.printStackTrace();
                        }

                        eggPicture.setImageBitmap(bitmap);


                        bitmap = null;

                        try {

                            bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), cookerView);

                        } catch (IOException e) {

                            e.printStackTrace();
                        }

                        cookerPicture.setImageBitmap(bitmap);

                        lifeCooker.setText(Integer.toString(etchebest.getLife()));
                        lifeEgg.setText(Integer.toString(randomEgg.getLife()));
                        ustensilName.setText(etchebest.getUstensil().get(0).getName());
                        cookerName.setText(etchebest.getUstensil().get(0).getName());
                        ustensilName.setText(randomEgg.getName());


                    }
                },
                11000);
    }

    private void presentation() {

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        displayText.setText("You have encountered " + randomEgg.getName());
                    }
                },
                1000);
        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        displayText.setText(randomEgg.getName() + " does not like your face.");
                    }
                },
                3000);
        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        displayText.setText(randomEgg.getName() + " does not like your face.");
                    }
                },
                5000);
        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        displayText.setText( randomEgg.getName() + ". wants your money");
                    }
                },
                7000);
        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        displayText.setText("You will have to fight to keep your money");
                    }
                },
                9000);

    }


    private void round(){


        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        displayText.setText("FIGHT COMMENCES !!!!");

                    }

                },
                13000);

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        displayText.setText("It's your turn. What do you want to do ?");
                    }

                },
                15000);

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        ustensilButton = findViewById(R.id.bAttack);

                        ustensilButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                new android.os.Handler().postDelayed(
                                        new Runnable() {
                                            public void run() {

                                                new android.os.Handler().postDelayed(
                                                        new Runnable() {
                                                            public void run() {

                                                            }

                                                        },
                                                        2000);



                                            }

                                        },
                                        2000);
                            }
                        });


                    }
                },
                17000);
    }
}
