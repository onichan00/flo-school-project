package com.hva.helios.models;

import java.time.LocalDate;

public class Project {
    private String name;
    private int status;
    private LocalDate created;
    private User specialists;
    private Language[] languages;

    public Project(String name, int status, LocalDate created, User specialists, Language[] languages) {
        this.name = name;
        this.status = status;
        this.created = created;
        this.specialists = specialists;
        this.languages = languages;
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

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public User getSpecialists() {
        return specialists;
    }

    public void setSpecialists(User specialists) {
        this.specialists = specialists;
    }

    public Language[] getLanguages() {
        return languages;
    }

    public void setLanguages(Language[] languages) {
        this.languages = languages;
    }
}
