package com.hva.helios.repositories;

import com.hva.helios.models.User;
import com.hva.helios.repositories.interfaces.jpa.UserJPARepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ComponentScan({ "com.hva.helios.repositories" })
public class UserRepositoryTests {
    @Autowired
    private UserJPARepository userRepo;

    //declare user
    User user;

    @BeforeEach
    public void setup() {
        // create instantiate new user
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

        // save user and store it in user variable
        user = userRepo.save(nUser);
    }

    @Test
    void deleteUserByUser() {
        // check if user exists
        assertNotNull(userRepo.findById(user.getId()));

        // delete user
        userRepo.delete(user);

        // check find and store user, if not found null ( deleted )
        User deleted = userRepo.findById(user.getId()).orElse(null);

        // check if user is deleted ( null )
        assertNull(deleted);
    }

    @Test
    void deleteUserById() {
        // check if user exists
        assertNotNull(userRepo.findById(user.getId()));

        // delete user
        userRepo.deleteById(user.getId());

        // check find and store user, if not found null ( deleted )
        User deleted = userRepo.findById(user.getId()).orElse(null);

        // check if user is deleted ( null )
        assertNull(deleted);
    }

    @Test
    void updateUser() {

        User toChange = userRepo.findById(user.getId()).orElse(null);

        assertNotNull(toChange);

        toChange.setFirst_name("New Firstname");

        userRepo.save(toChange);

        User changed = userRepo.findById(user.getId()).orElse(null);

        assertEquals("New Firstname", changed.getFirst_name());
    }

    @Test
    void findAllUsers() {

        // get all users
        List<User> toTest = userRepo.findAll();

        // test if the list is not null
        assertNotNull(toTest);

        // test if there is at least 1 user inside
        assertTrue(toTest.size() > 0);
    }

    @Test
    void findUserById(){
        // find and store user
        User foundUser = userRepo.findById(user.getId()).orElse(null);

        // check if user is not null
        assertNotNull(foundUser);

        // check if name matches
        assertEquals("yahia", foundUser.getFirst_name());
    }

}
