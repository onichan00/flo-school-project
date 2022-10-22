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
}
