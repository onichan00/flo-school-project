package com.hva.helios.models;

import java.time.LocalDate;

public class Specialist extends User implements ProfileExtension {

    private int user_id;
    private int available;
    private int preferred_hours;
    private Project works_on;
    private Language[] languages;

    public Specialist(int user_id) {
        // TODO Ask for help with super()
        super(user_id);
        this.user_id = user_id;

        this.available = 0;
        this.preferred_hours = 0;
        this.works_on = new Project(0, null, 0, null, null, null);
        this.languages = null;
    }

    public Specialist(int user_id, int available, int preferred_hours, Project works_on, Language[] languages) {
        // TODO Ask for help with super()
        super(user_id);
        this.user_id = user_id;
        this.available = available;
        this.preferred_hours = preferred_hours;
        this.works_on = works_on;
        this.languages = languages;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public int getPreferred_hours() {
        return preferred_hours;
    }

    public void setPreferred_hours(int preferred_hours) {
        this.preferred_hours = preferred_hours;
    }

    public Project getWorks_on() {
        return works_on;
    }

    public void setWorks_on(Project works_on) {
        this.works_on = works_on;
    }

    public Language[] getLanguages() {
        return languages;
    }

    public void setLanguages(Language[] languages) {
        this.languages = languages;
    }
}
