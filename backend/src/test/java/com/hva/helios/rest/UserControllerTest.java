package com.hva.helios.rest;

import com.hva.helios.models.User;
import com.hva.helios.repositories.interfaces.jpa.UserJPARepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private UserJPARepository userJPARepository;

    @Value("/api")
    private String servletContextPath;

    @BeforeEach
    void setup() {
        if (servletContextPath == null) servletContextPath = "/";
    }

    /**
     * This test checks whether a call to the specialist applications endpoint really only retrieves
     * users with a Specialist relationship whose approvalStatus == 2 (a.k.a. 'pending').
     */
    @Test
    void shouldFetchOnlyPendingSpecialistApplications() {
        ResponseEntity<User[]> response = restTemplate.getForEntity("/users/specialists/applications", User[].class);
        User[] users = response.getBody();

        //check HTTP status
        assertEquals(HttpStatus.OK, response.getStatusCode());

        for (User user: users) {
            //verify that User only has Specialist relationship
            assertNull(user.getClient());
            assertNull(user.getAdmin());
            //check Specialist's approval status
            assertEquals(2, user.getSpecialist().getApprovalStatus());
        }
    }
}