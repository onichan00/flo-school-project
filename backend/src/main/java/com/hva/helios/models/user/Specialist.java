package com.hva.helios.models.user;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hva.helios.models.Event;
import com.hva.helios.models.Project;
import com.hva.helios.models.user.hour.AvailableHour;
import com.hva.helios.models.user.skill.UserSkill;
import com.hva.helios.views.Views;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Specialist{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(Views.Public.class)
    private long id;

    @JsonView(Views.Public.class)
    private int available;

    @JsonView(Views.Public.class)
    private String specialistType;

    @JsonView(Views.Public.class)
    private long approvalStatus;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonView(Views.Public.class)
    private AvailableHour hours;

    @ManyToMany(fetch = FetchType.LAZY,
        cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
        },
        mappedBy = "specialists")
    @JsonView(Views.Internal.class)
    @JsonSerialize(using = Views.PublicSerializer.class)
    private Set<Project> projects = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "specialist")
    @JsonView(Views.Internal.class)
    @JsonSerialize(using = Views.PublicSerializer.class)
    private Set<UserSkill> skills;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonView(Views.Internal.class)
    @JsonSerialize(using = Views.PublicSerializer.class)
    private Set<Event> events;

    public Specialist() {

    }

    public Specialist(int available, String specialistType, long approvalStatus) {
        this.available = available;
        this.specialistType = specialistType;
        this.approvalStatus = approvalStatus;
    }

    public Specialist(int available, String specialistType, long approvalStatus, AvailableHour hours, Set<Project> projects, Set<UserSkill> skills, Set<Event> events) {
        this(available, specialistType, approvalStatus);

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

    public boolean associateUserSkill(UserSkill userSkill) {
        if (userSkill != null && userSkill.getSpecialist() == null) {
            skills.add(userSkill);
            userSkill.associateSpecialist(this);

            return true;
        }

        return false;
    }

    public boolean dissociateUserSkill(UserSkill userSkill) {
        if (userSkill != null && userSkill.getSpecialist() != null) {
            return skills.remove(userSkill) && userSkill.dissociateSpecialist(this);
        }

        return false;
    }

    public boolean addProject(Project project) {
        if (project != null) {
            projects.add(project);
            project.getSpecialists().add(this);

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

    public long getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(long approvalStatus) {
        this.approvalStatus = approvalStatus;
    }
}
