package com.hva.helios.rest.user;

import com.hva.helios.models.user.Client;
import com.hva.helios.repositories.user.ClientRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users/client")
public class ClientController {
    final private ClientRepository clientRepository = new ClientRepository();

    @GetMapping("")
    public List<Client> getAllClients() {
        return clientRepository.getAll();
    }

    @GetMapping("{id}")
    public Client getClient(@PathVariable int id) {
        return clientRepository.getById(id);
    }

    @PostMapping("")
    public Client addClient(@RequestBody Client client) {
        return clientRepository.saveItem(client);
    }

    @DeleteMapping("{id}")
    public Client deleteClient(@PathVariable int id) {
        return clientRepository.deleteById(id);
    }
}
