package com.hva.helios.rest;

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
        return userRepository.findAll().stream().filter(user -> user.getUserType() == 2).collect(Collectors.toList());
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
    public User getUserById(@PathVariable long id) {
//        List<User> users = new ArrayList<>();

//        return userRepository.findById(id);

//        users.addAll(clientRepository.findAll());
//        users.addAll(adminRepository.findAll());
//        users.addAll(specialistRepository.findAll());
//
//        User user = null;
//
////        users.stream().findFirst();
//
//        for (User value : users) {
//            if (value.getId() == id) user = value;
//        }
//
//        if (user == null) {
//            throw new NotFoundException("User not found");
//        }
//
//        User user = userRepository.findById(id)
//                .orElseThrow(() -> new NotFoundException("Project could not be found"));
        return userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Project could not be found"));
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
            if (user.getClient() != null){
               savedClient = clientRepository.save(user.getClient());

            }else {
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

    @PostMapping("/specialist/{userId}/skill")
    public User addUserSkill(@RequestBody UserSkill userSkill, @PathVariable long userId) {
        User user = userRepository.findById(userId).orElse(null);

        if (user == null) {
            throw new NotFoundException(String.format("The user with ID: %d was not found", userId));
        }

        UserSkill savedUserSkill = userSkillRepo.save(userSkill);

        Specialist specialist = user.getSpecialist();
        specialist.associateUserSkill(savedUserSkill);
        user.setSpecialist(specialist);

        return userRepository.save(user);
    }
}
