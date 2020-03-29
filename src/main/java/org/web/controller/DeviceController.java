package org.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.web.controller.responce.DeviceResponse;
import org.web.domain.Device;
import org.web.domain.Project;
import org.web.service.DeviceService;

import java.util.List;
import java.util.Map;

@RestController
public class DeviceController {

    private final DeviceService deviceService;

    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @GetMapping("findDevices/{id}")
    public Map<String, DeviceResponse> findAllDevices(@PathVariable Long id) {
        return deviceService.findDevicesByProjectId(id);
    }

}
