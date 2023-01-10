package com.hva.helios.data;

import com.hva.helios.models.User;
import com.hva.helios.models.user.Admin;
import com.hva.helios.models.user.Client;
import com.hva.helios.models.user.Specialist;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UserData {
    ArrayList<User> clients;
    ArrayList<User> Admins;
    Client clientData = new Client("https://www.google.com");

    User client1 = new User(
            "client",
            "client",
            "client",
            "client",
            "client",
            "https://images.unsplash.com/photo-1472099645785-5658abf4ff4e?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2070&q=80",
            "Hallo ik ben Client",
            "+31 6 12345678",
            "Amsterdam",
            "1091 GH",
            "Wibautstraat 3b",
            1L,
            new Client("testwebsite.nl")
    );

    User client2 = new User(
            "dennis.moesClient@hva.nl",
            "password123",
            "yahia",
            "",
            "elsherbini",
            "https://images.unsplash.com/photo-1507003211169-0a1dd7228f2d?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=987&q=80",
            "Hello I am Yahia",
            "+31 6 12345678",
            "Amsterdam",
            "1091 GH",
            "Wibautstraat 3b",
            1L,
            new Client("websitetest.nl")
    );

    User admin1 = new User(
            "dennis.moes1@hva.nl",
            "password123",
            "yahia",
            "",
            "elsherbini",
            "https://images.unsplash.com/photo-1507003211169-0a1dd7228f2d?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=987&q=80",
            "Hello I am Yahia",
            "+31 6 12345678",
            "Amsterdam",
            "1091 GH",
            "Wibautstraat 3b",
            0L
    );

    User admin2 = new User(
            "admin",
            "admin",
            "admin",
            "admin",
            "admin",
            "https://images.unsplash.com/photo-1507003211169-0a1dd7228f2d?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=987&q=80",
            "Hello I am admin",
            "+31 6 12345678",
            "Amsterdam",
            "1091 GH",
            "Wibautstraat 3b",
            0L
    );

    User specialist1 = new User(
            "specialist",
            "specialist",
            "specialist",
            "specialist",
            "specialist",
            "https://images.unsplash.com/photo-1507003211169-0a1dd7228f2d?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=987&q=80",
            "Hello I am specialist",
            "+31 6 12345678",
            "Amsterdam",
            "1091 GH",
            "Wibautstraat 3b",
            2L,
            new Specialist(1,"Backend engineer", 0,null,null,null,null)
    );

    User specialist2 = new User(
            "specialist1",
            "specialist1",
            "specialist1",
            "specialist1",
            "specialist1",
            "https://images.unsplash.com/photo-1507003211169-0a1dd7228f2d?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=987&q=80",
            "Hello I am specialist1",
            "+31 6 12345678",
            "Amsterdam",
            "1091 GH",
            "Wibautstraat 3b",
            2L,
            new Specialist(1,"Backend engineer", 0,null,null,null,null)
    );

    public UserData() {}

    public ArrayList<User> getClients() {
        return new ArrayList<>(List.of(client1,client2));
    }

    public ArrayList<User> getAdmins() {
        return new ArrayList<>(List.of(admin1,admin2));
    }

    public ArrayList<User> getSpecialists() {
        return new ArrayList<>(List.of(specialist1, specialist2));
    }
}
