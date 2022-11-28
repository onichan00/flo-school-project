package com.hva.helios.repositories.user;

import com.hva.helios.models.user.hour.Hour;
import com.hva.helios.repositories.EntityRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class HourJPARepository
        implements EntityRepository<Hour> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Hour> findAll() {
        TypedQuery<Hour> query =
                entityManager.createQuery(
                        "SELECT hour from Hour hour", Hour.class);

        return query.getResultList();
    }

    @Override
    public Hour findById(long id) {
        return entityManager.find(Hour.class, id);
    }

    @Override
    public Hour save(Hour entity) {
        return entityManager.merge(entity);
    }

    @Override
    public Hour deleteById(long id) {
        Hour Hour = findById(id);
        entityManager.remove(Hour);
        return Hour;
    }
}
