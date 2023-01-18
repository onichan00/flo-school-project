package com.hva.helios.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.hva.helios.rest.AnnouncementController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.hva.helios.exceptions.NotFoundException;
import com.hva.helios.models.Announcement;
import com.hva.helios.models.Project;
import com.hva.helios.models.User;
import com.hva.helios.repositories.AnnouncementRepository;
import com.hva.helios.repositories.ProjectJPARepository;
import com.hva.helios.repositories.interfaces.jpa.UserJPARepository;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ComponentScan({"com.hva.helios.rest", "com.hva.helios.repositories"})
@ExtendWith(MockitoExtension.class)
public class AnnouncementControllerTest {
    /**
     * Mocked instance of the {@link UserJPARepository}
     */
    @Mock
    private UserJPARepository userRepository;

    /**
     * Mocked instance of the {@link AnnouncementRepository}
     */
    @Mock
    private AnnouncementRepository announcementRepository;

    @InjectMocks
    private AnnouncementController controller;

    /**
     * Test method that tests the getAllAnnouncements() method of the AnnouncementController class.
     * The test case asserts that the method returns the expected list of announcements when invoked.
     */
    @Test
    public void getAllAnnouncements_shouldReturnAllAnnouncements() {
        //Arrange
        // create a list of expected announcements
        List<Announcement> expectedAnnouncements = new ArrayList<>();
        expectedAnnouncements.add(new Announcement());
        expectedAnnouncements.add(new Announcement());
        // mock the announcementRepository's findAll() method to return the expected announcements
        when(announcementRepository.findAll()).thenReturn(expectedAnnouncements);

        //Act
        // invoke the getAllAnnouncements() method of the controller
        List<Announcement> actualAnnouncements = controller.getAllAnnouncements();

        //Assert
        // assert that the returned list of announcements is the same as the expected list
        assertThat(actualAnnouncements).isEqualTo(expectedAnnouncements);
    }

    /**
     * Test method for {@link AnnouncementController#getAllAnnouncementsFromProjectId(long)}
     * Test if the method returns all announcements for a given project id
     */
    @Test
    public void getAllAnnouncementsFromProjectId_shouldReturnAnnouncementsForProjectId() {
        //Arrange
        //Creating a list of expected announcements
        List<Announcement> expectedAnnouncements = new ArrayList<>();
        expectedAnnouncements.add(new Announcement());
        expectedAnnouncements.add(new Announcement());
        //Mocking the call to the repository and returning the expected announcements
        when(announcementRepository.findAllById(1L)).thenReturn(expectedAnnouncements);

        //Act
        //Calling the method under test and storing the result in actualAnnouncements
        List<Announcement> actualAnnouncements = controller.getAllAnnouncementsFromProjectId(1L);

        //Assert
        //Checking if the expected announcements match the actual announcements
        assertThat(actualAnnouncements).isEqualTo(expectedAnnouncements);
    }

    /**
     * Test method to check if the addAnnouncement method throws a NotFoundException when the user is not found.
     */
    @Test
    public void addAnnouncement_shouldThrowNotFoundException_WhenUserNotFound() {
        // Arrange: Create an announcement object to add
        Announcement expectedAnnouncement = new Announcement();
        // Use Mockito to return a NotFoundException when the userRepository's findById method is called
        when(userRepository.findById(1L)).thenThrow(new NotFoundException("user not found"));

        // Act: Call the addAnnouncement method with the expectedAnnouncement, user id and project id
        Announcement actualAnnouncement = controller.addAnnouncement(expectedAnnouncement, 1L, 1L);

        // Assert: Check that the actualAnnouncement is null (indicating a NotFoundException was thrown)
        assertThat(actualAnnouncement).isEqualTo(null);
    }
}
