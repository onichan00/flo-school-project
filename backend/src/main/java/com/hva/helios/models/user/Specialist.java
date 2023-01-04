package com.hva.helios.models.user;

import com.hva.helios.models.Project;
import com.hva.helios.models.User;
import com.hva.helios.models.user.hour.AvailableHour;
import com.hva.helios.models.user.skill.UserSkill;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table
public class Specialist{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id = 0L;

    private int available;
    private String specialistType;

    private long approvalStatus;

    @OneToOne(cascade = CascadeType.ALL)
    private AvailableHour hours;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Project> projects;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<UserSkill> skills;

    public Specialist() {}

    public Specialist(int available, String specialistType, AvailableHour hours, List<Project> projects, List<UserSkill> skills,
                      long approvalStatus) {
        this.available = available;
        this.specialistType = specialistType;
        this.approvalStatus = approvalStatus;
    }

    public long getId() {
        return id;
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

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    public Set<UserSkill> getSkills() {
        return skills;
    }

    public void setSkills(Set<UserSkill> skills) {
        this.skills = skills;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(long approvalStatus) {
        this.approvalStatus = approvalStatus;
    }
}
