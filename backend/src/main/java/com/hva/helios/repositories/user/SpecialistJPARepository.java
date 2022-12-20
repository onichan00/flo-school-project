package com.hva.helios.repositories.user;

import com.hva.helios.models.user.Specialist;
import com.hva.helios.repositories.EntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class SpecialistJPARepository implements EntityRepository<Specialist> {

    @Autowired
    private EntityManager entityManager;

    public SpecialistJPARepository() {
    }

    @Override
    public List<Specialist> findAll() {
        TypedQuery<Specialist> query =
                entityManager.createQuery("SELECT '*' FROM Specialist specialist WHERE approvalStatus != 'approved'", Specialist.class);
        return query.getResultList();
    }

    @Override
    public Specialist findById(long id) {
        return entityManager.find(Specialist.class, id);
    }

    @Override
    public Specialist findByEmail(String email) {
        return null;
    }

    @Override
    public Specialist save(Specialist entity) {
        return entityManager.merge(entity);
    }

    @Override
    public Specialist deleteById(long id) {
        Specialist specialistToDelete = this.findById(id);
        entityManager.remove(specialistToDelete);
        return specialistToDelete;
    }
}
