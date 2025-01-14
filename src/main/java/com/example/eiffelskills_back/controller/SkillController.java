package com.example.eiffelskills_back.controller;

import com.example.eiffelskills_back.models.Skills;
import com.example.eiffelskills_back.services.SkillService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping("skill")
public class SkillController {
    private final SkillService skillService;

    @GetMapping("")
    public List<Skills> getAllSkills() {
        return skillService.getAllSkills();
    }

    @PostMapping("")
    public void addSkill(@RequestBody Skills skill) {skillService.addSkill(skill);}

    @GetMapping("/{id}")
    public Skills getSkillById(@PathVariable Long id) {return skillService.getSkillById(id);}

    @GetMapping("/module/{id}")
    public List<Skills> getSkillsByModule(@PathVariable Long id) {return skillService.getSkillsByModule(id);}

    @PostMapping("/{id}")
    public void updateSkillById(@PathVariable Long id, @RequestBody Skills skill) {
        skillService.updateSkill(id, skill);
    }

    @DeleteMapping("/{id}")
    public void deleteSkill(@PathVariable Long id) {skillService.deleteSkill(id);}
}
