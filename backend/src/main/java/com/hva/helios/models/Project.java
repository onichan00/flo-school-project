package com.hva.helios.models;

import com.hva.helios.data.SkillData;
import com.hva.helios.data.SpecialistData;
import com.hva.helios.models.user.Client;
import com.hva.helios.models.user.Specialist;
import com.hva.helios.models.user.skill.Skill;
import com.hva.helios.models.user.skill.UserSkill;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Entity
@Table
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id = 0L;

    private String name;
    private int status;
    private LocalDate created;
    private String description;

    @ManyToMany
    private Set<Specialist> specialists;

    @ManyToOne
//    @JoinColumn(name = "client_id")
    private Client client;


//    @OneToMany
//    private ArrayList<UserSkill> skills;

    protected Project() {

    }
    public Project(String name, Client client,int status, LocalDate created, String description) {
        this.name = name;
        this.status = status;
        this.created = created;
        this.description = description;
        this.client = client;
//        this.specialists = new HashSet<>(specialists);
        // TODO - Add specialists to the backend

    }

    public Project(String name,int status, LocalDate created, String description) {
        this.name = name;
        this.status = status;
        this.created = created;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
