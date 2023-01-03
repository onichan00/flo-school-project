package com.hva.helios.rest;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.hva.helios.exceptions.NotFoundException;
import com.hva.helios.models.Project;
import com.hva.helios.models.User;
import com.hva.helios.repositories.interfaces.testRepo;
import com.hva.helios.repositories.interfaces.jpa.UserJPARepository;
import com.hva.helios.views.Views;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4040", maxAge = 3600)
@RestController
@RequestMapping("projects")
public class ProjectController {

    @Autowired
    private testRepo projectRepository;

    @Autowired
    private UserJPARepository userRepository;

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
        User user = userRepository.findById(clientId).orElseThrow(() -> new NotFoundException("user not found"));

        // check if the client is even found
        if (user == null){
            throw new NotFoundException("Client could not be found");
        }

        // set the found client to the client of the project that has been created in the parameters with @RequestBody
        project.setUser(user);

        // set the data to now since the project just got created
        project.setCreated(new Date());

        // Saves the Project object to the projectRepository and returns it.
        return projectRepository.save(project);
    }

    @GetMapping("client/{client_id}")
    public List<Project> getProjectsByClient(@PathVariable long client_id) {
//        List<Project> projects = new ArrayList<>();

        User user = userRepository.findById(client_id)
                .orElseThrow(() -> new NotFoundException("user could not be found"));
//
//        for (Project project : getProject()) if (project.getClient().equals(client)) projects.add(project);
//

        return projectRepository.findAllByUser(user);
    }

    @GetMapping("{id}")
    @JsonView(Views.Internal.class)
    public Project getProject(@PathVariable long id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Project could not be found"));
    }

    @DeleteMapping("{id}")
    @JsonView(Views.Public.class)
    public long deleteProject(@PathVariable long id) {
        System.out.println(id);
        Project project = getProject(id);
        projectRepository.delete(project);

        return id;
    }

    @PostMapping("{id}/specialist")
    @JsonView(Views.Public.class)
    public Project addSpecialistToProject(@PathVariable long id, @RequestBody ObjectNode toAddUser) {
        Project project = projectRepository.findById(id).orElse(null);
        User user = userRepository.findById(toAddUser.get("id").asLong()).orElse(null);

        if (project == null) {
            throw new NotFoundException(String.format("Project with ID: %d was not found", id));
        }

        if (user == null) {
            throw new NotFoundException(String.format("User with ID: %d was not found", toAddUser.get("id").asLong()));
        }

        System.out.println(user);

        project.addSpecialist(user.getSpecialist());
//        user.getSpecialist().addProject(project);

        projectRepository.save(project);

        return project;
    }
}
