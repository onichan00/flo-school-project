package com.hva.helios.rest;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.hva.helios.exceptions.NotFoundException;
import com.hva.helios.models.Project;
import com.hva.helios.models.user.Client;
import com.hva.helios.models.user.skill.Skill;
import com.hva.helios.repositories.EntityRepository;
import com.hva.helios.repositories.testRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4040", maxAge = 3600)
@RestController
@RequestMapping("projects")
public class ProjectController {

    @Autowired
    private testRepo projectRepository;

    @Autowired
    private EntityRepository<Client>  clientRepository;

//    @Autowired
//    private EntityRepository<Project>  projectRepository;

    @GetMapping("")
    public List<Project> getProject() {
        return projectRepository.findAll();
    }

    /**
     * Add Project to the BE
     * @param project = project to add
     * @return save project to the backend
     */
    @PostMapping("{client_id}")
    public Project addProject(@RequestBody Project project, @PathVariable long client_id) {
//        Client client = clientRepository.findById(project.get("client_id").asLong());

        //sets the properties of the Project object, including the name, client, status, date, and description of the project.
        Project project1 = new Project(
                        project.getName()
                        , project.getBannerUrl()
                        , project.getStatus()
                        , LocalDate.now()
                        , project.getDescription()
                        , clientRepository.findById(client_id)
                        , project.getSkills()
                );

        // Saves the Project object to the projectRepository and returns it.
        return projectRepository.save(project1);
    }

    @GetMapping("client/{client_id}")
    public List<Project> getProjectsByClientId(@PathVariable String client_id) {
        return projectRepository.findAllByClient(clientRepository.findById(Long.parseLong(client_id)));
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
