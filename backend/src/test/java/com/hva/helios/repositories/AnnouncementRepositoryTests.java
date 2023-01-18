package com.hva.helios.repositories;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.hva.helios.models.Announcement;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * This class contains test cases for the AnnouncementRepository class.
 * It uses mock objects for testing purposes.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(MockitoExtension.class)
public class AnnouncementRepositoryTests {

    /**
     * Mock object of the EntityManager class.
     */
    @Mock
    private EntityManager entityManager;

    /**
     * Mock object of the TypedQuery class.
     */
    @Mock
    private TypedQuery<Announcement> query;

    /**
     * Injects the mock objects into the AnnouncementRepository instance.
     */
    @InjectMocks
    private AnnouncementRepository repository;

    /**
     * Test case for the findAll method.
     * Verifies if the method returns a list of all announcements.
     */
    @Test
    public void findAll_shouldReturnAllAnnouncements() {
        //Arrange
        List<Announcement> expectedAnnouncements = new ArrayList<>();
        expectedAnnouncements.add(new Announcement());
        expectedAnnouncements.add(new Announcement());
        when(entityManager.createQuery("SELECT announcement from Announcement announcement", Announcement.class)).thenReturn(query);
        when(query.getResultList()).thenReturn(expectedAnnouncements);

        //Act
        List<Announcement> actualAnnouncements = repository.findAll();

        //Assert
        assertThat(actualAnnouncements).isEqualTo(expectedAnnouncements);
    }


    /**
     * Test case for the save method.
     * Verifies if the method saves an announcement.
     */
    @Test
    public void save_shouldSaveAnnouncement() {
        //Arrange
        Announcement announcement = new Announcement();
        /**
         * Configures the mock object of the EntityManager to return the announcement
         * object when the merge method is called with the announcement object as an argument.
         */
        when(entityManager.merge(announcement)).thenReturn(announcement);

        //Act
        Announcement actualAnnouncement = repository.save(announcement);

        //Assert
        /**
         * Verifies if the actualAnnouncement object is equal to the expected announcement object.
         */
        assertThat(actualAnnouncement).isEqualTo(announcement);
        /**
         * Verifies if the merge method of the mock object of the EntitiesManager is called
         * with the announcement object as an argument.
         */
        verify(entityManager).merge(announcement);
    }
}

