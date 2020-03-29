package org.web.service;

import org.springframework.stereotype.Service;
import org.web.controller.responce.ProjectResponse;
import org.web.controller.responce.StatsResponse;
import org.web.domain.Device;
import org.web.domain.Event;
import org.web.domain.EventType;
import org.web.domain.Project;
import org.web.repository.EventRepository;
import org.web.repository.ProjectRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class DefaultProjectService implements ProjectService {

    private final ProjectRepository projectRepository;
    private final EventRepository eventRepository;

    public DefaultProjectService(ProjectRepository projectRepository,
                                 EventRepository eventRepository) {
        this.projectRepository = projectRepository;
        this.eventRepository = eventRepository;
    }

    @Override
    public List<ProjectResponse> findAllProjects() {
        List<ProjectResponse> responseList = new ArrayList<>();

        List<Project> projects = projectRepository.findAll();
        projects.forEach(p -> {
            List<Device> devices = p.getDevices();
            List<String> devicesSerial = new ArrayList<>();
            int deviceWithErrors = 0;
            int stableDevices = 0;
            for (Device it : devices) {
                devicesSerial.add(it.getSerialNumber());
                LocalDateTime start = LocalDateTime.now();
                LocalDateTime end = start.minusHours(24);
                boolean stable = true;
                List<Event> events = eventRepository.findByDeviceAndDateBetween(it.getId(), end, start);
                for (Event event : events) {
                    if (event.getEvent().equals(EventType.WARNING) ||
                            event.getEvent().equals(EventType.ERROR)) {
                        stable = false;
                    }
                }
                if (stable) {
                    stableDevices++;
                } else {
                    deviceWithErrors++;
                }
            }

            ProjectResponse projectResponse = getProjectResponse(p.getId(), p.getProjectName(), devicesSerial);
            StatsResponse s = getStatsResponse(devices.size(), deviceWithErrors, stableDevices);

            projectResponse.setStats(s);
            responseList.add(projectResponse);
        });
        return responseList;
    }


    public ProjectResponse getProjectResponse(Long id, String projectName,
                                              List<String> devicesSerial) {
        ProjectResponse projectResponse = new ProjectResponse();
        projectResponse.setId(id);
        projectResponse.setProjectName(projectName);
        projectResponse.setDevices(devicesSerial);

        return projectResponse;
    }

    public StatsResponse getStatsResponse(int size, int deviceWithErrors, int stableDevices) {
        StatsResponse statsResponse = new StatsResponse();
        statsResponse.setDeviceCount(size);
        statsResponse.setDeviceWithErrors(deviceWithErrors);
        statsResponse.setStableDevices(stableDevices);

        return statsResponse;
    }

}
