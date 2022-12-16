package com.hva.helios.rest;

import com.hva.helios.models.user.*;
import com.hva.helios.exceptions.NotFoundException;
import com.hva.helios.models.User;
import com.hva.helios.repositories.user.AdminJPARepository;
import com.hva.helios.repositories.user.ClientJPARepository;
import com.hva.helios.repositories.user.SpecialistJPARepository;
import com.hva.helios.repositories.user.UserJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

//@CrossOrigin(origins = *, maxAge = 3600)
@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    private AdminJPARepository adminRepository;
//
    @Autowired
    private ClientJPARepository clientRepository;
//
    @Autowired
    private SpecialistJPARepository specialistRepository;
//
    @Autowired
    private UserJPARepository userRepository;
//    @Autowired
//    private UserRepository userRepository;
//    @Autowired
//    private AdminJPARepository adminJPARepository;


//    @PutMapping("/update")
//    public User updateUserById(@RequestBody User user){
//        Long userType = user.getUserType();
//        Long id = user.getId();
//
//        if (userType == 0){
//            User oldUser = userRepository.findById(id).orElseThrow(() -> new NotFoundException("user not found"));
//
//            oldUser.setFirst_name(user.getFirst_name());
//            oldUser.setEmail(user.getEmail());
//            oldUser.setPassword(user.getPassword());
//            oldUser.setSecond_name(user.getSecond_name());
//            oldUser.setLast_name(user.getLast_name());
//            oldUser.setPhone(user.getPhone());
//
//            userRepository.
//            return oldUser;
//
//        }
//        if (userType == 1){
//            //TODO implement request parameters
//            Client client = new Client("webosaito");
//            clientRepository.save(client);
//            user.setClient(client);
//            User nUser = userRepository.save(user);
//
//            return nUser;
//        }
//        if (userType == 2){
//            Specialist specialist = new Specialist();
//            specialistRepository.save(specialist);
//            user.setSpecialist(specialist);
//            User nUser = userRepository.save(user);
//
//            return nUser;
//        }
//
//        throw new NotFoundException("register failed");
//    }
    @GetMapping("")
    public List<User> getAllUsers() {
//        Map<String, List<? extends User>> users = new HashMap<>();

//        users.put("client", clientRepository.findAll());
//        users.put("admin", adminRepository.findAll());
//        users.put("specialist", specialistRepository.findAll());

//        Map<String, List<? extends User>> users = new HashMap<>(userRepository.findAll());
//
//        return users;
        return userRepository.findAll();
    }

    @GetMapping("admins")
    public List<User> getAllAdmins(){
        return userRepository.findAll().stream().filter(user -> user.getUserType() == 0).collect(Collectors.toList());
    }

    @GetMapping("specialists")
    public List<User> getAllSpecialists(){
        return userRepository.findAll().stream().filter(user -> user.getUserType() == 2).collect(Collectors.toList());
    }

    @GetMapping("clients")
    public List<User> getAllClients(){
        return userRepository.findAll().stream().filter(user -> user.getUserType() == 1).collect(Collectors.toList());
    }

    @GetMapping("count")
    public long countUsers() {
        int amount = 0;
//
//        amount += clientRepository.findAll().size();
//        amount += adminRepository.findAll().size();
//        amount += specialistRepository.findAll().size();

        return userRepository.count();

//        return amount;
    }

    @GetMapping("{id}")
    public User getUserById(@PathVariable long id) {
//        List<User> users = new ArrayList<>();

//        return userRepository.findById(id);

//        users.addAll(clientRepository.findAll());
//        users.addAll(adminRepository.findAll());
//        users.addAll(specialistRepository.findAll());
//
//        User user = null;
//
////        users.stream().findFirst();
//
//        for (User value : users) {
//            if (value.getId() == id) user = value;
//        }
//
//        if (user == null) {
//            throw new NotFoundException("User not found");
//        }
//
//        User user = userRepository.findById(id)
//                .orElseThrow(() -> new NotFoundException("Project could not be found"));
        return userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Project could not be found"));
    }


    @PostMapping("login")
    public LoginResponse login(@RequestBody LoginBody loginBody) {
//        Specialist specialist = specialistRepository.findByEmail(loginBody.email());
//        Admin admin = adminRepository.findByEmail(loginBody.email());
//        Client client = clientRepository.findByEmail(loginBody.email());
//
//        if (admin != null) {
//            if (admin.getPassword().equals(loginBody.password())) {
//                return new LoginResponse(admin.getId(), true, false, false);
//            }
//        }
//        if (specialist != null) {
//            if (specialist.getPassword().equals(loginBody.password())) {
//
//                return new LoginResponse(client.getId(), false, false, true);
//            }
//        }
//        if (client != null) {
//            if (client.getPassword().equals(loginBody.password())) {
//                return new LoginResponse(client.getId(), false, true, false);
//            }
//        }

        User user = userRepository.findByEmail(loginBody.email());


        if (user.getPassword().equals(loginBody.password())) {
            return new LoginResponse(user.getId(),user.getUserType());
        }
        return new LoginResponse(-1l,-1);

    }

    @PostMapping("register")
    public LoginResponse register(@RequestBody User user) {

        // email unique check
        if (userRepository.findByEmail(user.getEmail()) != null){
            throw new NotFoundException("user with this email already exists");
        }

        Long userType = user.getUserType();

        if (userType == 0){
            Admin admin = new Admin();
            adminRepository.save(admin);
            user.setAdmin(admin);
            User nUser = userRepository.save(user);
            return new LoginResponse(nUser.getId(),nUser.getUserType());

        }
        if (userType == 1){
            //TODO implement request parameters
            Client client = new Client("webosaito");
            clientRepository.save(client);
            user.setClient(client);
            User newUser = userRepository.save(user);

            return new LoginResponse(newUser.getId(), newUser.getUserType());
        }
        if (userType == 2){
            Specialist specialist = new Specialist();
            specialistRepository.save(specialist);
            user.setSpecialist(specialist);
            User newUser = userRepository.save(user);

            return new LoginResponse(newUser.getId(), newUser.getUserType());
        }

        throw new NotFoundException("register failed");
    }



//    @PostMapping("admin/create")
//    public LoginResponse createAdmin(@RequestBody User user) {
//        Long userType = user.getUserType();
//
//
//        if (userType == 0){
//           Admin admin = new Admin();
//           adminRepository.save(admin);
//            user.setAdmin(admin);
//            User nUser = userRepository.save(user);
//            return new LoginResponse(nUser.getId(),nUser.getUserType());
//
//        }
//
//        throw new NotFoundException("Creation failed");
//    }

//    @PostMapping("admin/create")
//    public LoginResponse createAdmin(@RequestBody User user) {
//        Long userType = user.getUserType();
//
//        if (userType == 0) {
//            Admin admin = adminRepository.save(new Admin());
////            user.setAdmin(admin);
//            userRepository.save(user).setAdmin(admin);
//            return new LoginResponse(user.getId(), userType);
//        }
//
//
////        throw new NotFoundException("user is not of type admins");
//
//        throw new NotFoundException("Creation failed");
//    }

}
