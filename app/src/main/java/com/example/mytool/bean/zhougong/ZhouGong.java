package com.example.mytool.bean.zhougong;



import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Amence on 2016/11/15.
 */

public class ZhouGong implements Parcelable {
    private String reason;
    private String error_code;
    private List<ZhouGongResult> result;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.reason);
        dest.writeString(this.error_code);
        dest.writeTypedList(this.result);
    }

    public ZhouGong() {
    }

    protected ZhouGong(Parcel in) {
        this.reason = in.readString();
        this.error_code = in.readString();
        this.result = in.createTypedArrayList(ZhouGongResult.CREATOR);
    }

    public static final Creator<ZhouGong> CREATOR = new Creator<ZhouGong>() {
        @Override
        public ZhouGong createFromParcel(Parcel source) {
            return new ZhouGong(source);
        }

        @Override
        public ZhouGong[] newArray(int size) {
            return new ZhouGong[size];
        }
    };

    public static Creator<ZhouGong> getCREATOR() {
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

    public List<ZhouGongResult> getResult() {
        return result;
    }

    public void setResult(List<ZhouGongResult> result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "ZhouGong{" +
                "error_code='" + error_code + '\'' +
                ", reason='" + reason + '\'' +
                ", result=" + result +
                '}';
    }
}
