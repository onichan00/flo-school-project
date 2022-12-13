package com.hva.helios.models.user.skill;

import com.hva.helios.models.user.Specialist;
import com.hva.helios.models.user.skill.Skill;

import javax.persistence.*;

@Entity
@Table
public class UserSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id = 0L;
    private int level;
    @ManyToOne(cascade = CascadeType.ALL)
    private Skill skill;

    @ManyToOne
    private Specialist specialist;

    protected UserSkill() {}

    public UserSkill(Skill skill, int level, Specialist specialist) {
        this.skill = skill;
        this.level = level;
        this.specialist = specialist;
    }

    public long getId() {
        return id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }
}
