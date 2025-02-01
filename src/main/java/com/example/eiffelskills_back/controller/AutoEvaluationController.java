package com.example.eiffelskills_back.controller;

import com.example.eiffelskills_back.models.AutoEvaluations;
import com.example.eiffelskills_back.services.AutoEvaluationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @Class AutoEvaluationController
 * Autoevaluations and Quizz evaluations made by students are managed through this controller
 */
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("autoeval")
public class AutoEvaluationController {
    private final AutoEvaluationService autoEvaluationService;

    /**
     * getAllAutoEvaluations
     * @return all entries in autoevaluations table
     */
    @GetMapping("")
    public List<AutoEvaluations> getAllAutoEvaluations() {
        return autoEvaluationService.getAllAutoEvaluations();
    }

    /**
     * Method getAutoEvalById
     * @param id Long ID of the wanted autoevaluation
     * @return the autoevaluation with the given ID
     */
    @GetMapping("/{id}")
    public Optional<AutoEvaluations> getAutoEvalById(@PathVariable Long id) {
        return autoEvaluationService.getAutoEvaluationById(id);
    }

    /**
     * Method getAutoEvalByStudentId
     * @param id Long ID of the student who made evaluations
     * @return all evaluations made by the given student
     */
    @GetMapping("/student/{id}")
    public List<AutoEvaluations> getAutoEvalByStudentId(@PathVariable Long id) {
        return autoEvaluationService.getAutoEvaluationsByIdStudent(id);
    }

    /**
     * Method getAutoEvalByStudentAndListSkills
     * @param idStudent Long The student id we are searching evaluations
     * @param skills List(Long) All skills id we are searching evaluations
     * @return All evaluations made by the given student for all given skills
     */
    @PostMapping("/student/{idStudent}")
    public List<AutoEvaluations> getAutoEvalByStudentAndListSkills(@PathVariable Long idStudent, @RequestBody List<Long> skills) {
        return autoEvaluationService.getAutoEvalByStudentAndListSkills(idStudent, skills);
    }

    /**
     * Method addAutoEvaluation
     * @param autoEvaluation AutoEvaluation The evaluation we want to add.
     */
    @PostMapping("")
    public void addAutoEvaluation(@RequestBody AutoEvaluations autoEvaluation) {
        autoEvaluationService.save(autoEvaluation);
    }

    /**
     * Method updateAutoEvaluation
     * @param id Long ID of the entry we want to update
     * @param autoEvaluation AutoEvaluation element we want to set in the entry.
     */
    @PostMapping("/{id}")
    public void updateAutoEvaluation(@PathVariable Long id, @RequestBody AutoEvaluations autoEvaluation) {
        autoEvaluationService.update(id, autoEvaluation);
    }

    /**
     * Method updateBySkillAndStudent
     * @param autoEvaluation AutoEvaluation Evaluation we want to update in function of the ID and student ID
     */
    @PostMapping("/skill")
    public void updateBySkillAndStudent(@RequestBody AutoEvaluations autoEvaluation) {
        System.out.println("ID Reçu du client : " + autoEvaluation.getIdSkill());
        System.out.println("ID student Reçu du client : " + autoEvaluation.getIdStudent());
        System.out.println("Eval Reçu du client : " + autoEvaluation.getEval());
        autoEvaluationService.updateEvalBySkillAndStudent(autoEvaluation.getIdSkill(), autoEvaluation.getIdStudent(), autoEvaluation);
    }

    /**
     * Method deleteAutoEvaluation
     * @param id Long ID of the entry to delete.
     */
    @DeleteMapping("/{id}")
    public void deleteAutoEvaluation(@PathVariable Long id) {
        autoEvaluationService.deleteById(id);
    }
}