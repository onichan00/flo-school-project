package com.hva.helios.repositories;

import java.util.List;

public interface EntityRepository<E> {
    /**
     * Method to return a list of all entities
     * @return List of entities
     */
    List<E> findAll();

    /**
     * Method to find and return one entity specified by ID
     * @param id ID of object to find
     * @return Entity founded by ID
     */
    E findById(long id);

    E findByEmail(String email);

    /**
     * Method to save an entity to the DB
     * @param entity Entity to save
     * @return The entity that has been saved
     */
    E save(E entity);

    /**
     * Method to delete an entity from the DB
     * @param id Entity to be deleted, found by ID
     * @return The entity that has been deleted
     */
    E deleteById(long id);


}
