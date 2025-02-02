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

/**
 * Class AutoEvaluationService
 */
@Service
@RequiredArgsConstructor
public class AutoEvaluationService {
    private final AutoEvaluationDAO autoEvaluationDAO;

    /**
     * Method getAllAutoEvaluations
     * @return All AutoEvaluations entries
     */
    @Transactional
    public List<AutoEvaluations> getAllAutoEvaluations() {
        return autoEvaluationDAO.findAll();
    }

    /**
     * Method getAutoEvaluationById
     * @param id Long ID of the searched entry
     * @return The AutoEvaluations entry in function of the given ID
     */
    @Transactional
    public Optional<AutoEvaluations> getAutoEvaluationById(Long id) {
        return autoEvaluationDAO.findById(id);
    }

    /**
     * @deprecated
     * Method getFullAutoEvaluationsByIdStudent
     * @param studentId Long ID of the student we are searching all entries
     * @return /!\ Not working
     */
    @Transactional
    public Specification<Skills> getFullAutoEvaluationsByIdStudent(Long studentId) {
        return (root, query, criteriaBuilder) -> {
            Join<Skills,AutoEvaluations> fullAutoEvaluation = root.join("autoEvaluations");
            return criteriaBuilder.equal(fullAutoEvaluation.get("id_student"), studentId);
        };
    }

    /**
     * Method getAutoEvaluationsByIdStudent
     * @param studentId Long ID of the student we are searching all entries
     * @return All AutoEvaluations entries in function of the idStudent
     */
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

    /**
     * Method getAutoEvalByStudentAndSkills
     * @param studentId Long ID of the student we are searching all entries
     * @param idSkill Long ID of the skill we are searching all entries
     * @return All AutoEvaluations entries in function of the idStudent and idSkill
     */
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

    /**
     * Method downGradeAutoEval
     * @param studentId Long ID of the student we want to downgrade the quizz evaluation
     * @param skillId Long ID of the skill we want to downgrade the quizz evaluation
     * Downgrade entry's quizzEval attribute in function of idStudent and idSkill
     */
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

    /**
     * Method upgradeAutoEval
     * @param studentId Long ID of the student we want to upgrade the quizz evaluation
     * @param skillId Long ID of the skill we want to upgrade the quizz evaluation
     * Upgrade entry's quizzEval attribute in function of idStudent and idSkill
     */
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

    /**
     * Method save
     * @param autoEvaluations AutoEvaluation Object to add in entries
     * Add the given AutoEvaluation object in entries
     */
    @Transactional
    public void save(AutoEvaluations autoEvaluations) {
        autoEvaluationDAO.save(autoEvaluations);
    }

    /**
     * Method deleteById
     * @param id ID of the entry to delete
     * Delete the AutoEvaluations entry in function of the ID
     */
    @Transactional
    public void deleteById(Long id) {
        autoEvaluationDAO.deleteById(id);
    }

    /**
     * Method update
     * @param id Long ID of the entry to update
     * @param autoEvaluations AutoEvaluations Object with attributes to change in entries
     * Update the AutoEvaluations entry in function of the ID with attributes of the given object
     */
    public void update(Long id, AutoEvaluations autoEvaluations) {
        if (autoEvaluationDAO.findById(id).isEmpty()) {
            autoEvaluationDAO.save(autoEvaluations);
        } else {
            autoEvaluationDAO.updateAutoEvaluationById(id, autoEvaluations.getIdSkill(), autoEvaluations.getIdStudent(), autoEvaluations.getEval(), autoEvaluations.getQuizzEval());
        }
    }

    /**
     * Method updateEvalBySkillAndStudent
     * @param idSkill Long ID of the student we want to update the entry
     * @param idStudent Long ID of the skill we want to update the entry
     * @param autoEvaluations AutoEvaluations Object with attributes to change in entries
     * Update the AutoEvaluations autoEval entry in function of the idSkill and idStudent with attributes of the given object
     */
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

    /**
     * Method updateQuizzBySkillAndStudent
     * @param idSkill Long ID of the student we want to update the entry
     * @param idStudent Long ID of the skill we want to update the entry
     * @param autoEvaluations AutoEvaluations Object with attributes to change in entries
     * Update the AutoEvaluations quizzEval entry in function of the idSkill and idStudent with attributes of the given object
     */
    @Transactional
    public void updateQuizzBySkillAndStudent(Long idSkill, Long idStudent, AutoEvaluations autoEvaluations) {
        if (autoEvaluationDAO.findBySkillAndStudent(idSkill,idStudent).isEmpty()) {
            autoEvaluationDAO.save(autoEvaluations);
        } else {
            //System.out.println("Updated auto eval :\n"+autoEvaluations.getIdSkill()+" "+autoEvaluations.getIdStudent()+" "+autoEvaluations.getEval());
            autoEvaluationDAO.updateQuizzEvalBySkillAndStudent(autoEvaluations.getQuizzEval(), idSkill,idStudent);
        }
    }

    /**
     * Method getAutoEvalByStudentAndSkills
     * @param studentId Long ID of the student we are searching all entries
     * @param idSkills List(Long) IDs of skills we are searching all entries
     * @return All AutoEvaluations entries in function of the idStudent and all idSkill
     */
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

    /**
     * Method makeScore
     * @param studentId Long ID of the student we want to get the score
     * @param skillIds List(Long) All IDs of skills we search to make a score
     * @return The mean of all scores in all given skills
     */
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
