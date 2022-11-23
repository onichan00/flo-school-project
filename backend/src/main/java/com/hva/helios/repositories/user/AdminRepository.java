package com.hva.helios.repositories.user;

import com.hva.helios.data.AdminData;
import com.hva.helios.exceptions.NotFoundException;
import com.hva.helios.models.user.Admin;
import com.hva.helios.repositories.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AdminRepository implements CrudRepository<Admin> {
    ArrayList<Admin> admins = new AdminData().getAdmins();

    /**
     * Method to get and return all objects
     *
     * @return - List of objects
     */
    @Override
    public List<Admin> getAll() {
        return admins;
    }

    /**
     * @param item  - Item to find by
     * @return The item that needs to be found
     */
    @Override
    public Admin getByItem(Admin item) throws NotFoundException {
        int index = admins.indexOf(item);

        if (index == -1) {
            throw new NotFoundException("Item not found");
        }

        return admins.get(index);
    }

    /**
     * Method to save object
     *
     * @param item - Object to save
     * @return - Saved object
     */
    @Override
    public Admin saveItem(Admin item) {
        admins.add(item);

        return item;
    }

    /**
     * Method to delete object with the same ID
     *
     * @param id - ID of object to delete
     * @return - Deleted object
     */
    @Override
    public Admin deleteById(int id) {
        int index = -1;

        for (int i = 0; i < admins.size(); i++) {
            if (admins.get(i).getId() == id) index = i;
        }

        if (index == -1) throw new NotFoundException("Admin not found");

        Admin adminToBeDeleted = admins.get(index);

        admins.remove(index);

        return adminToBeDeleted;
    }

    /**
     * Method to find and return specific object from list
     *
     * @param id - ID of object to find
     * @return - Object with given ID
     */
    @Override
    public Admin getById(int id) {
        int index = -1;

        for (int i = 0; i < admins.size(); i++) {
            if (admins.get(i).getId() == id) index = i;
        }

        if (index == -1) throw new NotFoundException("Admin not found");

        return admins.get(index);
    }
}
