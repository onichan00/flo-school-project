package com.hva.helios.data;

import com.hva.helios.models.user.skill.Skill;
import com.hva.helios.models.user.skill.UserSkill;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SkillData {
    Random random = new Random();
    ArrayList<UserSkill> skills;

    Skill skill1 = new Skill("Java");
    Skill skill2 = new Skill("Dart");
    Skill skill3 = new Skill("C++");
    Skill skill4 = new Skill("Python");
    Skill skill5 = new Skill("Typescript");

    UserSkill userSkill1 = new UserSkill(skill1, random.nextInt(5));
    UserSkill userSkill2 = new UserSkill(skill2, random.nextInt(5));
    UserSkill userSkill3 = new UserSkill(skill3, random.nextInt(5));
    UserSkill userSkill4 = new UserSkill(skill4, random.nextInt(5));
    UserSkill userSkill5 = new UserSkill(skill5, random.nextInt(5));

    public SkillData() {
        this.skills = new ArrayList<>(List.of(userSkill1, userSkill2, userSkill3, userSkill4, userSkill5));
    }

    public ArrayList<UserSkill> getUserSkills() {
        return skills;
    }

    public ArrayList<Skill> getAvailableSkills() {
        return new ArrayList<>(List.of(skill1, skill2, skill3, skill4, skill5));
    }

    public ArrayList<UserSkill> getRandomSkills(int amount) {
        ArrayList<UserSkill> tempSkills = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            tempSkills.add(skills.get(random.nextInt(skills.size())));
        }

        return tempSkills;
    }
}
