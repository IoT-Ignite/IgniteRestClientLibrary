package com.ardic.android.iotignite.lib.restclient.model;

/**
 * Created by oguzcakir on 02.10.2018.
 */

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModeStore {

    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("desc")
    @Expose
    private String desc;
    @SerializedName("defaultProfile")
    @Expose
    private Boolean defaultProfile;
    @SerializedName("defaultPolicy")
    @Expose
    private Policy defaultPolicy;
    @SerializedName("configurations")
    @Expose
    private ModeConfigurations configurations;
    @SerializedName("scheduled")
    @Expose
    private Object scheduled;
    @SerializedName("isSwitchable")
    @Expose
    private Boolean isSwitchable;
    @SerializedName("isInContainer")
    @Expose
    private Boolean isInContainer;
    @SerializedName("switchPassword")
    @Expose
    private String switchPassword;
    @SerializedName("isBypassGoogleActivation")
    @Expose
    private Boolean isBypassGoogleActivation;
    @SerializedName("isEmpoweredMode")
    @Expose
    private Boolean isEmpoweredMode;
    @SerializedName("activationCode")
    @Expose
    private String activationCode;
    @SerializedName("createdDate")
    @Expose
    private String createdDate;
    @SerializedName("links")
    @Expose
    private List<Link> links = null;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Boolean getDefaultProfile() {
        return defaultProfile;
    }

    public void setDefaultProfile(Boolean defaultProfile) {
        this.defaultProfile = defaultProfile;
    }

    public Policy getDefaultPolicy() {
        return defaultPolicy;
    }

    public void setDefaultPolicy(Policy defaultPolicy) {
        this.defaultPolicy = defaultPolicy;
    }

    public ModeConfigurations getConfigurations() {
        return configurations;
    }

    public void setConfigurations(ModeConfigurations configurations) {
        this.configurations = configurations;
    }

    public Object getScheduled() {
        return scheduled;
    }

    public void setScheduled(Object scheduled) {
        this.scheduled = scheduled;
    }

    public Boolean getIsSwitchable() {
        return isSwitchable;
    }

    public void setIsSwitchable(Boolean isSwitchable) {
        this.isSwitchable = isSwitchable;
    }

    public Boolean getIsInContainer() {
        return isInContainer;
    }

    public void setIsInContainer(Boolean isInContainer) {
        this.isInContainer = isInContainer;
    }

    public String getSwitchPassword() {
        return switchPassword;
    }

    public void setSwitchPassword(String switchPassword) {
        this.switchPassword = switchPassword;
    }

    public Boolean getIsBypassGoogleActivation() {
        return isBypassGoogleActivation;
    }

    public void setIsBypassGoogleActivation(Boolean isBypassGoogleActivation) {
        this.isBypassGoogleActivation = isBypassGoogleActivation;
    }

    public Boolean getIsEmpoweredMode() {
        return isEmpoweredMode;
    }

    public void setIsEmpoweredMode(Boolean isEmpoweredMode) {
        this.isEmpoweredMode = isEmpoweredMode;
    }

    public String getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

}
