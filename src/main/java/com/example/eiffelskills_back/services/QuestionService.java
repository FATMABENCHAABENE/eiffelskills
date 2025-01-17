package com.example.eiffelskills_back.services;

import com.example.eiffelskills_back.DAO.QuestionDAO;
import com.example.eiffelskills_back.models.Questions;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionDAO questionDAO;

    @Transactional
    public Questions saveQuestions(Questions questions) {
        return questionDAO.save(questions);
    }

    @Transactional
    public List<Questions> getAllQuestions() {
        return questionDAO.findAll();
    }

    @Transactional
    public Questions getQuestionById(Long id) {
        return questionDAO.getReferenceById(id);
    }

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

    @Transactional
    public void deleteQuestionById(Long id) {
        questionDAO.deleteById(id);
    }
}
