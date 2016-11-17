package com.example.mytool.bean.start;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Amence on 2016/11/15.
 */

public class StartDayLuck implements Parcelable{
    private String data;
    private String name;
    private String datetime;
    private String all;
    private String color;
    private String health;
    private String love;
    private String money;
    private String number;
    private String QFriend;
    private String summary;
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getAll() {
        return all;
    }

    public void setAll(String all) {
        this.all = all;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getQFriend() {
        return QFriend;
    }

    public void setQFriend(String QFriend) {
        this.QFriend = QFriend;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
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
        return "StartLuck{" +
                "data='" + data + '\'' +
                ", name='" + name + '\'' +
                ", datetime='" + datetime + '\'' +
                ", all='" + all + '\'' +
                ", color='" + color + '\'' +
                ", health='" + health + '\'' +
                ", love='" + love + '\'' +
                ", money='" + money + '\'' +
                ", number='" + number + '\'' +
                ", QFriend='" + QFriend + '\'' +
                ", summary='" + summary + '\'' +
                ", work='" + work + '\'' +
                ", resultcode='" + resultcode + '\'' +
                ", error_code='" + error_code + '\'' +
                '}';
    }
}
