package com.wizlinx.parceablepractice;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class UserDetails implements Parcelable {
    public UserDetails(List<UserData> list) {
        this.list = list;
    }

    List<UserData> list;

    protected UserDetails(Parcel in) {
        list = in.createTypedArrayList(UserData.CREATOR);
    }

    public static final Creator<UserData> CREATOR = new Creator<UserData>() {
        @Override
        public UserData createFromParcel(Parcel in) {
            return new UserData(in);
        }

        @Override
        public UserData[] newArray(int size) {
            return new UserData[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(list);
    }

    public List<UserData> getList() {
        return list;
    }

    public void setList(List<UserData> list) {
        this.list = list;
    }

    public static Creator<UserData> getCREATOR() {
        return CREATOR;
    }
}
