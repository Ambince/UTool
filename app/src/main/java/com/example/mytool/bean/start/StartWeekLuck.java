package com.example.mytool.bean.start;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Amence on 2016/11/15.
 */

public class StartWeekLuck implements Parcelable {
    private String date;
    private String name;
    private String health;
    private String job;
    private String love;
    private String money;
    private String weekth;
    private String work;
    private String resultcode;
    private String error_code;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getLove() {
        return love;
    }

    public void setLove(String love) {
        this.love = love;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getWeekth() {
        return weekth;
    }

    public void setWeekth(String weekth) {
        this.weekth = weekth;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
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

    @Override
    public String toString() {
        return "StartWeekLuck{" +
                "date='" + date + '\'' +
                ", name='" + name + '\'' +
                ", health='" + health + '\'' +
                ", job='" + job + '\'' +
                ", love='" + love + '\'' +
                ", money='" + money + '\'' +
                ", weekth='" + weekth + '\'' +
                ", work='" + work + '\'' +
                ", resultcode='" + resultcode + '\'' +
                ", error_code='" + error_code + '\'' +
                '}';
    }
}
