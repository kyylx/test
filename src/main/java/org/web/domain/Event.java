package org.web.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;


@Entity
@Table(name = "events")
public class Event implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "device_id")
    private Device device;

    private Date date;

    private boolean isRead;

    /*@ElementCollection(targetClass = EventType.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "type", joinColumns = @JoinColumn(name = "events_id"))
    @Enumerated(EnumType.STRING)
    private Set<EventType> event;*/

    @Enumerated(EnumType.STRING)
    private EventType event;

    public EventType getEvent() {
        return event;
    }

    public void setEvent(EventType event) {
        this.event = event;
    }

    public Event() {}


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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    /*public Set<EventType> getEvent() {
        return event;
    }

    public void setEvent(Set<EventType> eventType) {
        this.event = eventType;
    }*/
}
