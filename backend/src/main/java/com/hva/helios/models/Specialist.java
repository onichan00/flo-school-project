package com.hva.helios.models;

public class Specialist extends User {
    private int available;
    private int preferred_hours;
    private Project[] works_on;
    private Language[] languages;

    public Specialist(int user_id,String email, String password, String first_name, String second_name, String last_name, String photo, String bio, float phone , int available, int preferred_hours, Project[] works_on, Language[] languages) {
        super(user_id,email,password,first_name,second_name,last_name,photo,bio,phone);
        this.available = available;
        this.preferred_hours = preferred_hours;
        this.works_on = works_on;
        this.languages = languages;
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

    public Project[] getWorks_on() {
        return works_on;
    }

    public void setWorks_on(Project[] works_on) {
        this.works_on = works_on;
    }

    public Language[] getLanguages() {
        return languages;
    }

    public void setLanguages(Language[] languages) {
        this.languages = languages;
    }
}
