package com.example.android.mydbab.models;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Example {

    @SerializedName("success")
    @Expose
    private Integer success;
    @SerializedName("page")
    @Expose
    private Integer page;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("active_list")
    @Expose
    private List<ActiveList> activeList = null;

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<ActiveList> getActiveList() {
        return activeList;
    }

    public void setActiveList(List<ActiveList> activeList) {
        this.activeList = activeList;
    }

}