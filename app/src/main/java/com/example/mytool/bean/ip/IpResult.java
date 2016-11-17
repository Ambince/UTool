package com.example.mytool.bean.ip;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Amence on 2016/11/10.
 */

public class IpResult implements Parcelable {
    private String area;
    private String location;

    protected IpResult(Parcel in) {
        area = in.readString();
        location = in.readString();
    }

    public static final Creator<IpResult> CREATOR = new Creator<IpResult>() {
        @Override
        public IpResult createFromParcel(Parcel in) {
            return new IpResult(in);
        }

        @Override
        public IpResult[] newArray(int size) {
            return new IpResult[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(area);
        dest.writeString(location);
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "IpResult{" +
                "area='" + area + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
