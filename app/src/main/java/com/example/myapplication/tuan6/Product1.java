package com.example.myapplication.tuan6;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Product1 implements Parcelable {
    private String styleID;
    private String brand;
    private String price;
    private String additionalInfo;
    private String searchImage;

    public Product1() {
    }

    public Product1(String styleID, String brand, String price, String additionalInfo, String searchImage) {
        this.styleID = styleID;
        this.brand = brand;
        this.price = price;
        this.additionalInfo = additionalInfo;
        this.searchImage = searchImage;
    }

    protected Product1(Parcel in) {
        styleID = in.readString();
        brand = in.readString();
        price = in.readString();
        additionalInfo = in.readString();
        searchImage = in.readString();
    }

    public static final Creator<Product1> CREATOR = new Creator<Product1>() {
        @Override
        public Product1 createFromParcel(Parcel in) {
            return new Product1(in);
        }

        @Override
        public Product1[] newArray(int size) {
            return new Product1[size];
        }
    };

    public String getStyleID() {
        return styleID;
    }

    public void setStyleID(String styleID) {
        this.styleID = styleID;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public String getSearchImage() {
        return searchImage;
    }

    public void setSearchImage(String searchImage) {
        this.searchImage = searchImage;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(styleID);
        dest.writeString(brand);
        dest.writeString(price);
        dest.writeString(additionalInfo);
        dest.writeString(searchImage);

    }
}
