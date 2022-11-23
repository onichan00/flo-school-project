package com.hva.helios.repositories;

import com.hva.helios.models.Specialist;

import java.util.ArrayList;
import java.util.List;

/**
 * Specialists Repository for the SpecialistClass
 * @author Simon Vriesema
 */
public class SpecialistsRepository implements CrudRepository<Specialist> {

    //Specialists
    Specialist specialists0, specialist1, specialist2, specialist3, specialist4;
    //Specialists arraylist
    private ArrayList<Specialist> specialists;

    public SpecialistsRepository(){
    }

    public ArrayList<Specialist> getSpecialists() {
        return this.specialists;
    }

    /**
     * Method to get and return all specialists
     * @return - List of specialists
     * @param items - list of specialists
     */
    @Override
    public List<Specialist> getAll(List<Specialist> items) {
        return CrudRepository.super.getAll(items);
    }

    /**
     * @param item - Specialist to find by
     * @param items - List to find specialists in
     * @return The specialists that needs to be found
     */
    @Override
    public Specialist getByItem(Specialist item, List<Specialist> items) {
        return CrudRepository.super.getByItem(item, items);
    }

    /**
     * Method to save specialist
     * @param item - Specialist to save
     * @return - Saved specialist
     */
    @Override
    public Specialist saveItem(Specialist item) {
        int index = specialists.indexOf(item);

        // Check if the specialist already exists
        if (index == -1) {
            specialists.add(item);
        } else {
            specialists.set(index, item);
        }

        return item;
    }

    /**
     * Method to delete specialist with the same ID
     * @param id - ID of specialist to delete
     * @return - Deleted specialist
     */
    @Override
    public Specialist deleteById(int id) {
        int index = specialists.indexOf(new Specialist(id));

        Specialist specialist = specialists.get(index);

        specialists.remove(index);

        return specialist;
    }

    /**
     * Method to find and return specific specialist from list
     * @param id - ID of specialist to find
     * @return - specialist with given ID
     */
    @Override
    public Specialist getById(int id) {
        Specialist specialist = new Specialist(id);

        for (Specialist s : specialists) {
            if (s.equals(specialist)) specialist = s;
        }

        return specialist;
    }
}
