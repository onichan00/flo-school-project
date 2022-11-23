package com.hva.helios.rest;

import com.hva.helios.models.user.skill.Skill;
import com.hva.helios.repositories.SkillRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller that will manage the skills that a specialist can select for their profile
 */
@RestController
@RequestMapping("skills")
public class SkillController {
    final private SkillRepository skillRepository = new SkillRepository();

    @GetMapping("")
    public List<Skill> getSkills() {
        return skillRepository.getAll();
    }

    @PostMapping("")
    public Skill addSkill(@RequestBody Skill skill) {
        return skillRepository.saveItem(skill);
    }

    @DeleteMapping("{id}")
    public Skill deleteSkill(@PathVariable int id) {
        return skillRepository.deleteById(id);
    }
}
