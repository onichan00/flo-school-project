package com.hva.helios.repositories.interfaces;

import com.hva.helios.models.Project;
import com.hva.helios.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface testRepo extends JpaRepository<Project,Long>{
    List<Project> findAllByUser(User user);

}