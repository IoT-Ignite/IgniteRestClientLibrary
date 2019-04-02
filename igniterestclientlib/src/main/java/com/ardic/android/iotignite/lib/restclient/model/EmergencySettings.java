package com.ardic.android.iotignite.lib.restclient.model;

/**
 * Created by oguzcakir on 27.09.2018.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EmergencySettings {

    @SerializedName("isActive")
    @Expose
    private String isActive;

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

}
