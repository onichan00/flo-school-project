package com.hva.helios.models;

public class Client implements ProfileExtension {
    private String website;
    private Project[] projects;

    public Client(String website, Project[] projects) {
        this.website = website;
        this.projects = projects;
    }
}
