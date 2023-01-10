package com.hva.helios.repositories;

import com.hva.helios.models.Announcement;
import com.hva.helios.models.Project;
import com.hva.helios.repositories.interfaces.EntityRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Simon Vriesema
 */
@Repository
@Transactional
public class AnnouncementRepository implements EntityRepository<Announcement> {

    /**
     * The entity manager to use for persistence operations.
     */
    @PersistenceContext
    private EntityManager entityManager;
    /**
     * Method to return a list of all entities
     *
     * @return List of entities
     */
    @Override
    public List<Announcement> findAll() {
        TypedQuery<Announcement> query =
                entityManager.createQuery(
                        "SELECT announcement from Announcement announcement", Announcement.class);

        return query.getResultList();
    }

    /**
     * Method to find and return one entity specified by ID
     *
     * @param id ID of object to find
     * @return Entity founded by ID
     */
    @Override
    public Announcement findById(long id) {
        return null;
    }

    /**
     * @param email
     * @return
     */
    @Override
    public Announcement findByEmail(String email) {
        return null;
    }

    /**
     * Method to save an entity to the DB
     *
     * @param entity Entity to save
     * @return The entity that has been saved
     */
    @Override
    public Announcement save(Announcement entity) {
        return entityManager.merge(entity);
    }

    /**
     * Method to delete an entity from the DB
     *
     * @param id Entity to be deleted, found by ID
     * @return The entity that has been deleted
     */
    @Override
    public Announcement deleteById(long id) {
        return null;
    }

    /**
     * Returns a list of announcements for the given project.
     *
     * @param project the project to filter the announcements by
     * @return a list of announcements for the given project
     */
    public List<Announcement> getAllByProject (Project project) {
        // Use a stream to filter the announcements by project
        return this.findAll()
                .stream()
                .filter(announcement -> announcement.getProject().equals(project))
                .collect(Collectors.toList());
    }

    /**
     * Saves a list of announcements to the database.
     *
     * @param announcements the announcements to save
     * @return the saved announcements
     */
    public List<Announcement> saveAll(List<Announcement> announcements) {
        return announcements.stream()
                .map(this::save)
                .collect(Collectors.toList());
    }


    /**
     * Method to find and return all entity specified by ID
     *
     * @param id ID of object to find
     * @return Entity founded by ID
     */
    public List<Announcement> findAllById(long id) {
        return this.findAll()
                .stream()
                .filter(announcement -> announcement.getProject().getId().equals(id))
                .collect(Collectors.toList());
    }
}
