package com.hva.helios.repositories;

import com.hva.helios.models.FileModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface FileRepository extends JpaRepository<FileModel, String> {
    Optional<FileModel> findByName(String name);
}
