package com.example.pankathon;

public class Ustensil {
    private String name;
    private int attack;

    public void setPicture(String picture) {
        this.picture = picture;
    }

    private String picture;

    public Ustensil(String name, int attack, String picture) {
        this.name = name;
        this.attack = attack;
        this.picture = picture;
    }


    public String getName() {
        return name;
    }

    public int getAttack() {
        return attack;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public String getPicture() {
        return picture;
    }
}
