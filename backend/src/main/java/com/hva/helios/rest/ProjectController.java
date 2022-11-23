package com.hva.helios.rest;

import com.hva.helios.exceptions.NotFoundException;
import com.hva.helios.models.Project;
import com.hva.helios.repositories.ProjectsRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 * Project controller for the Projects Repository
 * @author Simon Vriesema
 */
@RestController
@RequestMapping("/projects")
public class ProjectController {
    private final ProjectsRepository PROJECT_REPO;

    public ProjectController(ProjectsRepository PROJECT_REPO){
        this.PROJECT_REPO = PROJECT_REPO;
    }

    @GetMapping("")
    public List<Project> getAll() {
        return PROJECT_REPO.getAll(PROJECT_REPO.getProjects());
    }

    /**
     * Get project by id
     * @param id - id of the project
     * @return - the project
     */
    @GetMapping(path = "{id}", produces = "application/json")
    public Project getProject(@PathVariable int id) {
        Project project = PROJECT_REPO.getByItem(new Project(id), PROJECT_REPO.getProjects());

        if (project == null) throw new NotFoundException(String.format("No project found with id: %d", id));

        return project;
    }

    /**
     * Save project
     * @param project - project that needs to be saved
     * @return - the project that is saved
     */
    @PostMapping("")
    public Project saveProject(@RequestBody Project project) {
        Project item = PROJECT_REPO.saveItem(project);

        URI location = ServletUriComponentsBuilder.
                fromCurrentRequest().path("/{id}")
                .buildAndExpand(item.getId()).toUri();

        return ResponseEntity.created(location).body(project).getBody();
    }

    /**
     * Delete project
      * @param id - id of project that has to be deleted
     * @return - the project that is deleted
     */
    @DeleteMapping(path = "{id}", produces = "application/json")
    public Project deleteProject(@PathVariable int id) {
        Project item = PROJECT_REPO.deleteById(id);

        if (item == null) throw new NotFoundException(String.format("No project found with id: %d", id));

        return ResponseEntity.ok(item).getBody();
    }
}
