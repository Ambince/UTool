package com.example.mytool.bean.phone;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Amence on 2016/11/2.
 */

public class PhoneResult implements Parcelable {
    private String province;
    private String city;
    private String areacode;
    private String zip;
    private String company;
    public  PhoneResult(){

    }

    protected PhoneResult(Parcel in) {
        province = in.readString();
        city = in.readString();
        areacode = in.readString();
        zip = in.readString();
        company = in.readString();
    }

    public static final Creator<PhoneResult> CREATOR = new Creator<PhoneResult>() {
        @Override
        public PhoneResult createFromParcel(Parcel in) {
            return new PhoneResult(in);
        }

        @Override
        public PhoneResult[] newArray(int size) {
            return new PhoneResult[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(province);
        parcel.writeString(city);
        parcel.writeString(areacode);
        parcel.writeString(zip);
        parcel.writeString(company);
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAreacode() {
        return areacode;
    }

    public void setAreacode(String areacode) {
        this.areacode = areacode;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "PhoneResult{" +
                "province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", areacode='" + areacode + '\'' +
                ", zip='" + zip + '\'' +
                ", company='" + company + '\'' +
                '}';
    }
}
