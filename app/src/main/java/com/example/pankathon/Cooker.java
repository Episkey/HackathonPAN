package com.example.pankathon;

import java.util.ArrayList;

public class Cooker {
    private String name;
    private int life;
    private String picture;
    private ArrayList<Ustensil> ustensil;
    private int age;

    public Cooker(String name, int life, String picture,Ustensil ustensil, int age) {
        this.name = name;
        this.life = life;
        this.picture = picture;
        this.ustensil.add(ustensil);
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getLife() {
        return life;
    }

    public String getPicture() {
        return picture;
    }


    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }



    public void setAge(int age) {
        this.age = age;
    }

    public ArrayList<Ustensil> getUstensil() {
        return ustensil;
    }

    public void setUstensil(ArrayList<Ustensil> ustensil) {
        this.ustensil = ustensil;
    }
}
