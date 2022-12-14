package com.hva.helios.rest.user;

import com.hva.helios.models.user.Admin;
import com.hva.helios.repositories.EntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users/admin")
public class AdminController {
    @Autowired
    private EntityRepository<Admin> adminRepository;

    @GetMapping("")
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    @GetMapping("{id}")
    public Admin getAdmin(@PathVariable int id) {
        return adminRepository.findById(id);
    }

    @PostMapping
    public Admin addAdmin(@RequestBody Admin admin) {
        return adminRepository.save(admin);
    }

    @DeleteMapping("{id}")
    public Admin deleteAdmin(@PathVariable int id) {
        return adminRepository.deleteById(id);
    }
}
