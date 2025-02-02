package com.example.eiffelskills_back.services;

import com.example.eiffelskills_back.DAO.SkillDAO;
import com.example.eiffelskills_back.models.Skills;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Class SkillService
 */
@Service
@RequiredArgsConstructor
public class SkillService {
    public final SkillDAO skillDAO;
    public final AutoEvaluationService autoEvaluationService;

    /**
     * Method getAllSkills
     * @return All Skills entries
     */
    @Transactional
    public List<Skills> getAllSkills() {
        return skillDAO.findAll();
    }

    /**
     * Method getSkillById
     * @param id Long ID of the searched entry
     * @return The Skills entry in function of the given ID
     */
    @Transactional
    public Optional<Skills> getSkillById(Long id) {
        return skillDAO.findById(id);
    }

    /**
     * Method addSkill
     * @param skill Skills Object to add in entries
     * Add the given Skills object in entries
     */
    @Transactional
    public void addSkill(Skills skill) {
        System.out.println(skill);
        skillDAO.save(skill);
    }

    /**
     * Method getSkillsByModule
     * @param moduleId Long ID of the module we search the entries
     * @return All Skills entries in function of the given idModule
     */
    @Transactional
    public List<Skills> getSkillsByModule(Long moduleId) {
        System.out.println("Inside getSkillsByModule with moduleId: " + moduleId);
        List<Skills> all = skillDAO.findAll();
        List<Skills> skills = new ArrayList<Skills>();
        for (Skills skill : all) {
            if (skill.getIdModule().equals(moduleId)) {
                skills.add(skill);
            }
        }
        return skills;
    }

    /**
     * Method updateSkill
     * @param id Long ID of the entry to update
     * @param skill Skills Object with attributes to change in entries
     * Update Skills entry in function of the given ID with attributes of the given object
     */
    @Transactional
    public void updateSkill(Long id, Skills skill) {
        if (skillDAO.findById(id).isEmpty()) {
            skillDAO.save(skill);
        } else {
            skillDAO.updateById(id,skill.getDescription(),skill.getIdModule());
        }
    }

    /**
     * Method makeScore
     * @param idStudent Long ID of the student we want the score
     * @param idModule Long ID of the module wea want the score
     * @return Use autoEvaluationService to get the score of all quizzEval in function of the given idStudent and idModule
     */
    @Transactional
    public Float makeScore(Long idStudent, Long idModule) {
        List<Skills> skills = this.getSkillsByModule(idModule);
        List<Long> idsSkill = new ArrayList<>();
        for (Skills skill : skills) {
            idsSkill.add(skill.getId());
        }
        return autoEvaluationService.makeScore(idStudent, idsSkill);
    }

    /**
     * Method deleteSkill
     * @param id ID of the entry to delete
     * Delete the Skills entry in function of the given ID
     */
    @Transactional
    public void deleteSkill(Long id) {
        skillDAO.deleteById(id);
    }
}
