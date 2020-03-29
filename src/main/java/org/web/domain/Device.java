package org.web.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "devices")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String serialNumber;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "project_id")
    private Project project;

    @OneToMany
    private List<Event> events;

    public Device() {

    }

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

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public Device(String serialNumber) {
        this.serialNumber = serialNumber;
    }

}
