package com.example.eiffelskills_back.services;

import com.example.eiffelskills_back.DAO.QuestionDAO;
import com.example.eiffelskills_back.models.Questions;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionDAO questionDAO;

    @Transactional
    public Questions saveQuestions(Questions questions) {
        return questionDAO.save(questions);
    }
}
