package com.hva.helios.rest;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hva.helios.models.record.LoginBody;
import com.hva.helios.models.record.LoginResponse;
import com.hva.helios.models.user.*;
import com.hva.helios.exceptions.NotFoundException;
import com.hva.helios.models.User;
import com.hva.helios.models.user.skill.UserSkill;
import com.hva.helios.repositories.interfaces.jpa.AdminJPARepository;
import com.hva.helios.repositories.interfaces.jpa.ClientJPARepository;
import com.hva.helios.repositories.interfaces.jpa.SpecialistJPARepository;
import com.hva.helios.repositories.interfaces.jpa.UserJPARepository;
import com.hva.helios.repositories.user.UserSkillJPARepository;
import com.hva.helios.views.Views;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

//@CrossOrigin(origins = *, maxAge = 3600)
@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    private AdminJPARepository adminRepository;
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

        oUser.setFirst_name(user.getFirst_name());
        oUser.setSecond_name(user.getSecond_name());
        oUser.setLast_name(user.getLast_name());
        oUser.setEmail(user.getEmail());
        oUser.setPhone(user.getPhone());
        oUser.setPassword(user.getPassword());

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
        return userRepository.findAll().stream().filter(user -> user.getUserType() == 0).collect(Collectors.toList());
    }

    @GetMapping("specialists")
    public List<User> getAllSpecialists() {
        return userRepository
                .findAll()
                .stream()
                .filter(user -> user.getUserType() == 2)
                .collect(Collectors.toList());
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


    @GetMapping("clients")
    public List<User> getAllClients() {
        return userRepository.findAll().stream().filter(user -> user.getUserType() == 1).collect(Collectors.toList());
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

    @PostMapping("login")
    public LoginResponse login(@RequestBody LoginBody loginBody) {
        User user = userRepository.findByEmail(loginBody.email());

        if (user.getPassword().equals(loginBody.password())) {
            return new LoginResponse(user.getId(), user.getUserType());
        }
        return new LoginResponse(-1L, -1);

    }

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
                savedSpecialist = specialistRepository.save(new Specialist());
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
    public User addUserSkill(@RequestBody UserSkill userSkill, @PathVariable long userId) {
        User user = userRepository.findById(userId).orElse(null);

        if (user == null) {
            throw new NotFoundException(String.format("The user with ID: %d was not found", userId));
        }

        userSkill = userSkillRepo.save(userSkill);
        user.getSpecialist().associateUserSkill(userSkill);

        return userRepository.save(user);
    }

    /**
     * Update a skill in a specialist profile
     * @param userId The ID of the user whose specialist profile will have the skill updated
     * @param userSkill The updated skill to be saved to the user's specialist profile
     * @return The updated user object
     * @throws NotFoundException If the user with the specified ID is not found
     */
    @PatchMapping("/specialist/{userId}/skill")
    public User updateUserSkill(@PathVariable long userId, @RequestBody UserSkill userSkill) {
        User user = userRepository.findById(userId).orElse(null);

        if (user == null) {
            throw new NotFoundException(String.format("The user with ID: %d was not found", userId));
        }

        userSkillRepo.save(userSkill);

        return user;
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
    public User deleteUserSkill(@PathVariable long userId, @PathVariable long skillId) {
        User user = userRepository.findById(userId).orElse(null);
        UserSkill userSkill = userSkillRepo.findById(skillId);

        if (user == null) {
            throw new NotFoundException(String.format("The user with ID: %d was not found", userId));
        }

        userSkill.dissociateSpecialist(user.getSpecialist());
        userSkillRepo.deleteById(skillId);

        return user;
    }
}
