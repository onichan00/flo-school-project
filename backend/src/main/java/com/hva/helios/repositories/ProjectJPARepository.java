package com.hva.helios.repositories;

import com.hva.helios.models.Project;
import com.hva.helios.models.user.skill.Skill;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ProjectJPARepository
        implements EntityRepository<Project> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Project> findAll() {
        TypedQuery<Project> query =
                entityManager.createQuery(
                        "SELECT project from Project project", Project.class);

        return query.getResultList();
    }

    @Override
    public Project findById(long id) {
        return entityManager.find(Project.class, id);
    }

    @Override
    public Project save(Project entity) {
        return entityManager.merge(entity);
    }

    @Override
    public Project deleteById(long id) {
        Project project = findById(id);
        entityManager.remove(project);
        return project;
    }
}
