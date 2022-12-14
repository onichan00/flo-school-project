package com.hva.helios.rest;

import com.hva.helios.models.user.*;
import com.hva.helios.exceptions.NotFoundException;
import com.hva.helios.models.User;
import com.hva.helios.repositories.EntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4040", maxAge = 3600)
@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    private EntityRepository<Admin> adminRepository;

    @Autowired
    private EntityRepository<Client> clientRepository;

    @Autowired
    private EntityRepository<Specialist> specialistRepository;

    @Autowired
    private EntityRepository<User> userRepository;

    @GetMapping("")
    public Map<String, List<? extends User>> getAllUsers() {
        Map<String, List<? extends User>> users = new HashMap<>();

        users.put("client", clientRepository.findAll());
        users.put("admin", adminRepository.findAll());
        users.put("specialist", specialistRepository.findAll());

        return users;
    }

    @GetMapping("/admins")
    public Map<String, List<? extends User>> getAllAdmins() {
        Map<String, List<? extends User>> users = new HashMap<>();

        users.put("admin", adminRepository.findAll());

        return users;
    }

    @GetMapping("count")
    public int countUsers() {
        int amount = 0;

        amount += clientRepository.findAll().size();
        amount += adminRepository.findAll().size();
        amount += specialistRepository.findAll().size();

        return amount;
    }

    @GetMapping("{id}")
    public User getUserById(@PathVariable int id) {
        List<User> users = new ArrayList<>();

        return userRepository.findById(id);

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
//        return user;
    }


    @PostMapping("login")
    public LoginResponse login(@RequestBody LoginBody loginBody) {
        Specialist specialist = specialistRepository.findByEmail(loginBody.email());
        Admin admin = adminRepository.findByEmail(loginBody.email());
        Client client = clientRepository.findByEmail(loginBody.email());

        if (admin != null) {
            if (admin.getPassword().equals(loginBody.password())) {
                return new LoginResponse(admin.getId(), true, false, false);
            }
        }
        if (specialist != null) {
            if (specialist.getPassword().equals(loginBody.password())) {

                return new LoginResponse(client.getId(), false, false, true);
            }
        }
        if (client != null) {
            if (client.getPassword().equals(loginBody.password())) {
                return new LoginResponse(client.getId(), false, true, false);
            }
        }

        throw new NotFoundException("Inloggen niet gelukt");
    }

    @PostMapping("register")
    public LoginResponse register(@RequestBody User user) {
       Long userType = user.getUserType();


       if (userType == 0){
           Admin admin = new Admin(user.getEmail(),user.getPassword(), user.getFirst_name(), user.getSecond_name(), user.getLast_name(), user.getPhoto(), user.getBio(), user.getPhone(), user.getCity(), user.getZipCode(), user.getAddress());
            var adminSave = adminRepository.save(admin);
            return new LoginResponse(adminSave.getId(),true,false,false);

       }
        if (userType == 1){
            Client client = new Client(user.getEmail(),user.getPassword(), user.getFirst_name(), user.getSecond_name(), user.getLast_name(), user.getPhoto(), user.getBio(), user.getPhone(), user.getCity(), user.getZipCode(), user.getAddress());

            var clientSave = clientRepository.save(client);

            return new LoginResponse(clientSave.getId(), false,true,false);
        }
        if (userType == 2){
            Specialist specialist = new Specialist(user.getEmail(),user.getPassword(), user.getFirst_name(), user.getSecond_name(), user.getLast_name(), user.getPhoto(), user.getBio(), user.getPhone(), user.getCity(), user.getZipCode(), user.getAddress());


            var specialistSave = specialistRepository.save(specialist);

            return new LoginResponse(specialistSave.getId(), false,false,true);
        }

        throw new NotFoundException("Register failed");
    }
}
