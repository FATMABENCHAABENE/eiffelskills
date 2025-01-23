package com.example.eiffelskills_back.services;

import com.example.eiffelskills_back.DAO.SkillDAO;
import com.example.eiffelskills_back.models.Skills;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SkillService {
    public final SkillDAO skillDAO;
    public final AutoEvaluationService autoEvaluationService;

    @Transactional
    public List<Skills> getAllSkills() {
        return skillDAO.findAll();
    }

    @Transactional
    public Optional<Skills> getSkillById(Long id) {
        return skillDAO.findById(id);
    }

    @Transactional
    public void addSkill(Skills skill) {
        System.out.println(skill);
        skillDAO.save(skill);
    }

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

    @Transactional
    public void updateSkill(Long id, Skills skill) {
        if (skillDAO.findById(id).isEmpty()) {
            skillDAO.save(skill);
        } else {
            skillDAO.updateById(id,skill.getDescription(),skill.getIdModule());
        }
    }

    @Transactional
    public Float makeScore(Long idStudent, Long idModule) {
        List<Skills> skills = this.getSkillsByModule(idModule);
        List<Long> idsSkill = new ArrayList<>();
        for (Skills skill : skills) {
            idsSkill.add(skill.getIdModule());
        }
        return autoEvaluationService.makeScore(idStudent, idsSkill);
    }

    @Transactional
    public void deleteSkill(Long id) {
        skillDAO.deleteById(id);
    }
}
