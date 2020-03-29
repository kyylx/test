package org.web.domain;

import java.io.Serializable;

public class Stats implements Serializable {
    private int deviceCount;
    private int deviseWithErrors;
    private int stableDevices;

    public Stats(int deviceCount, int deviseWithErrors, int stableDevices) {
        this.deviceCount = deviceCount;
        this.deviseWithErrors = deviseWithErrors;
        this.stableDevices = stableDevices;
    }

    public int getDeviceCount() {
        return deviceCount;
    }

    public void setDeviceCount(int deviceCount) {
        this.deviceCount = deviceCount;
    }

    public int getDeviseWithErrors() {
        return deviseWithErrors;
    }

    public void setDeviseWithErrors(int deviseWithErrors) {
        this.deviseWithErrors = deviseWithErrors;
    }

    public int getStableDevices() {
        return stableDevices;
    }

    public void setStableDevices(int stableDevices) {
        this.stableDevices = stableDevices;
    }

    @Override
    public String toString() {
        return "Stats{" +
                "deviceCount=" + deviceCount +
                ", deviseWithErrors=" + deviseWithErrors +
                ", stableDevices=" + stableDevices +
                '}';
    }
}
