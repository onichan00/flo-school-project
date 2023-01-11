package com.hva.helios.repositories.interfaces.jpa;

import com.hva.helios.models.user.Specialist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface SpecialistJPARepository
        extends JpaRepository<Specialist,Long> {

    List<Specialist> findById(long id);

    Specialist getSpecialistById(long id);
}
