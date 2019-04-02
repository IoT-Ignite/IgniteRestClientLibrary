package com.ardic.android.iotignite.lib.restclient.model;

/**
 * Created by oguzcakir on 02.10.2018.
 */

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PolicyProfile {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("bookmarks")
    @Expose
    private List<Object> bookmarks = null;
    @SerializedName("settings")
    @Expose
    private List<PolicySetting> settings = null;
    @SerializedName("applicationPolicies")
    @Expose
    private List<Object> applicationPolicies = null;
    @SerializedName("applicationBlackPermissions")
    @Expose
    private List<Object> applicationBlackPermissions = null;
    @SerializedName("installationPolicies")
    @Expose
    private InstallationPolicies installationPolicies;
    @SerializedName("wifiApnPolicies")
    @Expose
    private WifiApnPolicies wifiApnPolicies;
    @SerializedName("applicationShortcuts")
    @Expose
    private List<Object> applicationShortcuts = null;
    @SerializedName("wificonfigs")
    @Expose
    private List<Object> wificonfigs = null;
    @SerializedName("mobileApnConfigs")
    @Expose
    private List<Object> mobileApnConfigs = null;
    @SerializedName("hotspotConfig")
    @Expose
    private HotspotConfig hotspotConfig;
    @SerializedName("ecrSettings")
    @Expose
    private Object ecrSettings;
    @SerializedName("passwordPolicy")
    @Expose
    private Object passwordPolicy;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Object> getBookmarks() {
        return bookmarks;
    }

    public void setBookmarks(List<Object> bookmarks) {
        this.bookmarks = bookmarks;
    }

    public List<PolicySetting> getSettings() {
        return settings;
    }

    public void setSettings(List<PolicySetting> settings) {
        this.settings = settings;
    }

    public List<Object> getApplicationPolicies() {
        return applicationPolicies;
    }

    public void setApplicationPolicies(List<Object> applicationPolicies) {
        this.applicationPolicies = applicationPolicies;
    }

    public List<Object> getApplicationBlackPermissions() {
        return applicationBlackPermissions;
    }

    public void setApplicationBlackPermissions(List<Object> applicationBlackPermissions) {
        this.applicationBlackPermissions = applicationBlackPermissions;
    }

    public InstallationPolicies getInstallationPolicies() {
        return installationPolicies;
    }

    public void setInstallationPolicies(InstallationPolicies installationPolicies) {
        this.installationPolicies = installationPolicies;
    }

    public WifiApnPolicies getWifiApnPolicies() {
        return wifiApnPolicies;
    }

    public void setWifiApnPolicies(WifiApnPolicies wifiApnPolicies) {
        this.wifiApnPolicies = wifiApnPolicies;
    }

    public List<Object> getApplicationShortcuts() {
        return applicationShortcuts;
    }

    public void setApplicationShortcuts(List<Object> applicationShortcuts) {
        this.applicationShortcuts = applicationShortcuts;
    }

    public List<Object> getWificonfigs() {
        return wificonfigs;
    }

    public void setWificonfigs(List<Object> wificonfigs) {
        this.wificonfigs = wificonfigs;
    }

    public List<Object> getMobileApnConfigs() {
        return mobileApnConfigs;
    }

    public void setMobileApnConfigs(List<Object> mobileApnConfigs) {
        this.mobileApnConfigs = mobileApnConfigs;
    }

    public HotspotConfig getHotspotConfig() {
        return hotspotConfig;
    }

    public void setHotspotConfig(HotspotConfig hotspotConfig) {
        this.hotspotConfig = hotspotConfig;
    }

    public Object getEcrSettings() {
        return ecrSettings;
    }

    public void setEcrSettings(Object ecrSettings) {
        this.ecrSettings = ecrSettings;
    }

    public Object getPasswordPolicy() {
        return passwordPolicy;
    }

    public void setPasswordPolicy(Object passwordPolicy) {
        this.passwordPolicy = passwordPolicy;
    }

}
