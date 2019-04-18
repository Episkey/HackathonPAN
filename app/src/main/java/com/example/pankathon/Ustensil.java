package com.example.pankathon;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

public class Ustensil implements Parcelable {
    private String name;
    private int attack;

    protected Ustensil(Parcel in) {
        name = in.readString();
        attack = in.readInt();
        picture = in.readString();
    }

    public static final Creator<Ustensil> CREATOR = new Creator<Ustensil>() {
        @Override
        public Ustensil createFromParcel(Parcel in) {
            return new Ustensil(in);
        }

        @Override
        public Ustensil[] newArray(int size) {
            return new Ustensil[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(attack);
        dest.writeString(picture);
    }


}
