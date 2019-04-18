package com.example.pankathon;

import android.os.Parcel;
import android.os.Parcelable;

public class Settings implements Parcelable {
    private int world;

    public Settings(int world) {
        this.world = world;
    }

    protected Settings(Parcel in) {
        world = in.readInt();
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(world);
    }
}
