package com.ardic.android.iotignite.lib.restclient.model;

/**
 * Created by oguzcakir on 18.03.2019.
 */

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModeAppsDTO {

    @SerializedName("packageName")
    @Expose
    private String packageName;
    @SerializedName("notify")
    @Expose
    private Boolean notify;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("versionCode")
    @Expose
    private String versionCode;
    @SerializedName("versionName")
    @Expose
    private String versionName;
    @SerializedName("type")
    @Expose
    private Object type;
    @SerializedName("size")
    @Expose
    private Integer size;
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("desc")
    @Expose
    private String desc;
    @SerializedName("version")
    @Expose
    private String version;
    @SerializedName("osVersion")
    @Expose
    private String osVersion;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("deviceModel")
    @Expose
    private String deviceModel;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("externalUrl")
    @Expose
    private String externalUrl;
    @SerializedName("hidden")
    @Expose
    private Boolean hidden;
    @SerializedName("downloadCount")
    @Expose
    private Integer downloadCount;
    @SerializedName("ratingCount")
    @Expose
    private Integer ratingCount;
    @SerializedName("createDate")
    @Expose
    private long createDate;
    @SerializedName("rating")
    @Expose
    private Integer rating;
    @SerializedName("appType")
    @Expose
    private String appType;
    @SerializedName("category")
    @Expose
    private Category category;
    @SerializedName("icons")
    @Expose
    private List<Icon> icons = null;
    @SerializedName("videos")
    @Expose
    private List<Object> videos = null;
    @SerializedName("screenshots")
    @Expose
    private List<Object> screenshots = null;
    @SerializedName("comments")
    @Expose
    private List<Object> comments = null;
    @SerializedName("tags")
    @Expose
    private List<Object> tags = null;
    @SerializedName("permissions")
    @Expose
    private Object permissions;
    @SerializedName("links")
    @Expose
    private List<Object> links = null;

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public Boolean getNotify() {
        return notify;
    }

    public void setNotify(Boolean notify) {
        this.notify = notify;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(String versionCode) {
        this.versionCode = versionCode;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public Object getType() {
        return type;
    }

    public void setType(Object type) {
        this.type = type;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
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

    public String getExternalUrl() {
        return externalUrl;
    }

    public void setExternalUrl(String externalUrl) {
        this.externalUrl = externalUrl;
    }

    public Boolean getHidden() {
        return hidden;
    }

    public void setHidden(Boolean hidden) {
        this.hidden = hidden;
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

    public long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(long createDate) {
        this.createDate = createDate;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getAppType() {
        return appType;
    }

    public void setAppType(String appType) {
        this.appType = appType;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Icon> getIcons() {
        return icons;
    }

    public void setIcons(List<Icon> icons) {
        this.icons = icons;
    }

    public List<Object> getVideos() {
        return videos;
    }

    public void setVideos(List<Object> videos) {
        this.videos = videos;
    }

    public List<Object> getScreenshots() {
        return screenshots;
    }

    public void setScreenshots(List<Object> screenshots) {
        this.screenshots = screenshots;
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

    public Object getPermissions() {
        return permissions;
    }

    public void setPermissions(Object permissions) {
        this.permissions = permissions;
    }

    public List<Object> getLinks() {
        return links;
    }

    public void setLinks(List<Object> links) {
        this.links = links;
    }
}
