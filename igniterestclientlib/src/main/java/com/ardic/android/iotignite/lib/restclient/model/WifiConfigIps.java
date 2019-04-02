package com.ardic.android.iotignite.lib.restclient.model;

/**
 * Created by oguzcakir on 20.03.2019.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WifiConfigIps {

    @SerializedName("ip")
    @Expose
    private String ip;
    @SerializedName("gateway")
    @Expose
    private String gateway;
    @SerializedName("prefix")
    @Expose
    private String prefix;
    @SerializedName("dns1")
    @Expose
    private String dns1;
    @SerializedName("dns2")
    @Expose
    private String dns2;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getGateway() {
        return gateway;
    }

    public void setGateway(String gateway) {
        this.gateway = gateway;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getDns1() {
        return dns1;
    }

    public void setDns1(String dns1) {
        this.dns1 = dns1;
    }

    public String getDns2() {
        return dns2;
    }

    public void setDns2(String dns2) {
        this.dns2 = dns2;
    }
}
