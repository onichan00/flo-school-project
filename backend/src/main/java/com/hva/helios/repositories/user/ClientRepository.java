package com.hva.helios.repositories.user;

import com.hva.helios.data.ClientData;
import com.hva.helios.exceptions.NotFoundException;
import com.hva.helios.models.user.Client;
import com.hva.helios.models.user.Specialist;
import com.hva.helios.repositories.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ClientRepository implements CrudRepository<Client> {
    ArrayList<Client> clients;

    public ClientRepository() {
        clients = new ClientData().getClients();
    }

    /**
     * @param item - Item to find by
     * @return The item that needs to be found
     */
    @Override
    public Client getByItem(Client item) {
        int index = clients.indexOf(item);

        if (index == -1) throw new NotFoundException("Client not found");

        return clients.get(index);
    }

    /**
     * Method to get and return all objects
     *
     * @return - List of objects
     */
    @Override
    public List<Client> getAll() {
        return clients;
    }

    /**
     * Method to save object
     *
     * @param item - Object to save
     * @return - Saved object
     */
    @Override
    public Client saveItem(Client item) {
        clients.add(item);

        return item;
    }

    /**
     * Method to delete object with the same ID
     *
     * @param id - ID of object to delete
     * @return - Deleted object
     */
    @Override
    public Client deleteById(int id) {
        int index = -1;

        for (int i = 0; i < clients.size(); i++) {
            if (clients.get(i).getId() == id) index = i;
        }

        if (index == -1) throw new NotFoundException("Admin not found");

        Client clientToBeDeleted = clients.get(index);

        clients.remove(index);

        return clientToBeDeleted;
    }

    /**
     * Method to find and return specific object from list
     *
     * @param id - ID of object to find
     * @return - Object with given ID
     */
    @Override
    public Client getById(int id) {
        int index = -1;

        for (int i = 0; i < clients.size(); i++) {
            if (clients.get(i).getId() == id) index = i;
        }

        if (index == -1) throw new NotFoundException("Admin not found");

        return clients.get(index);
    }
}
