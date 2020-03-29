package org.web.service;

import org.springframework.stereotype.Service;
import org.web.domain.Event;
import org.web.repository.EventRepository;

import java.util.List;

@Service
public class DefaultEventService implements EventService {

    private final EventRepository eventRepository;

    public DefaultEventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<Event> findAllEvents() {
        return eventRepository.findAll();
    }
}
