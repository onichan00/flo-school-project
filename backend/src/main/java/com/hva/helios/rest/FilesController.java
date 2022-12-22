package com.hva.helios.rest;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/files")
public class FilesController {

    @GetMapping("/list")
    public List<String> findAll() {
        return null;
    }

    @GetMapping("/{fileName}")
    public MultipartFile downloadFile(@PathVariable("fileName") String fileName) {
        return null;
    }

    @PostMapping("/upload")
    public String uploadFile(@RequestParam MultipartFile file) throws IOException {

        // TODO check whether file already exists
        String filePath = System.getProperty("user.dir") + "/uploads" + File.separator + file.getOriginalFilename();
        String uploadStatus;

        try (FileOutputStream fileOutputStream = new FileOutputStream(filePath)){
            fileOutputStream.write(file.getBytes());
            uploadStatus = String.format(
                    "File %s uploaded successfully.", file.getOriginalFilename()
            );
        }

        return uploadStatus;
    }
}
