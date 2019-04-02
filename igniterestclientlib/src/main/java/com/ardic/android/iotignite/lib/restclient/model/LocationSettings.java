package com.ardic.android.iotignite.lib.restclient.model;

/**
 * Created by oguzcakir on 27.09.2018.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LocationSettings {

    @SerializedName("defaultUpdateInterval")
    @Expose
    private String defaultUpdateInterval;
    @SerializedName("emergencyUpdateInterval")
    @Expose
    private String emergencyUpdateInterval;
    @SerializedName("keepLocationInfoOnShutdown")
    @Expose
    private String keepLocationInfoOnShutdown;

    public String getDefaultUpdateInterval() {
        return defaultUpdateInterval;
    }

    public void setDefaultUpdateInterval(String defaultUpdateInterval) {
        this.defaultUpdateInterval = defaultUpdateInterval;
    }

    public String getEmergencyUpdateInterval() {
        return emergencyUpdateInterval;
    }

    public void setEmergencyUpdateInterval(String emergencyUpdateInterval) {
        this.emergencyUpdateInterval = emergencyUpdateInterval;
    }

    public String getKeepLocationInfoOnShutdown() {
        return keepLocationInfoOnShutdown;
    }

    public void setKeepLocationInfoOnShutdown(String keepLocationInfoOnShutdown) {
        this.keepLocationInfoOnShutdown = keepLocationInfoOnShutdown;
    }

}
