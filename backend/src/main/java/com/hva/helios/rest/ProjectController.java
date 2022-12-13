package com.hva.helios.rest;

import com.hva.helios.exceptions.NotFoundException;
import com.hva.helios.models.Project;
import com.hva.helios.models.user.Client;
import com.hva.helios.repositories.EntityRepository;
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
    @PostMapping("")
    public Project addProject(@RequestBody ObjectNode project) {
        Client client = clientRepository.findById(project.get("client_id").asLong());

        //sets the properties of the Project object, including the name, client, status, date, and description of the project.
        Project project1 = new Project(
                project.get("name").asText()
                ,client
                ,project.get("status").asInt()
                ,LocalDate.now()
                ,project.get("description").asText()
        );

        //saves the Project object to the projectRepository and returns it.
        return projectRepository.save(project1);
    }

    @GetMapping("client/{client_id}")
    public List<Project> getProjectsByClient(@PathVariable String client_id) {
        List<Project> projects = new ArrayList<>();
        Client client = clientRepository.findById(Long.parseLong(client_id));

        for (Project project : getProject()) if (project.getClient().equals(client)) projects.add(project);

        return null;
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
