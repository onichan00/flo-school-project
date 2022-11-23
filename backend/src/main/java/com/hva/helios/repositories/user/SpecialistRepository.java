package com.hva.helios.repositories.user;

import com.hva.helios.data.ProjectData;
import com.hva.helios.data.SkillData;
import com.hva.helios.data.SpecialistData;
import com.hva.helios.exceptions.NotFoundException;
import com.hva.helios.models.user.Specialist;
import com.hva.helios.models.user.hour.AvailableHour;
import com.hva.helios.models.user.skill.Skill;
import com.hva.helios.models.user.skill.UserSkill;
import com.hva.helios.repositories.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SpecialistRepository implements CrudRepository<Specialist> {
    private static ArrayList<Specialist> specialists;

    public SpecialistRepository() {
        AvailableHour availableHour = new AvailableHour(1);

        SpecialistData specialistData = new SpecialistData();
        SkillData skillsData = new SkillData();
        ProjectData projectsData = new ProjectData();

        specialists = new ArrayList<>();

        specialists.addAll(specialistData.getSpecialists());
    }

    /**
     * @param item - Item to find by
     * @return The item that needs to be found
     */
    @Override
    public Specialist getByItem(Specialist item) {
        int index = specialists.indexOf(item);

        if (index == -1) throw new NotFoundException("Specialist not found");

        return specialists.get(index);
    }

    /**
     * Method to get and return all objects
     *
     * @return - List of objects
     */
    @Override
    public List<Specialist> getAll() {
        return specialists;
    }

    /**
     * Method to save object
     *
     * @param item - Object to save
     * @return - Saved object
     */
    @Override
    public Specialist saveItem(Specialist item) {
        specialists.add(item);

        return item;
    }

    /**
     * Method to delete object with the same ID
     *
     * @param id - ID of object to delete
     * @return - Deleted object
     */
    @Override
    public Specialist deleteById(int id) {
        int index = -1;

        for (int i = 0; i < specialists.size(); i++) {
            if (specialists.get(i).getId() == id) index = i;
        }

        if (index == -1) throw new NotFoundException("Admin not found");

        Specialist specialistToBeDeleted = specialists.get(index);

        specialists.remove(index);

        return specialistToBeDeleted;
    }

    /**
     * Method to find and return specific object from list
     *
     * @param id - ID of object to find
     * @return - Object with given ID
     */
    @Override
    public Specialist getById(int id) {
        int index = -1;

        for (int i = 0; i < specialists.size(); i++) {
            if (specialists.get(i).getId() == id) index = i;
        }

        if (index == -1) throw new NotFoundException("Admin not found");

        return specialists.get(index);
    }

    public UserSkill saveSkill(Skill skill, int level, int userId) {
        UserSkill userSkill = new UserSkill(skill, level);

        Specialist specialist = getById(userId);

        specialist.addSkill(userSkill);

        return userSkill;
    }

//    public UserSkill deleteSkill(int userId, int skillId) {
//        Specialist specialist = getById(userId);
//    }
}
