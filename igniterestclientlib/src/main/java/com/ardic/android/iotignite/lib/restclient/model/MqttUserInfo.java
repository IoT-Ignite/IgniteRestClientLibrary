package com.ardic.android.iotignite.lib.restclient.model;

import com.google.gson.annotations.SerializedName;

public class MqttUserInfo {

    @SerializedName("deviceId")
    private String deviceId;

    @SerializedName("password")
    private String password;

    @SerializedName("username")
    private String username;

    public MqttUserInfo(String deviceId, String password, String username) {
        this.deviceId = deviceId;
        this.password = password;
        this.username = username;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "MqttUserInfo{" +
                "deviceId='" + deviceId + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
