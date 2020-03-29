package org.web.controller.responce;

import java.util.List;

public class ProjectResponse {

    private Long id;
    private String projectName;
    private StatsResponse stats;
    private List<String> devices;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public StatsResponse getStats() {
        return stats;
    }

    public void setStats(StatsResponse stats) {
        this.stats = stats;
    }

    public List<String> getDevices() {
        return devices;
    }

    public void setDevices(List<String> devices) {
        this.devices = devices;
    }
}
