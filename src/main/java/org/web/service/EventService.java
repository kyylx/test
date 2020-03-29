package org.web.service;


import org.web.domain.Event;

import java.util.List;

public interface EventService {
    List<Event> findAllEvents();
}
