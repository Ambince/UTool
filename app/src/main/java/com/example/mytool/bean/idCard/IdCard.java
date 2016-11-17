package com.example.mytool.bean.idCard;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Amence on 2016/11/10.
 */

public class IdCard implements Parcelable {
    private String resultcode;
    private String reason;
    private String error_code;
    private IdResult result;

    public IdCard() {
        
    }

    protected IdCard(Parcel in) {
        resultcode = in.readString();
        reason = in.readString();
        error_code = in.readString();
        result = in.readParcelable(IdResult.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(resultcode);
        dest.writeString(reason);
        dest.writeString(error_code);
        dest.writeParcelable(result, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<IdCard> CREATOR = new Creator<IdCard>() {
        @Override
        public IdCard createFromParcel(Parcel in) {
            return new IdCard(in);
        }

        @Override
        public IdCard[] newArray(int size) {
            return new IdCard[size];
        }
    };

    public String getResultcode() {
        return resultcode;
    }

    public void setResultcode(String resultcode) {
        this.resultcode = resultcode;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getError_code() {
        return error_code;
    }

    public void setError_code(String error_code) {
        this.error_code = error_code;
    }

    public IdResult getResult() {
        return result;
    }

    public void setResult(IdResult result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "IdCard{" +
                "resultcode='" + resultcode + '\'' +
                ", reason='" + reason + '\'' +
                ", error_code='" + error_code + '\'' +
                ", result=" + result +
                '}';
    }
}
