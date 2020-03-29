package org.web.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


@Entity
@Table(name = "events")
public class Event implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "device_id")
    private Device device;

    private LocalDateTime date;

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    private boolean isRead;

    @Enumerated(EnumType.STRING)
    private EventType event;

    public EventType getEvent() {
        return event;
    }

    public void setEvent(EventType event) {
        this.event = event;
    }

    public Event() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

}
