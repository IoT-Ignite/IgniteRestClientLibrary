package com.ardic.android.iotignite.lib.restclient.model;

/**
 * Created by oguzcakir on 20.03.2019.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class WifiConfigProxy {

    @SerializedName("proxy")
    @Expose
    private String proxy;
    @SerializedName("port")
    @Expose
    private String port;
    @SerializedName("excluded")
    @Expose
    private String excluded;

    public String getProxy() {
        return proxy;
    }

    public void setProxy(String proxy) {
        this.proxy = proxy;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getExcluded() {
        return excluded;
    }

    public void setExcluded(String excluded) {
        this.excluded = excluded;
    }
}
