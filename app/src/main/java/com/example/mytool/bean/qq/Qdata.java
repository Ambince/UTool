package com.example.mytool.bean.qq;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Amence on 2016/11/7.
 */

public class Qdata implements Parcelable {
    private String conclusion;
    private String analysis;

    protected Qdata(Parcel in) {
        conclusion = in.readString();
        analysis = in.readString();
    }

    public static final Creator<Qdata> CREATOR = new Creator<Qdata>() {
        @Override
        public Qdata createFromParcel(Parcel in) {
            return new Qdata(in);
        }

        @Override
        public Qdata[] newArray(int size) {
            return new Qdata[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(conclusion);
        parcel.writeString(analysis);
    }

    public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }

    public String getAnalysis() {
        return analysis;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis;
    }

    @Override
    public String toString() {
        return "Qdata{" +
                "conclusion='" + conclusion + '\'' +
                ", analysis='" + analysis + '\'' +
                '}';
    }
}
