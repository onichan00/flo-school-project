package com.hva.helios.rest.user;

import com.hva.helios.models.user.Specialist;
import com.hva.helios.repositories.user.SpecialistJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/{id}")
    public String updateApplication(@PathVariable("id") long id, Specialist specialist) {
        Specialist updatedSpecialist = repository.save(specialist);
        return String.format(
                "Changed application approval status of specialist with ID %d to %s.",
                updatedSpecialist.getId(),
                updatedSpecialist.getApprovalStatus()
        );
    }
}
