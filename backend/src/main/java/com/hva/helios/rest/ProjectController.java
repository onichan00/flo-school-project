package com.hva.helios.rest;

import com.hva.helios.exceptions.NotFoundException;
import com.hva.helios.models.Project;
import com.hva.helios.repositories.testRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4040", maxAge = 3600)
@RestController
@RequestMapping("projects")
public class ProjectController {

    @Autowired
    private testRepo projectRepository;

    @GetMapping("")
    public List<Project> getProject() {
        return projectRepository.findAll();
    }

    @PostMapping("")
    public Project addProject(@RequestBody Project project) {
        return projectRepository.save(project);
    }

    @GetMapping("{id}")
    public Project getProject(@PathVariable long id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Project could not be found"));

    }

    @DeleteMapping("{id}")
    public long deleteProject(@PathVariable long id) {
        System.out.println(id);
        Project project = getProject(id);
        projectRepository.delete(project);

        return id;
    }
}
