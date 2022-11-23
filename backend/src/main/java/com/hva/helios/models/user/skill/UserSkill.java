package com.hva.helios.models.user.skill;

import com.hva.helios.models.user.skill.Skill;

public class UserSkill {
    private int id;
    private String name;
    private int level;

    public UserSkill(Skill skill, int level) {
        this.id = skill.getId();
        this.name = skill.getName();
        this.level = level;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
