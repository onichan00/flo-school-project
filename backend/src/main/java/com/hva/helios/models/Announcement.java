package com.hva.helios.models;

import com.fasterxml.jackson.annotation.JsonView;
import com.hva.helios.views.Views;

import java.time.LocalDate;
import javax.persistence.*;

/**
 * A simple class that represents an announcement.
 *
 * @author Simon Vriesema
 */
@Entity
public class Announcement {
    /**
     * The unique ID of the announcement.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(Views.Public.class)
    private Long id;

    /**
     * The message of the announcement.
     */
    @JsonView(Views.Public.class)
    private String message;

    /**
     * The dateAndTime when the announcement was made.
     */
    @JsonView(Views.Public.class)
    private LocalDate dateAndTime;

    /**
     * The user who made the announcement.
     */
    @JsonView(Views.Public.class)
    @ManyToOne
    private User user;

    /**
     * The project to which the announcement relates.
     */
    @JsonView(Views.Public.class)
    @ManyToOne()
    private Project project;

    /**
     * Default constructor required by JPA.
     */
    public Announcement() {}

    /**
     * Creates a new announcement with the specified message, dateAndTime, user, and project.
     *
     * @param message the message of the announcement
     * @param dateAndTime the dateAndTime when the announcement was made
     */
    public Announcement(String message, LocalDate dateAndTime) {
        this();
        this.message = message;
        this.dateAndTime = dateAndTime;
    }

    /**
     * Creates a new announcement with the specified message, dateAndTime, user, and project.
     *
     * @param user the user who made the announcement
     * @param project the project to which the announcement relates
     */
    public Announcement(User user, Project project) {
        this();
        this.user = user;
        this.project = project;
    }

    /**
     * Returns the unique ID of the announcement.
     *
     * @return the unique ID of the announcement
     */
    public Long getId() {
        return id;
    }

    /**
     * Returns the message of the announcement.
     *
     * @return the message of the announcement
     */
    public String getMessage() {
        return message;
    }

    /**
     * Returns the dateAndTime when the announcement was made.
     *
     * @return the dateAndTime when the announcement was made
     */
    public LocalDate getDateAndTime() {
        return dateAndTime;
    }

    /**
     * Returns the user who made the announcement.
     *
     * @return the user who made the announcement
     */
    public User getUser() {
        return user;
    }


    /**
     * Returns the project to which the announcement relates.
     *
     * @return the project to which the announcement relates
     */
    public Project getProject() {
        return project;
    }

    /**
     * Sets the message of the announcement.
     *
     * @param message the message of the announcement
     */
    public void setMessage(String message) {
        this.message = message;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDateAndTime(LocalDate dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setProject(Project project) {
        this.project = project;
    }

}
