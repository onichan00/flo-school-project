package com.hva.helios.repositories;

import com.hva.helios.models.Project;
import com.hva.helios.models.user.Client;
import com.hva.helios.repositories.interfaces.EntityRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

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

    /**
     * Returns a map with keys representing the last 7 days and values representing the number of projects created on each day.
     * The keys are strings in the format "YYYY-MM-DD" and the values are integers.
     *
     * @return a map with keys representing the last 7 days and values representing the number of projects created on each day
     */
    public Map<String, Integer> getProjectCountByDay() {
        final int AMOUNT_OF_DAYS = 6;
        Map<String, Integer> projectCountByDay = new LinkedHashMap<>();
        List<Project> projects = this.findAll();

        // Get the current time as a Date
        Date currentDate = new Date();

        // Iterate through the last 6 days
        for (int i = 0; i < AMOUNT_OF_DAYS; i++) {
            // Get the date as a string in the format "YYYY-MM-DD"
            SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD");
            String dateString = dateFormat.format(currentDate);

            // Find the number of projects created on this date
            long projectCount = projects.stream()
                    .filter(project -> {
                        SimpleDateFormat projectDateFormat = new SimpleDateFormat("YYYY-MM-DD");
                        String projectDateString = projectDateFormat.format(project.getCreated());
                        return projectDateString.equals(dateString);
                    })
                    .count();

            // Add the date and project count to the map
            projectCountByDay.put(dateString, (int) projectCount);

            // Decrement the date to move to the previous day
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(currentDate);
            calendar.add(Calendar.DATE, -1);
            currentDate = calendar.getTime();
        }

        return projectCountByDay;
    }


    /**
     * Returns a list of the most recently created projects.
     *
     * @return a list of projects, sorted in descending order by creation date.
     */
    public List<Project> getMostRecentProjects() {
        // Use a stream to sort the projects by their creation date in descending order
        return this.findAll()
                .stream()
                .sorted((p1, p2) -> p2.getCreated().compareTo(p1.getCreated()))
                .collect(Collectors.toList());
    }

    /**
     * Compares the number of projects created at least one week ago to the total number of projects.
     * Returns a map with keys "Positive" and "Negative", representing the percentage increase or decrease in the number of projects.
     * If the percentage is zero, both keys will have a value of 0.0.
     *
     * @return a map with keys "Positive" and "Negative" and values representing the percentage increase or decrease
     */
    public Map<String, Double> compareProjectData() {
        // Get the current time as a Date object
        Date currentTime = new Date();

        // Get the time one week ago as a Date object
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentTime);
        calendar.add(Calendar.DATE, -7);
        Date oneWeekAgo = calendar.getTime();

        // Find the total number of projects
        double numOfProjects = this.findAll().size();

        // Find the total number of projects created at least one week ago
        long numOfProjectsCreatedOneWeekAgo = this.findAll()
                .stream()
                .filter(project -> project.getCreated().before(oneWeekAgo))
                .count();

        // Calculate the percentage change in the number of projects
        double percentage = ((numOfProjects - numOfProjectsCreatedOneWeekAgo) / numOfProjects ) * 100;

        // Round the result to two decimal places
        DecimalFormat df = new DecimalFormat("#.##");
        double percentageDouble = Double.parseDouble(df.format(percentage));

        Map<String, Double> riseOrFall = new HashMap<>();

        if (percentageDouble > 0) {
            riseOrFall.put("Positive", percentageDouble);
            riseOrFall.put("Negative", 0.0);
        } else if (percentageDouble < 0) {
            riseOrFall.put("Positive", 0.0);
            riseOrFall.put("Negative", Math.abs(percentageDouble));
        } else {
            riseOrFall.put("Positive", 0.0);
            riseOrFall.put("Negative", 0.0);
        }

        return riseOrFall;
    }


}
