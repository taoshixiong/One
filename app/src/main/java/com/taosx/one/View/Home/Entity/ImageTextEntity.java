package com.taosx.one.View.Home.Entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * 图文
 * Created by TAO_SX on 2017/4/25/025.
 */

public class ImageTextEntity implements Parcelable {
    private java.util.List<DataEntity> data;

    public List<DataEntity> getData() {
        return data;
    }

    public void setData(List<DataEntity> data) {
        this.data = data;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(this.data);
    }

    public ImageTextEntity() {
    }

    protected ImageTextEntity(Parcel in) {
        this.data = in.createTypedArrayList(DataEntity.CREATOR);
    }

    public static final Parcelable.Creator<ImageTextEntity> CREATOR = new Parcelable.Creator<ImageTextEntity>() {
        @Override
        public ImageTextEntity createFromParcel(Parcel source) {
            return new ImageTextEntity(source);
        }

        @Override
        public ImageTextEntity[] newArray(int size) {
            return new ImageTextEntity[size];
        }
    };
}
