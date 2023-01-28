package com.hva.helios.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.matchesPattern;
import static org.junit.jupiter.api.Assertions.*;

public class FileModelTest {

    @BeforeEach
    void setup() {}

    /**
     * Checks whether the createSampleFile method properly sets an ID for the FileModel instance
     */
    @Test
    void creatingSampleFileShouldSetFileIdAsUuid() {
        FileModel[] files = {
                FileModel.createSampleFile(),
                FileModel.createSampleFile(),
                FileModel.createSampleFile()
        };
        System.out.println(files[0].getTimestamp());
        for (FileModel file : files) {
            //verify that ID is set
            assertNotNull(file.getId());
            //verify that ID is of type UUID by matching against regex pattern
            assertThat(file.getId(), matchesPattern(
                    "[A-Fa-f0-9]{8}-[A-Fa-f0-9]{4}-[A-Fa-f0-9]{4}-[A-Fa-f0-9]{4}-[A-Fa-f0-9]{12}"));
        }
    }


}




















