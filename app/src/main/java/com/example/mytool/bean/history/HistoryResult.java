package com.example.mytool.bean.history;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Amence on 2016/11/15.
 */

public class HistoryResult implements Parcelable {
    private String day;
    private String date;
    private String title;
    private String e_id;


    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getE_id() {
        return e_id;
    }

    public void setE_id(String e_id) {
        this.e_id = e_id;
    }

    @Override
    public String toString() {
        return "HistoryResult{" +
                "day='" + day + '\'' +
                ", date='" + date + '\'' +
                ", title='" + title + '\'' +
                ", e_id='" + e_id + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.day);
        dest.writeString(this.date);
        dest.writeString(this.title);
        dest.writeString(this.e_id);
    }

    public HistoryResult() {
    }

    protected HistoryResult(Parcel in) {
        this.day = in.readString();
        this.date = in.readString();
        this.title = in.readString();
        this.e_id = in.readString();
    }

    public static final Creator<HistoryResult> CREATOR = new Creator<HistoryResult>() {
        @Override
        public HistoryResult createFromParcel(Parcel source) {
            return new HistoryResult(source);
        }

        @Override
        public HistoryResult[] newArray(int size) {
            return new HistoryResult[size];
        }
    };
}
