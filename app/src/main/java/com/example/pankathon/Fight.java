package com.example.pankathon;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.io.IOException;
import java.util.Random;

import static com.example.pankathon.MainActivity.COOKER;
import static com.example.pankathon.MainActivity.EGG;
import static com.example.pankathon.MainActivity.SETTINGS;

public class Fight extends AppCompatActivity {


    private static TextView lifeEgg;
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
    private TextView eggName;
    public static final String RETURN_SETTINGS = "RETURN_SETTINGS";



    static boolean victory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fight);


        lifeEgg = findViewById(R.id.tvEggLife);
        ustensilName = findViewById(R.id.tvUstensilName);
        cookerName = findViewById(R.id.tvCookerName);
        eggPicture = findViewById(R.id.ivEggPicture);
        cookerPicture =findViewById(R.id.ivCookerPicture);
        ustensilPicture =findViewById(R.id.ivUstensilPicture);
        displayText = findViewById(R.id.tvDialog);
        eggName = findViewById(R.id.tvEggName);

        fromActivityFight();
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



                        Uri ustensilView = Uri.parse(etchebest.getUstensil().getPicture());
                        Uri cookerView = Uri.parse(etchebest.getPicture());

                        Bitmap bitmap = null;
                        try {

                            bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), ustensilView);

                        } catch (IOException e) {

                            e.printStackTrace();
                        }

                        ustensilPicture.setImageBitmap(bitmap);

                        Glide.with(Fight.this).load(randomEgg.getPicture()).into(eggPicture);


                        bitmap = null;

                        try {

                            bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), cookerView);

                        } catch (IOException e) {

                            e.printStackTrace();
                        }

                        cookerPicture.setImageBitmap(bitmap);


                        lifeEgg.setText(Integer.toString(randomEgg.getLife()));
                        ustensilName.setText(etchebest.getUstensil().getName());
                        cookerName.setText(etchebest.getName());
                        eggName.setText(randomEgg.getName());



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
        Button attackUstensil = findViewById(R.id.bAttack);

        attackUstensil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attack();
            }
        });


    }
    public void attack() {
        if (randomEgg.getLife() > etchebest.getUstensil().getAttack()) {
            Random r = new Random();
            int i = r.nextInt(10);
            if (i<5) {
                randomEgg.setLife(randomEgg.getLife() - etchebest.getUstensil().getAttack());
                displayText.setText("You attack " + randomEgg.getName() + " and " + randomEgg.getName()+ " takes damages !");
                lifeEgg.setText(Integer.toString(randomEgg.getLife()));
            }
            else {
                displayText.setText("You attack " + randomEgg.getName() + " but " + randomEgg.getName()+ " dudges !");
            }
        }
        else {
            lifeEgg.setText(Integer.toString(0));
            Uri eggBroken = Uri.parse("android.resource://com.example.pankathon/drawable/fatality");
            Bitmap bitmap = null;
            try {

                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), eggBroken);

            } catch (IOException e) {

                e.printStackTrace();
            }

            eggPicture.setImageBitmap(bitmap);
            displayText.setText("You make a fatality on " + randomEgg.getName() + " !");
            randomEgg.setLife(100);
            new android.os.Handler().postDelayed(
                    new Runnable() {
                        public void run() {
                                settings.getEggCaught().add(randomEgg);
                                displayText.setText("You've got a " + randomEgg.getName() + ", congratulations !");

                        }
                    },
                    2000);
            new android.os.Handler().postDelayed(
                    new Runnable() {
                        public void run() {

                            Intent goToMainactivity = new Intent(Fight.this, MainActivity.class);
                            goToMainactivity.putExtra(RETURN_SETTINGS, (Parcelable) settings );
                            startActivity(goToMainactivity);
                        }
                    },
                    2000);
        }

    }
}
