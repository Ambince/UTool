package com.example.mytool.bean.weather;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Amence on 2016/11/4.
 */

public class WeatherDetail implements Parcelable {
    private String temperature;
    private String humidity;
    private String info;
    private String img;


    protected WeatherDetail(Parcel in) {
        temperature = in.readString();
        humidity = in.readString();
        info = in.readString();
        img = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(temperature);
        dest.writeString(humidity);
        dest.writeString(info);
        dest.writeString(img);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<WeatherDetail> CREATOR = new Creator<WeatherDetail>() {
        @Override
        public WeatherDetail createFromParcel(Parcel in) {
            return new WeatherDetail(in);
        }

        @Override
        public WeatherDetail[] newArray(int size) {
            return new WeatherDetail[size];
        }
    };

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "WeatherDetail{" +
                "temperature='" + temperature + '\'' +
                ", humidity='" + humidity + '\'' +
                ", info='" + info + '\'' +
                ", img='" + img + '\'' +
                '}';
    }
}
