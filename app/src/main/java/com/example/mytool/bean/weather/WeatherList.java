package com.example.mytool.bean.weather;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Amence on 2016/11/4.
 */

public class WeatherList implements Parcelable {
    private String date;
    private WeatherDayInfo info;
    private String week;
    private String nongli;


    protected WeatherList(Parcel in) {
        date = in.readString();
        info = in.readParcelable(WeatherDayInfo.class.getClassLoader());
        week = in.readString();
        nongli = in.readString();
    }

    public static final Creator<WeatherList> CREATOR = new Creator<WeatherList>() {
        @Override
        public WeatherList createFromParcel(Parcel in) {
            return new WeatherList(in);
        }

        @Override
        public WeatherList[] newArray(int size) {
            return new WeatherList[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(date);
        parcel.writeParcelable(info, i);
        parcel.writeString(week);
        parcel.writeString(nongli);
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public WeatherDayInfo getInfo() {
        return info;
    }

    public void setInfo(WeatherDayInfo info) {
        this.info = info;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getNongli() {
        return nongli;
    }

    public void setNongli(String nongli) {
        this.nongli = nongli;
    }

    @Override
    public String toString() {
        return "WeatherList{" +
                "date='" + date + '\'' +
                ", info=" + info +
                ", week='" + week + '\'' +
                ", nongli='" + nongli + '\'' +
                '}';
    }
}
