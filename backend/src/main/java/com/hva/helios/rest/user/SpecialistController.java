package com.hva.helios.rest.user;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.hva.helios.models.User;
import com.hva.helios.models.user.Specialist;
import com.hva.helios.models.user.hour.AvailableHour;
import com.hva.helios.models.user.skill.Skill;
import com.hva.helios.models.user.skill.UserSkill;
import com.hva.helios.repositories.EntityRepository;
import com.hva.helios.repositories.user.SpecialistJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("users/specialist")
public class SpecialistController {
    @Autowired
    private EntityRepository<Specialist> specialistRepository;

    @Autowired
    private EntityRepository<AvailableHour> availableHourRepository;

    @Autowired
    private EntityRepository<UserSkill> userSkillRepository;

    @Autowired
    private EntityRepository<Skill> skillRepository;

    @GetMapping("")
    public List<Specialist> getAllSpecialists() {
        return specialistRepository.findAll();
    }

    @PostMapping("")
    public Specialist addSpecialist(@RequestBody Specialist specialist) {
        return specialistRepository.save(specialist);
    }

    @GetMapping("{id}")
    public Specialist getSpecialist(@PathVariable int id) {
        return specialistRepository.findById(id);
    }

    @DeleteMapping("{id}")
    public Specialist deleteSpecialist(@PathVariable int id) {
        return specialistRepository.deleteById(id);
    }

    @GetMapping("{id}/hours")
    public AvailableHour getHoursOfSpecialist(@PathVariable int id) {
        Specialist specialist = specialistRepository.findById(id);

        return specialist.getHours();
    }

    @PostMapping("{id}/hours")
    public AvailableHour setHoursOfSpecialist(@PathVariable int id, @RequestBody AvailableHour hours) {
        availableHourRepository.save(hours);
        return hours;
    }

    @GetMapping("{id}/skills")
    public Set<UserSkill> getUserSkill(@PathVariable int id) {
        return specialistRepository.findById(id).getSkills();
    }

    @PostMapping("{id}/skills")
    public Set<UserSkill> addUserSkill(@PathVariable int id, @RequestBody ObjectNode body) {
        // Get the specialist via the POST body
        Specialist specialist = specialistRepository.findById(body.get("specialist").asLong());

        // Get the skill via the POST body
        Skill skill = skillRepository.findById(body.get("skill").get("id").asLong());
        int level = body.get("level").asInt();

        // Create a UserSkill via the POST body
        UserSkill userSkill = new UserSkill(skill, level, specialist);

        specialist.addSkill(userSkill);
        userSkillRepository.save(userSkill);

        return specialist.getSkills();
    }
}
