package com.hva.helios.rest;

import com.hva.helios.models.FileModel;
import com.hva.helios.repositories.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("files")
public class FileController {

    @Autowired
    FileRepository fileRepository;

    @PostMapping("upload/{id}")
    public FileModel upload(
            @RequestBody MultipartFile file,
            @PathVariable("id") long userId) throws IOException {

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        FileModel fileModel = new FileModel(userId, fileName, file.getContentType(), file.getBytes());
        boolean exists = fileRepository.findByName(fileName).isPresent();

        if (!exists) {
            return fileRepository.save(fileModel);
        }
        else return null;
    }

    @GetMapping("download/{name}")
    public ResponseEntity<byte[]> download(
            @PathVariable("name") String name) {
        FileModel fileModel = fileRepository.findByName(name).get();

        String header = "attachment; filename=\"" + fileModel.getName() + "\"";

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, header)
                .body(fileModel.getData());
    }
}
