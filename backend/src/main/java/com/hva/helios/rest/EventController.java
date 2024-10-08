package com.hva.helios.rest;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.hva.helios.exceptions.NotFoundException;
import com.hva.helios.exceptions.PreConditionFailed;
import com.hva.helios.models.Event;
import com.hva.helios.models.Project;
import com.hva.helios.models.User;
import com.hva.helios.models.enums.EventType;
import com.hva.helios.models.user.Specialist;
import com.hva.helios.repositories.ProjectJPARepository;
import com.hva.helios.repositories.interfaces.jpa.EventJPARepository;
import com.hva.helios.views.Views;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/events")
public class EventController {
    @Autowired
    private EventJPARepository eventRepo;

    @Autowired
    private ProjectJPARepository projectRepo;

    /**
     * Retrieves a list of events for a given project.
     *
     * @param projectId The ID of the project to retrieve events for
     * @return A list of events for the given project
     * @throws NotFoundException If no events are found for the given project
     */
    @GetMapping("/projects/{projectId}")
    public List<Event> getEventsForProject(@PathVariable long projectId) {
        // Retrieve the list of events for the given project ID
        List<Event> events = eventRepo.findEventsByProject_Id(projectId);

        // If the list of events is empty, throw a NotFoundException
        if (events.isEmpty()) {
            throw new NotFoundException(String.format("There were no events found that were attached to project with ID: %d", projectId));
        }

        // Return the list of events
        return eventRepo.findEventsByProject_Id(projectId);
    }


    /**
     * Retrieves an event with the given ID.
     *
     * @param id The ID of the event to retrieve
     * @return The event with the given ID
     * @throws NotFoundException If no event is found with the given ID
     */
    @GetMapping("/{id}")
    public Event getEventById(@PathVariable long id) {
        // Attempt to retrieve the event with the given ID
        Event event = eventRepo.findById(id).orElse(null);

        // If the event is not found, throw a NotFoundException
        if (event == null) {
            throw new NotFoundException(String.format("Event with ID: %d was not found", id));
        }

        // Return the event
        return event;
    }

    /**
     * Creates a new event.
     *
     * @param event The event to create
     * @return The created event
     */
    @PostMapping("/")
    public Event createEvent(@RequestBody Event event) {
        // FIXME: Remove bug where project

        var id = event.getProject().getId();

        event.setProject(projectRepo.findById(id));

        // Save the event to the repository and return it
        return eventRepo.save(event);
    }

    /**
     * Updates an existing event.
     *
     * @param id The ID of the event to update
     * @param toMergeEvent The updated event information
     * @return The updated event
     * @throws NotFoundException if no event is found with the given ID
     * @throws PreConditionFailed if the event ID in the path does not match the event ID in the request body
     */
    @PutMapping("/{id}")
    public Event updateEvent(@PathVariable long id, @RequestBody Event toMergeEvent) {
        // Attempt to retrieve the event with the given ID
        Event event = eventRepo.findById(id).orElse(null);

        // If the event is not found, throw a NotFoundException
        if (event == null) {
            throw new NotFoundException(String.format("Event with ID: %d was not found", id));
        }

        // If the event ID in the path does not match the event ID in the request body, throw a PreConditionFailed exception
        if (!Objects.equals(event.getId(), toMergeEvent.getId())) {
            throw new PreConditionFailed(String.format("Event with ID: %d does not match with parameter ID: %d", event.getId(), event.getId()));
        }

        // Update the event and return it
        return eventRepo.save(toMergeEvent);
    }

    /**
     * Deletes an event with the given ID.
     *
     * @param id The ID of the event to delete
     * @return an HTTP response with the deleted event
     * @throws NotFoundException If no event is found with the given ID
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Event> deleteEvent(@PathVariable long id) {
        // Attempt to retrieve the event with the given ID
        Event deletedEvent = eventRepo.findById(id).orElse(null);

        // If the event is not found, throw a NotFoundException
        if (deletedEvent == null) {
            throw new NotFoundException(String.format("Event with ID: %d was not found", id));
        }

        // Delete the event
        eventRepo.delete(deletedEvent);

        // Return an HTTP response with the deleted event
        return ResponseEntity.ok(deletedEvent);
    }

    /**
     * Updates the accepted field of an Event object based on the provided id and request body.
     *
     * @param id The ID of the even object to be updates
     * @param node The request body containing the new accepted value
     * @return The updated Event object
     * @throws NotFoundException If no Event object is found with the provided ID
     * @throws PreConditionFailed If the ID of the Event object does not match the ID in the request body
     */
    @PatchMapping("/{id}/accepted")
    public Event updateEventAccepted(@PathVariable long id, @RequestBody ObjectNode node) {
        // Attempt to retrieve the event with the given ID
        Event event = eventRepo.findById(id).orElse(null);

        // Check if the event with the provided ID exists
        if (event == null) {
            // If not, throw a NotFoundException
            throw new NotFoundException(String.format("Event with ID: %d was not found", id));
        }

        // Check if the ID of the event matches the ID in the request body
        if (!Objects.equals(event.getId(), node.get("id").asLong())) {
            // If not, throw a PreConditionFailed exception
            throw new PreConditionFailed(String.format("Event with ID: %d does not match with parameter ID: %d", event.getId(), node.get("id").asLong()));
        }

        // Update the accepted field of the Event object
        event.setAccepted(node.get("accepted").asInt());

        // Save the updated event and return it
        return eventRepo.save(event);
    }
}
