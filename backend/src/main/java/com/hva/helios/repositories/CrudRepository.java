package com.hva.helios.repositories;

import java.util.List;

/**
 * Interface that will have methods that are used by all repositories that will implement this interface
 * @param <T> Class to use
 */
public interface CrudRepository<T> {
    /**
     *
     * @param item - Item to find by
     * @param items - List to find item in
     * @return The item that needs to be found
     */
    T getByItem(T item);

    /**
     * Method to get and return all objects
     *
     * @return - List of objects
     */
    List<T> getAll();

    /**
     * Method to save object
     * @param item - Object to save
     * @return - Saved object
     */
    T saveItem(T item);

    /**
     * Method to delete object with the same ID
     * @param id - ID of object to delete
     * @return - Deleted object
     */
    T deleteById(int id);

    /**
     * Method to find and return specific object from list
     * @param id - ID of object to find
     * @return - Object with given ID
     */
    T getById(int id);
}
