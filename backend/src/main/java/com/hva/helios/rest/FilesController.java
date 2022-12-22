package com.hva.helios.rest;

import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Arrays;

@RestController
@RequestMapping("/files")
public class FilesController {

    @GetMapping("/list/{id}")
    public String[] findAll(@PathVariable("id") long uploaderId) {

        String path = System.getProperty("user.dir") + "/uploads/" + uploaderId;
        File directory = new File(path);

        return directory.list();
    }

    @GetMapping("/download/{id}/{path:.+}")
    public ResponseEntity<Resource> downloadFile(
            @PathVariable("path") String fileName, @PathVariable("id") long uploaderId) throws IOException {

        String uploadDirectory = System.getProperty("user.dir") + "\\uploads\\" + uploaderId + "\\";
        System.out.println(uploadDirectory);
        String[] files = this.findAll(uploaderId);

        if (!Arrays.asList(files).contains(fileName)) {
            return new ResponseEntity(
                    "File not found.",
                    HttpStatus.NOT_FOUND);
        }

        String filePath = uploadDirectory + File.separator + fileName;
        File file = new File(filePath);
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"")
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }

    @PostMapping("/upload/{id}")
    public String uploadFile(
            @RequestBody MultipartFile file, @PathVariable("id") long uploaderId) throws IOException {

        // TODO check whether file already exists
        String filePath =
                System.getProperty("user.dir") + "/uploads" + File.separator + uploaderId + File.separator + file.getOriginalFilename();
        String uploadStatus = "";
        boolean exists = new File(
                System.getProperty("user.dir") + "/uploads/" + uploaderId
        ).mkdirs();

        try (FileOutputStream fileOutputStream = new FileOutputStream(filePath)) {
            fileOutputStream.write(file.getBytes());
            uploadStatus = String.format(
                    "Upload successful.\nFile name: %s \nDirectory: %s\nFile size: %s bytes",
                    file.getOriginalFilename(),
                    filePath,
                    file.getSize()
            );
        }

        return uploadStatus;
    }
}
