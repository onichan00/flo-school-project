package com.hva.helios.data;

import com.hva.helios.models.user.Admin;
import com.hva.helios.models.user.Specialist;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AdminData {
    Random random = new Random();
    ArrayList<Admin> admins;

    Admin admin1 = new Admin(
        3,
        "m.n.groen@hva.nl",
        "password123",
        "maarten",
        "",
        "groen",
        "https://images.unsplash.com/photo-1560250097-0b93528c311a?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=987&q=80",
        "Hallo ik ben Maarten",
        "+31 6 12345678"
    );

    Admin admin2 = new Admin(
            4,
            "m.n.groen@hva.nl",
            "password123",
            "marcio",
            "",
            "fucker",
            "https://images.unsplash.com/photo-1500648767791-00dcc994a43e?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=987&q=80",
            "Hello I am Marcio",
            "+31 6 12345678"
    );

    public AdminData() {
        this.admins = new ArrayList<>(List.of(admin1, admin2));
    }

    public ArrayList<Admin> getAdmins() {
        return admins;
    }

    public ArrayList<Admin> getRandomAdmins(int amount) {
        ArrayList<Admin> tempAdmins = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            tempAdmins.add(admins.get(random.nextInt(admins.size())));
        }

        return tempAdmins;
    }
}
