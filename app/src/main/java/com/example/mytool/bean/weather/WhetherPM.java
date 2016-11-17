package com.example.mytool.bean.weather;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Amence on 2016/11/4.
 */

public class WhetherPM implements Parcelable{
    protected WhetherPM(Parcel in) {
    }

    public static final Creator<WhetherPM> CREATOR = new Creator<WhetherPM>() {
        @Override
        public WhetherPM createFromParcel(Parcel in) {
            return new WhetherPM(in);
        }

        @Override
        public WhetherPM[] newArray(int size) {
            return new WhetherPM[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
    }
}
