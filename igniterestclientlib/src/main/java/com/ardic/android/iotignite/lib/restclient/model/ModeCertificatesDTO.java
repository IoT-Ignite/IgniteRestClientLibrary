package com.ardic.android.iotignite.lib.restclient.model;

/**
 * Created by oguzcakir on 19.03.2019.
 */


import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModeCertificatesDTO {

    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("productId")
    @Expose
    private String productId;
    @SerializedName("dataKey")
    @Expose
    private String dataKey;
    @SerializedName("categoryId")
    @Expose
    private String categoryId;
    @SerializedName("creator")
    @Expose
    private String creator;
    @SerializedName("data")
    @Expose
    private CertificateData data;
    @SerializedName("links")
    @Expose
    private List<Object> links = null;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getDataKey() {
        return dataKey;
    }

    public void setDataKey(String dataKey) {
        this.dataKey = dataKey;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public CertificateData getCertificateData() {
        return data;
    }

    public void setCertificateData(CertificateData certificateData) {
        this.data = certificateData;
    }

    public List<Object> getLinks() {
        return links;
    }

    public void setLinks(List<Object> links) {
        this.links = links;
    }
}
