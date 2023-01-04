package com.hva.helios.data;

import com.hva.helios.models.Project;
//import com.hva.helios.models.user.Specialist;
//import com.hva.helios.models.user.skill.Skill;
//import com.hva.helios.models.user.skill.UserSkill;
//import com.hva.helios.repositories.interfaces.jpa.SpecialistJPARepository;
//import com.hva.helios.rest.UserController;
//import com.hva.helios.rest.user.SpecialistController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class ProjectData {
    Random random = new Random();
    ArrayList<Project> projects;

    String bannerImage = "https://images.unsplash.com/photo-1614850715649-1d0106293bd1?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2340&q=80";
    String bannerImage2 = "https://images.unsplash.com/photo-1608597003542-9d831d8d6ff4?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2340&q=80";

    Project project1 = new Project("Project 1", bannerImage, 0, new Date(), "Test description");
    Project project2 = new Project("Project 2", bannerImage2, 1, new Date(), "Test description");
    Project project3 = new Project("Project 3", bannerImage, 0, new Date(), "Test description");
    Project project4 = new Project("Project 4", bannerImage2, 2, new Date(), "Test description");

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
