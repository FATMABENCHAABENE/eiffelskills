package com.example.eiffelskills_back.services;

import com.example.eiffelskills_back.DAO.SkillDAO;
import com.example.eiffelskills_back.models.Skills;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SkillService {
    public final SkillDAO skillDAO;

    public List<Skills> getAllSkills() {
        return skillDAO.findAll();
    }

    public Skills getSkillById(Long id) {
        return skillDAO.getReferenceById(id);
    }

    public void addSkill(Skills skill) {skillDAO.save(skill);}

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
}
