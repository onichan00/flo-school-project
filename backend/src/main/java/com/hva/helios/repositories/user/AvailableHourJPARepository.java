package com.hva.helios.repositories.user;

import com.hva.helios.models.user.hour.AvailableHour;
import com.hva.helios.models.user.hour.Hour;
import com.hva.helios.repositories.EntityRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public AvailableHour findByEmail(String email) {
        return null;
    }

    @Override
    public AvailableHour save(AvailableHour entity) {
//        for (Map.Entry<String,String> entry : gfg.entrySet())
//            System.out.println("Key = " + entry.getKey() +
//                ", Value = " + entry.getValue());

//        Map<String, Hour> days = entity.getDays();
//
//        for ()

        return entityManager.merge(entity);
    }

    @Override
    public AvailableHour deleteById(long id) {
        AvailableHour availableHour = findById(id);
        entityManager.remove(availableHour);
        return availableHour;
    }
}
