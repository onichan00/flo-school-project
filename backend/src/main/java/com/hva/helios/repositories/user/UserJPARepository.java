package com.hva.helios.repositories.user;

import com.hva.helios.models.User;
import com.hva.helios.models.user.Specialist;
import com.hva.helios.repositories.EntityRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface UserJPARepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
//    Specialist findSpecialistByUser(User user);

}
