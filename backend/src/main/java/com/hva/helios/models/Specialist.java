package com.hva.helios.models;

public class Specialist implements ProfileExtension {
    private int user_id;
    private int available;
    private int preferred_hours;
    private Project works_on;
    private Language[] languages;

    public Specialist(int user_id, int available, int preferred_hours, Project works_on, Language[] languages) {
        this.user_id = user_id;
        this.available = available;
        this.preferred_hours = preferred_hours;
        this.works_on = works_on;
        this.languages = languages;
    }
}
