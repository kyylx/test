package org.web.controller.responce;

public class SummaryInfoResponse {
    private Integer eventCount;
    private Integer warningCount;
    private Integer errorCount;

    public Integer getEventCount() {
        return eventCount;
    }

    public void setEventCount(Integer eventCount) {
        this.eventCount = eventCount;
    }

    public Integer getWarningCount() {
        return warningCount;
    }

    public void setWarningCount(Integer warningCount) {
        this.warningCount = warningCount;
    }

    public Integer getErrorCount() {
        return errorCount;
    }

    public void setErrorCount(Integer errorCount) {
        this.errorCount = errorCount;
    }
}
