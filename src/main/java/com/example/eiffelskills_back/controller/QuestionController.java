package com.example.eiffelskills_back.controller;

import com.example.eiffelskills_back.models.Questions;
import com.example.eiffelskills_back.services.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
}
