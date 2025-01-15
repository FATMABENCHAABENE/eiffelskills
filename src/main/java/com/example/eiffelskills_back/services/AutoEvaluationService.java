package com.example.eiffelskills_back.services;

import com.example.eiffelskills_back.DAO.AutoEvaluationDAO;
import com.example.eiffelskills_back.models.AutoEvaluations;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AutoEvaluationService {
    private final AutoEvaluationDAO autoEvaluationDAO;

    @Transactional
    public List<AutoEvaluations> getAllAutoEvaluations() {
        return autoEvaluationDAO.findAll();
    }

    @Transactional
    public AutoEvaluations getAutoEvaluationById(Long id) {
        return autoEvaluationDAO.getReferenceById(id);
    }

    @Transactional
    public void save(AutoEvaluations autoEvaluations) {autoEvaluationDAO.save(autoEvaluations);}

    @Transactional
    public void deleteById(Long id) {autoEvaluationDAO.deleteById(id);}

    public void update(Long id, AutoEvaluations autoEvaluations) {
        if (autoEvaluationDAO.findById(id).isEmpty()) {
            autoEvaluationDAO.save(autoEvaluations);
        } else {
            autoEvaluationDAO.updateAutoEvaluationById(id, autoEvaluations.getIdSkill(), autoEvaluations.getIdStudent(), autoEvaluations.getEval());
        }
    }

    @Transactional
    public void updateBySkillAndStudent(Long idSkill, Long idStudent, AutoEvaluations autoEvaluations) {
        if (autoEvaluationDAO.findBySkillAndStudent(idSkill,idStudent).isEmpty()) {
            autoEvaluationDAO.save(autoEvaluations);
        } else {
            autoEvaluationDAO.updateAutoEvaluationBySkillAndStudent(idSkill,idStudent, autoEvaluations.getEval());
        }
    }
}
