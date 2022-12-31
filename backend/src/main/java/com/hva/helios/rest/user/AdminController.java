//package com.hva.helios.rest.user;
//
//import com.hva.helios.exceptions.NotFoundException;
//import com.hva.helios.models.user.Admin;
//import com.hva.helios.repositories.interfaces.EntityRepository;
//import com.hva.helios.repositories.interfaces.jpa.AdminJPARepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/users/admin")
//public class AdminController {
//    @Autowired
//    private AdminJPARepository adminRepository;
//
//    @GetMapping("")
//    public List<Admin> getAllAdmins() {
//        return adminRepository.findAll();
//    }
//
//    @GetMapping("{id}")
//    public Admin getAdmin(@PathVariable long id) {
//        return adminRepository.findById(id).orElseThrow(() -> new NotFoundException("admin could not be found"));
//    }
//
//    @PostMapping
//    public Admin addAdmin(@RequestBody Admin admin) {
//        return adminRepository.save(admin);
//    }
//
//    @DeleteMapping("{id}")
//    public void deleteAdmin(@PathVariable long id) {
//        adminRepository.deleteById(id);
//    }
//}
