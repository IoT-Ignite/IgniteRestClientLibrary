package com.ardic.android.iotignite.lib.restclient.model;

/**
 * Created by oguzcakir on 22.03.2019.
 */

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VpnConfigsData {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("vpnType")
    @Expose
    private String vpnType;
    @SerializedName("userName")
    @Expose
    private String userName;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("mppe")
    @Expose
    private String mppe;
    @SerializedName("server")
    @Expose
    private String server;
    @SerializedName("dnsSearchDomains")
    @Expose
    private Object dnsSearchDomains;
    @SerializedName("dnsServers")
    @Expose
    private Object dnsServers;
    @SerializedName("forwardRoutes")
    @Expose
    private Object forwardRoutes;
    @SerializedName("l2tpSecret")
    @Expose
    private Object l2tpSecret;
    @SerializedName("ipSecIdentifier")
    @Expose
    private Object ipSecIdentifier;
    @SerializedName("ipSecSecret")
    @Expose
    private Object ipSecSecret;
    @SerializedName("ipSecUserCert")
    @Expose
    private Object ipSecUserCert;
    @SerializedName("ipSecCaCert")
    @Expose
    private Object ipSecCaCert;
    @SerializedName("ipSecServerCert")
    @Expose
    private Object ipSecServerCert;
    @SerializedName("links")
    @Expose
    private List<Object> links = null;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVpnType() {
        return vpnType;
    }

    public void setVpnType(String vpnType) {
        this.vpnType = vpnType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMppe() {
        return mppe;
    }

    public void setMppe(String mppe) {
        this.mppe = mppe;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public Object getDnsSearchDomains() {
        return dnsSearchDomains;
    }

    public void setDnsSearchDomains(Object dnsSearchDomains) {
        this.dnsSearchDomains = dnsSearchDomains;
    }

    public Object getDnsServers() {
        return dnsServers;
    }

    public void setDnsServers(Object dnsServers) {
        this.dnsServers = dnsServers;
    }

    public Object getForwardRoutes() {
        return forwardRoutes;
    }

    public void setForwardRoutes(Object forwardRoutes) {
        this.forwardRoutes = forwardRoutes;
    }

    public Object getL2tpSecret() {
        return l2tpSecret;
    }

    public void setL2tpSecret(Object l2tpSecret) {
        this.l2tpSecret = l2tpSecret;
    }

    public Object getIpSecIdentifier() {
        return ipSecIdentifier;
    }

    public void setIpSecIdentifier(Object ipSecIdentifier) {
        this.ipSecIdentifier = ipSecIdentifier;
    }

    public Object getIpSecSecret() {
        return ipSecSecret;
    }

    public void setIpSecSecret(Object ipSecSecret) {
        this.ipSecSecret = ipSecSecret;
    }

    public Object getIpSecUserCert() {
        return ipSecUserCert;
    }

    public void setIpSecUserCert(Object ipSecUserCert) {
        this.ipSecUserCert = ipSecUserCert;
    }

    public Object getIpSecCaCert() {
        return ipSecCaCert;
    }

    public void setIpSecCaCert(Object ipSecCaCert) {
        this.ipSecCaCert = ipSecCaCert;
    }

    public Object getIpSecServerCert() {
        return ipSecServerCert;
    }

    public void setIpSecServerCert(Object ipSecServerCert) {
        this.ipSecServerCert = ipSecServerCert;
    }

    public List<Object> getLinks() {
        return links;
    }

    public void setLinks(List<Object> links) {
        this.links = links;
    }
}
