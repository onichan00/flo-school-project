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

    /**

     This method handles the login process for the user.
     @param loginBody an object containing the email and password fields for the user.
     @return a response entity with the user's id, user type, and (if applicable) specialist approval status.
     @throws NotFoundException if a user with the provided email is not found in the system.
     */
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

    /**

     Register a new user in the system.
     The method takes in a User object from the request body, perform email unique check, hash the password and
     set the userType. Based on the userType, it will save the user and also create admin, client or specialist
     respectively.
     @param user the new user information
     @return the registered user
     @throws NotFoundException if a user with the same email already exists or registration failed
     */
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

            return newUser;
        }

        if (userType == 2) {
            Specialist savedSpecialist;

            if (user.getSpecialist() != null){
                savedSpecialist = specialistRepository.save(user.getSpecialist());
            } else {
                savedSpecialist = specialistRepository.save(user.getSpecialist());
            }

            user.setSpecialist(savedSpecialist);

            User newUser = userRepository.save(user);

            return newUser;
        }

        throw new NotFoundException("register failed");
    }
}
