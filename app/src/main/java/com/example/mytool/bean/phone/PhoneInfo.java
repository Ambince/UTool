package com.example.mytool.bean.phone;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Amence on 2016/11/2.
 */

public class PhoneInfo implements Parcelable {
    private String resultcode;
    private PhoneResult result;

    private String error_code;


    protected PhoneInfo(Parcel in) {
        resultcode = in.readString();
        result = in.readParcelable(PhoneResult.class.getClassLoader());
        error_code = in.readString();
    }

    public static final Creator<PhoneInfo> CREATOR = new Creator<PhoneInfo>() {
        @Override
        public PhoneInfo createFromParcel(Parcel in) {
            return new PhoneInfo(in);
        }

        @Override
        public PhoneInfo[] newArray(int size) {
            return new PhoneInfo[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(resultcode);
        parcel.writeParcelable(result, i);
        parcel.writeString(error_code);
    }

    public String getResultcode() {
        return resultcode;
    }

    public void setResultcode(String resultcode) {
        this.resultcode = resultcode;
    }

    public PhoneResult getResult() {
        return result;
    }

    public void setResult(PhoneResult result) {
        this.result = result;
    }

    public String getError_code() {
        return error_code;
    }

    public void setError_code(String error_code) {
        this.error_code = error_code;
    }
}
