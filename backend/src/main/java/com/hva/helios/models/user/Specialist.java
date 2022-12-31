package com.hva.helios.models.user;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hva.helios.models.Event;
import com.hva.helios.models.Project;
import com.hva.helios.models.user.hour.AvailableHour;
import com.hva.helios.models.user.skill.UserSkill;
import com.hva.helios.views.Views;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class Specialist{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(Views.Public.class)
    private long id = 0L;

    @JsonView(Views.Public.class)
    private int available;

    @JsonView(Views.Public.class)
    private String specialistType;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonView(Views.Internal.class)
    private AvailableHour hours;

    @ManyToMany(cascade = CascadeType.ALL)
    @JsonView(Views.Internal.class)
    private Set<Project> projects;

    @OneToMany(cascade = CascadeType.ALL)
    @JsonView(Views.Internal.class)
    private Set<UserSkill> skills;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonSerialize(using = Views.PublicSerializer.class)
    @JsonView(Views.Internal.class)
    private Set<Event> events;

    public Specialist() {}

    public Specialist(int available, String specialistType) {
        this.available = available;
        this.specialistType = specialistType;
    }

    public Specialist(int available, String specialistType, AvailableHour hours, Set<Project> projects, Set<UserSkill> skills, Set<Event> events) {
        this(available, specialistType);

        this.hours = hours;
        this.projects = projects;
        this.skills = skills;
        this.events = events;
    }

    public boolean associateEvent(Event event) {
        if (event != null && event.getUser() == null) {
            event.associateSpecialist(this);
            events.add(event);

            return true;
        }

        return false;
    }

    public boolean dissociateEvent(Event event) {
        if (event != null && event.getUser() != null) {
            return events.remove(event) && event.dissociateSpecialist(this);
        }

        return false;
    }

    public boolean addProject(Project project) {
        if (project != null) {
            projects.add(project);
            project.addSpecialist(this);

            return true;
        }

        return false;
    }

    public boolean removeProject(long projectId) {
        Project project = projects.stream().
                filter(p -> p.getId() == projectId)
                .findFirst()
                .orElse(null);

        return removeProject(project);
    }

    public boolean removeProject(Project project) {
        if (project != null) {
            projects.remove(project);
            project.removeSpecialist(this);

            return true;
        }

        return false;
    }

    public long getId() {
        return id;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public String getSpecialistType() {
        return specialistType;
    }

    public void setSpecialistType(String specialistType) {
        this.specialistType = specialistType;
    }

    public AvailableHour getHours() {
        return hours;
    }

    public void setHours(AvailableHour hours) {
        this.hours = hours;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    public Set<UserSkill> getSkills() {
        return skills;
    }

    public void setSkills(Set<UserSkill> skills) {
        this.skills = skills;
    }

    public void addSkill(UserSkill skill) {
        skills.add(skill);
    }

    public void removeSkill(long skillId) {
        UserSkill skill = skills.stream().filter(s -> s.getId() == skillId).findFirst().orElse(null);

        if (skill != null) {
            skills.remove(skill);
        }
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<Event> getEvents() {
        return events;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
    }
}
