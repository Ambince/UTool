package com.example.mytool.bean.weather;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Amence on 2016/11/4.
 */

public class WeatherArrayResult implements Parcelable {
    private WeatherCommentData data;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.data, flags);
    }

    public WeatherArrayResult() {
    }

    protected WeatherArrayResult(Parcel in) {
        this.data = in.readParcelable(WeatherCommentData.class.getClassLoader());
    }

    public static final Creator<WeatherArrayResult> CREATOR = new Creator<WeatherArrayResult>() {
        @Override
        public WeatherArrayResult createFromParcel(Parcel source) {
            return new WeatherArrayResult(source);
        }

        @Override
        public WeatherArrayResult[] newArray(int size) {
            return new WeatherArrayResult[size];
        }
    };

    public WeatherCommentData getData() {
        return data;
    }

    public void setData(WeatherCommentData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "WeatherArrayResult{" +
                "data=" + data +
                '}';
    }
}
