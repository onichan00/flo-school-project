package com.hva.helios.models.user;

import com.hva.helios.data.ProjectData;
import com.hva.helios.models.Project;
import com.hva.helios.models.User;

import java.util.ArrayList;

public class Client extends User {
    private String website;
    private ArrayList<Project> projects;
    private int userType = 1;

    public Client(int user_id, String email, String password, String first_name, String second_name, String last_name, String photo, String bio, String phone , String website) {
        super(user_id, email, password, first_name, second_name, last_name, photo, bio, phone);
        this.website = website;

        this.projects = new ProjectData().getRandomProjects(2);
    }

    public Client(int user_id, String email, String password, String first_name, String second_name, String last_name, String photo, String bio, String phone , String website, ArrayList<Project> projects) {
        super(user_id, email, password, first_name, second_name, last_name, photo, bio, phone);
        this.website = website;
        this.projects = projects;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public ArrayList<Project> getProjects() {
        return projects;
    }

    public void setProjects(ArrayList<Project> projects) {
        this.projects = projects;
    }

    public int getUserType() {
        return userType;
    }
}
