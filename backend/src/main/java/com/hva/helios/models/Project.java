package com.hva.helios.models;

import com.hva.helios.data.SkillData;
import com.hva.helios.data.SpecialistData;
import com.hva.helios.models.user.Specialist;
import com.hva.helios.models.user.skill.UserSkill;

import java.time.LocalDate;
import java.util.ArrayList;

public class Project {
    private String name;
    private int status;
    private LocalDate created;
    private ArrayList<Specialist> specialists;
    private ArrayList<UserSkill> skills;

    public Project(String name, int status, LocalDate created) {
        this.name = name;
        this.status = status;
        this.created = created;

        // TODO - Add specialists to the backend
        // Initialize empty arraylist
        this.specialists = new ArrayList<>();
        this.skills = new SkillData().getRandomSkills(2);
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

    public ArrayList<Specialist> getSpecialists() {
        return specialists;
    }

    public void setSpecialists(ArrayList<Specialist> specialists) {
        this.specialists = specialists;
    }

    public ArrayList<UserSkill> getSkills() {
        return skills;
    }

    public void setSkills(ArrayList<UserSkill> skills) {
        this.skills = skills;
    }
}
