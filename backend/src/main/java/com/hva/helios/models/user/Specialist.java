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

    @OneToOne(cascade = CascadeType.ALL)
    private AvailableHour hours;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Project> projects;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<UserSkill> skills;

//    @OneToOne
//    private User user;

    public Specialist() {}

    public Specialist(int available, String specialistType, AvailableHour hours, List<Project> projects, List<UserSkill> skills) {
        this.available = available;
        this.specialistType = specialistType;

//        this.projects = projects;
//        this.skills = skills;
    }
//    public Specialist(User user){
//        this.user = user;
//
//    }

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

    public void addProject(Project project) {
        projects.add(project);
        project.getSpecialists().add(this);
    }

    public void removeProject(long projectId) {
        Project project = projects.stream().filter(p -> p.getId() == projectId).findFirst().orElse(null);

        if (project != null) {
            projects.remove(project);
            project.getSpecialists().remove(this);
        }
    }

    public Set<UserSkill> getSkills() {
        return skills;
    }

    public void setSkills(Set<UserSkill> skills) {
        this.skills = skills;
    }

    public void addSkill(UserSkill skill) {
        skills.add(skill);
    }

    public void removeSkill(long skillId) {
        UserSkill skill = skills.stream().filter(s -> s.getId() == skillId).findFirst().orElse(null);

        if (skill != null) {
            skills.remove(skill);
        }
    }

    public void setId(long id) {
        this.id = id;
    }
}
