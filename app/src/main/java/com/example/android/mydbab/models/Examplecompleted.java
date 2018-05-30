package com.example.android.mydbab.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Examplecompleted {

    @SerializedName("success")
    @Expose
    private Integer success;
    @SerializedName("page")
    @Expose
    private Integer page;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("completed_list")
    @Expose
    private List<CompletedList> completedList = null;

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

    public List<CompletedList> getCompletedList() {
        return completedList;
    }

    public void setCompletedList(List<CompletedList> completedList) {
        this.completedList = completedList;
    }

}