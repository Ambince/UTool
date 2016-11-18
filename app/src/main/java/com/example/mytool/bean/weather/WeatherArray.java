package com.example.mytool.bean.weather;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Amence on 2016/11/4.
 */

public class WeatherArray implements Parcelable {
    private String reason;
    private WeatherArrayResult result;
    private String error_code;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.reason);
        dest.writeParcelable(this.result, flags);
        dest.writeString(this.error_code);
    }

    public WeatherArray() {
    }

    protected WeatherArray(Parcel in) {
        this.reason = in.readString();
        this.result = in.readParcelable(WeatherArrayResult.class.getClassLoader());
        this.error_code = in.readString();
    }

    public static final Creator<WeatherArray> CREATOR = new Creator<WeatherArray>() {
        @Override
        public WeatherArray createFromParcel(Parcel source) {
            return new WeatherArray(source);
        }

        @Override
        public WeatherArray[] newArray(int size) {
            return new WeatherArray[size];
        }
    };

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getError_code() {
        return error_code;
    }

    public void setError_code(String error_code) {
        this.error_code = error_code;
    }

    public WeatherArrayResult getResult() {
        return result;
    }

    public void setResult(WeatherArrayResult result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "WeatherArray{" +
                "reason='" + reason + '\'' +
                ", result=" + result +
                ", error_code='" + error_code + '\'' +
                '}';
    }
}
