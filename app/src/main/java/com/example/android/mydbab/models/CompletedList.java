package com.example.android.mydbab.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CompletedList {

    @SerializedName("order_id")
    @Expose
    private Integer orderId;
    @SerializedName("shop_id")
    @Expose
    private Integer shopId;
    @SerializedName("shop_name")
    @Expose
    private String shopName;
    @SerializedName("order_status")
    @Expose
    private Integer orderStatus;
    @SerializedName("order_address")
    @Expose
    private String orderAddress;
    @SerializedName("shopDistance")
    @Expose
    private String shopDistance;
    @SerializedName("shop_icon")
    @Expose
    private String shopIcon;
    @SerializedName("order_date")
    @Expose
    private String orderDate;
    @SerializedName("order_details")
    @Expose
    private String orderDetails;
    @SerializedName("order_amount")
    @Expose
    private String orderAmount;
    @SerializedName("order_lat")
    @Expose
    private String orderLat;
    @SerializedName("order_lng")
    @Expose
    private String orderLng;
    @SerializedName("shop_lat")
    @Expose
    private String shopLat;
    @SerializedName("shop_lng")
    @Expose
    private String shopLng;
    @SerializedName("shop_address")
    @Expose
    private String shopAddress;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderAddress() {
        return orderAddress;
    }

    public void setOrderAddress(String orderAddress) {
        this.orderAddress = orderAddress;
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

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(String orderDetails) {
        this.orderDetails = orderDetails;
    }

    public String getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(String orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getOrderLat() {
        return orderLat;
    }

    public void setOrderLat(String orderLat) {
        this.orderLat = orderLat;
    }

    public String getOrderLng() {
        return orderLng;
    }

    public void setOrderLng(String orderLng) {
        this.orderLng = orderLng;
    }

    public String getShopLat() {
        return shopLat;
    }

    public void setShopLat(String shopLat) {
        this.shopLat = shopLat;
    }

    public String getShopLng() {
        return shopLng;
    }

    public void setShopLng(String shopLng) {
        this.shopLng = shopLng;
    }

    public String getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }

}