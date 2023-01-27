package com.hva.helios.rest;

import com.hva.helios.exceptions.NotFoundException;
import com.hva.helios.models.FileModel;
import com.hva.helios.repositories.FileJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("files")
public class FileController {

    @Autowired
    FileJPARepository fileRepository;

    @GetMapping("list/{userId}")
    public ResponseEntity<List<FileModel>> listFiles(
            @PathVariable("userId") long id) {
        List<FileModel> files = fileRepository.findByUserId(id);

        return ResponseEntity.status(HttpStatus.OK).body(files);
    }

    @PostMapping("upload/{userId}")
//    public FileModel upload(
    public ResponseEntity<FileModel> upload(
            @RequestBody MultipartFile file,
            @PathVariable("userId") long userId) throws IOException {

        if (file == null) {
            throw new IllegalArgumentException("No file selected.");
        }

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        FileModel fileModel = new FileModel(
                userId, fileName,
                file.getContentType(),
                file.getBytes()
        );

        FileModel savedFile = fileRepository.save(fileModel);

        return ResponseEntity.ok()
                .header(HttpHeaders.LOCATION, savedFile.getId())
                .body(savedFile);
    }

    @GetMapping("{id}")
    public ResponseEntity<byte[]> download(
            @PathVariable("id") String id) {
        FileModel fileModel = fileRepository.findById(id).orElse(null);

        if (fileModel == null) {
            throw new NotFoundException(String.format("File with ID: %s was not found", id));
        }

        String header = "attachment; filename=\"" + fileModel.getName() + "\"";

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, header)
                .body(fileModel.getData());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<byte[]> delete(
            @PathVariable("id") String id) {

        FileModel fileModel = fileRepository.findById(id).orElse(null);

        if (fileModel == null) {
            throw new NotFoundException(String.format("File with ID: %s was not found", id));
        }

        fileRepository.deleteById(id);

        return ResponseEntity.ok()
                .body(fileModel.getData());
    }
}
