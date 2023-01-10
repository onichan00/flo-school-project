package com.hva.helios.data;

import com.hva.helios.models.Announcement;
import com.hva.helios.models.Project;
import com.hva.helios.models.User;
import com.hva.helios.models.user.Client;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * A class that holds a list of announcements.
 *
 * @author Simon Vriesema
 */
public class AnnouncementData {
    private ArrayList<Announcement> announcements;

    /**
     * Creates a new instance of the {@link AnnouncementData} class.
     */
    public AnnouncementData() {
        // Create a new announcement with a message and the current date
        Announcement announcement = new Announcement("Hello World!", LocalDate.now());
        Announcement announcement2 = new Announcement("Hello World!", LocalDate.now());
        // Add the announcement to the list
        this.announcements = new ArrayList<>(List.of(announcement, announcement2));
    }

    /**
     * Gets the list of announcements.
     *
     * @return the list of announcements
     */
    public ArrayList<Announcement> getAnnouncements() {
        return announcements;
    }
}
