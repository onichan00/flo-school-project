package com.hva.helios.repositories.user;

import com.hva.helios.models.user.Specialist;
import com.hva.helios.repositories.EntityRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class SpecialistJPARepository
        implements EntityRepository<Specialist> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Specialist> findAll() {
        TypedQuery<Specialist> query = entityManager.createQuery(
                "Select specialist from Specialist specialist", Specialist.class);

        return query.getResultList();
    }

    @Override
    public Specialist findById(long id) {
        return entityManager.find(Specialist.class, id);
    }

    @Override
    public Specialist save(Specialist entity) {
        return entityManager.merge(entity);
    }

    @Override
    public Specialist deleteById(long id) {
        Specialist specialist = findById(id);
        entityManager.remove(specialist);
        return specialist;
    }
}
