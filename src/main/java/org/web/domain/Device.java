package org.web.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "devices")
public class Device implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String serialNumber;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "project_id")
    private Project projectId;

    @Transient
    private boolean hasErrors;

    @OneToMany
    private List<Event> events;

    public Device() {}

    public Device(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    @Transient
    private SummaryInfo summaryInfo;

    public Device(SummaryInfo summaryInfo) {
        this.summaryInfo = summaryInfo;
    }
}
