package com.hva.helios.data;

import com.hva.helios.models.user.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ClientData {
    Random random = new Random();
    ArrayList<Client> clients;

    Client client1 = new Client(
            "dennis.moes2@hva.nl",
            "password123",
            "john",
            "",
            "somers",
            "https://images.unsplash.com/photo-1472099645785-5658abf4ff4e?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2070&q=80",
            "Hallo ik ben John",
            "+31 6 12345678",
            "Amsterdam",
            "1091 GH",
            "Wibautstraat 3b",
            "https://google.com"
    );

    Client client2 = new Client(
            "dennis.moes2@hva.nl",
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
            "https://google.com"
    );

    public ClientData() {
        clients = new ArrayList<>(List.of(client1, client2));
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public ArrayList<Client> getRandomClients(int amount) {
        ArrayList<Client> tempClients = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            tempClients.add(clients.get(random.nextInt(amount)));
        }

        return tempClients;
    }
}
