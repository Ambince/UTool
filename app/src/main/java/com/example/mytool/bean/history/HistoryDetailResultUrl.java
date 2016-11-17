package com.example.mytool.bean.history;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Amence on 2016/11/16.
 */

public class HistoryDetailResultUrl implements Parcelable {
    private String pic_title;
    private String id;
    private String url;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.pic_title);
        dest.writeString(this.id);
        dest.writeString(this.url);
    }

    public HistoryDetailResultUrl() {
    }

    protected HistoryDetailResultUrl(Parcel in) {
        this.pic_title = in.readString();
        this.id = in.readString();
        this.url = in.readString();
    }

    public static final Creator<HistoryDetailResultUrl> CREATOR = new Creator<HistoryDetailResultUrl>() {
        @Override
        public HistoryDetailResultUrl createFromParcel(Parcel source) {
            return new HistoryDetailResultUrl(source);
        }

        @Override
        public HistoryDetailResultUrl[] newArray(int size) {
            return new HistoryDetailResultUrl[size];
        }
    };

    public static Creator<HistoryDetailResultUrl> getCREATOR() {
        return CREATOR;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPic_title() {
        return pic_title;
    }

    public void setPic_title(String pic_title) {
        this.pic_title = pic_title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "HistoryDetailResultUrl{" +
                "id='" + id + '\'' +
                ", pic_title='" + pic_title + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
