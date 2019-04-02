package com.ardic.android.iotignite.lib.restclient.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by oguzcakir on 02.10.2018.
 */

public class ModeConfigurations {

    @SerializedName("emergencySettings")
    @Expose
    private EmergencySettings emergencySettings;
    @SerializedName("locationSettings")
    @Expose
    private LocationSettings locationSettings;
    @SerializedName("batterySettings")
    @Expose
    private BatterySettings batterySettings;
    @SerializedName("deactivatedMode")
    @Expose
    private DeactivatedMode deactivatedMode;
    @SerializedName("olaSettings")
    @Expose
    private OlaSettings olaSettings;
    @SerializedName("logSettings")
    @Expose
    private LogSettings logSettings;

    public EmergencySettings getEmergencySettings() {
        return emergencySettings;
    }

    public void setEmergencySettings(EmergencySettings emergencySettings) {
        this.emergencySettings = emergencySettings;
    }

    public LocationSettings getLocationSettings() {
        return locationSettings;
    }

    public void setLocationSettings(LocationSettings locationSettings) {
        this.locationSettings = locationSettings;
    }

    public BatterySettings getBatterySettings() {
        return batterySettings;
    }

    public void setBatterySettings(BatterySettings batterySettings) {
        this.batterySettings = batterySettings;
    }

    public DeactivatedMode getDeactivatedMode() {
        return deactivatedMode;
    }

    public void setDeactivatedMode(DeactivatedMode deactivatedMode) {
        this.deactivatedMode = deactivatedMode;
    }

    public OlaSettings getOlaSettings() {
        return olaSettings;
    }

    public void setOlaSettings(OlaSettings olaSettings) {
        this.olaSettings = olaSettings;
    }

    public LogSettings getLogSettings() {
        return logSettings;
    }

    public void setLogSettings(LogSettings logSettings) {
        this.logSettings = logSettings;
    }
}
