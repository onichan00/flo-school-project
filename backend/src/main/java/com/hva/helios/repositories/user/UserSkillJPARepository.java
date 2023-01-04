package com.hva.helios.repositories.user;

import com.hva.helios.models.user.skill.UserSkill;
import com.hva.helios.repositories.interfaces.EntityRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserSkillJPARepository
        implements EntityRepository<UserSkill> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<UserSkill> findAll() {
        TypedQuery<UserSkill> query =
                entityManager.createQuery("SELECT userSkill from UserSkill userSkill", UserSkill.class);

        return query.getResultList();
    }

    @Override
    public UserSkill findById(long id) {
        return entityManager.find(UserSkill.class, id);
    }

    @Override
    public UserSkill findByEmail(String email) {
        return null;
    }

    @Override
    public UserSkill save(UserSkill entity) {
        return entityManager.merge(entity);
    }

    @Override
    public UserSkill deleteById(long id) {
        UserSkill userSkill = findById(id);
        entityManager.remove(userSkill);
        return userSkill;
    }
}
