package com.hva.helios.repositories.user;

import com.hva.helios.models.User;
import com.hva.helios.repositories.EntityRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserJPARepository
        implements EntityRepository<User> {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Method to return a list of all entities
     *
     * @return List of entities
     */
    @Override
    public List<User> findAll() {
        TypedQuery<User> query = entityManager.createQuery(
                "Select user from User user", User.class);

        return query.getResultList();
    }

    /**
     * Method to find and return one entity specified by ID
     *
     * @param id ID of object to find
     * @return Entity founded by ID
     */
    @Override
    public User findById(long id) {
        return entityManager.find(User.class, id);
    }

    /**
     * Method to save an entity to the DB
     *
     * @param entity Entity to save
     * @return The entity that has been saved
     */
    @Override
    public User save(User entity) {
        return null;
    }

    /**
     * Method to delete an entity from the DB
     *
     * @param id Entity to be deleted, found by ID
     * @return The entity that has been deleted
     */
    @Override
    public User deleteById(long id) {
        return null;
    }
}
