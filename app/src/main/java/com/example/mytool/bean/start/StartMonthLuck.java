package com.example.mytool.bean.start;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Amence on 2016/11/15.
 */

public class StartMonthLuck implements Parcelable {
    private String date;
    private String name;
    private String all;
    private String happyMagic;
    private String health;
    private String love;
    private String money;
    private String month;
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

    public String getAll() {
        return all;
    }

    public void setAll(String all) {
        this.all = all;
    }

    public String getHappyMagic() {
        return happyMagic;
    }

    public void setHappyMagic(String happyMagic) {
        this.happyMagic = happyMagic;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
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

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
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
        return "StartMonthLuck{" +
                "date='" + date + '\'' +
                ", name='" + name + '\'' +
                ", all='" + all + '\'' +
                ", happyMagic='" + happyMagic + '\'' +
                ", health='" + health + '\'' +
                ", love='" + love + '\'' +
                ", money='" + money + '\'' +
                ", month='" + month + '\'' +
                ", work='" + work + '\'' +
                ", resultcode='" + resultcode + '\'' +
                ", error_code='" + error_code + '\'' +
                '}';
    }
}
