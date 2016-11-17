package com.example.mytool.bean.qq;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Amence on 2016/11/7.
 */

public class Qluck implements Parcelable {
    private String error_code;
    private String reason;
    private Qresult result;

    public Qluck(){

    }

    protected Qluck(Parcel in) {
        error_code = in.readString();
        reason = in.readString();
        result = in.readParcelable(Qresult.class.getClassLoader());
    }

    public static final Creator<Qluck> CREATOR = new Creator<Qluck>() {
        @Override
        public Qluck createFromParcel(Parcel in) {
            return new Qluck(in);
        }

        @Override
        public Qluck[] newArray(int size) {
            return new Qluck[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(error_code);
        parcel.writeString(reason);
        parcel.writeParcelable(result, i);
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

    public Qresult getResult() {
        return result;
    }

    public void setResult(Qresult result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Qluck{" +
                "error_code='" + error_code + '\'' +
                ", reason='" + reason + '\'' +
                ", result=" + result +
                '}';
    }


}
