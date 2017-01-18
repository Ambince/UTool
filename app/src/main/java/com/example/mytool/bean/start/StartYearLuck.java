package com.example.mytool.bean.start;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Arrays;

/**
 * Created by Amence on 2016/11/15.
 */

public class StartYearLuck implements Parcelable {
    private String name;
    private String date;
    private String year;
    private String resultcode;
    private String error_code;
    private StartYearMiMa mima;
    private String[] career;
    private String[] love;
    private String[] health;
    private String[] finance;
    private String luckyStone;
    private String future;

    public StartYearLuck() {
    }

    protected StartYearLuck(Parcel in) {
        name = in.readString();
        date = in.readString();
        year = in.readString();
        resultcode = in.readString();
        error_code = in.readString();
        mima = in.readParcelable(StartYearMiMa.class.getClassLoader());
        career = in.createStringArray();
        love = in.createStringArray();
        health = in.createStringArray();
        finance = in.createStringArray();
        luckyStone = in.readString();
        future = in.readString();
    }

    public static final Creator<StartYearLuck> CREATOR = new Creator<StartYearLuck>() {
        @Override
        public StartYearLuck createFromParcel(Parcel in) {
            return new StartYearLuck(in);
        }

        @Override
        public StartYearLuck[] newArray(int size) {
            return new StartYearLuck[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(date);
        dest.writeString(year);
        dest.writeString(resultcode);
        dest.writeString(error_code);
        dest.writeParcelable(mima, flags);
        dest.writeStringArray(career);
        dest.writeStringArray(love);
        dest.writeStringArray(health);
        dest.writeStringArray(finance);
        dest.writeString(luckyStone);
        dest.writeString(future);
    }

    public String[] getCareer() {
        return career;
    }

    public void setCareer(String[] career) {
        this.career = career;
    }

    public static Creator<StartYearLuck> getCREATOR() {
        return CREATOR;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getError_code() {
        return error_code;
    }

    public void setError_code(String error_code) {
        this.error_code = error_code;
    }

    public String[] getFinance() {
        return finance;
    }

    public void setFinance(String[] finance) {
        this.finance = finance;
    }

    public String getFuture() {
        return future;
    }

    public void setFuture(String future) {
        this.future = future;
    }

    public String[] getHealth() {
        return health;
    }

    public void setHealth(String[] health) {
        this.health = health;
    }

    public String[] getLove() {
        return love;
    }

    public void setLove(String[] love) {
        this.love = love;
    }

    public String getLuckyStone() {
        return luckyStone;
    }

    public void setLuckyStone(String luckyStone) {
        this.luckyStone = luckyStone;
    }

    public StartYearMiMa getMima() {
        return mima;
    }

    public void setMima(StartYearMiMa mima) {
        this.mima = mima;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResultcode() {
        return resultcode;
    }

    public void setResultcode(String resultcode) {
        this.resultcode = resultcode;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
