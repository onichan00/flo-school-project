package com.hva.helios.rest;

import com.hva.helios.models.user.hour.AvailableHour;
import com.hva.helios.repositories.HourJPARepository;
import com.hva.helios.repositories.user.AvailableHourJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
