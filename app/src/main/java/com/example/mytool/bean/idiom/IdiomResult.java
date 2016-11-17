package com.example.mytool.bean.idiom;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Arrays;

/**
 * Created by Amence on 2016/11/10.
 */

public class IdiomResult implements Parcelable {
    private String bushou;
    private String head;
    private String pinyin;
    private String chengyujs;
    private String from_;
    private String example;
    private String yufa;
    private String ciyujs;
    private String yinzhengjs;
    private String[] tongyi;
    private String[] fanyi;

    protected IdiomResult(Parcel in) {
        bushou = in.readString();
        head = in.readString();
        pinyin = in.readString();
        chengyujs = in.readString();
        from_ = in.readString();
        example = in.readString();
        yufa = in.readString();
        ciyujs = in.readString();
        yinzhengjs = in.readString();
        tongyi = in.createStringArray();
        fanyi = in.createStringArray();
    }

    public static final Creator<IdiomResult> CREATOR = new Creator<IdiomResult>() {
        @Override
        public IdiomResult createFromParcel(Parcel in) {
            return new IdiomResult(in);
        }

        @Override
        public IdiomResult[] newArray(int size) {
            return new IdiomResult[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(bushou);
        dest.writeString(head);
        dest.writeString(pinyin);
        dest.writeString(chengyujs);
        dest.writeString(from_);
        dest.writeString(example);
        dest.writeString(yufa);
        dest.writeString(ciyujs);
        dest.writeString(yinzhengjs);
        dest.writeStringArray(tongyi);
        dest.writeStringArray(fanyi);
    }

    public String getBushou() {
        return bushou;
    }

    public void setBushou(String bushou) {
        this.bushou = bushou;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public String getChengyujs() {
        return chengyujs;
    }

    public void setChengyujs(String chengyujs) {
        this.chengyujs = chengyujs;
    }

    public String getFrom_() {
        return from_;
    }

    public void setFrom_(String from_) {
        this.from_ = from_;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public String getYufa() {
        return yufa;
    }

    public void setYufa(String yufa) {
        this.yufa = yufa;
    }

    public String getCiyujs() {
        return ciyujs;
    }

    public void setCiyujs(String ciyujs) {
        this.ciyujs = ciyujs;
    }

    public String getYinzhengjs() {
        return yinzhengjs;
    }

    public void setYinzhengjs(String yinzhengjs) {
        this.yinzhengjs = yinzhengjs;
    }

    public String[] getTongyi() {
        return tongyi;
    }

    public void setTongyi(String[] tongyi) {
        this.tongyi = tongyi;
    }

    public String[] getFanyi() {
        return fanyi;
    }

    public void setFanyi(String[] fanyi) {
        this.fanyi = fanyi;
    }

    @Override
    public String toString() {
        return "IdiomResult{" +
                "bushou='" + bushou + '\'' +
                ", head='" + head + '\'' +
                ", pinyin='" + pinyin + '\'' +
                ", chengyujs='" + chengyujs + '\'' +
                ", from_='" + from_ + '\'' +
                ", example='" + example + '\'' +
                ", yufa='" + yufa + '\'' +
                ", ciyujs='" + ciyujs + '\'' +
                ", yinzhengjs='" + yinzhengjs + '\'' +
                ", tongyi=" + Arrays.toString(tongyi) +
                ", fanyi=" + Arrays.toString(fanyi) +
                '}';
    }
}
