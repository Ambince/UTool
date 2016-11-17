package com.example.mytool.bean.qq;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Amence on 2016/11/7.
 */

public class Qresult implements Parcelable {
    private Qdata data;

    protected Qresult(Parcel in) {
        data = in.readParcelable(Qdata.class.getClassLoader());
    }

    public static final Creator<Qresult> CREATOR = new Creator<Qresult>() {
        @Override
        public Qresult createFromParcel(Parcel in) {
            return new Qresult(in);
        }

        @Override
        public Qresult[] newArray(int size) {
            return new Qresult[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(data, i);
    }

    public Qdata getData() {
        return data;
    }

    public void setData(Qdata data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Qresult{" +
                "data=" + data +
                '}';
    }
}
