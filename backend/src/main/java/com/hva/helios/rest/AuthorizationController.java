package com.hva.helios.rest;

import com.hva.helios.APIConfig;
import com.hva.helios.exceptions.NotFoundException;
import com.hva.helios.models.JWToken;
import com.hva.helios.models.User;
import com.hva.helios.models.record.LoginBody;
import com.hva.helios.models.record.LoginResponse;
import com.hva.helios.models.user.Admin;
import com.hva.helios.models.user.Client;
import com.hva.helios.models.user.Specialist;
import com.hva.helios.repositories.interfaces.jpa.AdminJPARepository;
import com.hva.helios.repositories.interfaces.jpa.ClientJPARepository;
import com.hva.helios.repositories.interfaces.jpa.SpecialistJPARepository;
import com.hva.helios.repositories.interfaces.jpa.UserJPARepository;
import com.hva.helios.utilities.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("authorization")
public class AuthorizationController {

    @Autowired
    private UserJPARepository userRepository;


    @Autowired
    private SpecialistJPARepository specialistRepository;

    @Autowired
    private ClientJPARepository clientRepository;

    @Autowired
    private AdminJPARepository adminRepository;

    @Autowired
    private APIConfig apiConfig;

    Authentication authentication = new Authentication();

    @PostMapping("login")
    public ResponseEntity login(@RequestBody LoginBody loginBody) {
        User user = userRepository.findByEmail(loginBody.email());


        if (user == null) {
            throw new NotFoundException(String.format("User with email: %s was not found", loginBody.email()));
        }
        String hashedPassword = authentication.hash(loginBody.password());


        JWToken jwToken = new JWToken(user.getFirst_name()+user.getSecond_name()+user.getLast_name(), user.getId(), user.getUserType());
        String tokenString = jwToken.encode(this.apiConfig.getIssuer(),
                this.apiConfig.getPassphrase(), this.apiConfig.getTokenDurationOfValidity(), user.getUserType());



        if (!user.getPassword().equals(hashedPassword)) {
            return ResponseEntity.badRequest()
                    .body(new LoginResponse(-1L, -1L, null));

        }

        if (user.getUserType() == 2){
            return ResponseEntity.ok().header(HttpHeaders.AUTHORIZATION,"Bearer " +  tokenString)
                    .body(new LoginResponse(user.getId(), user.getUserType(), user.getSpecialist().getApprovalStatus()));
        }

        return ResponseEntity.ok().header(HttpHeaders.AUTHORIZATION,"Bearer " +  tokenString)
                .body(new LoginResponse(user.getId(), user.getUserType(), null));

    }

    @PostMapping("register")
    public User register(@RequestBody User user) {
        // email unique check
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new NotFoundException("user with this email already exists");
        }

        String hashedPassword = authentication.hash(user.getPassword());
        user.setPassword(hashedPassword);
        Long userType = user.getUserType();

        if (userType == 0) {
            Admin admin = new Admin();
            Admin savedAdmin = adminRepository.save(admin);
            user.setAdmin(savedAdmin);
            User nUser = userRepository.save(user);
//            return new LoginResponse(nUser.getId(), nUser.getUserType());
            return nUser;

        }

        if (userType == 1) {
            Client savedClient;
            if (user.getClient() != null) {
                savedClient = clientRepository.save(user.getClient());

            } else {
                savedClient = clientRepository.save(new Client());
            }
            user.setClient(savedClient);
            User newUser = userRepository.save(user);

//            return new LoginResponse(newUser.getId(), newUser.getUserType());
            return newUser;
        }

        // TODO: convert objects from the json to the correct type and set them to the specialists before setting the specialist in the user and saving the user
        // TODO: TLDR its not functional yet
        if (userType == 2) {
            Specialist savedSpecialist;

            if (user.getSpecialist() != null){
                savedSpecialist = specialistRepository.save(user.getSpecialist());
            } else {
                savedSpecialist = specialistRepository.save(user.getSpecialist());
            }

            user.setSpecialist(savedSpecialist);

            User newUser = userRepository.save(user);

//            return new LoginResponse(newUser.getId(), newUser.getUserType());
            return newUser;
        }

        throw new NotFoundException("register failed");
    }
}
