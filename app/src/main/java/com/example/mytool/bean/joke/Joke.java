package com.example.mytool.bean.joke;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Amence on 2016/11/3.
 */

public class Joke implements Parcelable {
    private String error_code;
    private String reason;
    private Result result;


    protected Joke(Parcel in) {
        error_code = in.readString();
        reason = in.readString();
        result = in.readParcelable(Result.class.getClassLoader());
    }

    public static final Creator<Joke> CREATOR = new Creator<Joke>() {
        @Override
        public Joke createFromParcel(Parcel in) {
            return new Joke(in);
        }

        @Override
        public Joke[] newArray(int size) {
            return new Joke[size];
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

    @Override
    public String toString() {
        return "Joke{" +
                "error_code='" + error_code + '\'' +
                ", reason='" + reason + '\'' +
                ", result=" + result +
                '}';
    }

    public String getError_code() {
        return error_code;
    }

    public void setError_code(String error_code) {
        this.error_code = error_code;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
