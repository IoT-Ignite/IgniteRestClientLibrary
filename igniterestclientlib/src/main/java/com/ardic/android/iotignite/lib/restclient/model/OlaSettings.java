package com.ardic.android.iotignite.lib.restclient.model;

/**
 * Created by oguzcakir on 27.09.2018.
 */


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OlaSettings {

    @SerializedName("emergencyCalls")
    @Expose
    private String emergencyCalls;
    @SerializedName("lockCreditTime")
    @Expose
    private Integer lockCreditTime;
    @SerializedName("mobileCountryCode")
    @Expose
    private Integer mobileCountryCode;
    @SerializedName("mobileNetworkCode")
    @Expose
    private String mobileNetworkCode;
    @SerializedName("operationDuration")
    @Expose
    private Integer operationDuration;
    @SerializedName("unknownDuration")
    @Expose
    private Integer unknownDuration;
    @SerializedName("waitTimeForLock")
    @Expose
    private Integer waitTimeForLock;

    public String getEmergencyCalls() {
        return emergencyCalls;
    }

    public void setEmergencyCalls(String emergencyCalls) {
        this.emergencyCalls = emergencyCalls;
    }

    public Integer getLockCreditTime() {
        return lockCreditTime;
    }

    public void setLockCreditTime(Integer lockCreditTime) {
        this.lockCreditTime = lockCreditTime;
    }

    public Integer getMobileCountryCode() {
        return mobileCountryCode;
    }

    public void setMobileCountryCode(Integer mobileCountryCode) {
        this.mobileCountryCode = mobileCountryCode;
    }

    public String getMobileNetworkCode() {
        return mobileNetworkCode;
    }

    public void setMobileNetworkCode(String mobileNetworkCode) {
        this.mobileNetworkCode = mobileNetworkCode;
    }

    public Integer getOperationDuration() {
        return operationDuration;
    }

    public void setOperationDuration(Integer operationDuration) {
        this.operationDuration = operationDuration;
    }

    public Integer getUnknownDuration() {
        return unknownDuration;
    }

    public void setUnknownDuration(Integer unknownDuration) {
        this.unknownDuration = unknownDuration;
    }

    public Integer getWaitTimeForLock() {
        return waitTimeForLock;
    }

    public void setWaitTimeForLock(Integer waitTimeForLock) {
        this.waitTimeForLock = waitTimeForLock;
    }

}