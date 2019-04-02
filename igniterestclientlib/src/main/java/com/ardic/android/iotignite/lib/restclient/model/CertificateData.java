package com.ardic.android.iotignite.lib.restclient.model;

/**
 * Created by oguzcakir on 19.03.2019.
 */


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CertificateData {

    @SerializedName("alias")
    @Expose
    private String alias;
    @SerializedName("data")
    @Expose
    private Object data;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("password")
    @Expose
    private Object password;
    @SerializedName("enforced")
    @Expose
    private Object enforced;

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getPassword() {
        return password;
    }

    public void setPassword(Object password) {
        this.password = password;
    }

    public Object getEnforced() {
        return enforced;
    }

    public void setEnforced(Object enforced) {
        this.enforced = enforced;
    }
}
