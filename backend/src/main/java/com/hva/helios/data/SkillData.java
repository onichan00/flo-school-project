package com.hva.helios.data;

import com.hva.helios.models.user.skill.Skill;
import com.hva.helios.models.user.skill.UserSkill;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SkillData {
    Random random = new Random();
    ArrayList<UserSkill> skills;

    Skill skill1 = new Skill(1, "Java");
    Skill skill2 = new Skill(2, "Dart");
    Skill skill3 = new Skill(3, "C++");
    Skill skill4 = new Skill(4, "Python");

    UserSkill userSkill1 = new UserSkill(skill1, random.nextInt(6));
    UserSkill userSkill2 = new UserSkill(skill2, random.nextInt(6));
    UserSkill userSkill3 = new UserSkill(skill3, random.nextInt(6));
    UserSkill userSkill4 = new UserSkill(skill4, random.nextInt(6));

    public SkillData() {
        this.skills = new ArrayList<>(List.of(userSkill1, userSkill2, userSkill3, userSkill4));
    }

    public ArrayList<UserSkill> getUserSkills() {
        return skills;
    }

    public ArrayList<Skill> getAvailableSkills() {
        return new ArrayList<>(List.of(skill1, skill2, skill3, skill4));
    }

    public ArrayList<UserSkill> getRandomSkills(int amount) {
        ArrayList<UserSkill> tempSkills = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            tempSkills.add(skills.get(random.nextInt(skills.size())));
        }

        return tempSkills;
    }
}
