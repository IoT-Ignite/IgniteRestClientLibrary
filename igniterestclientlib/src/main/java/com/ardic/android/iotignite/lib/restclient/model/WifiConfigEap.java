package com.ardic.android.iotignite.lib.restclient.model;

/**
 * Created by oguzcakir on 20.03.2019.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WifiConfigEap {

    @SerializedName("eapMethod")
    @Expose
    private String eapMethod;
    @SerializedName("phase2Type")
    @Expose
    private String phase2Type;
    @SerializedName("anonId")
    @Expose
    private String anonId;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("passwd")
    @Expose
    private String passwd;
    @SerializedName("userCert")
    @Expose
    private Object userCert;
    @SerializedName("caCert")
    @Expose
    private String caCert;
    @SerializedName("privateKey")
    @Expose
    private Object privateKey;

    public String getEapMethod() {
        return eapMethod;
    }

    public void setEapMethod(String eapMethod) {
        this.eapMethod = eapMethod;
    }

    public String getPhase2Type() {
        return phase2Type;
    }

    public void setPhase2Type(String phase2Type) {
        this.phase2Type = phase2Type;
    }

    public String getAnonId() {
        return anonId;
    }

    public void setAnonId(String anonId) {
        this.anonId = anonId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public Object getUserCert() {
        return userCert;
    }

    public void setUserCert(Object userCert) {
        this.userCert = userCert;
    }

    public String getCaCert() {
        return caCert;
    }

    public void setCaCert(String caCert) {
        this.caCert = caCert;
    }

    public Object getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(Object privateKey) {
        this.privateKey = privateKey;
    }
}
