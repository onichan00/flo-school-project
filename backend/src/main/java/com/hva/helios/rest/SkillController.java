package com.hva.helios.rest;

import com.hva.helios.models.user.skill.Skill;
import com.hva.helios.repositories.EntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller that will manage the skills that a specialist can select for their profile
 */
@RestController
@RequestMapping("skills")
public class SkillController {
    @Autowired
    private EntityRepository<Skill> skillRepository;

    @GetMapping("")
    public List<Skill> getSkills() {
        return skillRepository.findAll();
    }

    @PostMapping("")
    public Skill addSkill(@RequestBody Skill skill) {
        return skillRepository.save(skill);
    }

    @GetMapping("{id}")
    public Skill getSkill(@PathVariable int id) {
        return skillRepository.findById(id);
    }

    @DeleteMapping("{id}")
    public Skill deleteSkill(@PathVariable int id) {
        return skillRepository.deleteById(id);
    }
}
