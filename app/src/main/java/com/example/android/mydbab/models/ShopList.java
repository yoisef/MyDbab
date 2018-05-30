package com.example.android.mydbab.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ShopList {

    @SerializedName("shop_id")
    @Expose
    private Integer shopId;
    @SerializedName("shop_type")
    @Expose
    private Integer shopType;
    @SerializedName("shop_name")
    @Expose
    private String shopName;
    @SerializedName("destination_long")
    @Expose
    private String destinationLong;
    @SerializedName("destination_lat")
    @Expose
    private String destinationLat;
    @SerializedName("shopDistance")
    @Expose
    private String shopDistance;
    @SerializedName("shop_icon")
    @Expose
    private String shopIcon;

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Integer getShopType() {
        return shopType;
    }

    public void setShopType(Integer shopType) {
        this.shopType = shopType;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getDestinationLong() {
        return destinationLong;
    }

    public void setDestinationLong(String destinationLong) {
        this.destinationLong = destinationLong;
    }

    public String getDestinationLat() {
        return destinationLat;
    }

    public void setDestinationLat(String destinationLat) {
        this.destinationLat = destinationLat;
    }

    public String getShopDistance() {
        return shopDistance;
    }

    public void setShopDistance(String shopDistance) {
        this.shopDistance = shopDistance;
    }

    public String getShopIcon() {
        return shopIcon;
    }

    public void setShopIcon(String shopIcon) {
        this.shopIcon = shopIcon;
    }

}
