package com.hva.helios.models;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
//import com.hva.helios.data.SpecialistData;
import com.hva.helios.models.user.Specialist;
import com.hva.helios.models.user.skill.Skill;
import com.hva.helios.views.Views;

import javax.persistence.*;
import java.util.*;

@Entity
@Table
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(Views.Public.class)
    private Long id;

    @Column(nullable = false)
    @JsonView(Views.Public.class)
    private String name;

    @JsonView(Views.Public.class)
    private int status;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonView(Views.Public.class)
    private Date created;

    @JsonView(Views.Public.class)
    private String description;

    @JsonView(Views.Public.class)
    private String bannerUrl;

    @ManyToOne
    @JsonSerialize(using = Views.PublicSerializer.class)
    @JsonView(Views.Internal.class)
    private User user;

    @ManyToMany
    @JsonView(Views.Internal.class)
    private Set<Specialist> specialists;

    @OneToMany
    @JsonSerialize(using = Views.PublicSerializer.class)
    @JsonView(Views.Internal.class)
    private List<Skill> skills;

    @OneToMany(mappedBy = "project", cascade = CascadeType.MERGE)
    @JsonSerialize(using = Views.PublicSerializer.class)
    @JsonView(Views.Internal.class)
    private Set<Event> events;

    /**
     * Default constructor for JPA with default values for fields
     */
    protected Project() {
        // Set default values for fields
        this.description = "No description given";
        this.status = -1;
        this.created = new Date();
    }

    public Project(String name, User user, String bannerUrl, int status, Date created, String description, Set<Specialist> specialists, List<Skill> skills, Set<Event> events) {
        // Call the default constructor to set default values for fields
        this();
        // Set the values of the fields using the parameters
        this.name = name;
        this.user = user;
        this.bannerUrl = bannerUrl;
        this.status = status;
        this.created = created;
        this.description = description;
        this.specialists = specialists;
        this.skills = skills;
        this.events = events;
    }

    public Project(String name, User user) {
        // Call the default constructor to set default values for fields
        this();
        // Set the name and user fields using the parameters
        this.name = name;
        this.user = user;
    }

    public Project(String name, User user, String bannerUrl, int status, Date created, String description) {
        // call the constructor that takes name and user as parameters
        this(name, user);
        // Set the bannerUrl, status, created, and description fields using the parameters
        this.bannerUrl = bannerUrl;
        this.status = status;
        this.created = created;
        this.description = description;
    }

    public Project(String name, String bannerUrl, int status, Date created, String description) {
        // Call the default constructor to set default values for fields
        this();
        // Set the name, bannerUrl, status, created, and description fields using the parameters
        this.name = name;
        this.status = status;
        this.created = created;
        this.description = description;
    }

    public boolean associateEvent(Event event) {
        if (event != null && event.getProject() == null) {
            event.associateProject(this);
            events.add(event);

            return true;
        }

        return false;
    }

    public boolean dissociateEvent(Event event) {
        if (event != null && event.getProject() != null) {
            return events.remove(event) && event.dissociateProject(this);
        }

        return false;
    }

    public boolean addSpecialist(Specialist specialist) {
        if (specialist != null) {
            specialists.add(specialist);
            specialist.addProject(this);

            return true;
        }

        return false;
    }

    public boolean removeSpecialist(long specialistId) {
        Specialist specialist = specialists.stream()
                .filter(s -> s.getId() == specialistId)
                .findFirst()
                .orElse(null);

        return removeSpecialist(specialist);
    }

    public boolean removeSpecialist(Specialist specialist) {
        if (specialist != null) {
            specialists.remove(specialist);
            specialist.removeProject(this);

            return true;
        }

        return false;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Set<Specialist> getSpecialists() {
        return specialists;
    }

    public void setSpecialists(Set<Specialist> specialists) {
        this.specialists = specialists;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getBannerUrl() {
        return bannerUrl;
    }

    public void setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public Set<Event> getEvents() {
        return events;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
    }
}
