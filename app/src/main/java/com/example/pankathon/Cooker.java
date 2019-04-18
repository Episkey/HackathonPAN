package com.example.pankathon;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Cooker implements Parcelable {
    private String name;
    private int life;
    private String picture;
    private Ustensil ustensil;
    private int age;

    public Cooker(String name, int life, String picture,Ustensil ustensil, int age) {
        this.name = name;
        this.life = life;
        this.picture = picture;
        this.ustensil = ustensil;
        this.age = age;
    }

    protected Cooker(Parcel in) {
        name = in.readString();
        life = in.readInt();
        picture = in.readString();
        ustensil = in.readParcelable(Ustensil.class.getClassLoader());
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(life);
        dest.writeString(picture);
        dest.writeParcelable(ustensil, flags);
        dest.writeInt(age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Ustensil getUstensil() {
        return ustensil;
    }

    public void setUstensil(Ustensil ustensil) {
        this.ustensil = ustensil;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static Creator<Cooker> getCREATOR() {
        return CREATOR;
    }
}
