package com.hva.helios.repositories.user;

import com.hva.helios.models.user.Admin;
import com.hva.helios.repositories.EntityRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class AdminJPARepository
        implements EntityRepository<Admin> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Admin> findAll() {
        TypedQuery<Admin> query =
                entityManager.createQuery("SELECT admin from Admin admin", Admin.class);

        return query.getResultList();
    }

    @Override
    public Admin findById(long id) {
        return entityManager.find(Admin.class, id);
    }

    @Override
    public Admin findByEmail(String email) {
        TypedQuery<Admin> query = entityManager.createQuery("SELECT admin from Admin admin",Admin.class);
        for (Admin admin : query.getResultList()){
            if (admin.getEmail().equals(email)){
                return admin;
            };
        };
        return null;
    }

    @Override
    public Admin save(Admin entity) {
        return entityManager.merge(entity);
    }

    @Override
    public Admin deleteById(long id) {
        Admin admin = findById(id);
        entityManager.remove(admin);
        return admin;
    }
}
