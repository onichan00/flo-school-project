package com.hva.helios.models;

import com.hva.helios.data.SkillData;
import com.hva.helios.data.SpecialistData;
import com.hva.helios.models.user.Specialist;
import com.hva.helios.models.user.skill.UserSkill;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Table
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id = 0L;

    private String name;
    private int status;
    private LocalDate created;

    @ManyToMany
    private Set<Specialist> specialists;

//    @OneToMany
//    private ArrayList<UserSkill> skills;

    protected Project() {}

    public Project(String name, int status, LocalDate created) {
        this.name = name;
        this.status = status;
        this.created = created;

        // TODO - Add specialists to the backend
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public Set<Specialist> getSpecialists() {
        return specialists;
    }

    public void setSpecialists(Set<Specialist> specialists) {
        this.specialists = specialists;
    }
}
