package com.hva.helios.utilities;

import com.hva.helios.models.FileModel;
import com.hva.helios.repositories.FileJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private FileJPARepository fileRepository;

    @Override
    public void run(String... args) throws Exception {
        this.initializeFiles();
    }

    private void initializeFiles() {
        for (int i = 0; i < 10; i++) {
            fileRepository.save(FileModel.createSampleFile());
        }
    }
}
