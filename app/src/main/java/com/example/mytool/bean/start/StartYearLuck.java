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
    private String[] future;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getResultcode() {
        return resultcode;
    }

    public void setResultcode(String resultcode) {
        this.resultcode = resultcode;
    }

    public String getError_code() {
        return error_code;
    }

    public void setError_code(String error_code) {
        this.error_code = error_code;
    }

    public StartYearMiMa getMima() {
        return mima;
    }

    public void setMima(StartYearMiMa mima) {
        this.mima = mima;
    }

    public String[] getCareer() {
        return career;
    }

    public void setCareer(String[] career) {
        this.career = career;
    }

    public String[] getLove() {
        return love;
    }

    public void setLove(String[] love) {
        this.love = love;
    }

    public String[] getHealth() {
        return health;
    }

    public void setHealth(String[] health) {
        this.health = health;
    }

    public String[] getFinance() {
        return finance;
    }

    public void setFinance(String[] finance) {
        this.finance = finance;
    }

    public String getLuckyStone() {
        return luckyStone;
    }

    public void setLuckyStone(String luckyStone) {
        this.luckyStone = luckyStone;
    }

    public String[] getFuture() {
        return future;
    }

    public void setFuture(String[] future) {
        this.future = future;
    }

    @Override
    public String toString() {
        return "StartYearLuck{" +
                "name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", year='" + year + '\'' +
                ", resultcode='" + resultcode + '\'' +
                ", error_code='" + error_code + '\'' +
                ", mima=" + mima +
                ", career=" + Arrays.toString(career) +
                ", love=" + Arrays.toString(love) +
                ", health=" + Arrays.toString(health) +
                ", finance=" + Arrays.toString(finance) +
                ", luckyStone='" + luckyStone + '\'' +
                ", future=" + Arrays.toString(future) +
                '}';
    }
}
