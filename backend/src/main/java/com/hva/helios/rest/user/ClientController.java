//package com.hva.helios.rest.user;
//
//import com.hva.helios.exceptions.NotFoundException;
//import com.hva.helios.models.user.Client;
//import com.hva.helios.repositories.interfaces.EntityRepository;
//import com.hva.helios.repositories.interfaces.jpa.AdminJPARepository;
//import com.hva.helios.repositories.interfaces.jpa.ClientJPARepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/users/client")
//public class ClientController {
//    @Autowired
//    private ClientJPARepository clientRepository;
//    @Autowired
//    private AdminJPARepository adminJPARepository;
//
//    @GetMapping("")
//    public List<Client> getAllClients() {
//        return clientRepository.findAll();
//    }
//
//    @GetMapping("{id}")
//    public Client getClient(@PathVariable long id) {
//        Client client = clientRepository.findById(id).orElseThrow(() -> new NotFoundException("Project could not be found"));
//        return client;
//    }
//
//    @PostMapping("")
//    public Client addClient(@RequestBody Client client) {
//        return clientRepository.save(client);
//    }
//
//    @DeleteMapping("{id}")
//    public void deleteClient(@PathVariable long id) {
//        clientRepository.deleteById(id);
//    }
//}
