package com.google.gdgdus.studyjam;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {

    public final int age;

    public final String id;

    public final String name;

    public User(final int age, final String id, final String name) {
        this.age = age;
        this.id = id;
        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.age);
        dest.writeString(this.id);
        dest.writeString(this.name);
    }

    protected User(Parcel in) {
        this.age = in.readInt();
        this.id = in.readString();
        this.name = in.readString();
    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}
