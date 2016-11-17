package com.example.mytool.bean.history;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Amence on 2016/11/16.
 */

public class HistoryDetailResult implements Parcelable {
    private String e_id;
    private String title;
    private String content;
    private String picNo;
    private List<HistoryDetailResultUrl> picUrl;
    private String error_code;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.e_id);
        dest.writeString(this.title);
        dest.writeString(this.content);
        dest.writeString(this.picNo);
        dest.writeTypedList(this.picUrl);
        dest.writeString(this.error_code);
    }

    public HistoryDetailResult() {
    }

    protected HistoryDetailResult(Parcel in) {
        this.e_id = in.readString();
        this.title = in.readString();
        this.content = in.readString();
        this.picNo = in.readString();
        this.picUrl = in.createTypedArrayList(HistoryDetailResultUrl.CREATOR);
        this.error_code = in.readString();
    }

    public static final Creator<HistoryDetailResult> CREATOR = new Creator<HistoryDetailResult>() {
        @Override
        public HistoryDetailResult createFromParcel(Parcel source) {
            return new HistoryDetailResult(source);
        }

        @Override
        public HistoryDetailResult[] newArray(int size) {
            return new HistoryDetailResult[size];
        }
    };

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public static Creator<HistoryDetailResult> getCREATOR() {
        return CREATOR;
    }

    public String getE_id() {
        return e_id;
    }

    public void setE_id(String e_id) {
        this.e_id = e_id;
    }

    public String getError_code() {
        return error_code;
    }

    public void setError_code(String error_code) {
        this.error_code = error_code;
    }

    public String getPicNo() {
        return picNo;
    }

    public void setPicNo(String picNo) {
        this.picNo = picNo;
    }

    public List<HistoryDetailResultUrl> getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(List<HistoryDetailResultUrl> picUrl) {
        this.picUrl = picUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "HistoryDetailResult{" +
                "content='" + content + '\'' +
                ", e_id='" + e_id + '\'' +
                ", title='" + title + '\'' +
                ", picNo='" + picNo + '\'' +
                ", picUrl=" + picUrl +
                ", error_code='" + error_code + '\'' +
                '}';
    }
}
