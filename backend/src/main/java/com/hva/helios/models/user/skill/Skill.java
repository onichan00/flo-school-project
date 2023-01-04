package com.hva.helios.models.user.skill;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hva.helios.models.Project;
import com.hva.helios.views.Views;

import javax.persistence.*;
import javax.swing.text.View;
import java.util.HashSet;
import java.util.Set;

/**
 * Class off skill to add to specialist object
 */
@Entity
@Table
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(Views.Public.class)
    private long id = 0L;

    @JsonView(Views.Public.class)
    private String name;

    @ManyToMany(fetch = FetchType.LAZY,
        cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
        },
        mappedBy = "skills")
    @JsonView(Views.Public.class)
    @JsonSerialize(using = Views.PublicSerializer.class)
    private Set<Project> projects = new HashSet<>();

    protected Skill() {}

    public Skill(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> project) {
        this.projects = project;
    }
}
