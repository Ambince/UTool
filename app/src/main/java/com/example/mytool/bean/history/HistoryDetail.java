package com.example.mytool.bean.history;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Amence on 2016/11/17.
 */

public class HistoryDetail implements Parcelable{
    private String reason;
    private List<HistoryDetailResult> result;
    private String error_code;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.reason);
        dest.writeTypedList(this.result);
        dest.writeString(this.error_code);
    }

    public HistoryDetail() {
    }

    protected HistoryDetail(Parcel in) {
        this.reason = in.readString();
        this.result = in.createTypedArrayList(HistoryDetailResult.CREATOR);
        this.error_code = in.readString();
    }

    public static final Creator<HistoryDetail> CREATOR = new Creator<HistoryDetail>() {
        @Override
        public HistoryDetail createFromParcel(Parcel source) {
            return new HistoryDetail(source);
        }

        @Override
        public HistoryDetail[] newArray(int size) {
            return new HistoryDetail[size];
        }
    };

    public static Creator<HistoryDetail> getCREATOR() {
        return CREATOR;
    }

    public String getError_code() {
        return error_code;
    }

    public void setError_code(String error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public List<HistoryDetailResult> getResult() {
        return result;
    }

    public void setResult(List<HistoryDetailResult> result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "HistoryDetail{" +
                "error_code='" + error_code + '\'' +
                ", reason='" + reason + '\'' +
                ", result=" + result +
                '}';
    }
}
