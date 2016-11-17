package com.example.mytool.bean.weather;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Arrays;

/**
 * Created by Amence on 2016/11/4.
 */

public class LifeWeatherInfo  implements Parcelable{
    private String[] chuanyi;
    private String[] ganmao;
    private String[] kongtiao;
    private String[] xiche;
    private String[] yundong;
    private String[] ziwaixian;

    protected LifeWeatherInfo(Parcel in) {
        chuanyi = in.createStringArray();
        ganmao = in.createStringArray();
        kongtiao = in.createStringArray();
        xiche = in.createStringArray();
        yundong = in.createStringArray();
        ziwaixian = in.createStringArray();
    }

    public static final Creator<LifeWeatherInfo> CREATOR = new Creator<LifeWeatherInfo>() {
        @Override
        public LifeWeatherInfo createFromParcel(Parcel in) {
            return new LifeWeatherInfo(in);
        }

        @Override
        public LifeWeatherInfo[] newArray(int size) {
            return new LifeWeatherInfo[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringArray(chuanyi);
        parcel.writeStringArray(ganmao);
        parcel.writeStringArray(kongtiao);
        parcel.writeStringArray(xiche);
        parcel.writeStringArray(yundong);
        parcel.writeStringArray(ziwaixian);
    }

    @Override
    public String toString() {
        return "LifeWeatherInfo{" +
                "chuanyi=" + Arrays.toString(chuanyi) +
                ", ganmao=" + Arrays.toString(ganmao) +
                ", kongtiao=" + Arrays.toString(kongtiao) +
                ", xiche=" + Arrays.toString(xiche) +
                ", yundong=" + Arrays.toString(yundong) +
                ", ziwaixian=" + Arrays.toString(ziwaixian) +
                '}';
    }

    public String[] getChuanyi() {
        return chuanyi;
    }

    public void setChuanyi(String[] chuanyi) {
        this.chuanyi = chuanyi;
    }

    public String[] getGanmao() {
        return ganmao;
    }

    public void setGanmao(String[] ganmao) {
        this.ganmao = ganmao;
    }

    public String[] getKongtiao() {
        return kongtiao;
    }

    public void setKongtiao(String[] kongtiao) {
        this.kongtiao = kongtiao;
    }

    public String[] getXiche() {
        return xiche;
    }

    public void setXiche(String[] xiche) {
        this.xiche = xiche;
    }

    public String[] getYundong() {
        return yundong;
    }

    public void setYundong(String[] yundong) {
        this.yundong = yundong;
    }

    public String[] getZiwaixian() {
        return ziwaixian;
    }

    public void setZiwaixian(String[] ziwaixian) {
        this.ziwaixian = ziwaixian;
    }
}
