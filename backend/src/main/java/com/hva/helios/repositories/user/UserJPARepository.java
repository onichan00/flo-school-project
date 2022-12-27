package com.hva.helios.repositories.user;

import com.hva.helios.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserJPARepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
