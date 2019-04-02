package com.ardic.android.iotignite.lib.restclient.model;

/**
 * Created by oguzcakir on 27.09.2018.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DeactivatedMode {

    @SerializedName("appPersistence")
    @Expose
    private String appPersistence;
    @SerializedName("contentPersistence")
    @Expose
    private String contentPersistence;
    @SerializedName("defaultPersistence")
    @Expose
    private String defaultPersistence;

    public String getAppPersistence() {
        return appPersistence;
    }

    public void setAppPersistence(String appPersistence) {
        this.appPersistence = appPersistence;
    }

    public String getContentPersistence() {
        return contentPersistence;
    }

    public void setContentPersistence(String contentPersistence) {
        this.contentPersistence = contentPersistence;
    }

    public String getDefaultPersistence() {
        return defaultPersistence;
    }

    public void setDefaultPersistence(String defaultPersistence) {
        this.defaultPersistence = defaultPersistence;
    }

}
