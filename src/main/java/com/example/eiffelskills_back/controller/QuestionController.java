package com.example.eiffelskills_back.controller;

import com.example.eiffelskills_back.models.Questions;
import com.example.eiffelskills_back.services.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("question")
public class QuestionController {
    private final QuestionService questionService;

    @PostMapping("")
    public Questions saveQuestion(@RequestBody Questions question) {
        return questionService.saveQuestions(question);
    }

    @GetMapping("")
    public List<Questions> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @GetMapping("/{id}")
    public Questions getQuestionById(@PathVariable Long id) {
        return questionService.getQuestionById(id);
    }

    @GetMapping("/MCQ/{idMcq}")
    public List<Questions> getQuestionsByMcq(@PathVariable Long idMcq) {
        return questionService.getQuestionsByIdMcq(idMcq);
    }

    @DeleteMapping("/{id}")
    public void deleteQuestionById(@PathVariable Long id) {
        questionService.deleteQuestionById(id);
    }
}
