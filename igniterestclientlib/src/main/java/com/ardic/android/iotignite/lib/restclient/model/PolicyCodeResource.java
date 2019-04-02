package com.ardic.android.iotignite.lib.restclient.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by oguzcakir on 03.10.2018.
 */

public class PolicyCodeResource {

    @SerializedName("defaultPolicy")
    @Expose
    private Policy defaultPolicy;

    public Policy getDefaultPolicy() {
        return defaultPolicy;
    }

    public void setDefaultPolicy(Policy defaultPolicy) {
        this.defaultPolicy = defaultPolicy;
    }
}
