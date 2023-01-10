package com.hva.helios.rest;

import com.hva.helios.exceptions.NotFoundException;
import com.hva.helios.models.Announcement;
import com.hva.helios.models.Project;
import com.hva.helios.models.User;
import com.hva.helios.repositories.AnnouncementRepository;
import com.hva.helios.repositories.ProjectJPARepository;
import com.hva.helios.repositories.interfaces.jpa.UserJPARepository;
import com.hva.helios.repositories.user.UserSkillJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

/**
 * A controller class for managing announcements.
 *
 * @author Simon Vriesema
 */
@RestController
@RequestMapping("announcements")
public class AnnouncementController {
    @Autowired
    private ProjectJPARepository projectRepository;
    @Autowired
    private UserJPARepository userRepository;
    @Autowired
    private AnnouncementRepository announcementRepository;

    @GetMapping("")
    public List<Announcement> getAllAnnouncements() {
        return announcementRepository.findAll();
    }

    @GetMapping("{id}")
    public List<Announcement> getAllAnnouncementsFromProjectId (@PathVariable long id) {
        return announcementRepository.findAllById(id);
    }

    @PostMapping("get")
    public Announcement addAnnouncement(@RequestBody Announcement announcement, @RequestParam long clientId, @RequestParam long projectId ) {
        System.out.println("KAK" + announcement);
        System.out.println("KAK" + clientId);
        System.out.println("KAK" + projectId);

        try {
            User user = userRepository.findById(clientId).orElseThrow(() -> new NotFoundException("user not found"));
            Project project = (Project) projectRepository.findById(projectId);

            announcement.setUser(user);
            announcement.setProject(project);

            return announcementRepository.save(announcement);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    @PostMapping("announcements")
    public List<Announcement> addAnnouncements(@RequestBody List<Announcement> announcements, @RequestParam long clientId, @RequestParam long projectId) {
        try {
            User user = userRepository.findById(clientId).orElseThrow(() -> new NotFoundException("user not found"));
            Project project = (Project) projectRepository.findById(projectId);

            // Set the user and project for each announcement
            announcements.forEach(a -> {
                a.setUser(user);
                a.setProject(project);
            });

            // Save the announcements to the database
            return announcementRepository.saveAll(announcements);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return Collections.emptyList();
        }
    }


}
