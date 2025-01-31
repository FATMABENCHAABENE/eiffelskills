package com.example.eiffelskills_back.controller;

import com.example.eiffelskills_back.models.Skills;
import com.example.eiffelskills_back.services.SkillService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * SkillController :
 * Skill are managed trough this controller.
 */
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
    public Optional<Skills> getSkillById(@PathVariable Long id) {
        System.out.println("ID reçu du FRONT :" + id);
        return skillService.getSkillById(id);
    }

    @GetMapping("/module/{id}")
    public List<Skills> getSkillsByModule(@PathVariable Long id) {
        System.out.println("In getSkillsByModule");
        return skillService.getSkillsByModule(id);
    }

    @PostMapping("/{id}")
    public void updateSkillById(@PathVariable Long id, @RequestBody Skills skill) {
        skillService.updateSkill(id, skill);
    }

    /**
     * Method getScore
     * @param idStudent <Long> The student we want to have the score
     * @param idModule <Long> This module we want skill's evaluations
     * @return The global score for all skills in performed by the given student in the given module
     */
    @GetMapping("/score/{idStudent}/{idModule}")
    public Float getScore(@PathVariable Long idStudent, @PathVariable Long idModule) {
        return skillService.makeScore(idStudent, idModule);
    }

    @DeleteMapping("/{id}")
    public void deleteSkill(@PathVariable Long id) {skillService.deleteSkill(id);}
}
