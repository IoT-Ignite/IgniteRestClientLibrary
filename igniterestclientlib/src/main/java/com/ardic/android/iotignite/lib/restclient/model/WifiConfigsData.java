package com.ardic.android.iotignite.lib.restclient.model;

/**
 * Created by oguzcakir on 20.03.2019.
 */

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WifiConfigsData {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("wifiConfigBasic")
    @Expose
    private WifiConfigBasic wifiConfigBasic;
    @SerializedName("wifiConfigEap")
    @Expose
    private WifiConfigEap wifiConfigEap;
    @SerializedName("wifiConfigIps")
    @Expose
    private WifiConfigIps wifiConfigIps;
    @SerializedName("wifiConfigProxy")
    @Expose
    private WifiConfigProxy wifiConfigProxy;
    @SerializedName("wifiConfigWep")
    @Expose
    private Object wifiConfigWep;
    @SerializedName("links")
    @Expose
    private List<Object> links = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public WifiConfigBasic getWifiConfigBasic() {
        return wifiConfigBasic;
    }

    public void setWifiConfigBasic(WifiConfigBasic wifiConfigBasic) {
        this.wifiConfigBasic = wifiConfigBasic;
    }

    public WifiConfigEap getWifiConfigEap() {
        return wifiConfigEap;
    }

    public void setWifiConfigEap(WifiConfigEap wifiConfigEap) {
        this.wifiConfigEap = wifiConfigEap;
    }

    public WifiConfigIps getWifiConfigIps() {
        return wifiConfigIps;
    }

    public void setWifiConfigIps(WifiConfigIps wifiConfigIps) {
        this.wifiConfigIps = wifiConfigIps;
    }

    public WifiConfigProxy getWifiConfigProxy() {
        return wifiConfigProxy;
    }

    public void setWifiConfigProxy(WifiConfigProxy wifiConfigProxy) {
        this.wifiConfigProxy = wifiConfigProxy;
    }

    public Object getWifiConfigWep() {
        return wifiConfigWep;
    }

    public void setWifiConfigWep(Object wifiConfigWep) {
        this.wifiConfigWep = wifiConfigWep;
    }

    public List<Object> getLinks() {
        return links;
    }

    public void setLinks(List<Object> links) {
        this.links = links;
    }
}
