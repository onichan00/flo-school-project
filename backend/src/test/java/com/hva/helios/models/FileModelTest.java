package com.hva.helios.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileModelTest {

    FileModel fileModel1, fileModel2;

    @BeforeEach
    void setup() {
        fileModel1 = new FileModel(10000L, "Test-text-file.txt", "txt", new byte[]{});
        fileModel2 = new FileModel(10001L, "Test-image.png", "png", new byte[]{});
    }

    @Test
    void suffixShouldMatchFileType() {
        String[] file1Suffix = fileModel1.getName().split("\\.");
        String[] file2Suffix = fileModel2.getName().split("\\.");

        assertEquals(file1Suffix[1], fileModel1.getType());
        assertEquals(file2Suffix[1], fileModel2.getType());
    }
}
