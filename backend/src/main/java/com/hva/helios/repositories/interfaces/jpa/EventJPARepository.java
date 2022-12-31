package com.hva.helios.repositories.interfaces.jpa;

import com.hva.helios.models.user.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface EventJPARepository extends JpaRepository<Event, Long> {

}
