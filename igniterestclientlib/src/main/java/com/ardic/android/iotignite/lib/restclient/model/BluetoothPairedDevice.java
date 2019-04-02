package com.ardic.android.iotignite.lib.restclient.model;

/**
 * Created by oguzcakir on 02.10.2018.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BluetoothPairedDevice {

    @SerializedName("pairedbluetoothaddress")
    @Expose
    private String pairedbluetoothaddress;
    @SerializedName("pairedbluetoothname")
    @Expose
    private String pairedbluetoothname;
    @SerializedName("pairedDate")
    @Expose
    private long pairedDate;

    public String getPairedbluetoothaddress() {
        return pairedbluetoothaddress;
    }

    public void setPairedbluetoothaddress(String pairedbluetoothaddress) {
        this.pairedbluetoothaddress = pairedbluetoothaddress;
    }

    public String getPairedbluetoothname() {
        return pairedbluetoothname;
    }

    public void setPairedbluetoothname(String pairedbluetoothname) {
        this.pairedbluetoothname = pairedbluetoothname;
    }

    public long getPairedDate() {
        return pairedDate;
    }

    public void setPairedDate(Integer pairedDate) {
        this.pairedDate = pairedDate;
    }

}
