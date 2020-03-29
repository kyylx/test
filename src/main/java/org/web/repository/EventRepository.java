package org.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.web.domain.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
}
