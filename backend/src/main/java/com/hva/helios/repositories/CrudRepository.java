package com.hva.helios.repositories;


import java.util.List;

/**
 * Interface that will have methods that are used by all repositories that will implement this interface
 * @param <T> Class to use
 */
public interface CrudRepository<T> {
    /**
     * Method to get and return all objects
     *
     * @return - List of objects
     */
    default List<T> getAll(List<T> items) {
        return items;
    }

    /**
     *
     * @param item - Item to find by
     * @param items - List to find item in
     * @return The item that needs to be found
     */
    default T getByItem(T item, List<T> items) {
        int index = items.indexOf(item);

        return index == -1 ? null : items.get(index);
    }

    /**
     * Method to save object
     * @param item - Object to save
     * @return - Saved object
     */
    default T saveItem(T item, List<T> items) {
        // Check if the item already exists
        int index = items.indexOf(item);

        if (index == -1) {
            items.add(item);
        } else {
            items.set(index, item);
        }

        return item;
    }

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
