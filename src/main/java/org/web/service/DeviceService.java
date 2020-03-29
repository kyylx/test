package org.web.service;

import org.web.domain.Device;

import java.util.List;

public interface DeviceService {

    List<Device> findAllDevices();
    List<Device> findAllDevicesForProject(Long id);
}
