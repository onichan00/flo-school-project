package com.hva.helios.repositories.user;

import com.hva.helios.models.user.hour.AvailableHour;
import com.hva.helios.repositories.EntityRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class AvailableHourJPARepository
        implements EntityRepository<AvailableHour> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<AvailableHour> findAll() {
        TypedQuery<AvailableHour> query =
                entityManager.createQuery(
                        "SELECT availableHour from AvailableHour availableHour", AvailableHour.class);

        return query.getResultList();
    }

    @Override
    public AvailableHour findById(long id) {
        return entityManager.find(AvailableHour.class, id);
    }

    @Override
    public AvailableHour save(AvailableHour entity) {
        return entityManager.merge(entity);
    }

    @Override
    public AvailableHour deleteById(long id) {
        AvailableHour availableHour = findById(id);
        entityManager.remove(availableHour);
        return availableHour;
    }
}
