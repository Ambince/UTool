package com.example.mytool.bean.ip;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Amence on 2016/11/10.
 */

public class IP implements Parcelable {
    private String resultcode;
    private String reason;
    private IpResult result;

    public IP(){

    }


    public IP(Parcel in) {
        resultcode = in.readString();
        reason = in.readString();
        result = in.readParcelable(IpResult.class.getClassLoader());
    }

    public static final Creator<IP> CREATOR = new Creator<IP>() {
        @Override
        public IP createFromParcel(Parcel in) {
            return new IP(in);
        }

        @Override
        public IP[] newArray(int size) {
            return new IP[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(resultcode);
        dest.writeString(reason);
        dest.writeParcelable(result, flags);
    }

    public String getResultcode() {
        return resultcode;
    }

    public void setResultcode(String resultcode) {
        this.resultcode = resultcode;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public IpResult getResult() {
        return result;
    }

    public void setResult(IpResult result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "IP{" +
                "resultcode='" + resultcode + '\'' +
                ", reason='" + reason + '\'' +
                ", result=" + result +
                '}';
    }
}
