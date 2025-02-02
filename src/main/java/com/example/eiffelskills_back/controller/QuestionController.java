package com.example.eiffelskills_back.controller;

import com.example.eiffelskills_back.models.Questions;
import com.example.eiffelskills_back.services.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Class QuestionController
 * All question are inserted by teacher and managed through this controller
 */
@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("question")
public class QuestionController {
    private final QuestionService questionService;

    /**
     * Method saveQuestion
     * @param question Questions Object to add in Questions entries
     * @return The saved Question object
     */
    @PostMapping("")
    public Questions saveQuestion(@RequestBody Questions question) {
        //System.out.println(question);
        return questionService.saveQuestions(question);
    }

    /**
     * Method getAllQuestions
     * @return All Questions entries
     */
    @GetMapping("")
    public List<Questions> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    /**
     * Method getQuestionById
     * @param id Long ID of the searched entry
     * @return The Questions entry in function of the given ID
     */
    @GetMapping("/{id}")
    public Optional<Questions> getQuestionById(@PathVariable Long id) {
        return questionService.getQuestionById(id);
    }

    /**
     * Method getQuestionsByMcq
     * @param idMcq Long ID of the Mcq we are searching Questions entries
     * @return All Questions entries in function of the given Mcq ID
     */
    @GetMapping("/MCQ/{idMcq}")
    public List<Questions> getQuestionsByMcq(@PathVariable Long idMcq) {
        return questionService.getQuestionsByIdMcq(idMcq);
    }

    /**
     * Method deleteQuestionById
     * @param id Long ID of the entry to delete
     * Delete the Question entry in function of the given IDs
     */
    @DeleteMapping("/{id}")
    public void deleteQuestionById(@PathVariable Long id) {
        questionService.deleteQuestionById(id);
    }
}
