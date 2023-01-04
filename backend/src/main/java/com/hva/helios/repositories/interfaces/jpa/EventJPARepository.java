package com.hva.helios.repositories.interfaces.jpa;

import com.hva.helios.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface EventJPARepository
        extends JpaRepository<Event, Long> {
    List<Event> findEventsByProject_Id(Long id);
}
