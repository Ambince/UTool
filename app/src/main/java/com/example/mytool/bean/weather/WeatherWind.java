package com.example.mytool.bean.weather;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Amence on 2016/11/4.
 */

public class WeatherWind implements Parcelable {
    private String direct;
    private String power;
    private String offset;
    private String windspeed;

    protected WeatherWind(Parcel in) {
        direct = in.readString();
        power = in.readString();
        offset = in.readString();
        windspeed = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(direct);
        dest.writeString(power);
        dest.writeString(offset);
        dest.writeString(windspeed);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<WeatherWind> CREATOR = new Creator<WeatherWind>() {
        @Override
        public WeatherWind createFromParcel(Parcel in) {
            return new WeatherWind(in);
        }

        @Override
        public WeatherWind[] newArray(int size) {
            return new WeatherWind[size];
        }
    };

    public String getDirect() {
        return direct;
    }

    public void setDirect(String direct) {
        this.direct = direct;
    }

    public String getWindspeed() {
        return windspeed;
    }

    public void setWindspeed(String windspeed) {
        this.windspeed = windspeed;
    }

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }
}
