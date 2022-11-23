package com.hva.helios.rest.user;

import com.hva.helios.models.user.Admin;
import com.hva.helios.repositories.user.AdminRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users/admin")
public class AdminController {
    final private AdminRepository adminRepository = new AdminRepository();

    @GetMapping("")
    public List<Admin> getAllAdmins() {
        return adminRepository.getAll();
    }

    @GetMapping("{id}")
    public Admin getAdmin(@PathVariable int id) {
        return adminRepository.getById(id);
    }

    @PostMapping
    public Admin addAdmin(@RequestBody Admin admin) {
        return adminRepository.saveItem(admin);
    }

    @DeleteMapping("{id}")
    public Admin deleteAdmin(@PathVariable int id) {
        return adminRepository.deleteById(id);
    }
}
