package com.ardic.android.iotignite.lib.restclient.model;

/**
 * Created by oguzcakir on 03.10.2018.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("timestamp")
    @Expose
    private String timestamp;
    @SerializedName("activePolicy")
    @Expose
    private String activePolicy;
    @SerializedName("hash")
    @Expose
    private String hash;
    @SerializedName("policyProfile")
    @Expose
    private PolicyProfile policyProfile;


    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getActivePolicy() {
        return activePolicy;
    }

    public void setActivePolicy(String activePolicy) {
        this.activePolicy = activePolicy;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public PolicyProfile getPolicyProfile() {
        return policyProfile;
    }

    public void setPolicyProfile(PolicyProfile policyProfile) {
        this.policyProfile = policyProfile;
    }
}
