package com.example.mytool.bean.weather;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Amence on 2016/11/7.
 */

public class WeatherDayInfo implements Parcelable {
    private String[] day;
    private String[] night;

    protected WeatherDayInfo(Parcel in) {
        day = in.createStringArray();
        night = in.createStringArray();
    }

    public static final Creator<WeatherDayInfo> CREATOR = new Creator<WeatherDayInfo>() {
        @Override
        public WeatherDayInfo createFromParcel(Parcel in) {
            return new WeatherDayInfo(in);
        }

        @Override
        public WeatherDayInfo[] newArray(int size) {
            return new WeatherDayInfo[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringArray(day);
        parcel.writeStringArray(night);
    }

    public String[] getDay() {
        return day;
    }

    public void setDay(String[] day) {
        this.day = day;
    }

    public String[] getNight() {
        return night;
    }

    public void setNight(String[] night) {
        this.night = night;
    }
}
