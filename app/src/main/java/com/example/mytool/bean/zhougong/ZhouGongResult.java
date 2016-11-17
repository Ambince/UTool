package com.example.mytool.bean.zhougong;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Amence on 2016/11/15.
 */

public class ZhouGongResult implements Parcelable {
    private String id;
    private String title;
    private String des;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.title);
        dest.writeString(this.des);
    }

    public ZhouGongResult() {
    }

    protected ZhouGongResult(Parcel in) {
        this.id = in.readString();
        this.title = in.readString();
        this.des = in.readString();
    }

    public static final Creator<ZhouGongResult> CREATOR = new Creator<ZhouGongResult>() {
        @Override
        public ZhouGongResult createFromParcel(Parcel source) {
            return new ZhouGongResult(source);
        }

        @Override
        public ZhouGongResult[] newArray(int size) {
            return new ZhouGongResult[size];
        }
    };

    public static Creator<ZhouGongResult> getCREATOR() {
        return CREATOR;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "ZhouGongResult{" +
                "des='" + des + '\'' +
                ", id='" + id + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}