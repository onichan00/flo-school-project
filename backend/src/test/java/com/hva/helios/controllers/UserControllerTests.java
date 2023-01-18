package com.hva.helios.controllers;

import com.hva.helios.models.Project;
import com.hva.helios.models.User;
import com.hva.helios.models.user.Specialist;
import com.hva.helios.repositories.interfaces.jpa.SpecialistJPARepository;
import com.hva.helios.repositories.interfaces.jpa.UserJPARepository;
import com.hva.helios.repositories.interfaces.testRepo;
import com.hva.helios.rest.UserController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//@DataJpaTest
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ComponentScan({ "com.hva.helios.rest", "com.hva.helios.repositories" })
@Transactional
public class UserControllerTests {
    @Autowired
    private UserJPARepository userRepo;

    @Autowired
    private SpecialistJPARepository specialistRepo;

    @Autowired
    private testRepo projectRepo;

    @Autowired
    private UserController userController;

    private User user;

    @BeforeEach
    public void setup() {
        // declare and instantiate new user
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

        // save and store new user
        user = userRepo.save(nUser);


    }

    @Test
    void deleteUserById() {
        // check if user exists
        assertNotNull(userRepo.findById(user.getId()));

        // find user by its id
        userController.deleteUserById(user.getId());

        // get user and store it ( should be null )
        User deleted = userRepo.findById(user.getId()).orElse(null);

        // check if deleted
        assertNull(deleted);
    }

    @Test
    void updateUser() {

        // find user by its id
        User toChange = userRepo.findById(user.getId()).orElse(null);

        // check if the user is found
        assertNotNull(toChange);

        // set a new first name
        toChange.setFirst_name("New Firstname");

        // update the user
        userController.updateUser(toChange);

        // find the user again
        User changed = userRepo.findById(user.getId()).orElse(null);

        // check if name matches new name
        assertEquals("New Firstname", changed.getFirst_name());
    }

    @Test
    void getAllUsers() {

        // get all users
        List<User> toTest = userController.getAllUsers();

        // test if the list is not null
        assertNotNull(toTest);

        // test if there is at least 1 user inside
        assertTrue(toTest.size() > 0);
    }

    @Test
    void getAllApprovedSpecialists() {

        // make a new specialist user
        User nSpecialist = new User("specialist22@gmail.com",
                "specialist",
                "jan",
                "",
                "Willem",
                null,
                "Hello I am specialist",
                "+31 6 12345678",
                "Amsterdam",
                "1091 GH",
                "Wibautstraat 3b",
                2L
        );

        // create a new specialist with approval status 1 ( approved )
        Specialist nSubCat =new Specialist(1,"Backend engineer", 1,null,null,null,null);

        // save it to the repo
        Specialist subCat = specialistRepo.save(nSubCat);

        // set the saved specialist
        nSpecialist.setSpecialist(subCat);

        // save the user
        userRepo.save(nSpecialist);

        // get all approved specialists
        List<User> toTest = userController.getAllApprovedSpecialists();

        // test if the list is not null
        assertNotNull(toTest);

        // test if the saved specialist is inside of the list
        assertNotNull(toTest.contains(nSpecialist));
    }

    @Test
    void getAllSpecialistsFromProject() {
        // check if project exists
        Project project = projectRepo.findById(1L).orElse(null);
        assertNotNull(project);

        // get all specialists from project
        List<User> allSpecialists = userController.getAllSpecialistsFromProject(1);

        // check if there are specialists in the project
        assertNotNull(allSpecialists);
    }

}