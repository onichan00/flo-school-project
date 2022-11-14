package com.hva.helios.rest;

import com.hva.helios.models.User;
import com.hva.helios.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    private UserRepository userRepo;

    @GetMapping("")
    public List<User> getAllUsers(){
        return userRepo.getAllUsers();
    }
    @GetMapping("/admins")
    public List<User> getAllAdmins(){
        return userRepo.getAllAdmins();
    }
    @GetMapping("/specialists")
    public List<User> getAllSpecialists(){
        return userRepo.getAllSpecialists();
    }

    @GetMapping("/clients")
    public List<User> getAllClients(){
        return userRepo.getAllClients();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id){
        return userRepo.getById(id);
    }
}
