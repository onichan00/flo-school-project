package com.hva.helios.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RightsData {
    Random random = new Random();

    ArrayList<String> rights;

    public RightsData() {
        this.rights = new ArrayList<>(
            List.of(
                "canEditUsers",
                "canEditSpecialists",
                "canDeleteSpecialists",
                "canDeleteSpecialists",
                "canEditClients",
                "canDeleteClients"
            )
        );
    }

    public ArrayList<String> getRights() {
        return rights;
    }

    public ArrayList<String> getRandomRights(int amount) {
        ArrayList<String> tempRights = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            tempRights.add(rights.get(random.nextInt(rights.size())));
        }

        return tempRights;
    }
}
