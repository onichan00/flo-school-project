package com.hva.helios.repositories;

import com.hva.helios.models.Event;
import com.hva.helios.models.enums.EventType;
import com.hva.helios.repositories.interfaces.jpa.EventJPARepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ComponentScan({ "com.hva.helios.repositories" })
public class EventRepositoryTest {
    @Autowired
    private EventJPARepository eventRepo;

    private Event event;

    @AfterEach
    public void tearDown() {
        eventRepo.deleteAll();
    }

    @BeforeEach
    public void setup() {
        event = new Event(null, new Date(), new Date(), "Meeting with Apple", EventType.WORK, "Starbucks", "LOREM IPSUM");
        eventRepo.save(event);
    }

    @Test
    void whenFindById_thenReturnEvent() {
        System.out.println(event);
        assertEquals(0,0);
    }

    @Test
    public void whenSaveAndRetrieveEvent_thenOK() {
        Event found = eventRepo.findById(event.getId()).orElse(null);
        assertNotNull(found);

        assertEquals(event.getTitle(), found.getTitle());
    }

    @Test
    public void whenUpdateEntity_thenOK() {
        Event found = eventRepo.findById(event.getId()).orElse(null);
        assertNotNull(found);

        found.setTitle("Test title");
        eventRepo.save(found);

        Event updated = eventRepo.findById(event.getId()).orElse(null);
        assertNotNull(updated);

        assertEquals(updated.getTitle(), "Test title");
    }

    @Test
    public void whenDeleteEntity_thenOK() {
        eventRepo.deleteById(event.getId());

        Event deleted = eventRepo.findById(event.getId()).orElse(null);
        assertNull(deleted);
    }

//    @Test
//    public void findEventByProject() {
//
//    }

    /**
     *     Associating and dissociating a specialist:
     *
     *     Create a new event and a new specialist
     *     Use the associateSpecialist method to associate the specialist with the event
     *     Use the dissociateSpecialist method to dissociate the specialist from the event
     *     Assert that the event's user is correctly associated or dissociated with the specialist
     *
     *     Associating and dissociating a project:
     *
     *     Create a new event and a new project
     *     Use the associateProject method to associate the project with the event
     *     Use the dissociateProject method to dissociate the project from the event
     *     Assert that the event's project is correctly associated or dissociated with the project
     *
     *     Finding events by user:
     *
     *     Create multiple events with different users
     *     Use the repository's find method, such as findByUser to retrieve events by a specific user
     *     Assert that the retrieved events match the expected user
     *
     *     Finding events by project:
     *
     *     Create multiple events with different projects
     *     Use the repository's find method, such as findByProject to retrieve events by a specific project
     *     Assert that the retrieved events match the expected project
     *
     *     Finding events by date range:
     *
     *     Create multiple events with different start and end dates
     *     Use the repository's find method, such as findByStartBetween or findByEndBetween to retrieve events within a specific date range
     *     Assert that the retrieved events match the expected date range.
     */
}
