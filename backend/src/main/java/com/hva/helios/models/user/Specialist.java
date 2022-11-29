package com.hva.helios.models.user;

import com.hva.helios.models.Project;
import com.hva.helios.models.User;
import com.hva.helios.models.user.hour.AvailableHour;
import com.hva.helios.models.user.skill.UserSkill;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Specialist extends User {
    @Id
    @GeneratedValue
    private final long id = 0L;

    private int available;
    private String specialistType;

    @OneToOne(cascade = CascadeType.ALL)
    private AvailableHour hours;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Project> projects;
//
//    @OneToMany(cascade = CascadeType.ALL)
//    private List<UserSkill> skills;

    protected Specialist() {}

    public Specialist(String email, String password, String first_name, String second_name, String last_name, String photo, String bio, String phone, String city, String zipCode, String address, int available, String specialistType, AvailableHour hours, List<Project> projects, List<UserSkill> skills) {
        super(email, password, first_name, second_name, last_name, photo, bio, phone, city, zipCode, address);

        this.available = available;
        this.specialistType = specialistType;

//        this.projects = projects;
//        this.skills = skills;
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

    public AvailableHour getHours() {
        return hours;
    }

    public void setHours(AvailableHour hours) {
        this.hours = hours;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
//
//    public List<UserSkill> getSkills() {
//        return skills;
//    }
//
//    public void setSkills(List<UserSkill> skills) {
//        this.skills = skills;
//    }

    public int getUserType() {
        return 2;
    }
}
