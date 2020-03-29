package org.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.web.domain.Device;
import org.web.domain.Event;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    @Query(value = "SELECT * FROM events WHERE device_id=? AND date>? AND date<?", nativeQuery = true)
    List<Event> findByDeviceAndDateBetween(Long deviceId, LocalDateTime from, LocalDateTime to);
}
