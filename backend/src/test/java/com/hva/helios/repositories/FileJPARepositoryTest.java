package com.hva.helios.repositories;

import com.hva.helios.models.FileModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest(includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION,
        classes = {Repository.class, Entity.class}))
public class FileJPARepositoryTest {

    @Autowired
    private FileJPARepository filesRepo;

    private List<FileModel> files = new ArrayList<>();

    @Value("/api")
    private String servletContextPath;

    @BeforeEach
    void setup() {
        this.initializeFiles();
    }

    void initializeFiles() {
        for (int i = 0; i < 10; i++) {
            FileModel file = new FileModel();
            file.setUserId(i);
            file.setName("test-file" + i + ".txt");
            file.setType("text file");
            file.setData(new byte[] {});
            file.setId("" + i);

            files.add(file);
        }
    }

    /**
     * This test checks whether a file can be saved and whether ID generation for the file properly
     * results in a UUID String. It also checks whether the name and type of the file have been
     * saved correctly.
     */
    @Test
    void filesCanBeSaved() {
        // Create file
        FileModel file = new FileModel();
        file.setUserId(40000);
        file.setName("test-file.txt");
        file.setType("text file");
        file.setData(new byte[]{});

        // Save file
        FileModel savedFile = filesRepo.save(file);

        // Check whether ID is generated (as a String)
        assertNotNull(savedFile.getId());
        assertEquals(String.class, savedFile.getId().getClass());

        // Check whether file name and type are correct
        assertEquals("test-file.txt", savedFile.getName());
        assertEquals("text file", savedFile.getType());
    }
}

















