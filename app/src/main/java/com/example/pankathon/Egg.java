package com.example.pankathon;

import android.os.Parcel;
import android.os.Parcelable;

public class Egg implements Parcelable {


        private String id;
        private String name;
        private String color;
        private String caliber;
        private int farming;
        private String country;
        private String rarity;
        private String picture;
        private String power;
        private int life;

        public Egg(String id, String name, String color, String caliber, int farming, String country, String rarity, String picture, String power, int life) {
            this.id = id;
            this.name = name;
            this.color = color;
            this.caliber = caliber;
            this.farming = farming;
            this.country = country;
            this.rarity = rarity;
            this.picture = picture;
            this.power = power;
            this.life = life;
        }


    protected Egg(Parcel in) {
        id = in.readString();
        name = in.readString();
        color = in.readString();
        caliber = in.readString();
        farming = in.readInt();
        country = in.readString();
        rarity = in.readString();
        picture = in.readString();
        power = in.readString();
        life = in.readInt();
    }

    public static final Creator<Egg> CREATOR = new Creator<Egg>() {
        @Override
        public Egg createFromParcel(Parcel in) {
            return new Egg(in);
        }

        @Override
        public Egg[] newArray(int size) {
            return new Egg[size];
        }
    };

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public String getCaliber() {
        return caliber;
    }

    public int getFarming() {
        return farming;
    }

    public String getCountry() {
        return country;
    }

    public String getRarity() {
        return rarity;
    }

    public String getPicture() {
        return picture;
    }

    public String getPower() {
        return power;
    }

    public int getLife() {
        return life;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setCaliber(String caliber) {
        this.caliber = caliber;
    }

    public void setFarming(int farming) {
        this.farming = farming;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public void setLife(int life) {
        this.life = life;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(name);
        dest.writeString(color);
        dest.writeString(caliber);
        dest.writeInt(farming);
        dest.writeString(country);
        dest.writeString(rarity);
        dest.writeString(picture);
        dest.writeString(power);
        dest.writeInt(life);
    }
}
