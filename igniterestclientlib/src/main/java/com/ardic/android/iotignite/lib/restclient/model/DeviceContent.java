package com.ardic.android.iotignite.lib.restclient.model;

/**
 * Created by oguzcakir on 02.10.2018.
 */

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DeviceContent {

    @SerializedName("deviceId")
    @Expose
    private String deviceId;
    @SerializedName("imei")
    @Expose
    private String imei;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("osVersion")
    @Expose
    private String osVersion;
    @SerializedName("model")
    @Expose
    private String model;
    @SerializedName("modeAppVersion")
    @Expose
    private String modeAppVersion;
    @SerializedName("lockStatus")
    @Expose
    private boolean lockStatus;
    @SerializedName("mandatoryLockStatus")
    @Expose
    private boolean mandatoryLockStatus;
    @SerializedName("lostStatus")
    @Expose
    private boolean lostStatus;
    @SerializedName("createdDate")
    @Expose
    private long createdDate;
    @SerializedName("lastModifiedDate")
    @Expose
    private long lastModifiedDate;
    @SerializedName("detailLastModifiedDate")
    @Expose
    private long detailLastModifiedDate;
    @SerializedName("lastPresenceDate")
    @Expose
    private long lastPresenceDate;
    @SerializedName("presence")
    @Expose
    private Presence presence;
    @SerializedName("battery")
    @Expose
    private Battery battery;
    @SerializedName("network")
    @Expose
    private Network network;
    @SerializedName("storage")
    @Expose
    private Storage storage;
    @SerializedName("osProfile")
    @Expose
    private OSProfile osProfile;
    @SerializedName("currentUser")
    @Expose
    private User currentUser;
    @SerializedName("users")
    @Expose
    private List<User> users = null;
    @SerializedName("adminArea")
    @Expose
    private AdminArea adminArea;
    @SerializedName("activePolicy")
    @Expose
    private Policy activePolicy;
    @SerializedName("afexMode")
    @Expose
    private String afexMode;
    @SerializedName("currentPolicy")
    @Expose
    private String currentPolicy;
    @SerializedName("links")
    @Expose
    private List<Link> links = null;
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("location")
    @Expose
    private Location location;
    @SerializedName("deviceTimezone")
    @Expose
    private String deviceTimezone;
    @SerializedName("deviceCurrentTime")
    @Expose
    private String deviceCurrentTime;
    @SerializedName("label")
    @Expose
    private String label;

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModeAppVersion() {
        return modeAppVersion;
    }

    public void setModeAppVersion(String modeAppVersion) {
        this.modeAppVersion = modeAppVersion;
    }

    public boolean isLockStatus() {
        return lockStatus;
    }

    public void setLockStatus(boolean lockStatus) {
        this.lockStatus = lockStatus;
    }

    public boolean isMandatoryLockStatus() {
        return mandatoryLockStatus;
    }

    public void setMandatoryLockStatus(boolean mandatoryLockStatus) {
        this.mandatoryLockStatus = mandatoryLockStatus;
    }

    public boolean isLostStatus() {
        return lostStatus;
    }

    public void setLostStatus(boolean lostStatus) {
        this.lostStatus = lostStatus;
    }

    public long getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(long createdDate) {
        this.createdDate = createdDate;
    }

    public long getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(long lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public long getDetailLastModifiedDate() {
        return detailLastModifiedDate;
    }

    public void setDetailLastModifiedDate(long detailLastModifiedDate) {
        this.detailLastModifiedDate = detailLastModifiedDate;
    }

    public long getLastPresenceDate() {
        return lastPresenceDate;
    }

    public void setLastPresenceDate(Integer lastPresenceDate) {
        this.lastPresenceDate = lastPresenceDate;
    }

    public Presence getPresence() {
        return presence;
    }

    public void setPresence(Presence presence) {
        this.presence = presence;
    }

    public Battery getBattery() {
        return battery;
    }

    public void setBattery(Battery battery) {
        this.battery = battery;
    }

    public Network getNetwork() {
        return network;
    }

    public void setNetwork(Network network) {
        this.network = network;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public OSProfile getOsProfile() {
        return osProfile;
    }

    public void setOsProfile(OSProfile osProfile) {
        this.osProfile = osProfile;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public AdminArea getAdminArea() {
        return adminArea;
    }

    public void setAdminArea(AdminArea adminArea) {
        this.adminArea = adminArea;
    }

    public Policy getActivePolicy() {
        return activePolicy;
    }

    public void setActivePolicy(Policy activePolicy) {
        this.activePolicy = activePolicy;
    }

    public String getAfexMode() {
        return afexMode;
    }

    public void setAfexMode(String afexMode) {
        this.afexMode = afexMode;
    }

    public String getCurrentPolicy() {
        return currentPolicy;
    }

    public void setCurrentPolicy(String currentPolicy) {
        this.currentPolicy = currentPolicy;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getDeviceTimezone() {
        return deviceTimezone;
    }

    public void setDeviceTimezone(String deviceTimezone) {
        this.deviceTimezone = deviceTimezone;
    }

    public String getDeviceCurrentTime() {
        return deviceCurrentTime;
    }

    public void setDeviceCurrentTime(String deviceCurrentTime) {
        this.deviceCurrentTime = deviceCurrentTime;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "DeviceContent{" +
                "deviceId='" + deviceId + '\'' +
                ", status='" + status + '\'' +
                ", osVersion='" + osVersion + '\'' +
                ", model='" + model + '\'' +
                ", labeL='" + label + '\'' +
                ", modeAppVersion='" + modeAppVersion + '\'' +
                ", lockStatus=" + lockStatus +
                ", mandatoryLockStatus=" + mandatoryLockStatus +
                ", lostStatus=" + lostStatus +
                ", createdDate=" + createdDate +
                ", lastModifiedDate=" + lastModifiedDate +
                ", detailLastModifiedDate=" + detailLastModifiedDate +
                ", presence=" + presence +
                ", location=" + location +
                ", battery=" + battery +
                ", network=" + network +
                ", storage=" + storage +
                ", osProfile=" + osProfile +
                ", currentUser=" + currentUser +
                ", users=" + users +
                ", adminArea=" + adminArea +
                ", activePolicy=" + activePolicy +
                ", afexMode='" + afexMode + '\'' +
                ", deviceTimeZone='" + deviceTimezone + '\'' +
                ", deviceCurrentTime='" + deviceCurrentTime + '\'' +
                ", links=" + links +
                ", code='" + code + '\'' +
                '}';
    }
}
