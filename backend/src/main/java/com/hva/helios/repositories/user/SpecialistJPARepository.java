package com.hva.helios.repositories.user;

import com.hva.helios.models.Project;
import com.hva.helios.models.user.Admin;
import com.hva.helios.models.user.Specialist;
import com.hva.helios.models.user.hour.AvailableHour;
import com.hva.helios.models.user.skill.UserSkill;
import com.hva.helios.repositories.EntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Repository
@Transactional
public class SpecialistJPARepository
        implements EntityRepository<Specialist> {

    @Autowired
    private EntityRepository<AvailableHour> availableHourRepository;

    @Autowired
    private EntityRepository<Project> projectsRepository;

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
    public Specialist findByEmail(String email) {
        TypedQuery<Specialist> query =
                entityManager.createQuery("SELECT specialist from Specialist specialist",Specialist.class);
        for (Specialist specialist : query.getResultList()){
            if (specialist.getEmail().equals(email)){
                return specialist;
            };
        };
        return null;
    }

    @Override
    public Specialist save(Specialist entity) {
        // Try to get the hours already assigned to the specialist
        AvailableHour availableHour = entity.getHours();
        Set<Project> projects = entity.getProjects();
        Set<UserSkill> skills = entity.getSkills();

        // If there is no hour assigned to the specialist make new hour
        if (availableHour == null) {
            availableHour = new AvailableHour();
            entity.setHours(availableHour);

            // Insert the new AvailableHour object in the DB
            availableHourRepository.save(availableHour);
        }

        return entityManager.merge(entity);
    }

    @Override
    public Specialist deleteById(long id) {
        Specialist specialist = findById(id);
        entityManager.remove(specialist);
        return specialist;
    }
}
