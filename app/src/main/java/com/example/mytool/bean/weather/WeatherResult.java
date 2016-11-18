package com.example.mytool.bean.weather;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Amence on 2016/11/4.
 */

public class WeatherResult implements Parcelable {
    private WeatherData data;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.data, flags);
    }

    public WeatherResult() {
    }

    protected WeatherResult(Parcel in) {
        this.data = in.readParcelable(WeatherData.class.getClassLoader());
    }

    public static final Creator<WeatherResult> CREATOR = new Creator<WeatherResult>() {
        @Override
        public WeatherResult createFromParcel(Parcel source) {
            return new WeatherResult(source);
        }

        @Override
        public WeatherResult[] newArray(int size) {
            return new WeatherResult[size];
        }
    };

    public WeatherData getData() {
        return data;
    }

    public void setData(WeatherData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "WeatherResult{" +
                "data=" + data +
                '}';
    }
}
