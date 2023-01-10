package com.hva.helios.rest;

import com.fasterxml.jackson.annotation.JsonView;
import com.hva.helios.APIConfig;
import com.hva.helios.models.JWToken;
import com.hva.helios.models.record.LoginBody;
import com.hva.helios.models.record.LoginResponse;
import com.hva.helios.models.user.*;
import com.hva.helios.exceptions.NotFoundException;
import com.hva.helios.models.User;
import com.hva.helios.models.user.skill.UserSkill;
import com.hva.helios.repositories.ProjectJPARepository;
import com.hva.helios.repositories.interfaces.jpa.AdminJPARepository;
import com.hva.helios.repositories.interfaces.jpa.ClientJPARepository;
import com.hva.helios.repositories.interfaces.jpa.SpecialistJPARepository;
import com.hva.helios.repositories.interfaces.jpa.UserJPARepository;
import com.hva.helios.repositories.user.UserSkillJPARepository;
import com.hva.helios.views.Views;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.*;
import java.util.stream.Collectors;

//@CrossOrigin(origins = *, maxAge = 3600)
@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    private AdminJPARepository adminRepository;

    @Autowired
    private APIConfig apiConfig;
    //
    @Autowired
    private ClientJPARepository clientRepository;
    //
    @Autowired
    private SpecialistJPARepository specialistRepository;
    //
    @Autowired
    private UserJPARepository userRepository;

    @Autowired
    private UserSkillJPARepository userSkillRepo;

    @Autowired
    private ProjectJPARepository projectJPARepository;

    // TODO: uncomment this when jwt implemented on frontend
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<String> deleteUserById(@PathVariable long id, @RequestAttribute(name = JWToken.KEY) JWToken jwToken) {
//
//        // check if the user is a admin before deleting the user
//        if (jwToken == null ||  jwToken.getUserType() != 0){
//            return ResponseEntity.badRequest()
//                    .body("youre not authorized to delete this user");
//
//        }
//
//        userRepository.deleteById(id);
//
//        return ResponseEntity.ok()
//                .body("successfully deleted user: " + id);
//
//    }

    @DeleteMapping("/delete/{id}")
    public void deleteUserById(@PathVariable long id) {
        userRepository.deleteById(id);
    }

    @PutMapping("/update")
    public User updateUser(@RequestBody User user) {
        // save attributes that get used multiple times
        Long userType = user.getUserType();
        Long id = user.getId();

        // we get the old user from JPA
        // im not sure if we need to put this inside of the if statements each time or not but for now this works
        User oUser = userRepository.findById(id).orElseThrow(() -> new NotFoundException("user not found"));

        System.out.println(oUser);

        oUser.setEmail(user.getEmail());

        oUser.setFirst_name(user.getFirst_name());
        oUser.setSecond_name(user.getSecond_name());
        oUser.setLast_name(user.getLast_name());

        oUser.setCity(user.getCity());
        oUser.setZipCode(user.getZipCode());
        oUser.setAddress(user.getAddress());
        oUser.setBio(user.getBio());
        oUser.setPhone(user.getPhone());
        oUser.setPassword(user.getPassword());
        oUser.setPhoto(user.getPhoto());

        if (userType == 0) {
            return userRepository.save(oUser);
        }

        if (userType == 1) {
            Client client = oUser.getClient();
            client.setWebsite(client.getWebsite());

            oUser.setClient(client);

            return userRepository.save(oUser);
        }

        if (userType == 2) {
            Specialist specialist = oUser.getSpecialist();
            specialist.setSpecialistType(specialist.getSpecialistType());

            oUser.setSpecialist(specialist);

            return userRepository.save(oUser);
        }

        throw new NotFoundException("User not found!");
    }

    @GetMapping("")
    public List<User> getAllUsers() {
//        Map<String, List<? extends User>> users = new HashMap<>();

//        users.put("client", clientRepository.findAll());
//        users.put("admin", adminRepository.findAll());
//        users.put("specialist", specialistRepository.findAll());

//        Map<String, List<? extends User>> users = new HashMap<>(userRepository.findAll());
//
//        return users;
        return userRepository.findAll();
    }

    @GetMapping("admins")
    public List<User> getAllAdmins() {
        return userRepository
                .findAll()
                .stream()
                .filter(user -> user.getUserType() == 0)
                .collect(Collectors.toList());
    }

    /**
     * Handles a GET request to retrieve all specialists.
     *
     * @return a list of all specialists in the database
     */
    @GetMapping("specialists")
    public List<User> getAllSpecialists() {
        // Retrieve all users from the database
        List<User> users = userRepository.findAll();
        // Filter the list to include only specialists (users with user type 2)
        // Return the list of specialists
        return users.stream()
                .filter(user -> user.getUserType() == 2)
                .collect(Collectors.toList());
    }

    @GetMapping("specialists-not-accepted")
    public List<User> getNotAcceptedSpecialists() {
        return getAllSpecialists()
                .stream()
                .filter(specialists -> specialists.getSpecialist().getApprovalStatus() == 0)
                .collect(Collectors.toList());
    }

    @GetMapping("clients")
    public List<User> getAllClients() {
        return userRepository
                .findAll()
                .stream()
                .filter(user -> user.getUserType() == 1)
                .collect(Collectors.toList());
    }

    /**
     * Handles a GET request to check if an email is already in use.
     *
     * @param email the email to check
     * @return a bad request response if the email is already in use, or an OK response if it is not
     */
    @GetMapping("check-email/{email}")
    public ResponseEntity<Void> checkEmail(@PathVariable String email) {
        // Check if a user with the specified email exists in the database
        if (userRepository.findByEmail(email) != null) {
            // If a user with the email exists, return a bad request response
            return ResponseEntity.badRequest().build();
        }
        // If a user with the email does not exist, return an OK response
        return ResponseEntity.ok().build();
    }

    /**
     * Returns a list of all specialists who are assigned to a project with the given id.
     *
     * @param id the id of the project
     * @return a list of specialists assigned to the project with the given id
     */
    @GetMapping("specialists/{id}")
    public List<User> getAllSpecialistsFromProject(@PathVariable long id) {
        // Get all specialists
        List<User> specialists = this.getAllSpecialists();

        // Filter the specialists to only include those who are assigned to a project with the given id
        return specialists.stream()
                .filter(user -> user.getSpecialist().getProjects()
                        .stream()
                        .anyMatch(project -> project.getId() == id))
                .collect(Collectors.toList());
    }

    /**
     * Get a single Client user
     * @param id user id of Client selected in frontend
     * @return Client with chosen ID
     */
    @GetMapping("clients/{id}")
    public ResponseEntity<User> getClientById(
            @PathVariable long id) {
        User client = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Client with ID %d could not be found", id)));

        return ResponseEntity.ok()
                .body(client);
    }

    /**
     * Create a new Client-type user
     */
    @PostMapping("clients")
    public ResponseEntity<Client> addClient(
            @RequestBody Client client) {

        return null;
    }

    @GetMapping("count")
    public long countUsers() {
        int amount = 0;
//
//        amount += clientRepository.findAll().size();
//        amount += adminRepository.findAll().size();
//        amount += specialistRepository.findAll().size();

        return userRepository.count();

//        return amount;
    }

    @GetMapping("{id}")
    @JsonView(Views.Internal.class)
    public User getUserById(@PathVariable long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("User with ID: %d could not be found", id)));
    }

    //TODO: remove from here because its inside the AuthorizationController.java allready for jwt
    // left it just in case
    @PostMapping("login")
    public LoginResponse login(@RequestBody LoginBody loginBody) {
        User user = userRepository.findByEmail(loginBody.email());

        JWToken jwToken = new JWToken(user.getFirst_name()+user.getSecond_name()+user.getLast_name(), user.getId(), user.getUserType());
        String tokenString = jwToken.encode(this.apiConfig.getIssuer(),
                this.apiConfig.getPassphrase(), this.apiConfig.getTokenDurationOfValidity(), user.getUserType());


        if (!user.getPassword().equals(loginBody.password())) {
            return new LoginResponse(-1L, -1L, user.getSpecialist().getApprovalStatus());

        }

        return new LoginResponse(user.getId(), user.getUserType(), user.getSpecialist().getApprovalStatus());
    }

    //TODO: remove from here because its inside the AuthorizationController.java allready for jwt
    // left it just in case

    @PostMapping("register")
    public User register(@RequestBody User user) {
        // email unique check
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new NotFoundException("user with this email already exists");
        }

        System.out.println("sout" + user.getPhone());
        System.out.println(user);
        Long userType = user.getUserType();

        if (userType == 0) {
            Admin admin = new Admin();
            Admin savedAdmin = adminRepository.save(admin);
            user.setAdmin(savedAdmin);
            User nUser = userRepository.save(user);
//            return new LoginResponse(nUser.getId(), nUser.getUserType());
            return nUser;

        }

        if (userType == 1) {
            Client savedClient;
            if (user.getClient() != null) {
                savedClient = clientRepository.save(user.getClient());

            } else {
                savedClient = clientRepository.save(new Client());
            }
            user.setClient(savedClient);
            User newUser = userRepository.save(user);

//            return new LoginResponse(newUser.getId(), newUser.getUserType());
            return newUser;
        }

        // TODO: convert objects from the json to the correct type and set them to the specialists before setting the specialist in the user and saving the user
        // TODO: TLDR its not functional yet
        if (userType == 2) {
            Specialist savedSpecialist;

            if (user.getSpecialist() != null){
                savedSpecialist = specialistRepository.save(user.getSpecialist());
            } else {
                savedSpecialist = specialistRepository.save(user.getSpecialist());
            }

            user.setSpecialist(savedSpecialist);

            User newUser = userRepository.save(user);

//            return new LoginResponse(newUser.getId(), newUser.getUserType());
            return newUser;
        }

        throw new NotFoundException("register failed");
    }

    /**
     * Add a new skill to a user's specialist profile.
     * @param userSkill The new skill to add to the user's specialist profile
     * @param userId The id of the user whose specialist profile will have the new skill added
     * @return The updated user object
     * @throws NotFoundException If the user with the specified ID is not found
     */
    @PostMapping("/specialist/{userId}/skill")
    public Set<UserSkill> addUserSkill(@RequestBody UserSkill userSkill, @PathVariable long userId) {
        User user = userRepository.findById(userId).orElse(null);

        if (user == null) {
            throw new NotFoundException(String.format("The user with ID: %d was not found", userId));
        }

        userSkill = userSkillRepo.save(userSkill);
        user.getSpecialist().associateUserSkill(userSkill);
        user = userRepository.save(user);

        return user.getSpecialist().getSkills();
    }

    /**
     * Update a skill in a specialist profile
     * @param userId The ID of the user whose specialist profile will have the skill updated
     * @param userSkill The updated skill to be saved to the user's specialist profile
     * @return The updated user object
     * @throws NotFoundException If the user with the specified ID is not found
     */
    @PatchMapping("/specialist/{userId}/skill")
    public Set<UserSkill> updateUserSkill(@PathVariable long userId, @RequestBody UserSkill userSkill) {
        User user = userRepository.findById(userId).orElse(null);

        if (user == null) {
            throw new NotFoundException(String.format("The user with ID: %d was not found", userId));
        }

        userSkill.setSpecialist(user.getSpecialist());
        userSkillRepo.save(userSkill);

        return user.getSpecialist().getSkills();
    }

    /**
     * Delete a skill from a specialist
     *
     * @param userId The ID of the user whose specialist profile will have the skill deleted
     * @param skillId The ID of the skill that will be deleted
     * @return The updated user object
     * @throws NotFoundException If the user with the specified ID is not found
     */
    @DeleteMapping("/specialist/{userId}/skill/{skillId}")
    public Set<UserSkill> deleteUserSkill(@PathVariable long userId, @PathVariable long skillId) {
        User user = userRepository.findById(userId).orElse(null);
        UserSkill userSkill = userSkillRepo.findById(skillId);

        if (user == null) {
            throw new NotFoundException(String.format("The user with ID: %d was not found", userId));
        }

        userSkill.dissociateSpecialist(user.getSpecialist());
        userSkillRepo.deleteById(skillId);

        return user.getSpecialist().getSkills();
    }

    /**
     * Get all Specialists with an approval status of 'pending' (2)
     */
    @GetMapping("/specialists/applications")
    public List<User> getAllApplications() {
        return this.getAllSpecialists()
                .stream()
                .filter(user -> user.getSpecialist().getApprovalStatus() == 2)
                .collect(Collectors.toList());
    }

    /**
     * Updates only the approval status of a Specialist
     * @param id Specialist's user ID
     * @param specialist basically just the updated approval status
     * @return updated Specialist and HTTP status
     */
    @PutMapping("/specialists/applications/{id}")
    public ResponseEntity<Specialist> updateApplication(
            @PathVariable("id") long id,
            @RequestBody Specialist specialist) {
        Specialist specialistToUpdate = specialistRepository.getSpecialistById(id);

        specialistToUpdate.setApprovalStatus(specialist.getApprovalStatus());
        specialistRepository.save(specialistToUpdate);

        HttpHeaders headers = new HttpHeaders();
        headers.add(
                "Location",
                ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .toUriString()
        );
        return new ResponseEntity<>(specialistToUpdate, headers, HttpStatus.OK);
    }
}
