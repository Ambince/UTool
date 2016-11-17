package com.example.mytool.bean.history;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Amence on 2016/11/16.
 */

public class History implements Parcelable {
    private String reason;
    private List<HistoryResult> result;
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

    public History() {
    }

    protected History(Parcel in) {
        this.reason = in.readString();
        this.result = in.createTypedArrayList(HistoryResult.CREATOR);
        this.error_code = in.readString();
    }

    public static final Creator<History> CREATOR = new Creator<History>() {
        @Override
        public History createFromParcel(Parcel source) {
            return new History(source);
        }

        @Override
        public History[] newArray(int size) {
            return new History[size];
        }
    };

    public static Creator<History> getCREATOR() {
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

    public List<HistoryResult> getResult() {
        return result;
    }

    public void setResult(List<HistoryResult> result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "History{" +
                "error_code='" + error_code + '\'' +
                ", reason='" + reason + '\'' +
                ", result=" + result +
                '}';
    }
}
