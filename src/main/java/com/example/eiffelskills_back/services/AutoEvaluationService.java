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
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AutoEvaluationService {
    private final AutoEvaluationDAO autoEvaluationDAO;

    @Transactional
    public List<AutoEvaluations> getAllAutoEvaluations() {
        return autoEvaluationDAO.findAll();
    }

    @Transactional
    public Optional<AutoEvaluations> getAutoEvaluationById(Long id) {
        return autoEvaluationDAO.findById(id);
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
        //System.out.println("Current Eval : "+all);
        if (all.isEmpty()) {
            this.save(new AutoEvaluations(skillId,studentId,"no evaluated","no acquired"));
        } else {
            for (AutoEvaluations autoEvaluation : all) {
                String newEval = "";
                switch (autoEvaluation.getQuizzEval()) {
                    case("acquired"): newEval = "acquiring"; break;
                    case("acquiring"): newEval = "no acquired"; break;
                    case("no acquired"): newEval = "no acquired"; break;
                    default: newEval = "no acquired"; break;
                }
                autoEvaluation.setQuizzEval(newEval);
                this.updateQuizzBySkillAndStudent(studentId, skillId, autoEvaluation);
            }
        }
    }

    @Transactional
    public void upgradeAutoEval(Long studentId, Long skillId) {
        List<AutoEvaluations> all = this.getAutoEvalByStudentAndSkills(studentId, skillId);
        //System.out.println("Current Eval : "+all.get(0).getQuizzEval());
        if (all.isEmpty()) {
            this.save(new AutoEvaluations(skillId,studentId,"no evaluated","acquired"));
        } else {
            for (AutoEvaluations autoEvaluation : all) {
                String newEval = "";
                switch (autoEvaluation.getQuizzEval()) {
                    case("acquired"): newEval = "acquired"; break;
                    case("acquiring"): newEval = "acquired"; break;
                    case("no acquired"): newEval = "acquiring"; break;
                    default: newEval = "acquired"; break;
                }
                autoEvaluation.setQuizzEval(newEval);
                this.updateQuizzBySkillAndStudent(studentId, skillId, autoEvaluation);
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
            autoEvaluationDAO.updateAutoEvaluationById(id, autoEvaluations.getIdSkill(), autoEvaluations.getIdStudent(), autoEvaluations.getEval(), autoEvaluations.getQuizzEval());
        }
    }

    @Transactional
    public void updateEvalBySkillAndStudent(Long idSkill, Long idStudent, AutoEvaluations autoEvaluations) {
        if (autoEvaluationDAO.findBySkillAndStudent(idSkill,idStudent).isEmpty()) {
            System.out.println("add : "+autoEvaluations.toString());
            autoEvaluationDAO.save(autoEvaluations);
        } else {
            //System.out.println("Updated auto eval :\n"+autoEvaluations.getIdSkill()+" "+autoEvaluations.getIdStudent()+" "+autoEvaluations.getEval());
            autoEvaluationDAO.updateAutoEvalBySkillAndStudent(autoEvaluations.getEval(), idSkill,idStudent);
        }
    }

    @Transactional
    public void updateQuizzBySkillAndStudent(Long idSkill, Long idStudent, AutoEvaluations autoEvaluations) {
        if (autoEvaluationDAO.findBySkillAndStudent(idSkill,idStudent).isEmpty()) {
            autoEvaluationDAO.save(autoEvaluations);
        } else {
            //System.out.println("Updated auto eval :\n"+autoEvaluations.getIdSkill()+" "+autoEvaluations.getIdStudent()+" "+autoEvaluations.getEval());
            autoEvaluationDAO.updateQuizzEvalBySkillAndStudent(autoEvaluations.getQuizzEval(), idSkill,idStudent);
        }
    }

    public List<AutoEvaluations> getAutoEvalByStudentAndListSkills(Long studentId, List<Long> idSkills) {
        List<AutoEvaluations> all = autoEvaluationDAO.findAll();
        List<AutoEvaluations> autoEvaluations = new ArrayList<>();
        for (AutoEvaluations autoEvaluation : all) {
            if (autoEvaluation.getIdStudent().equals(studentId) && idSkills.contains(autoEvaluation.getIdSkill())) {
                autoEvaluations.add(autoEvaluation);
            }
        }
        return autoEvaluations;
    }

    @Transactional
    public Float makeScore(Long studentId, List<Long> skillIds) {
        //System.out.println("Skills : "+skillIds+"\n studentId : "+studentId);
        List<AutoEvaluations> autoEvaluations = new ArrayList<>();
        for (Long skillId : skillIds) {
            autoEvaluations.addAll(this.getAutoEvalByStudentAndSkills(studentId, skillId));
        }
        //System.out.println("All eval : "+autoEvaluations);
        List<Float> allScores = new ArrayList<>();
        for (AutoEvaluations autoEvaluation : autoEvaluations) {
            switch (autoEvaluation.getQuizzEval()) {
                case ("acquired"): allScores.add(20F); break;
                case ("acquiring"): allScores.add(10F); break;
                case ("no acquired"): allScores.add(1F); break;
                case ("no evaluated"): allScores.add(0F); break;
            }
        }
        Float score = 0F;
        for (Float allScore : allScores) {
            score += allScore;
        }
        //System.out.println("scores = "+allScores);
        return score/allScores.size();
    }
}
