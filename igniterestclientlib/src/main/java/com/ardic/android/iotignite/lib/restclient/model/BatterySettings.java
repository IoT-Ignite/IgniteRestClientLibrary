package com.ardic.android.iotignite.lib.restclient.model;

/**
 * Created by oguzcakir on 02.10.2018.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BatterySettings {

    @SerializedName("keepChargeTimes")
    @Expose
    private String keepChargeTimes;

    public String getKeepChargeTimes() {
        return keepChargeTimes;
    }

    public void setKeepChargeTimes(String keepChargeTimes) {
        this.keepChargeTimes = keepChargeTimes;
    }

}
