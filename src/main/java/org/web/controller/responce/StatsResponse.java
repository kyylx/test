package org.web.controller.responce;

public class StatsResponse {

    private Integer deviceCount;
    private Integer deviceWithErrors;
    private Integer stableDevices;

    public Integer getDeviceCount() {
        return deviceCount;
    }

    public void setDeviceCount(Integer deviceCount) {
        this.deviceCount = deviceCount;
    }

    public Integer getDeviceWithErrors() {
        return deviceWithErrors;
    }

    public void setDeviceWithErrors(Integer deviceWithErrors) {
        this.deviceWithErrors = deviceWithErrors;
    }

    public Integer getStableDevices() {
        return stableDevices;
    }

    public void setStableDevices(Integer stableDevices) {
        this.stableDevices = stableDevices;
    }
}
