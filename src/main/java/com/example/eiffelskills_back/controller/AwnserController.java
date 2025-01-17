package com.example.eiffelskills_back.controller;

import com.example.eiffelskills_back.models.Awnsers;
import com.example.eiffelskills_back.services.AwnserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        return awnserService.getAwnsersByIdQuestion(idQuestion);
    }

    @GetMapping("/check/{id}")
    public Boolean checkAwnserById(@PathVariable Long id) {
        return awnserService.checkAwnser(id);
    }

    @PostMapping("/globalcheck/{idStudent}")
    public void checkGlobalAwnser(@PathVariable Long idStudent, @RequestBody List<Long> idList) {
        awnserService.checkListAwnser(idList, idStudent);
    }
}
