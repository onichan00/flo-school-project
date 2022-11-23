package com.hva.helios.rest.user;

import com.hva.helios.models.user.Specialist;
import com.hva.helios.models.user.skill.Skill;
import com.hva.helios.models.user.skill.UserSkill;
import com.hva.helios.repositories.user.SpecialistRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users/specialist")
public class SpecialistController {
    final private SpecialistRepository specialistRepository = new SpecialistRepository();

    @GetMapping("")
    public List<Specialist> getAllSpecialists() {
        return specialistRepository.getAll();
    }

    @GetMapping("{id}")
    public Specialist getSpecialist(@PathVariable int id) {
        return specialistRepository.getById(id);
    }

    @PostMapping("")
    public Specialist addSpecialist(@RequestBody Specialist specialist) {
        return specialistRepository.saveItem(specialist);
    }

    @DeleteMapping("{id}")
    public Specialist deleteSpecialist(@PathVariable int id) {
        return specialistRepository.deleteById(id);
    }

    @PostMapping("{userId}/skill")
    public UserSkill addUserSkill(@PathVariable int userId, @RequestBody Skill skill, int level) {
        return specialistRepository.saveSkill(skill, level, userId);
    }

//    @DeleteMapping("{userId}/skill/{skillId}")
//    public UserSkill deleteUserSkill(@PathVariable int userId, @PathVariable int skillId) {
//        return specialistRepository.dee
//    }
}
