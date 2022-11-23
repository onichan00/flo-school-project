package com.hva.helios.repositories;

import com.hva.helios.exceptions.NotFoundException;
import com.hva.helios.models.*;
import com.hva.helios.models.user.Admin;
import com.hva.helios.repositories.user.AdminRepository;
import com.hva.helios.repositories.user.ClientRepository;
import com.hva.helios.repositories.user.SpecialistRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {

    private static ArrayList<User> users;

    final private AdminRepository adminRepository;
    final private ClientRepository clientRepository;
    final private SpecialistRepository specialistRepository;


    public UserRepository() {
        specialistRepository = new SpecialistRepository();
        adminRepository = new AdminRepository();
        clientRepository = new ClientRepository();
    }

    public Map<String, List<? extends User>> getAllUsers() {
        Map<String, List<? extends User>> users = new HashMap<>();

        // Make JSON object
        users.put("client", clientRepository.getAll());
        users.put("admin", adminRepository.getAll());
        users.put("specialist", specialistRepository.getAll());

        return users;
    }

    public int countUsers() {
        int amount = 0;

        amount += clientRepository.getAll().size();
        amount += adminRepository.getAll().size();
        amount +=specialistRepository.getAll().size();

        return amount;
    }

    public User findUser(int id) {
        List<User> users = new ArrayList<>();

        users.addAll(clientRepository.getAll());
        users.addAll(adminRepository.getAll());
        users.addAll(specialistRepository.getAll());

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
