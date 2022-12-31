package com.hva.helios.repositories.interfaces.jpa;

import com.hva.helios.models.User;
import com.hva.helios.models.user.Specialist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserJPARepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
