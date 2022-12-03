package com.hva.helios.rest;

import com.hva.helios.LoginResponse;
import com.hva.helios.exceptions.NotFoundException;
import com.hva.helios.models.LoginBody;
import com.hva.helios.models.User;
import com.hva.helios.models.user.Admin;
import com.hva.helios.models.user.Client;
import com.hva.helios.models.user.Specialist;
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

    @GetMapping("")
    public Map<String, List<? extends User>> getAllUsers() {
        Map<String, List<? extends User>> users = new HashMap<>();

        users.put("client", clientRepository.findAll());
        users.put("admin", adminRepository.findAll());
        users.put("specialist", specialistRepository.findAll());

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

        users.addAll(clientRepository.findAll());
        users.addAll(adminRepository.findAll());
        users.addAll(specialistRepository.findAll());

        User user = null;

        for (User value : users) {
            if (value.getId() == id) user = value;
        }

        if (user == null) {
            throw new NotFoundException("User not found");
        }

        return user;
    }


    @PostMapping("login")
    public LoginResponse login(@RequestBody LoginBody loginBody) {
        Specialist specialist = specialistRepository.findByEmail(loginBody.getEmail());
        Admin admin = adminRepository.findByEmail(loginBody.getEmail());
        Client client = clientRepository.findByEmail(loginBody.getEmail());

        if (admin != null) {
            if (admin.getPassword().equals(loginBody.getPassword())) {
                LoginResponse loginResponse = new LoginResponse(admin.getId(),true,false,false);
                return loginResponse;
            }
        }
        if (client != null) {
            if (client.getPassword().equals(loginBody.getPassword())) {
                LoginResponse loginResponse = new LoginResponse(client.getId(),false,true,false);
                return loginResponse;
            }
        }
        if (specialist != null) {
            if (specialist.getPassword().equals(loginBody.getPassword())) {

                LoginResponse loginResponse = new LoginResponse(client.getId(),false,false,true);
                return loginResponse;
            }
        }
        return  new LoginResponse(-1L,false,false,false);
    }
}
