package com.hva.helios.models.user.skill;

import com.fasterxml.jackson.annotation.JsonView;
import com.hva.helios.models.user.Specialist;
import com.hva.helios.models.user.skill.Skill;
import com.hva.helios.views.Views;

import javax.persistence.*;

@Entity
@Table
public class UserSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(Views.Public.class)
    private long id = 0L;

    @JsonView(Views.Public.class)
    private int level;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonView(Views.Public.class)
    private Skill skill;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonView(Views.Internal.class)
    private Specialist specialist;

    protected UserSkill() {}

    public UserSkill(Skill skill, int level, Specialist specialist) {
        this.skill = skill;
        this.level = level;
        this.specialist = specialist;
    }

    public boolean associateSpecialist(Specialist specialist) {
        if (specialist != null && this.getSpecialist() == null) {
            setSpecialist(specialist);
            specialist.associateUserSkill(this);

            return true;
        }

        return false;
    }

    public boolean dissociateSpecialist(Specialist specialist) {
        if (specialist != null && getSpecialist() != null) {
            setSpecialist(null);
            return specialist.dissociateUserSkill(this);
        }

        return false;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Specialist getSpecialist() {
        return specialist;
    }

    public void setSpecialist(Specialist specialist) {
        this.specialist = specialist;
    }
}
