package com.example.mytool.bean.weather;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Amence on 2016/11/4.
 */

public class WeatherRealtime implements Parcelable {
    private String city_code;
    private String city_name;
    private String date;
    private String time;
    private String week;
    private String moon;
    private String dataUptime;
    private WeatherDetail weather;
    private WeatherWind wind;

    protected WeatherRealtime(Parcel in) {
        city_code = in.readString();
        city_name = in.readString();
        date = in.readString();
        time = in.readString();
        week = in.readString();
        moon = in.readString();
        dataUptime = in.readString();
        weather = in.readParcelable(WeatherDetail.class.getClassLoader());
        wind = in.readParcelable(WeatherWind.class.getClassLoader());
    }

    public static final Creator<WeatherRealtime> CREATOR = new Creator<WeatherRealtime>() {
        @Override
        public WeatherRealtime createFromParcel(Parcel in) {
            return new WeatherRealtime(in);
        }

        @Override
        public WeatherRealtime[] newArray(int size) {
            return new WeatherRealtime[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(city_code);
        parcel.writeString(city_name);
        parcel.writeString(date);
        parcel.writeString(time);
        parcel.writeString(week);
        parcel.writeString(moon);
        parcel.writeString(dataUptime);
        parcel.writeParcelable(weather, i);
        parcel.writeParcelable(wind, i);
    }

    public String getCity_code() {
        return city_code;
    }

    public void setCity_code(String city_code) {
        this.city_code = city_code;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getMoon() {
        return moon;
    }

    public void setMoon(String moon) {
        this.moon = moon;
    }

    public String getDataUptime() {
        return dataUptime;
    }

    public void setDataUptime(String dataUptime) {
        this.dataUptime = dataUptime;
    }

    public WeatherDetail getWeather() {
        return weather;
    }

    public void setWeather(WeatherDetail weather) {
        this.weather = weather;
    }

    public WeatherWind getWind() {
        return wind;
    }

    public void setWind(WeatherWind wind) {
        this.wind = wind;
    }

    @Override
    public String toString() {
        return "WeatherRealtime{" +
                "city_code='" + city_code + '\'' +
                ", city_name='" + city_name + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", week='" + week + '\'' +
                ", moon='" + moon + '\'' +
                ", dataUptime='" + dataUptime + '\'' +
                ", weather=" + weather +
                ", wind=" + wind +
                '}';
    }
}
