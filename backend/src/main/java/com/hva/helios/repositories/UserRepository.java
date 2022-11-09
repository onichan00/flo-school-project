package com.hva.helios.repositories;

import com.hva.helios.models.Specialist;
import com.hva.helios.models.User;

import java.util.ArrayList;
import java.util.List;

/**
 * User Repository for the User Class
 * @author simon_vriesema
 */
public class UserRepository implements CrudRepository<User> {

    User user0, user1, user2, user3;
    private ArrayList<User> users;

    public ArrayList<User> getUsers() {
        return this.users;
    }


    /**
     * Method to get and return all users
     * @return - List of users
     * @param items - list of users
     */
    @Override
    public List<User> getAll(List<User> items) {
        return CrudRepository.super.getAll(items);
    }

    /**
     * @param item - User to find by
     * @param items - List to find users in
     * @return The users that needs to be found
     */
    @Override
    public User getByItem(User item, List<User> items) {
        return CrudRepository.super.getByItem(item, items);
    }

    /**
     * Method to save user
     * @param item - User to save
     * @return - Saved user
     */
    @Override
    public User saveItem(User item) {
        int index = users.indexOf(item);

        // Check if the user already exists
        if (index == -1) {
            users.add(item);
        } else {
            users.set(index, item);
        }

        return item;
    }

    /**
     * Method to delete user with the same ID
     * @param id - ID of user to delete
     * @return - Deleted user
     */
    @Override
    public User deleteById(int id) {
        int index = users.indexOf(users.get(id));

        User user = users.get(index);

        users.remove(index);

        return user;
    }

    /**
     * Method to find and return specific user from list
     * @param id - ID of user to find
     * @return - user with given ID
     */
    @Override
    public User getById(int id) {
        User user = users.get(id);

        for (User u : users) {
            if (u.equals(user)) user = u;
        }

        return user;
    }
}
