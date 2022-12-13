package com.hva.helios.repositories;//package com.hva.helios.repositories;
//
//import com.hva.helios.models.Project;
//import com.hva.helios.models.user.skill.Skill;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import javax.swing.text.html.Option;
//import javax.transaction.Transactional;
//import java.util.Optional;
//
//@Repository
//@Transactional
//public interface ProjectJPARepository extends JpaRepository<Project,Long>{
//}

import com.hva.helios.models.Project;
import com.hva.helios.models.user.Client;
import com.hva.helios.models.user.Specialist;
import com.hva.helios.models.user.skill.Skill;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
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
    public Project findByEmail(String email) {
        return null;
    }

    @Override
    public Project save(Project entity) {
        return entityManager.merge(entity);
    }

    @Override
    public Project deleteById(long id) {
        Project project = entityManager.find(Project.class, id);
        entityManager.remove(project);
        return project;
//        Project project = findById(id);
//        entityManager.remove(project);
//        return null;
    }

    public List<Project> findByClient(Client client) {
        List<Project> projects = new ArrayList<>();
        TypedQuery<Project> query =
                entityManager.createQuery("SELECT project from Project project", Project.class);

        for (Project project : query.getResultList()){
            if (project.getClient().equals(client)){
                projects.add(project);
            };
        };

        if (projects.size() > 0) return projects;

        return null;
    }
}
