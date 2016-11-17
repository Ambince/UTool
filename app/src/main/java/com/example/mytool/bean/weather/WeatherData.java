package com.example.mytool.bean.weather;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Amence on 2016/11/4.
 */

public class WeatherData implements Parcelable {

    private String pubdate;
    private String pubtime;
    private WeatherRealtime realtime;
    private String[] life;
    private List<WeatherList> weather;
    private WeatherF3h f3h;
    private WhetherPM pm25;
    private String jingqu;
    private String jingqutq;
    private String date;
    private String isForeign;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.pubdate);
        dest.writeString(this.pubtime);
        dest.writeParcelable(this.realtime, flags);
        dest.writeStringArray(this.life);
        dest.writeTypedList(this.weather);
        dest.writeParcelable(this.f3h, flags);
        dest.writeParcelable(this.pm25, flags);
        dest.writeString(this.jingqu);
        dest.writeString(this.jingqutq);
        dest.writeString(this.date);
        dest.writeString(this.isForeign);
    }

    public WeatherData() {
    }

    protected WeatherData(Parcel in) {
        this.pubdate = in.readString();
        this.pubtime = in.readString();
        this.realtime = in.readParcelable(WeatherRealtime.class.getClassLoader());
        this.life = in.createStringArray();
        this.weather = in.createTypedArrayList(WeatherList.CREATOR);
        this.f3h = in.readParcelable(WeatherF3h.class.getClassLoader());
        this.pm25 = in.readParcelable(WhetherPM.class.getClassLoader());
        this.jingqu = in.readString();
        this.jingqutq = in.readString();
        this.date = in.readString();
        this.isForeign = in.readString();
    }

    public static final Creator<WeatherData> CREATOR = new Creator<WeatherData>() {
        @Override
        public WeatherData createFromParcel(Parcel source) {
            return new WeatherData(source);
        }

        @Override
        public WeatherData[] newArray(int size) {
            return new WeatherData[size];
        }
    };

    public static Creator<WeatherData> getCREATOR() {
        return CREATOR;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public WeatherF3h getF3h() {
        return f3h;
    }

    public void setF3h(WeatherF3h f3h) {
        this.f3h = f3h;
    }

    public String getIsForeign() {
        return isForeign;
    }

    public void setIsForeign(String isForeign) {
        this.isForeign = isForeign;
    }

    public String getJingqu() {
        return jingqu;
    }

    public void setJingqu(String jingqu) {
        this.jingqu = jingqu;
    }

    public String getJingqutq() {
        return jingqutq;
    }

    public void setJingqutq(String jingqutq) {
        this.jingqutq = jingqutq;
    }

    public String[] getLife() {
        return life;
    }

    public void setLife(String[] life) {
        this.life = life;
    }

    public WhetherPM getPm25() {
        return pm25;
    }

    public void setPm25(WhetherPM pm25) {
        this.pm25 = pm25;
    }

    public String getPubdate() {
        return pubdate;
    }

    public void setPubdate(String pubdate) {
        this.pubdate = pubdate;
    }

    public String getPubtime() {
        return pubtime;
    }

    public void setPubtime(String pubtime) {
        this.pubtime = pubtime;
    }

    public WeatherRealtime getRealtime() {
        return realtime;
    }

    public void setRealtime(WeatherRealtime realtime) {
        this.realtime = realtime;
    }

    public List<WeatherList> getWeather() {
        return weather;
    }

    public void setWeather(List<WeatherList> weather) {
        this.weather = weather;
    }

    @Override
    public String toString() {
        return "WeatherData{" +
                "date='" + date + '\'' +
                ", pubdate='" + pubdate + '\'' +
                ", pubtime='" + pubtime + '\'' +
                ", realtime=" + realtime +
                ", life=" + Arrays.toString(life) +
                ", weather=" + weather +
                ", f3h=" + f3h +
                ", pm25=" + pm25 +
                ", jingqu='" + jingqu + '\'' +
                ", jingqutq='" + jingqutq + '\'' +
                ", isForeign='" + isForeign + '\'' +
                '}';
    }
}
