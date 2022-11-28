package com.hva.helios.rest;

import com.hva.helios.models.User;
import com.hva.helios.models.user.Admin;
import com.hva.helios.models.user.Client;
import com.hva.helios.repositories.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4040", maxAge = 3600)
@RestController
@RequestMapping("users")
public class UserController {
    final private UserRepository userRepo = new UserRepository();

    @GetMapping("")
    public Map<String, List<? extends User>> getAllUsers() {
        return userRepo.getAllUsers();
    }

    @GetMapping("count")
    public int countUsers() {
        return userRepo.countUsers();
    }

    @GetMapping("{id}")
    public User getUserById(@PathVariable int id) {
        return userRepo.findUser(id);
    }
}
