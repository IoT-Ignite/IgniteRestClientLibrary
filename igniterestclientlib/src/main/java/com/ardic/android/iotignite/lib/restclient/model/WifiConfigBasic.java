package com.ardic.android.iotignite.lib.restclient.model;

/**
 * Created by oguzcakir on 20.03.2019.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WifiConfigBasic {

    @SerializedName("wifiConfigBasic")
    @Expose
    private Object wifiConfigBasic;
    @SerializedName("ssid")
    @Expose
    private String ssid;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("security")
    @Expose
    private String security;

    public Object getWifiConfigBasic() {
        return wifiConfigBasic;
    }

    public void setWifiConfigBasic(Object wifiConfigBasic) {
        this.wifiConfigBasic = wifiConfigBasic;
    }

    public String getSsid() {
        return ssid;
    }

    public void setSsid(String ssid) {
        this.ssid = ssid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSecurity() {
        return security;
    }

    public void setSecurity(String security) {
        this.security = security;
    }
}
