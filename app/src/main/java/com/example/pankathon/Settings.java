package com.example.pankathon;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Settings implements Parcelable {
    private int world;

    private ArrayList<Egg> eggCaught = new ArrayList<>();

    protected Settings(Parcel in) {
        world = in.readInt();
        eggCaught = in.createTypedArrayList(Egg.CREATOR);
    }

    public static final Creator<Settings> CREATOR = new Creator<Settings>() {
        @Override
        public Settings createFromParcel(Parcel in) {
            return new Settings(in);
        }

        @Override
        public Settings[] newArray(int size) {
            return new Settings[size];
        }
    };

    public int getWorld() {
        return world;
    }

    public void setWorld(int world) {
        this.world = world;
    }

    public ArrayList<Egg> getEggCaught() {
        return eggCaught;
    }

    public void setEggCaught(ArrayList<Egg> eggCaught) {
        this.eggCaught = eggCaught;
    }

    public Settings(int world, Egg egg) {
        this.world = world;
        this.eggCaught.add(egg);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(world);
        dest.writeTypedList(eggCaught);
    }
}
