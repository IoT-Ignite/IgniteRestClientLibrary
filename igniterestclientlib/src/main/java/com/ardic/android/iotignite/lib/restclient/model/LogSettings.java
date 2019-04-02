package com.ardic.android.iotignite.lib.restclient.model;

/**
 * Created by oguzcakir on 27.09.2018.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LogSettings {

    @SerializedName("period")
    @Expose
    private Integer period;
    @SerializedName("size")
    @Expose
    private Integer size;

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

}
