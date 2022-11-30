package com.hva.helios.models.user.skill;

import javax.persistence.*;

/**
 * Class off skill to add to specialist object
 */
@Entity
@Table
public class Skill {
    @Id
    @GeneratedValue
    private long id = 0L;
    private String name;

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
}
