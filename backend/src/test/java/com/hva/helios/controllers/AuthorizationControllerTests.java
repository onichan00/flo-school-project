package com.hva.helios.controllers;

import com.hva.helios.exceptions.NotFoundException;
import com.hva.helios.models.User;
import com.hva.helios.models.record.LoginBody;
import com.hva.helios.repositories.interfaces.jpa.SpecialistJPARepository;
import com.hva.helios.repositories.interfaces.jpa.UserJPARepository;
import com.hva.helios.repositories.interfaces.testRepo;
import com.hva.helios.rest.AuthorizationController;
import com.hva.helios.rest.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ComponentScan({ "com.hva.helios.rest", "com.hva.helios.repositories" })
@Transactional
public class AuthorizationControllerTests {

    @Autowired
    private UserJPARepository userRepo;

    @Autowired
    private SpecialistJPARepository specialistRepo;

    @Autowired
    private testRepo projectRepo;

    @Autowired
    private UserController userController;

    @Autowired
    private AuthorizationController authController;

    @Test
    void login() {
        // create a login body
        LoginBody truthyLoginBody = new LoginBody("admin", "admin");
        LoginBody falsyLoginBody = new LoginBody("admin", "wrongpassword");


        // try to login and save login response
        ResponseEntity loginResponse200 = authController.login(truthyLoginBody);

        // try to login with wrong password
        ResponseEntity loginResponse400 = authController.login(falsyLoginBody);

        // check if login is succesfull
        assertEquals(HttpStatus.OK, loginResponse200.getStatusCode());

        // check if login is unsuccesfull on wrong input
        assertEquals(HttpStatus.BAD_REQUEST, loginResponse400.getStatusCode());


    }

    @Test
    void register() {
        // create new user
        User nUser = new User("dennis223.moes1@hva.nl",
                "password123",
                "yahia",
                "",
                "elsherbini",
                null,
                "Hello I am Yahia",
                "+31 6 12345678",
                "Amsterdam",
                "1091 GH",
                "Wibautstraat 3b",
                0L);

        // register user
        User registeredUser = authController.register(nUser);

        // check if registered user name matches created user name
        assertEquals("yahia",registeredUser.getFirst_name());

        //try to register same user with same email again
        Exception thrownException = assertThrows(NotFoundException.class,() -> {
            authController.register(nUser);
        });


        assertEquals("user with this email already exists", thrownException.getMessage());

    }
}
