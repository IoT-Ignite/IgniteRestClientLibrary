package com.ardic.android.iotignite.lib.restclient.model;

/**
 * Created by oguzcakir on 02.10.2018.
 */


import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WifiApnPolicies {

    @SerializedName("blackList")
    @Expose
    private List<Object> blackList = null;
    @SerializedName("whiteList")
    @Expose
    private List<Object> whiteList = null;
    @SerializedName("unconfigurableList")
    @Expose
    private List<Object> unconfigurableList = null;
    @SerializedName("ruleOrders")
    @Expose
    private List<Object> ruleOrders = null;

    public List<Object> getBlackList() {
        return blackList;
    }

    public void setBlackList(List<Object> blackList) {
        this.blackList = blackList;
    }

    public List<Object> getWhiteList() {
        return whiteList;
    }

    public void setWhiteList(List<Object> whiteList) {
        this.whiteList = whiteList;
    }

    public List<Object> getUnconfigurableList() {
        return unconfigurableList;
    }

    public void setUnconfigurableList(List<Object> unconfigurableList) {
        this.unconfigurableList = unconfigurableList;
    }

    public List<Object> getRuleOrders() {
        return ruleOrders;
    }

    public void setRuleOrders(List<Object> ruleOrders) {
        this.ruleOrders = ruleOrders;
    }

}