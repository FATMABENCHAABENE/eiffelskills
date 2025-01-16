package com.example.eiffelskills_back.controller;

import com.example.eiffelskills_back.models.Mcq;
import com.example.eiffelskills_back.services.McqService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class McqController {
    private final McqService mcqService;

    @PostMapping("")
    public Mcq saveMcq(@RequestBody Mcq mcq) {
        return mcqService.saveMcq(mcq);
    }

    @GetMapping("")
    public List<Mcq> getAllMcqs() {
        return mcqService.getAllMcqs();
    }

    @GetMapping("/{id}")
    public Optional<Mcq> getMcqById(@PathVariable Long id) {
        return mcqService.getMcqById(id);
    }

    @GetMapping("/module/{idModule}")
    public List<Mcq> getMcqByIdModule(@PathVariable Long idModule) {
        return mcqService.getMcqByIdModule(idModule);
    }

    @DeleteMapping("/{id}")
    public void deleteMcqById(@PathVariable Long id) {
        mcqService.deleteMcqById(id);
    }

    @DeleteMapping("/module/{idModule}")
    public void deleteMcqByIdModule(@PathVariable Long idModule) {
        mcqService.deleteMcqByIdModule(idModule);
    }
}
