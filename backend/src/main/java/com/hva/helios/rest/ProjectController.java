package com.hva.helios.rest;

import com.hva.helios.models.Project;
import com.hva.helios.repositories.EntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("projects")
public class ProjectController {
    @Autowired
    private EntityRepository<Project> projectRepository;

    @GetMapping("")
    public List<Project> getProject() {
        return projectRepository.findAll();
    }

    @PostMapping("")
    public Project addProject(@RequestBody Project project) {
        return projectRepository.save(project);
    }

    @GetMapping("{id}")
    public Project getProject(@PathVariable int id) {
        Project project = projectRepository.findById(id);

        if (project == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Project not found"
            );
        }

        return projectRepository.findById(id);
    }

    @DeleteMapping("{id}")
    public Project deleteProject(@PathVariable int id) {
        return projectRepository.deleteById(id);
    }
}
