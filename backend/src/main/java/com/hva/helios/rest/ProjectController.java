package com.hva.helios.rest;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.hva.helios.exceptions.NotFoundException;
import com.hva.helios.models.Project;
import com.hva.helios.models.user.Client;
import com.hva.helios.repositories.EntityRepository;
import com.hva.helios.repositories.testRepo;
import com.hva.helios.repositories.user.ClientJPARepository;
import com.hva.helios.repositories.user.UserJPARepository;
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
    private ClientJPARepository clientRepository;

//    @Autowired
//    private UserJPARepository clientRepository;

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
    public Project addProject(@RequestBody Project project, @RequestParam long clientId) {
        // finding the necessary user bt its id gotten from the request parameter( which is declared as ?clientId = this.userId in the postrequest, see frontend
        Client client = clientRepository.findById(clientId);

        // check if the client is even found
        if (client == null){
            throw new NotFoundException("Client could not be found");
        }

        // set the found client to the client of the project that has been created in the parameters with @RequestBody
        project.setClient(client);

        // set the data to now since the project just got created
        project.setCreated(LocalDate.now());

        // Saves the Project object to the projectRepository and returns it.
        return projectRepository.save(project);
    }

    @GetMapping("client/{client_id}")
    public List<Project> getProjectsByClient(@PathVariable String client_id) {
//        List<Project> projects = new ArrayList<>();
        Client client = clientRepository.findClientByUserId(Long.parseLong(client_id));
//
//        for (Project project : getProject()) if (project.getClient().equals(client)) projects.add(project);
//

        return projectRepository.findAllByClient(client);
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
