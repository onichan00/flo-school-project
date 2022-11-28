package com.hva.helios.repositories;

import com.hva.helios.exceptions.NotFoundException;
import com.hva.helios.models.*;
import com.hva.helios.models.user.Admin;
import com.hva.helios.models.user.Client;
import com.hva.helios.models.user.Specialist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {

    private static ArrayList<User> users;

    @Autowired
    private EntityRepository<Admin> adminRepository;

    @Autowired
    private EntityRepository<Client> clientRepository;

    @Autowired
    private EntityRepository<Specialist> specialistRepository;

    public UserRepository() {}

    public Map<String, List<? extends User>> getAllUsers() {
        Map<String, List<? extends User>> users = new HashMap<>();

        // Make JSON object
//        users.put("client", clientRepository.findAll());
//        users.put("admin", adminRepository.findAll());
//        users.put("specialist", specialistRepository.findAll());

        System.out.println(clientRepository.findAll().size());
        System.out.println(adminRepository.findAll().size());
        System.out.println(specialistRepository.findAll().size());

        return users;
    }

    public int countUsers() {
        int amount = 0;

        amount += clientRepository.findAll().size();
        amount += adminRepository.findAll().size();
        amount +=specialistRepository.findAll().size();

        return amount;
    }

    public User findUser(int id) {
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
}
