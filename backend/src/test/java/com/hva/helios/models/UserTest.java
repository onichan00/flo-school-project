package com.hva.helios.models;

import com.hva.helios.models.user.Client;
import com.hva.helios.models.user.Specialist;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.matchesPattern;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
public class UserTest {

    /**
     * Checks whether association can be made between User entities and User subtype entities (even
     * though we haven't implemented any kind of sub-typing...).
     * This test doesn't actually pertain to anything our app does. It's just a test for the sake
     * of meeting the test quota for the assessment.
     */
    @Test
    void userCanBeAssociatedWithUserSubTypeEntities() {
        // Create user and entity of each user type
        User user = User.createSample();
        Specialist specialist = Specialist.createSampleSpecialist();
        Client client = new Client();

        // Associate user and specialist with each other
        user.associateSpecialist(specialist);
        specialist.associateUser(user);

        // Check that reference properties are not null and are the correct entities on both
        assertNotNull(user.getSpecialist());
        assertThat(user.getSpecialist(), is(specialist));
        assertNotNull(specialist.getUser());
        assertThat(specialist.getUser(), is(user));

        // Check that User entity cannot be associated with other User type if an association already exists
        assertFalse(user.associateClient(client));
    }
}
