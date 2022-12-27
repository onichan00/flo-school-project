package com.hva.helios.repositories.user;

import com.hva.helios.models.user.Specialist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface SpecialistJPARepository
        extends JpaRepository<Specialist,Long> {

}
