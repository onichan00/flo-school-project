package com.hva.helios.repositories;

import com.hva.helios.models.user.skill.Skill;
import com.hva.helios.repositories.EntityRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class SkillJPARepository
        implements EntityRepository<Skill> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Skill> findAll() {
        TypedQuery<Skill> query =
                entityManager.createQuery(
                        "SELECT skill from Skill skill", Skill.class);

        return query.getResultList();
    }

    @Override
    public Skill findById(long id) {
        return entityManager.find(Skill.class, id);
    }

    @Override
    public Skill findByEmail(String email) {
        return null;
    }

    @Override
    public Skill save(Skill entity) {
        return entityManager.merge(entity);
    }

    @Override
    public Skill deleteById(long id) {
        Skill skill = findById(id);
        entityManager.remove(skill);
        return skill;
    }
}
