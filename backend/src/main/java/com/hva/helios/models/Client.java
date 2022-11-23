package com.hva.helios.models;

public class Client extends User {
    private String website;
    private Project[] projects;

    public Client(int user_id,String email, String password, String first_name, String second_name, String last_name, String photo, String bio, long phone ,String website, Project[] projects) {
        super(user_id,email,password,first_name,second_name,last_name,photo,bio,phone);
        this.website = website;
        this.projects = projects;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Project[] getProjects() {
        return projects;
    }

    public void setProjects(Project[] projects) {
        this.projects = projects;
    }
}
