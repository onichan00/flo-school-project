package com.hva.helios.data;

import com.hva.helios.models.user.Specialist;
import com.hva.helios.models.user.hour.AvailableHour;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SpecialistData {
    Random random = new Random();
    ArrayList<Specialist> specialists;

    AvailableHour availableHour = new AvailableHour();
    AvailableHour availableHour2 = new AvailableHour();

    ProjectData projectsData = new ProjectData();
    SkillData skillsData = new SkillData();
    ArrayList<String> specialistType = new ArrayList<>(List.of("mobile", "frontend", "backend", "desktop", "security", "devOps"));

    Specialist specialist1 = new Specialist(
            "dennis.moes3@hva.nl",
            "password123",
            "dennis",
            "Cornelis",
            "moes",
            "https://images.unsplash.com/photo-1558203728-00f45181dd84?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2074&q=80",
            "Hallo ik ben Dennis",
            "+31 6 12345678",
            "Amsterdam",
            "1091 GH",
            "Wibautstraat 3b",
            1,
            specialistType.get(random.nextInt(specialistType.size())),
            availableHour,
            projectsData.getRandomProjects(2),
//            skillsData.getRandomSkills(3)
            null
    );

    Specialist specialist2 = new Specialist(
            "ilias.aachboun@hva.nl",
            "password123",
            "ilias",
            "",
            "aachbound",
            "https://images.unsplash.com/photo-1537511446984-935f663eb1f4?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2070&q=80",
            "Hallo ik ben Ilias",
            "+31 6 12345678",
            "Amsterdam",
            "1091 GH",
            "Wibautstraat 3b",
            1,
            specialistType.get(random.nextInt(specialistType.size())),
            availableHour2,
            projectsData.getRandomProjects(1),
//            skillsData.getRandomSkills(2)
            null
    );

    public SpecialistData() {
        this.specialists = new ArrayList<>(List.of(specialist1, specialist2));
    }

    public ArrayList<Specialist> getSpecialists() {
        return specialists;
    }

    public ArrayList<Specialist> getRandomSpecialists(int amount) {
        ArrayList<Specialist> tempSpecialists = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            tempSpecialists.add(specialists.get(random.nextInt(specialists.size())));
        }

        return tempSpecialists;
    }
}
