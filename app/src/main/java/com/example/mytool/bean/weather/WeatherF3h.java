package com.example.mytool.bean.weather;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Amence on 2016/11/4.
 */

public class WeatherF3h implements Parcelable{
    protected WeatherF3h(Parcel in) {
    }

    public static final Creator<WeatherF3h> CREATOR = new Creator<WeatherF3h>() {
        @Override
        public WeatherF3h createFromParcel(Parcel in) {
            return new WeatherF3h(in);
        }

        @Override
        public WeatherF3h[] newArray(int size) {
            return new WeatherF3h[size];
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
