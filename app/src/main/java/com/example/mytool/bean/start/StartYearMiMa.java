package com.example.mytool.bean.start;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Arrays;

/**
 * Created by Amence on 2016/11/15.
 */

public class StartYearMiMa implements Parcelable {
    private String info;
    private String[] text;

    protected StartYearMiMa(Parcel in) {
        info = in.readString();
        text = in.createStringArray();
    }

    public static final Creator<StartYearMiMa> CREATOR = new Creator<StartYearMiMa>() {
        @Override
        public StartYearMiMa createFromParcel(Parcel in) {
            return new StartYearMiMa(in);
        }

        @Override
        public StartYearMiMa[] newArray(int size) {
            return new StartYearMiMa[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(info);
        dest.writeStringArray(text);
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String[] getText() {
        return text;
    }

    public void setText(String[] text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "StartYearMiMa{" +
                "info='" + info + '\'' +
                ", text=" + Arrays.toString(text) +
                '}';
    }
}
