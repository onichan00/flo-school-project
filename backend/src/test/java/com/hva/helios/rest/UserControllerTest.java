package com.hva.helios.rest;

import com.hva.helios.models.User;
import com.hva.helios.models.user.Specialist;
import com.hva.helios.repositories.interfaces.jpa.UserJPARepository;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

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
    void applicationsEndpointShouldReturnOnlyPendingSpecialistApplications() {

        ResponseEntity<User[]> response = restTemplate.getForEntity(
                "/users/specialists/applications", User[].class);
        User[] users = response.getBody();

        // Check HTTP status
        assertEquals(HttpStatus.OK, response.getStatusCode());

        assertNotNull(users);
        for (User user: users) {
            // Verify that User only has Specialist relationship
            assertNull(user.getClient());
            assertNull(user.getAdmin());
            // Check Specialist's approval status
            assertThat(user.getSpecialist().getApprovalStatus(), is(2L));
        }
    }

    /**
     * This test checks whether a Specialist-type User's approval status is properly updated to 1.
     */
    @Test
    void specialistApplicationApprovalStatusShouldBe1AfterUpdating() {
        // Do some stuff
        Map<String, String> params = new HashMap<>();
        Specialist specialist = Specialist.createSampleSpecialist();
        specialist.setApprovalStatus(1);
        specialist.setId(1L);
        params.put("id", "1");

        // Update Specialist's approval status
        restTemplate.put("/users/specialists/applications/1", specialist, params);

        // Fetch all Specialist type User entities
        User[] specialists = restTemplate.getForObject("/users/specialists", User[].class);

        // Attempt to find updated Specialist in Array of all specialists
        Specialist updatedSpecialist = null;
        for (User user: specialists) {
            if (user.getSpecialist().getId() == specialist.getId()) {
                // Assign specialist from findAll() to local variable
                updatedSpecialist = user.getSpecialist();
            }
        }
        // Check whether approval status has been properly updated to be 1 (WOW SO DESCRIPTIVE)
        assertNotNull(updatedSpecialist);
        assertThat(updatedSpecialist.getApprovalStatus(), is(1L));
    }
}

















