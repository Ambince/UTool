package com.example.mytool.bean.weather;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Amence on 2016/11/4.
 */

public class LifeWeather implements Parcelable {
    private String date;
    private LifeWeatherInfo info;


    protected LifeWeather(Parcel in) {
        date = in.readString();
        info = in.readParcelable(LifeWeatherInfo.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(date);
        dest.writeParcelable(info, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<LifeWeather> CREATOR = new Creator<LifeWeather>() {
        @Override
        public LifeWeather createFromParcel(Parcel in) {
            return new LifeWeather(in);
        }

        @Override
        public LifeWeather[] newArray(int size) {
            return new LifeWeather[size];
        }
    };

    @Override
    public String toString() {
        return "LifeWeather{" +
                "date='" + date + '\'' +
                ", info=" + info +
                '}';
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public LifeWeatherInfo getInfo() {
        return info;
    }

    public void setInfo(LifeWeatherInfo info) {
        this.info = info;
    }
}
