package com.ardic.android.iotignite.lib.restclient.model;

/**
 * Created by oguzcakir on 18.03.2019.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Icon {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private Object name;
    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("type")
    @Expose
    private Object type;
    @SerializedName("size")
    @Expose
    private String size;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object getName() {
        return name;
    }

    public void setName(Object name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Object getType() {
        return type;
    }

    public void setType(Object type) {
        this.type = type;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

}
