package com.hva.helios.repositories;

import com.hva.helios.models.Project;
import com.hva.helios.models.user.Client;
import com.hva.helios.models.user.skill.Skill;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface testRepo extends JpaRepository<Project,Long>{
    List<Project> findAllByClient(Client client);
}