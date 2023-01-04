package com.hva.helios.data;

import com.hva.helios.models.User;
import com.hva.helios.models.user.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UserData {
    ArrayList<User> clients;
    Client clientData = new Client("https://www.google.com");

    User client1 = new User(
            "dennis.moes@hva.nl",
            "password123",
            "John",
            "",
            "Somers",
            "https://images.unsplash.com/photo-1472099645785-5658abf4ff4e?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2070&q=80",
            "Hallo ik ben John",
            "+31 6 12345678",
            "Amsterdam",
            "1091 GH",
            "Wibautstraat 3b",
            1L,
            clientData
    );

    User client2 = new User(
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
            1L,
            clientData
    );

    public UserData() {}

    public ArrayList<User> getClients() {
        return new ArrayList<>(List.of(client1, client2));
    }
}
