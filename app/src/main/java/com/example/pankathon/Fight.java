package com.example.pankathon;

import android.app.Activity;
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

public class Fight extends AppCompatActivity {

    static boolean victory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fight);




    }

    public void initialization(final Cooker cooker, final Egg egg){


        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {

                        ImageView eggPicture = findViewById(R.id.imageView1);
                        ImageView cookerPicture =findViewById((R.id.imageView2));
                        ImageView ustensilPicture =findViewById(R.id.imageView3);

                        Uri ustensilView = Uri.parse(cooker.getUstensil().get(0).getPicture());
                        Uri eggView = Uri.parse(egg.getPicture());
                        Uri cookerView = Uri.parse(cooker.getPicture());

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

                        TextView lifeCooker = findViewById(R.id.textView1);
                        TextView lifeEgg = findViewById(R.id.textView2);
                        TextView ustensilName = findViewById(R.id.button3);


                        lifeCooker.setText(Integer.toString(cooker.getLife()));
                        lifeEgg.setText(Integer.toString(egg.getLife()));
                        ustensilName.setText(cooker.getUstensil().get(0));


                    }
                },
                11000);
    }

    public static void presentation(final Cooker cooker, final Egg egg) {
        final TextView texView = (TextView) context.findViewById(R.id.textView);
        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        texView.setText("You have encountered " + bot.getName());
                    }
                },
                1000);
        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        texView.setText(bot.getName() + " does not like your face.");
                    }
                },
                3000);
        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        texView.setText(bot.getName() + " does not like your face.");
                    }
                },
                5000);
        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        texView.setText( bot.getName() + ". wants your money");
                    }
                },
                7000);
        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        texView.setText("You will have to fight to keep your money");
                    }
                },
                9000);

    }


    public static void round(final Cooker cooker, final Egg egg){
        final TextView texView = (TextView) context.findViewById(R.id.textView);
        final TextView lifeBot = context.findViewById(R.id.textView6);
        final TextView lifeCharacter = context.findViewById(R.id.textView7);

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        texView.setText("FIGHT COMMENCES !!!!");

                    }

                },
                13000);

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        texView.setText("It's your turn. What do you want to do ?");
                    }

                },
                15000);

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        Button weaponButton = context.findViewById(R.id.button2);
                        Button spellButton = context.findViewById(R.id.button3);
                        Button protectionButton = context.findViewById(R.id.button4);

                        weaponButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                int attackCharacter = (1 + charater.getCoefWeapon()/100)* charater.getWeapons().get(0).getAttack();
                                bot.setLife(bot.getLife()-attackCharacter);
                                texView.setText("You have inflected " + attackCharacter + " to " + bot.getName());
                                new android.os.Handler().postDelayed(
                                        new Runnable() {
                                            public void run() {
                                                texView.setText(bot.getName() +"is angry ! but he suffers");
                                                lifeBot.setText(Integer.toString(bot.getLife()));
                                                new android.os.Handler().postDelayed(
                                                        new Runnable() {
                                                            public void run() {
                                                                int aleatoryResponse =(int)(Math.random()*2);
                                                                int attackBot = (aleatoryResponse == 1) ? bot.getWeapons().get(0).getAttack()*(1 + bot.getCoefWeapon()/100) : bot.getSpells().get(0).getAttack()*(1 + bot.getCoefSpell()/100);
                                                                String attackName = (aleatoryResponse == 1) ? bot.getWeapons().get(0).getWeaponName() : bot.getSpells().get(0).getSpellName();
                                                                charater.setLife(charater.getLife()-attackBot);
                                                                lifeCharacter.setText(Integer.toString(charater.getLife()));
                                                                texView.setText("he has inflected " + attackBot + " to " + charater.getName()+ " with this " + attackName);

                                                            }

                                                        },
                                                        2000);



                                            }

                                        },
                                        2000);
                            }
                        });


                        spellButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                int attackCharacter = (1 + charater.getCoefSpell()/100)* charater.getSpells().get(0).getAttack();
                                bot.setLife(bot.getLife()-attackCharacter);
                                texView.setText("You have inflected " + attackCharacter + " to " + bot.getName());
                                new android.os.Handler().postDelayed(
                                        new Runnable() {
                                            public void run() {
                                                texView.setText(bot.getName() +"is angry ! but he suffers");
                                                lifeBot.setText(Integer.toString(bot.getLife()));
                                                new android.os.Handler().postDelayed(
                                                        new Runnable() {
                                                            public void run() {
                                                                int aleatoryResponse =(int)(Math.random()*2);
                                                                int attackBot = (aleatoryResponse == 1) ? bot.getWeapons().get(0).getAttack()*(1 + bot.getCoefWeapon()/100) : bot.getSpells().get(0).getAttack()*(1 + bot.getCoefSpell()/100);
                                                                String attackName = (aleatoryResponse == 1) ? bot.getWeapons().get(0).getWeaponName() : bot.getSpells().get(0).getSpellName();
                                                                charater.setLife(charater.getLife()-attackBot);
                                                                lifeCharacter.setText(Integer.toString(charater.getLife()));
                                                                texView.setText("he has inflected " + attackBot + " to " + charater.getName()+ " with this " + attackName);

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
