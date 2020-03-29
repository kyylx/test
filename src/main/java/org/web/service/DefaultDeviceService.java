package org.web.service;

import org.springframework.stereotype.Service;
import org.web.controller.responce.DeviceResponse;
import org.web.controller.responce.SummaryInfoResponse;
import org.web.domain.Device;
import org.web.domain.Event;
import org.web.domain.EventType;
import org.web.exeptions.NotFoundException;
import org.web.repository.DeviceRepository;
import org.web.repository.EventRepository;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Objects.isNull;

@Service
public class DefaultDeviceService implements DeviceService {

    private final DeviceRepository deviceRepository;
    private final EventRepository eventRepository;

    public DefaultDeviceService(DeviceRepository deviceRepository,
                                EventRepository eventRepository) {
        this.deviceRepository = deviceRepository;
        this.eventRepository = eventRepository;
    }

    @Override
    public Map<String, DeviceResponse> findDevicesByProjectId(Long projectId) {

        List<Device> devices = deviceRepository.findDeviceByProjectId(projectId);
        if (isNull(devices) || devices.isEmpty()) {
            throw new NotFoundException("Devices not found for this project: " + projectId);
        }
        Map<String, DeviceResponse> deviceResponseMap = new HashMap<>();
        devices.forEach(d -> {
            DeviceResponse deviceResponse = new DeviceResponse();
            deviceResponse.setId(d.getId());
            deviceResponse.setProjectId(d.getProject() != null ? d.getProject().getId() : null);
            deviceResponse.setSerialNumber(d.getSerialNumber());
            SummaryInfoResponse summaryInfo = prepareSummaryInfo(d);
            boolean hasErrors = summaryInfo.getErrorCount() > 0 || summaryInfo.getWarningCount() > 0;
            deviceResponse.setHasErrors(hasErrors);
            deviceResponse.setSummaryInfo(summaryInfo);
            deviceResponseMap.put(d.getSerialNumber(), deviceResponse);
        });
        return deviceResponseMap;
    }

    private SummaryInfoResponse prepareSummaryInfo(Device device) {
        LocalDateTime start = LocalDateTime.now();
        LocalDateTime end = start.minusHours(24);
        List<Event> deviceEvents = eventRepository
                .findByDeviceAndDateBetween(device.getId(), end, start);
        SummaryInfoResponse s = new SummaryInfoResponse();
        int warningCount = 0;
        int errorCount = 0;
        int eventCount = 0;
        for (Event event : deviceEvents) {
            if (event.getEvent().equals(EventType.WARNING)) {
                warningCount++;
            }
            if (event.getEvent().equals(EventType.ERROR)) {
                errorCount++;
            }
            if (event.getEvent().equals(EventType.EVENT)) {
                eventCount++;
            }
        }
        s.setEventCount(eventCount);
        s.setErrorCount(errorCount);
        s.setWarningCount(warningCount);
        return s;
    }

}
