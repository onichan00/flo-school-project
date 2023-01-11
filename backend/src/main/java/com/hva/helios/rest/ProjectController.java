package com.hva.helios.rest;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.hva.helios.exceptions.NotFoundException;
import com.hva.helios.exceptions.PreConditionFailed;
import com.hva.helios.models.Project;
import com.hva.helios.models.User;
import com.hva.helios.models.user.Specialist;
import com.hva.helios.models.user.skill.Skill;
import com.hva.helios.repositories.ProjectJPARepository;
import com.hva.helios.repositories.interfaces.jpa.SpecialistJPARepository;
import com.hva.helios.repositories.interfaces.testRepo;
import com.hva.helios.repositories.interfaces.jpa.UserJPARepository;
import com.hva.helios.views.Views;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4040", maxAge = 3600)
@RestController
@RequestMapping("projects")
public class ProjectController {

    @Autowired
    private testRepo testRepository;

    @Autowired
    private ProjectJPARepository projectRepository;

    @Autowired
    private UserJPARepository userRepository;

    @Autowired
    private SpecialistJPARepository specialistRepository;


    @GetMapping("")
    public List<Project> getProject() {
        return testRepository.findAll();
    }

    /**
     * Add Project to the BE
     *
     * @param project = project to add
     * @return save project to the backend
     */
    @PostMapping("")
    public Project addProject(@RequestBody Project project, @RequestParam long clientId) {
        // finding the necessary user bt its id gotten from the request parameter( which is declared as ?clientId = this.userId in the postrequest, see frontend
        User user = userRepository.findById(clientId).orElseThrow(() -> new NotFoundException("user not found"));

        // check if the client is even found
        if (user == null) {
            throw new NotFoundException("Client could not be found");
        }

        // set the found client to the client of the project that has been created in the parameters with @RequestBody
        project.setUser(user);

        // set the data to now since the project just got created
        project.setCreated(new Date());

        // Saves the Project object to the testRepository and returns it.
        return testRepository.save(project);
    }

    @GetMapping("client/{client_id}")
    public List<Project> getProjectsByClient(@PathVariable long client_id) {
//        List<Project> projects = new ArrayList<>();

        User user = userRepository.findById(client_id)
                .orElseThrow(() -> new NotFoundException("user could not be found"));
//
//        for (Project project : getProject()) if (project.getClient().equals(client)) projects.add(project);
//

        return testRepository.findAllByUser(user);
    }

    /**
     * @return Map containing data for the dashboard view
     */
    @GetMapping("dashboard")
    public Map<String, Object> getDashboardData() {
        // Create a map to store the dashboard data
        Map<String, Object> dashboardData = new HashMap<>();

        // Add the data to the dashboard map
        dashboardData.put("mostRecentProjects", projectRepository.getMostRecentProjects());
        dashboardData.put("compareProjectData", projectRepository.compareProjectData());
        dashboardData.put("projectCountByDay", projectRepository.getProjectCountByDay());
        dashboardData.put("totalOfEverything", getTotalOfEverything());
        dashboardData.put("notApprovedSpecialists", getNotApprovedSpecialists());

        // Return the dashboard data map
        return dashboardData;
    }


    /**
     * Returns a map containing the total number of projects, clients, and specialists in the system.
     *
     * @return Map containing the total number of projects, clients, and specialists
     */
    public Map<String, Integer> getTotalOfEverything() {
        // Find the total number of projects
        int numOfProjects = projectRepository.findAll().size();

        // Find the total number of clients
        int numOfClients = (int) userRepository
                .findAll()
                .stream()
                .filter(user -> user.getUserType() == 1)
                .toList()
                .size();

        // Find the total number of specialists
        int numOfSpecialists = (int) userRepository
                .findAll()
                .stream()
                .filter(user -> user.getUserType() == 2)
                .toList()
                .size();

        // Find the total number of Admins
        int numOfAdmins = (int) userRepository
                .findAll()
                .stream()
                .filter(user -> user.getUserType() == 0)
                .toList()
                .size();


        // Create a map to store the totals
        Map<String, Integer> totalOfEverything = new HashMap<>();
        totalOfEverything.put("numOfProjects", numOfProjects);
        totalOfEverything.put("numOfClients", numOfClients);
        totalOfEverything.put("numOfSpecialists", numOfSpecialists);
        totalOfEverything.put("numOfAdmins", numOfAdmins);

        // Return the map
        return totalOfEverything;
    }

    public List<User> getNotApprovedSpecialists() {
        // Get a list of not approved specialists
        return userRepository
                .findAll()
                .stream()
                .filter(specialist -> specialist.getUserType() == 2)
                .toList()
                .stream()
                .filter(specialist -> specialist.getSpecialist() != null
                        && specialist.getSpecialist().getApprovalStatus() == 2)
                .toList();
    }

    @GetMapping("{id}")
    @JsonView(Views.Internal.class)
    public Project getProject(@PathVariable long id) {
        return testRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Project could not be found"));
    }

    @GetMapping("specialist/{id}")
    @JsonView(Views.Internal.class)
    public List<Project> getProjectsBySpecialist(@PathVariable long id) {

        // this version is made in case we decide to use the user id that is stored in the session to find the specific specialist
        var specialistFromUserId = userRepository.findAll().stream()
                .filter(user -> user.getUserType() == 2 && user.getId() == id)
                .map(user -> user.getSpecialist())
                .findFirst()
                .orElseThrow(() -> new NotFoundException("no specialist found"));

        return testRepository.findAll()
                .stream()
                .filter(project -> project.getSpecialists().contains(specialistFromUserId))
                .collect(Collectors.toList());

//        // this version is used if we decide to use th specific specialist id
//        var specialist = specialistRepository.getSpecialistById(id);
//
//        return testRepository.findAll()
//                .stream()
//                .filter(project -> project.getSpecialists().contains(specialist))
//                .collect(Collectors.toList());


        // this version is made in case streams didnt work, its an elementary version of the above
//        var projects = testRepository.findAll();
//
//        var AllProjects = new ArrayList<Project>();
//
//        for (Project project : projects) {
//            if (project.getSpecialists().contains(specialist)){
//                AllProjects.add(project);
//            }
//        }
//
//        return AllProjects;

//        return testRepository.findAllBySpecialist(userId);

    }

    @DeleteMapping("{id}")
    @JsonView(Views.Public.class)
    public long deleteProject(@PathVariable long id) {
        System.out.println(id);
        Project project = getProject(id);
        testRepository.delete(project);

        return id;
    }

    @PutMapping("{id}")
    public Project updateProject(@PathVariable long id, @RequestBody Project toMergeProject) {
        Project project = testRepository.findById(id).orElse(null);

        if (project == null) {
            throw new NotFoundException(String.format("Project with ID: %d was not found", id));
        }

        if (!Objects.equals(project.getId(), toMergeProject.getId())) {
            throw new PreConditionFailed(String.format("Project with ID: %d does not match parameter ID: %d", project.getId(), id));
        }

        return testRepository.save(toMergeProject);
    }

    @PostMapping("{id}/specialist")
    @JsonView(Views.Public.class)
    public Project addSpecialistToProject(@PathVariable long id, @RequestBody ObjectNode toAddUser) {
        Project project = testRepository.findById(id).orElse(null);
        User user = userRepository.findById(toAddUser.get("id").asLong()).orElse(null);

        if (project == null) {
            throw new NotFoundException(String.format("Project with ID: %d was not found", id));
        }

        if (user == null) {
            throw new NotFoundException(String.format("User with ID: %d was not found", toAddUser.get("id").asLong()));
        }

        Set<Specialist> specialists = project.getSpecialists();
        Specialist specialist = user.getSpecialist();

        if (specialists.contains(specialist)) {
            project.removeSpecialist(specialist);
        } else {
            project.addSpecialist(specialist);
        }

        testRepository.save(project);

        return project;
    }

    @PostMapping("{id}/skills")
    @JsonView(Views.Public.class)
    public Project addSkillToProject(@PathVariable long id, @RequestBody Skill skill) {
        Project project = testRepository.findById(id).orElse(null);

        if (project == null) {
            throw new NotFoundException(String.format("Project with ID: %d was not found", id));
        }

        List<Skill> skills = project.getSkills();

        if (skills.contains(skill)) {
            project.removeSkill(skill);
        } else {
            project.addSkill(skill);
        }

        testRepository.save(project);

        return project;
    }
}
