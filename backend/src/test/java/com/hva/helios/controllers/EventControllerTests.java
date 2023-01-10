package com.hva.helios.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hva.helios.exceptions.NotFoundException;
import com.hva.helios.exceptions.PreConditionFailed;
import com.hva.helios.models.Event;
import com.hva.helios.repositories.interfaces.jpa.EventJPARepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.hva.helios.rest.EventController;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@WebMvcTest(controllers = EventController.class)
public class EventControllerTests {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private EventController controller;

    @MockBean
    private EventJPARepository eventsRepo;

    private ObjectMapper objectMapper;
    private Event event1;
    private Event event2;
    private List<Event> events;

    @BeforeEach()
    public void setup() {
        objectMapper = new ObjectMapper();

        event1 = new Event(null, new Date(), new Date(), "Event 1");
        event2 = new Event(null, new Date(), new Date(), "Event 2");;

        events = new ArrayList<>(List.of(event1, event2));
    }

    @Test
    public void getEventsForProject() throws Exception {
        mvc.perform(get("/events/projects/1"))
                .andExpect(status().isOk());

        verify(eventsRepo).findEventsByProject_Id(1L);
    }

    @Test
    public void testResponse() {

    }
}
