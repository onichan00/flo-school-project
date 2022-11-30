package com.hva.helios.rest.user;

import com.hva.helios.models.user.Client;
import com.hva.helios.repositories.EntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users/client")
public class ClientController {
    @Autowired
    private EntityRepository<Client> clientRepository;

    @GetMapping("")
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @GetMapping("{id}")
    public Client getClient(@PathVariable int id) {
        return clientRepository.findById(id);
    }

    @PostMapping("")
    public Client addClient(@RequestBody Client client) {
        return clientRepository.save(client);
    }

    @DeleteMapping("{id}")
    public Client deleteClient(@PathVariable int id) {
        return clientRepository.deleteById(id);
    }
}
