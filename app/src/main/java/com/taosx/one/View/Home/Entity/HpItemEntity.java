package com.taosx.one.View.Home.Entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by TAO_SX on 2017/4/25/025.
 */

public class HpItemEntity implements Parcelable {
    private String name;
    private String url;
    private String originalUrl;//原图
    private List<DataEntity> listData;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public List<DataEntity> getListData() {
        return listData;
    }

    public void setListData(List<DataEntity> listData) {
        this.listData = listData;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.url);
        dest.writeString(this.originalUrl);
        dest.writeTypedList(this.listData);
    }

    public HpItemEntity() {
    }

    protected HpItemEntity(Parcel in) {
        this.name = in.readString();
        this.url = in.readString();
        this.originalUrl = in.readString();
        this.listData = in.createTypedArrayList(DataEntity.CREATOR);
    }

    public static final Parcelable.Creator<HpItemEntity> CREATOR = new Parcelable.Creator<HpItemEntity>() {
        @Override
        public HpItemEntity createFromParcel(Parcel source) {
            return new HpItemEntity(source);
        }

        @Override
        public HpItemEntity[] newArray(int size) {
            return new HpItemEntity[size];
        }
    };
}
