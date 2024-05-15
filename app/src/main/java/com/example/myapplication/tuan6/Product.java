package com.example.myapplication.tuan6;

public class Product {
    private String styleID;
    private String brand;
    private String price;
    private String additionalInfo;
    private String searchImage;

    public Product() {
    }

    public Product(String styleID, String brand, String price, String additionalInfo, String searchImage) {
        this.styleID = styleID;
        this.brand = brand;
        this.price = price;
        this.additionalInfo = additionalInfo;
        this.searchImage = searchImage;
    }

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
}
