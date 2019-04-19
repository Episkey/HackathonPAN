package com.example.pankathon;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Cooker implements Parcelable {
    private String name;
    private int life;
    private String picture;
    private ArrayList<Ustensil> ustensil = new ArrayList<>();
    private int age;

    public Cooker(String name, int life, String picture,Ustensil ustensil, int age) {
        this.name = name;
        this.life = life;
        this.picture = picture;
        this.ustensil.add(ustensil);
        this.age = age;
    }


    protected Cooker(Parcel in) {
        name = in.readString();
        life = in.readInt();
        picture = in.readString();
        ustensil = in.createTypedArrayList(Ustensil.CREATOR);
        age = in.readInt();
    }

    public static final Creator<Cooker> CREATOR = new Creator<Cooker>() {
        @Override
        public Cooker createFromParcel(Parcel in) {
            return new Cooker(in);
        }

        @Override
        public Cooker[] newArray(int size) {
            return new Cooker[size];
        }
    };

    public String getName() {
        return name;
    }

    public int getLife() {
        return life;
    }

    public String getPicture() {
        return picture;
    }

    public ArrayList<Ustensil> getUstensil() {
        return ustensil;
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

    public void setUstensil(ArrayList<Ustensil> ustensil) {
        this.ustensil = ustensil;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(life);
        dest.writeString(picture);
        dest.writeTypedList(ustensil);
        dest.writeInt(age);
    }
}
