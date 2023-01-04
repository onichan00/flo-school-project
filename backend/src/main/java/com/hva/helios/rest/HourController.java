package com.hva.helios.rest;

import com.hva.helios.exceptions.NotFoundException;
import com.hva.helios.exceptions.PreConditionFailed;
import com.hva.helios.models.user.hour.AvailableHour;
import com.hva.helios.repositories.HourJPARepository;
import com.hva.helios.repositories.user.AvailableHourJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("hours")
public class HourController {
    @Autowired
    private AvailableHourJPARepository hourRepo;

    @GetMapping("/")
    public List<AvailableHour> getHours() {
        return hourRepo.findAll();
    }

    @PutMapping("/{id}")
    public AvailableHour update(@RequestBody AvailableHour toMergeHours, @PathVariable long id) {
        AvailableHour existingHour = hourRepo.findById(id);

        // Check if an AvailableHour object was given
        if (existingHour == null) {
            throw new NotFoundException(String.format("Hour entity with ID: %d was not found", id));
        }

        // Check if the ID in the route correspondents wit the ID of the object
        if (existingHour.getId() != toMergeHours.getId()) {
            throw new PreConditionFailed(String.format("Hour entity with ID: %d does not match with parameter ID: %d", existingHour.getId(), toMergeHours.getId()));
        }

        return hourRepo.save(toMergeHours);
    }
}
