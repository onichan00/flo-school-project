package com.hva.helios.controllers;

import com.hva.helios.models.Project;
import com.hva.helios.models.User;
import com.hva.helios.repositories.ProjectJPARepository;
import com.hva.helios.rest.ProjectController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ComponentScan({"com.hva.helios.rest", "com.hva.helios.repositories"})
public class ProjectControllerTests {
    @Autowired
    private ProjectJPARepository projectRepo;

    @Autowired
    private ProjectController projectController;

    private Project project;

/*    @AfterEach
    public void tearDown() {
        projectRepo.deleteAll();
    }*/

    @BeforeEach
    public void setup() {
        User user = new User("test@gmail.com", "password123", "ilias", " ", "Aachboun", null, "Test bio", "0612345678", "Utrecht", "3242TP", "testStraat", 0L);
        project = new Project("Project 2", "Image", 1, new Date(), "Test description");


        projectRepo.save(project);
    }

    @Test
    public void getProjectById() {
        Project retrievedProject = projectController.getProject(project.getId());

        assertEquals(project.getId(), retrievedProject.getId());
    }

    @Test
    public void createProject() {
        Project newProject = new Project("New project", "testUrl", 2, new Date(), "Test description");
        projectRepo.save(project);

        assertEquals(project.getId(), this.project.getId(), "A new project has been made");

    }

    @Test
    public void updateProject() {
        project.setDescription("New type of description");

        assertNotEquals(project.getDescription(), "Test description", "The project description are not the same as one of them has been changed");
    }

}
