package com.example.eiffelskills_back.services;

import com.example.eiffelskills_back.DAO.AutoEvaluationDAO;
import com.example.eiffelskills_back.models.AutoEvaluations;
import com.example.eiffelskills_back.models.Skills;
import jakarta.persistence.criteria.Join;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public Specification<Skills> getFullAutoEvaluationsByIdStudent(Long studentId) {
        return (root, query, criteriaBuilder) -> {
            Join<Skills,AutoEvaluations> fullAutoEvaluation = root.join("autoEvaluations");
            return criteriaBuilder.equal(fullAutoEvaluation.get("id_student"), studentId);
        };
    }

    @Transactional
    public List<AutoEvaluations> getAutoEvaluationsByIdStudent(Long studentId) {
        List<AutoEvaluations> all = autoEvaluationDAO.findAll();
        List<AutoEvaluations> autoEvaluations = new ArrayList<>();
        for (AutoEvaluations autoEvaluation : all) {
            if (autoEvaluation.getIdStudent().equals(studentId)) {
                autoEvaluations.add(autoEvaluation);
            }
        }
        return autoEvaluations;
    }

    @Transactional
    public List<AutoEvaluations> getAutoEvalByStudentAndSkills(Long studentId, Long idSkill) {
        List<AutoEvaluations> all = autoEvaluationDAO.findAll();
        List<AutoEvaluations> autoEvaluations = new ArrayList<>();
        for (AutoEvaluations autoEvaluation : all) {
            if (autoEvaluation.getIdStudent().equals(studentId) && autoEvaluation.getIdSkill().equals(idSkill)) {
                autoEvaluations.add(autoEvaluation);
            }
        }
        return autoEvaluations;
    }

    @Transactional
    public void downGradeAutoEval(Long studentId, Long skillId) {
        List<AutoEvaluations> all = this.getAutoEvalByStudentAndSkills(studentId, skillId);
        if (all.isEmpty()) {
            this.save(new AutoEvaluations(skillId,studentId,"no acquired"));
        } else {
            for (AutoEvaluations autoEvaluation : all) {
                String newEval = "";
                switch (autoEvaluation.getEval()) {
                    case("acquired"): newEval = "acquiring"; break;
                    case("acquiring"): newEval = "no acquired"; break;
                    case("no acquired"): newEval = "no acquired"; break;
                }
                autoEvaluation.setEval(newEval);
                this.updateBySkillAndStudent(studentId, skillId, autoEvaluation);
            }
        }
    }

    public void upgradeAutoEval(Long studentId, Long skillId) {
        List<AutoEvaluations> all = this.getAutoEvalByStudentAndSkills(studentId, skillId);
        if (all.isEmpty()) {
            this.save(new AutoEvaluations(skillId,studentId,"acquired"));
        } else {
            for (AutoEvaluations autoEvaluation : all) {
                String newEval = "";
                switch (autoEvaluation.getEval()) {
                    case("acquired"): newEval = "acquired"; break;
                    case("acquiring"): newEval = "acquired"; break;
                    case("no acquired"): newEval = "acquiring"; break;
                }
                autoEvaluation.setEval(newEval);
                this.updateBySkillAndStudent(studentId, skillId, autoEvaluation);
            }
        }
    }

    @Transactional
    public void save(AutoEvaluations autoEvaluations) {
        autoEvaluationDAO.save(autoEvaluations);
    }

    @Transactional
    public void deleteById(Long id) {
        autoEvaluationDAO.deleteById(id);
    }

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
