package com.example.eiffelskills_back.controller;

import com.example.eiffelskills_back.models.Answers;
import com.example.eiffelskills_back.services.AnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Class AwnserController
 * Questions are inserted by teachers and managed through this controller. It is also used to check answers validity.
 */
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("awnser")
public class AnswerController {
    private final AnswerService answerService;

    /**
     * Method addByList
     * @param list List(String) The list of answers description
     * @param idQuestion The question answers are refered
     * @return List(Answers) The list of created entries
     */
    @PostMapping("/question/{idQuestion}")
    public List<Answers> addByList(@RequestBody List<String> list, @PathVariable Long idQuestion) {
        return answerService.addByList(list, idQuestion);
    }

    /**
     * Method updateGoodAnswer
     * @param id Long The ID of the answer we want to make good
     * Change the isGood attribute of the given answer from false to true
     */
    @PostMapping("/updateGood")
    public void updateGoodAnswer(@RequestBody Long id) {
        answerService.updateGoodAnswer(id);
    }

    /**
     * Method getAllAnswers
     * @return The list of all answer entries
     */
    @GetMapping("")
    public List<Answers> getAllAnswers() {
        return answerService.getAllAnswers();
    }

    /**
     * Method getAnswerByIdQuestion
     * @param idQuestion Long The ID of the question we want to get answers
     * @return All answers related to the given question
     */
    @GetMapping("/question/{idQuestion}")
    public List<Answers> getAnswerByIdQuestion(@PathVariable Long idQuestion) {
        System.out.println("je suis dans le back");
        return answerService.getAnswersByIdQuestion(idQuestion);
    }

    /**
     * Method checkAnswerById
     * @param id Long ID of the answer we want to check
     * @return The attribute isGood of the given answer
     */
    @GetMapping("/check/{id}")
    public Boolean checkAnswerById(@PathVariable Long id) {
        return answerService.checkAnswer(id);
    }

    /**
     * Method checkGlobalAnswer
     * @param idStudent <Long> Student who made answers
     * @param idList <List(Long)> List of given answers
     * Check if given answers are good and update evaluation in function of results
     */
    @PostMapping("/globalcheck/{idStudent}")
    public void checkGlobalAnswer(@PathVariable Long idStudent, @RequestBody List<Long> idList) {
        answerService.checkListAnswer(idList, idStudent);
    }
}
