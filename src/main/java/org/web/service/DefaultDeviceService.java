package org.web.service;

import org.springframework.stereotype.Service;
import org.web.domain.Device;
import org.web.repository.DeviceRepository;

import java.util.List;

@Service
public class DefaultDeviceService implements DeviceService {

    private final DeviceRepository deviceRepository;

    public DefaultDeviceService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }


    @Override
    public List<Device> findAllDevices() {
        return deviceRepository.findAll();
    }

    @Override
    public List<Device> findAllDevicesForProject(Long id) {
        return null;
    }
}
