package com.example.mytool.bean.joke;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Amence on 2016/11/3.
 */

public class Result implements Parcelable {
    private List<DataJoke> data;

    protected Result(Parcel in) {
        data = in.createTypedArrayList(DataJoke.CREATOR);
    }

    public static final Creator<Result> CREATOR = new Creator<Result>() {
        @Override
        public Result createFromParcel(Parcel in) {
            return new Result(in);
        }

        @Override
        public Result[] newArray(int size) {
            return new Result[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(data);
    }

    @Override
    public String toString() {
        return "Result{" +
                "data=" + data +
                '}';
    }

    public List<DataJoke> getData() {
        return data;
    }

    public void setData(List<DataJoke> data) {
        this.data = data;
    }
}
