package com.example.mytool.bean.joke;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Amence on 2016/11/3.
 */

public class DataJoke implements Parcelable {
    private String content;
    private String hashId;
    private String unixtime;
    private String updatetime;


    protected DataJoke(Parcel in) {
        content = in.readString();
        hashId = in.readString();
        unixtime = in.readString();
        updatetime = in.readString();
    }

    public static final Creator<DataJoke> CREATOR = new Creator<DataJoke>() {
        @Override
        public DataJoke createFromParcel(Parcel in) {
            return new DataJoke(in);
        }

        @Override
        public DataJoke[] newArray(int size) {
            return new DataJoke[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(content);
        parcel.writeString(hashId);
        parcel.writeString(unixtime);
        parcel.writeString(updatetime);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    public String getUnixtime() {
        return unixtime;
    }

    public void setUnixtime(String unixtime) {
        this.unixtime = unixtime;
    }

    public String getHashId() {
        return hashId;
    }

    public void setHashId(String hashId) {
        this.hashId = hashId;
    }
}
