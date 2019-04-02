package com.ardic.android.iotignite.lib.restclient.model;

/**
 * Created by oguzcakir on 03.10.2018.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SpecificDeviceInfoResult {

    @SerializedName("deviceId")
    @Expose
    private String deviceId;
    @SerializedName("command")
    @Expose
    private String command;
    @SerializedName("data")
    @Expose
    private Data data;
    @SerializedName("createDate")
    @Expose
    private long createDate;
    @SerializedName("nodeId")
    @Expose
    private String nodeId;
    @SerializedName("sensorId")
    @Expose
    private String sensorId;
    @SerializedName("cloudDate")
    @Expose
    private Integer cloudDate;

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(long createDate) {
        this.createDate = createDate;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getSensorId() {
        return sensorId;
    }

    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }

    public Integer getCloudDate() {
        return cloudDate;
    }

    public void setCloudDate(Integer cloudDate) {
        this.cloudDate = cloudDate;
    }

}
