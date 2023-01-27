package com.hva.helios.rest;

import com.hva.helios.models.FileModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Arrays;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FileControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Value("/api")
    private String servletContextPath;

    @LocalServerPort
    private int randomServerPort;

    @BeforeEach
    void setup() {
        if (servletContextPath == null) servletContextPath = "/";
    }

    //TODO finish
    @Test
    void shouldThrowExceptionWhenMaxFileSizeIsExceeded() {
        FileModel file = FileModel.createSampleFile("test-id");
        byte fileDataByte = 0x01;
        byte[] fileData = new byte[10000000];
        for (int i = 0; i < fileData.length; i++) {
            fileData[i] = fileDataByte++;
        }

//        MockMultipartFile file = new MockMultipartFile(
//                "test-file.txt",
//                fileData
//        );
        file.setData();

        ResponseEntity<FileModel> response = restTemplate.postForEntity(
                "http://localhost:" + randomServerPort + "/api/files/upload/" + 1,
                file,
                FileModel.class
        );

        assert(response.getStatusCode().getReasonPhrase().contains("Maximum upload size exceeded"));
    }
}