package com.example.eiffelskills_back.services;

import com.example.eiffelskills_back.DAO.QuestionDAO;
import com.example.eiffelskills_back.models.Questions;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Class QuestionService
 */
@Service
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionDAO questionDAO;
    private final AutoEvaluationService autoEvaluationService;

    /**
     * Method saveQuestions
     * @param questions Object to add in entries
     * @return The save Questions object
     */
    @Transactional
    public Questions saveQuestions(Questions questions) {
        return questionDAO.save(questions);
    }

    /**
     * Method getAllQuestions
     * @return All Questions entries
     */
    @Transactional
    public List<Questions> getAllQuestions() {
        return questionDAO.findAll();
    }

    /**
     * Method getQuestionById
     * @param id Long ID of the searched entry
     * @return The Questions entry in function of the given ID
     */
    @Transactional
    public Optional<Questions> getQuestionById(Long id) {
        return questionDAO.findById(id);
    }

    /**
     * Method getQuestionsByIdMcq
     * @param id Long ID of the Mcq we are searching entries
     * @return All Questions entries in function of the given idModule
     */
    @Transactional
    public List<Questions> getQuestionsByIdMcq(Long id) {
        List<Questions> all = questionDAO.findAll();
        List<Questions> questions = new ArrayList<>();
        for (Questions question : all) {
            if (question.getIdMcq().equals(id)) {
                questions.add(question);
            }
        }
        return questions;
    }

    /**
     * Method updateResult
     * @param idQuestion Long ID of the Questions we want to update skill
     * @param idStudent Long ID of the student who answered the question
     * @param isCorrect boolean If the answer is correct
     * Use autoEvaluationService to upgrade or downgrade quizzEval in function of idStudent, idQuestion and isCorrect
     */
    @Transactional
    public void updateResult(Long idQuestion, Long idStudent, boolean isCorrect) {
        Optional<Questions> question = this.getQuestionById(idQuestion);
        if (question.isPresent()) {
            if (isCorrect) {
                autoEvaluationService.upgradeAutoEval(idStudent, question.get().getIdSkill());
            } else {
                autoEvaluationService.downGradeAutoEval(idStudent, question.get().getIdSkill());
            }
        }
    }

    /**
     * Method deleteQuestionById
     * @param id Long ID of the entry to delete
     * Delete Questions entry in function of the given ID
     */
    @Transactional
    public void deleteQuestionById(Long id) {
        questionDAO.deleteById(id);
    }
}
