package com.hva.helios.repositories;

import com.hva.helios.data.SkillData;
import com.hva.helios.models.user.skill.Skill;

import java.util.ArrayList;
import java.util.List;

public class SkillRepository implements CrudRepository<Skill> {
    ArrayList<Skill> skills;

    public SkillRepository() {
        this.skills = new SkillData().getAvailableSkills();
    }

    /**
     * Method to get and return all objects
     *
     * @return - List of objects
     */
    @Override
    public List<Skill> getAll() {
        return this.skills;
    }

    /**
     * @param item  - Item to find by
     * @return The item that needs to be found
     */
    @Override
    public Skill getByItem(Skill item) {

        return skills.get(0);
    }

    /**
     * Method to save object
     *
     * @param item - Object to save
     * @return - Saved object
     */
    @Override
    public Skill saveItem(Skill item) {
        return null;
    }

    /**
     * Method to delete object with the same ID
     *
     * @param id - ID of object to delete
     * @return - Deleted object
     */
    @Override
    public Skill deleteById(int id) {
        return null;
    }

    /**
     * Method to find and return specific object from list
     *
     * @param id - ID of object to find
     * @return - Object with given ID
     */
    @Override
    public Skill getById(int id) {
        return null;
    }
}
