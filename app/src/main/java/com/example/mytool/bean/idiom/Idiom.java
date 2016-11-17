package com.example.mytool.bean.idiom;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Amence on 2016/11/10.
 */

public class Idiom implements Parcelable {
    private String reason;
    private IdiomResult result;
    private String error_code;

    public Idiom(){

    }

    protected Idiom(Parcel in) {
        reason = in.readString();
        result = in.readParcelable(IdiomResult.class.getClassLoader());
        error_code = in.readString();
    }

    public static final Creator<Idiom> CREATOR = new Creator<Idiom>() {
        @Override
        public Idiom createFromParcel(Parcel in) {
            return new Idiom(in);
        }

        @Override
        public Idiom[] newArray(int size) {
            return new Idiom[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(reason);
        dest.writeParcelable(result, flags);
        dest.writeString(error_code);
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public IdiomResult getResult() {
        return result;
    }

    public void setResult(IdiomResult result) {
        this.result = result;
    }

    public String getError_code() {
        return error_code;
    }

    public void setError_code(String error_code) {
        this.error_code = error_code;
    }

    @Override
    public String toString() {
        return "Idiom{" +
                "reason='" + reason + '\'' +
                ", result=" + result +
                ", error_code='" + error_code + '\'' +
                '}';
    }
}
