package com.hva.helios.rest.user;

import com.hva.helios.models.user.Specialist;
import com.hva.helios.repositories.EntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users/specialist")
public class SpecialistController {
    @Autowired
    private EntityRepository<Specialist> specialistRepository;

    @GetMapping("")
    public List<Specialist> getAllSpecialists() {
        return specialistRepository.findAll();
    }

    @GetMapping("{id}")
    public Specialist getSpecialist(@PathVariable int id) {
        return specialistRepository.findById(id);
    }

    @PostMapping("")
    public Specialist addSpecialist(@RequestBody Specialist specialist) {
        return specialistRepository.save(specialist);
    }

    @DeleteMapping("{id}")
    public Specialist deleteSpecialist(@PathVariable int id) {
        return specialistRepository.deleteById(id);
    }

//    @GetMapping("{id}/hours")
//    public AvailableHour getHoursOrSpecialist(@PathVariable int id) {
//        return specialistRepository.getHours(id);
//    }

//    @PostMapping("{id}/hours")
//    public AvailableHour setHoursOfSpecialist(@PathVariable int id, @RequestBody AvailableHour hours) {
//        return specialistRepository.saveHours(id, hours);
//    }
//
//    @PostMapping("{userId}/skill")
//    public UserSkill addUserSkill(@PathVariable int userId, @RequestBody Skill skill, int level) {
//        return specialistRepository.saveSkill(skill, level, userId);
//    }

//    @DeleteMapping("{id}/skill/{userSkill}")
//    public List<UserSkill> deleteUserSkill(@PathVariable int id, @PathVariable int userSkill) {
//        return specialistRepository.deleteSkill(id, userSkill);
//    }

//    @DeleteMapping("{userId}/skill/{skillId}")
//    public UserSkill deleteUserSkill(@PathVariable int userId, @PathVariable int skillId) {
//        return specialistRepository.dee
//    }
}
