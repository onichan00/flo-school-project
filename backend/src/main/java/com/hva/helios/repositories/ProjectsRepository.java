package com.hva.helios.repositories;

import com.hva.helios.models.Project;
import com.hva.helios.models.Specialist;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProjectsRepository implements CrudRepository<Project> {

    Project project0, project1,  project2, project3;
    private ArrayList<Project> projects;

    public ProjectsRepository() {
        this.project0 = new Project("Minecraft", 0, LocalDate.now(), null, null);
        this.project1 = new Project("Fortnite", 0, LocalDate.now(), null, null);
        this.project2 = new Project("Shrek 4?", 0, LocalDate.now(), null, null);
        this.project3 = new Project("Minecraft 2?", 0, LocalDate.now(), null, null);

        this.projects = new ArrayList<>(List.of(project0, project1,  project2, project3));;
    }

    /**
     * Method to get and return all projects
     * @return - List of projects
     * @param items - list of projects
     */
    @Override
    public List<Project> getAll(List<Project> items) {
        return CrudRepository.super.getAll(items);
    }

    /**
     * @param item - Project to find by
     * @param items - List to find projects in
     * @return The projects that needs to be found
     */
    @Override
    public Project getByItem(Project item, List<Project> items) {
        return CrudRepository.super.getByItem(item, items);
    }

    /**
     * Method to save project
     * @param item - project to save
     * @return - Saved project
     */
    @Override
    public Project saveItem(Project item) {
        int index = projects.indexOf(item);

        // Check if the project already exists
        if (index == -1) {
            projects.add(item);
        } else {
            projects.set(index, item);
        }

        return item;
    }

    /**
     * Method to delete project with the same ID
     * @param id - ID of project to delete
     * @return - Deleted project
     */
    @Override
    public Project deleteById(int id) {
        // TODO: Fix the error
//        int index = projects.indexOf(new Project());
//
//        Project project = projects.get(id);
//
//        projects.remove(index);
//
        return null;
    }

    /**
     * Method to find and return specific project from list
     * @param id - ID of project to find
     * @return - project with given ID
     */
    @Override
    public Project getById(int id) {
        // TODO: Fix the error
//        Project project = new Project();
//
//        for (Project p : projects) {
//            if (p.equals(project)) project = p;
//        }
//
        return null;
    }
}
