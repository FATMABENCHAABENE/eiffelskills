package com.example.eiffelskills_back.controller;

import com.example.eiffelskills_back.models.Awnsers;
import com.example.eiffelskills_back.services.AwnserService;
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
public class AwnserController {
    private final AwnserService awnserService;

    @PostMapping("/question/{idQuestion}")
    public List<Awnsers> addByList(@RequestBody List<String> list, @PathVariable Long idQuestion) {
        return awnserService.addByList(list, idQuestion);
    }

    @PostMapping("/updateGood")
    public void updateGoodAwnser(@RequestBody Long id) {
        awnserService.updateGoodAwnser(id);
    }

    @GetMapping("")
    public List<Awnsers> getAllAwnsers() {
        return awnserService.getAllAwnsers();
    }

    @GetMapping("/question/{idQuestion}")
    public List<Awnsers> getAwnserByIdQuestion(@PathVariable Long idQuestion) {
        System.out.println("je suis dans le back");
        return awnserService.getAwnsersByIdQuestion(idQuestion);
    }

    @GetMapping("/check/{id}")
    public Boolean checkAwnserById(@PathVariable Long id) {
        return awnserService.checkAwnser(id);
    }

    /**
     * Method checkGlobalAwnser
     * @param idStudent <Long> Student who made awnsers
     * @param idList <List(Long)> List of given awnsers
     * Check if given awnsers are good and update evaluation in function of results
     */
    @PostMapping("/globalcheck/{idStudent}")
    public void checkGlobalAwnser(@PathVariable Long idStudent, @RequestBody List<Long> idList) {
        awnserService.checkListAwnser(idList, idStudent);
    }
}
