package com.example.eiffelskills_back.services;

import com.example.eiffelskills_back.DAO.SkillDAO;
import com.example.eiffelskills_back.models.Skills;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SkillService {
    public final SkillDAO skillDAO;

    @Transactional
    public List<Skills> getAllSkills() {
        return skillDAO.findAll();
    }

    @Transactional
    public Skills getSkillById(Long id) {
        return skillDAO.getReferenceById(id);
    }

    @Transactional
    public void addSkill(Skills skill) {skillDAO.save(skill);}

    @Transactional
    public List<Skills> getSkillsByModule(Long moduleId) {
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
    public void deleteSkill(Long id) {
        skillDAO.deleteById(id);
    }
}
