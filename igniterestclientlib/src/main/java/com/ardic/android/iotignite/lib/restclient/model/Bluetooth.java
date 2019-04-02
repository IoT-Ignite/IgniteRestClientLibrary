package com.ardic.android.iotignite.lib.restclient.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by yavuz.erzurumlu on 7/13/17.
 */

public class Bluetooth {

    @SerializedName("bluetoothState")
    private String bluetoothState;

    @SerializedName("bluetoothMacId")
    private String bluetoothMacId;

    @SerializedName("bluetoothSupported")
    private boolean bluetoothSupported;

    @SerializedName("bluetoothPairedDevices")
    @Expose
    private List<BluetoothPairedDevice> bluetoothPairedDevices = null;

    public String getBluetoothState() {
        return bluetoothState;
    }

    public void setBluetoothState(String bluetoothState) {
        this.bluetoothState = bluetoothState;
    }

    public String getBluetoothMacId() {
        return bluetoothMacId;
    }

    public void setBluetoothMacId(String bluetoothMacId) {
        this.bluetoothMacId = bluetoothMacId;
    }

    public boolean isBluetoothSupported() {
        return bluetoothSupported;
    }

    public void setBluetoothSupported(boolean bluetoothSupported) {
        this.bluetoothSupported = bluetoothSupported;
    }

    public List<BluetoothPairedDevice> getBluetoothPairedDevices() {
        return bluetoothPairedDevices;
    }

    public void setBluetoothPairedDevices(List<BluetoothPairedDevice> bluetoothPairedDevices) {
        this.bluetoothPairedDevices = bluetoothPairedDevices;
    }

    @Override
    public String toString() {
        return "Bluetooth{" +
                "bluetoothState='" + bluetoothState + '\'' +
                ", bluetoothMacId='" + bluetoothMacId + '\'' +
                ", bluetoothSupported=" + bluetoothSupported +
                ", bluetoothPairedDevices='" + bluetoothPairedDevices + '\'' +
                '}';
    }
}
