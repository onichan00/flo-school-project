package com.hva.helios.models;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hva.helios.models.Project;
import com.hva.helios.models.enums.EventType;
import com.hva.helios.models.user.Specialist;
import com.hva.helios.views.Views;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(Views.Public.class)
    private Long id;

    @ManyToOne(cascade = { CascadeType.MERGE })
    @JoinColumn(name = "user_id")
    @JsonSerialize(using = Views.PublicSerializer.class)
    @JsonView(Views.Public.class)
    private Specialist user;

    @ManyToOne(cascade = { CascadeType.MERGE })
    @JoinColumn(name = "project_id")
    @JsonSerialize(using = Views.PublicSerializer.class)
    @JsonView(Views.Internal.class)
    private Project project;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "start_time")
    @JsonView(Views.Public.class)
    private Date start;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "end_time")
    @JsonView(Views.Public.class)
    private Date end;

    @Column(nullable = false)
    @JsonView(Views.Public.class)
    private String title;

    @Enumerated(EnumType.STRING)
    @Column(name = "event_type")
    @JsonView(Views.Public.class)
    private EventType eventType;

    @JsonView(Views.Internal.class)
    private String location;

    @JsonView(Views.Internal.class)
    private String description;

    @JsonView(Views.Public.class)
    private int accepted;

    protected Event() {}

//    public Event(Specialist user, Date start, Date)

    public Event(Specialist user, Date start, Date end, String title) {
        this.user = user;
        this.start = start;
        this.end = end;
        this.title = title;
    }

    public Event(Specialist user, Date start, Date end, String title, EventType eventType, String location, String description, Project project, int accepted) {
        this(user, start, end, title);

        this.eventType = eventType;
        this.location = location;
        this.description = description;
        this.project = project;
        this.accepted = accepted;
    }

    public Event(Specialist user, Date start, Date end, String title, EventType eventType, String location, String description) {
        this(user, start, end, title, eventType, location, description, null, 0);
    }

    /**
     * Associates a specialist with this event.
     *
     * @param specialist The specialist to associate
     * @return True if the specialist was successfully associated, false otherwise
     */
    public boolean associateSpecialist(Specialist specialist) {
        if (specialist != null & this.getUser() == null) {
            setUser(specialist);
            specialist.associateEvent(this);
            return true;
        }

        return false;
    }

    /**
     * Dissociates a specialist from this event.
     *
     * @param specialist The specialist to dissociate
     * @return True if the specialist was successfully dissociated, false otherwise
     */
    public boolean dissociateSpecialist(Specialist specialist) {
        if (specialist != null && getUser() != null) {
            return specialist.dissociateEvent(this);
        }

        return false;
    }

    public boolean associateProject(Project project) {
        if (project != null & this.getProject() == null) {
            setProject(project);
            project.associateEvent(this);
            return true;
        }

        return false;
    }

    public boolean dissociateProject(Project project) {
        if (project != null && getProject() != null) {
            return project.dissociateEvent(this);
        }

        return false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Specialist getUser() {
        return user;
    }

    public void setUser(Specialist user) {
        this.user = user;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAccepted() {
        return accepted;
    }

    public void setAccepted(int accepted) {
        this.accepted = accepted;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
