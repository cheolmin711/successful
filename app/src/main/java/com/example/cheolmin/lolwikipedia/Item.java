package com.example.cheolmin.lolwikipedia;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by cheolminhwang11 on 12/8/17.
 */

public class Item implements Parcelable {
    private String name;
    private int imageId;

    //TODO make item parcelable

    public Item (String name, int imageId){super();
    }

    protected Item(Parcel in) {
        name = in.readString();
        imageId = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public int getImageId(){return imageId;}

    public void setImageId(int id){imageId= id;}

    public void setName(String n){name = n;}

    public String getName(){return name;}

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(imageId);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Item> CREATOR = new Parcelable.Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };
}