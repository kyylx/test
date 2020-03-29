package org.web.service;

import org.web.controller.responce.DeviceResponse;

import java.util.Map;

public interface DeviceService {

    Map<String, DeviceResponse> findDevicesByProjectId(Long projectId);

}
