package com.hva.helios.models;

import java.time.LocalDate;

public class Project {
    private int id, status;
    private String name;
    private LocalDate created;
    private User specialists;
    private Language[] languages;

    public Project(int id, String name, int status, LocalDate created, User specialists, Language[] languages) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.created = created;
        this.specialists = specialists;
        this.languages = languages;
    }

    public Project (int id){
        this.id = id;

        this.name = "Not Given";
        this.status = 0;
        this.created = null;
        this.specialists = null;
        this.languages = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
