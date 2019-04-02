package com.ardic.android.iotignite.lib.restclient.model;

/**
 * Created by oguzcakir on 18.03.2019.
 */

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModeContentsDTO implements Serializable{

    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("desc")
    @Expose
    private String desc;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("location")
    @Expose
    private Object location;
    @SerializedName("size")
    @Expose
    private Integer size;
    @SerializedName("contentType")
    @Expose
    private String contentType;
    @SerializedName("downloadCount")
    @Expose
    private Integer downloadCount;
    @SerializedName("ratingCount")
    @Expose
    private Integer ratingCount;
    @SerializedName("rating")
    @Expose
    private Integer rating;
    @SerializedName("createDate")
    @Expose
    private long createDate;
    @SerializedName("updateDate")
    @Expose
    private long updateDate;
    @SerializedName("hidden")
    @Expose
    private Boolean hidden;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("externalUrl")
    @Expose
    private Object externalUrl;
    @SerializedName("category")
    @Expose
    private Category category;
    @SerializedName("comments")
    @Expose
    private List<Object> comments = null;
    @SerializedName("tags")
    @Expose
    private List<Object> tags = null;
    @SerializedName("categoryCode")
    @Expose
    private Object categoryCode;
    @SerializedName("links")
    @Expose
    private List<Object> links = null;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getLocation() {
        return location;
    }

    public void setLocation(Object location) {
        this.location = location;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public Integer getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(Integer downloadCount) {
        this.downloadCount = downloadCount;
    }

    public Integer getRatingCount() {
        return ratingCount;
    }

    public void setRatingCount(Integer ratingCount) {
        this.ratingCount = ratingCount;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Integer createDate) {
        this.createDate = createDate;
    }

    public long getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Integer updateDate) {
        this.updateDate = updateDate;
    }

    public Boolean getHidden() {
        return hidden;
    }

    public void setHidden(Boolean hidden) {
        this.hidden = hidden;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Object getExternalUrl() {
        return externalUrl;
    }

    public void setExternalUrl(Object externalUrl) {
        this.externalUrl = externalUrl;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Object> getComments() {
        return comments;
    }

    public void setComments(List<Object> comments) {
        this.comments = comments;
    }

    public List<Object> getTags() {
        return tags;
    }

    public void setTags(List<Object> tags) {
        this.tags = tags;
    }

    public Object getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(Object categoryCode) {
        this.categoryCode = categoryCode;
    }

    public List<Object> getLinks() {
        return links;
    }

    public void setLinks(List<Object> links) {
        this.links = links;
    }
}
