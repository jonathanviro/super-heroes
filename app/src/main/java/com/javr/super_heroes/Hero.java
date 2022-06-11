package com.javr.super_heroes;

import android.os.Parcel;
import android.os.Parcelable;

public class Hero implements Parcelable {
    private String name;
    private String alterEgo;
    private String shortBio;
    private float power;

    public Hero(String name, String alterEgo, String shortBio, float power) {
        this.name = name;
        this.alterEgo = alterEgo;
        this.shortBio = shortBio;
        this.power = power;
    }

    protected Hero(Parcel in) {
        name = in.readString();
        alterEgo = in.readString();
        shortBio = in.readString();
        power = in.readFloat();
    }

    public static final Creator<Hero> CREATOR = new Creator<Hero>() {
        @Override
        public Hero createFromParcel(Parcel in) {
            return new Hero(in);
        }

        @Override
        public Hero[] newArray(int size) {
            return new Hero[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlterEgo() {
        return alterEgo;
    }

    public void setAlterEgo(String alterEgo) {
        this.alterEgo = alterEgo;
    }

    public String getShortBio() {
        return shortBio;
    }

    public void setShortBio(String shortBio) {
        this.shortBio = shortBio;
    }

    public float getPower() {
        return power;
    }

    public void setPower(float power) {
        this.power = power;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(alterEgo);
        dest.writeString(shortBio);
        dest.writeFloat(power);
    }
}
