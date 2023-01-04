package com.hva.helios.rest.user;

import com.hva.helios.models.user.Specialist;
import com.hva.helios.repositories.interfaces.jpa.SpecialistJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/specialists/applications")
public class SpecialistApplicationsController {

    @Autowired
    SpecialistJPARepository repository;

    @GetMapping("")
    public List<Specialist> getAllApplications() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody List<Specialist> findById(
            @PathVariable("id") long id) {
        return repository.findById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Specialist> updateApplication(
            @PathVariable("id") long id,
            @RequestBody Specialist specialist) {
        Specialist specialistToUpdate = repository.getSpecialistById(id);

        specialistToUpdate.setApprovalStatus(specialist.getApprovalStatus());
        repository.save(specialistToUpdate);

        HttpHeaders headers = new HttpHeaders();
        headers.add(
                "Location",
                ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .toUriString()
        );
        return new ResponseEntity<>(specialistToUpdate, headers, HttpStatus.OK);
    }
}
