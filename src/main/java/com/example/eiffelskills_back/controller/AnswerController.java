package com.example.eiffelskills_back.controller;

import com.example.eiffelskills_back.models.Answers;
import com.example.eiffelskills_back.services.AnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * AwnserController :
 * Questions are inserted by teachers and managed through this controller. It is also used to check awnsers validity.
 */
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("awnser")
public class AnswerController {
    private final AnswerService answerService;

    /**
     * Method addByList
     * @param list List(String) The list of awnsers description
     * @param idQuestion The question awnsers are refered
     * @return List(Awnsers) The list of created entries
     */
    @PostMapping("/question/{idQuestion}")
    public List<Answers> addByList(@RequestBody List<String> list, @PathVariable Long idQuestion) {
        return answerService.addByList(list, idQuestion);
    }

    /**
     * Method updateGoodAwnser
     * @param id Long The ID of the awnser we want to make good
     * Change the isGood attribute of the given awnser from false to true
     */
    @PostMapping("/updateGood")
    public void updateGoodAwnser(@RequestBody Long id) {
        answerService.updateGoodAwnser(id);
    }

    /**
     * Method getAllAwnsers
     * @return The list of all awnser entries
     */
    @GetMapping("")
    public List<Answers> getAllAwnsers() {
        return answerService.getAllAwnsers();
    }

    /**
     * Method getAwnserByIdQuestion
     * @param idQuestion Long The ID of the question we want to get awnsers
     * @return All awnsers related to the given question
     */
    @GetMapping("/question/{idQuestion}")
    public List<Answers> getAwnserByIdQuestion(@PathVariable Long idQuestion) {
        System.out.println("je suis dans le back");
        return answerService.getAwnsersByIdQuestion(idQuestion);
    }

    /**
     * Method checkAwnserById
     * @param id Long ID of the awnser we want to check
     * @return The attribute isGood of the given awnser
     */
    @GetMapping("/check/{id}")
    public Boolean checkAwnserById(@PathVariable Long id) {
        return answerService.checkAwnser(id);
    }

    /**
     * Method checkGlobalAwnser
     * @param idStudent <Long> Student who made awnsers
     * @param idList <List(Long)> List of given awnsers
     * Check if given awnsers are good and update evaluation in function of results
     */
    @PostMapping("/globalcheck/{idStudent}")
    public void checkGlobalAwnser(@PathVariable Long idStudent, @RequestBody List<Long> idList) {
        answerService.checkListAwnser(idList, idStudent);
    }
}
