package com.hva.helios.controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.hva.helios.exceptions.NotFoundException;
import com.hva.helios.models.Event;
import com.hva.helios.models.Project;
import com.hva.helios.models.enums.EventType;
import com.hva.helios.repositories.interfaces.jpa.EventJPARepository;
import com.hva.helios.rest.EventController;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

//@DataJpaTest
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ComponentScan({ "com.hva.helios.rest", "com.hva.helios.repositories" })
public class EventControllerTests {
    @Autowired
    private EventJPARepository eventRepo;

    @Autowired
    private EventController eventController;

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
    public void getEventById() {
        Event calledEvent = eventController.getEventById(event.getId());
        assertEquals(calledEvent.getId(), event.getId());
    }

    @Test
    public void createEvent() {
        Project project = new Project("Project 2", "Image", 1, new Date(), "Test description");
        event.setProject(project);

        Event created = eventController.createEvent(event);

        assertEquals(event.getTitle(), created.getTitle());
    }

    @Test
    public void updateEvent() {
        assertEquals(event.getTitle(), "Meeting with Apple");

        event.setTitle("Updated Event");
        Event updated = eventController.updateEvent(event.getId(), event);

        assertNotNull(updated);
        assertEquals(updated.getTitle(), "Updated Event");
    }

    @Test
    public void deleteEvent() {
        ResponseEntity<Event> deleted = eventController.deleteEvent(event.getId());
        assertNotNull(deleted);

        assertThrows(
            NotFoundException.class,
            () -> {
                eventController.getEventById(event.getId());
            }
        );
    }

    @Test
    public void updateAcceptedStatus() {
        event.setAccepted(1);

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode node = mapper.createObjectNode();

        node.set("id", mapper.convertValue(event.getId(), JsonNode.class));
        node.set("accepted", mapper.convertValue(1, JsonNode.class));

        Event updated = eventController.updateEventAccepted(event.getId(), node);
        assertNotNull(updated);
        assertEquals(event.getId(), updated.getId());
        assertEquals(updated.getAccepted(), 1);
    }
}
