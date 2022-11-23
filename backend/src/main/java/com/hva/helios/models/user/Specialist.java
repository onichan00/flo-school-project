package com.hva.helios.models.user;

import com.hva.helios.models.Project;
import com.hva.helios.models.User;
import com.hva.helios.models.user.hour.AvailableHour;
import com.hva.helios.models.user.hour.Hour;
import com.hva.helios.models.user.skill.UserSkill;

import java.util.ArrayList;
import java.util.Map;

public class Specialist extends User {
    private int available;
    private String specialistType;
    private Map<String, Hour> hours;
    private int userType = 2;

    private ArrayList<Project> projects;
    private ArrayList<UserSkill> skills;

    public Specialist(int id, String email, String password, String first_name, String second_name, String last_name, String photo, String bio, String phone, int available, String specialistType, AvailableHour hour) {
        super(id, email, password, first_name, second_name, last_name, photo, bio, phone);

        this.available = available;
        this.specialistType = specialistType;
        this.hours = hour.getDays();

        // Initialize empty arraylist
        this.projects = new ArrayList<>();
        this.skills = new ArrayList<>();
    }

    public Specialist(int id, String email, String password, String first_name, String second_name, String last_name, String photo, String bio, String phone, int available, String specialistType, AvailableHour hour, ArrayList<Project> projects, ArrayList<UserSkill> userSkills) {
        super(id, email, password, first_name, second_name, last_name, photo, bio, phone);

        this.available = available;
        this.specialistType = specialistType;
        this.hours = hour.getDays();
        this.projects = projects;
        this.skills = userSkills;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public String getSpecialistType() {
        return specialistType;
    }

    public void setSpecialistType(String specialistType) {
        this.specialistType = specialistType;
    }

    public Map<String, Hour> getHours() {
        return hours;
    }

    public void setHours(Map<String, Hour> hours) {
        this.hours = hours;
    }

    public ArrayList<Project> getProjects() {
        return projects;
    }

    public void setProjects(ArrayList<Project> projects) {
        this.projects = projects;
    }

    public ArrayList<UserSkill> getSkills() {
        return skills;
    }

    public ArrayList<UserSkill> addSkill(UserSkill userSkill) {
        skills.add(userSkill);

        return skills;
    }

    public void setSkills(ArrayList<UserSkill> skills) {
        this.skills = skills;
    }

    public int getUserType() {
        return userType;
    }
}
