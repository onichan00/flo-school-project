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
            FileModel file = new FileModel();
            file.setUserId(i);
            file.setName("test-file" + i + ".txt");
            file.setType("text file");
            file.setData(new byte[] {});
            file.setId("test-id" + i);

            fileRepository.save(file);
        }
    }
}
