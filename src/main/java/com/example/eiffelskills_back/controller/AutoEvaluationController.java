package com.example.eiffelskills_back.controller;

import com.example.eiffelskills_back.models.AutoEvaluations;
import com.example.eiffelskills_back.services.AutoEvaluationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("autoeval")
public class AutoEvaluationController {
    private final AutoEvaluationService autoEvaluationService;

    @GetMapping("")
    public List<AutoEvaluations> getAllAutoEvaluations() {return autoEvaluationService.getAllAutoEvaluations();}

    @GetMapping("/{id}")
    public AutoEvaluations getAutoEvalById(@PathVariable Long id) {return autoEvaluationService.getAutoEvaluationById(id);}

    @PostMapping("")
    public void addAutoEvaluation(@RequestBody AutoEvaluations autoEvaluation) {
        autoEvaluationService.save(autoEvaluation);
    }

    @PostMapping("/{id}")
    public void updateAutoEvaluation(@PathVariable Long id, @RequestBody AutoEvaluations autoEvaluation) {
        autoEvaluationService.update(id, autoEvaluation);
    }

    @PostMapping("/skill/{idSkill}/{idStudent}")
    public void updateBySkillAndStudent(@PathVariable Long idSkill, @PathVariable Long idStudent, @RequestBody AutoEvaluations autoEvaluation) {
        autoEvaluationService.updateBySkillAndStudent(idSkill, idStudent, autoEvaluation);
    }

    @DeleteMapping("/{id}")
    public void deleteAutoEvaluation(@PathVariable Long id) {
        autoEvaluationService.deleteById(id);
    }
}