package com.hva.helios.data;

import com.hva.helios.models.Project;
import com.hva.helios.models.user.Specialist;
import com.hva.helios.models.user.skill.UserSkill;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProjectData {
    Random random = new Random();
    ArrayList<Project> projects;

    Project project1 = new Project("Project 1", 0, LocalDate.now());
    Project project2 = new Project("Project 2", 1, LocalDate.now());
    Project project3 = new Project("Project 3", 0, LocalDate.now());
    Project project4 = new Project("Project 4", 2, LocalDate.now());

    public ProjectData() {
        this.projects = new ArrayList<>(List.of(project1, project2, project3, project4));
    }

    public ArrayList<Project> getProjects() {
        return projects;
    }

    public ArrayList<Project> getRandomProjects(int amount) {
        ArrayList<Project> tempProjects = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            tempProjects.add(projects.get(random.nextInt(projects.size())));
        }

        return tempProjects;
    }
}
