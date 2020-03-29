package org.web.controller.responce;

public class DeviceResponse {
    private Long id;
    private String serialNumber;
    private Long projectId;
    private Boolean hasErrors;

    private SummaryInfoResponse summaryInfo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Boolean getHasErrors() {
        return hasErrors;
    }

    public void setHasErrors(Boolean hasErrors) {
        this.hasErrors = hasErrors;
    }

    public SummaryInfoResponse getSummaryInfo() {
        return summaryInfo;
    }

    public void setSummaryInfo(SummaryInfoResponse summaryInfo) {
        this.summaryInfo = summaryInfo;
    }
}
