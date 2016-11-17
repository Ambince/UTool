package com.example.mytool.bean.idCard;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Amence on 2016/11/10.
 */

public class IdResult implements Parcelable {
    private String area;
    private String sex;
    private String birthday;
    private String verify;


    protected IdResult(Parcel in) {
        area = in.readString();
        sex = in.readString();
        birthday = in.readString();
        verify = in.readString();
    }

    public static final Creator<IdResult> CREATOR = new Creator<IdResult>() {
        @Override
        public IdResult createFromParcel(Parcel in) {
            return new IdResult(in);
        }

        @Override
        public IdResult[] newArray(int size) {
            return new IdResult[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(area);
        dest.writeString(sex);
        dest.writeString(birthday);
        dest.writeString(verify);
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getVerify() {
        return verify;
    }

    public void setVerify(String verify) {
        this.verify = verify;
    }

    @Override
    public String toString() {
        return "IdResult{" +
                "area='" + area + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday='" + birthday + '\'' +
                ", verify='" + verify + '\'' +
                '}';
    }
}
