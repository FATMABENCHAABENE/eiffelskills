package com.example.eiffelskills_back.controller;

import com.example.eiffelskills_back.models.Mcq;
import com.example.eiffelskills_back.services.McqService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Class McqController
 * MCQ are inserted by teacher and managed through this controller
 */
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("MCQ")
public class McqController {
    private final McqService mcqService;

    /**
     * Method saveMcq
     * @param mcq Mcq Object to save
     * @return The saved object
     */
    @PostMapping("")
    public Mcq saveMcq(@RequestBody Mcq mcq) {
        System.out.println(mcq);
        return mcqService.saveMcq(mcq);
    }

    /**
     * Method getAllMcqs
     * @return All Mcq entries
     */
    @GetMapping("")
    public List<Mcq> getAllMcqs() {
        return mcqService.getAllMcqs();
    }

    /**
     * Method getMcqById
     * @param id Long ID of the searched entry
     * @return The entry with the given ID
     */
    @GetMapping("/{id}")
    public Optional<Mcq> getMcqById(@PathVariable Long id) {
        return mcqService.getMcqById(id);
    }

    /**
     * Method getMcqByIdModule
     * @param idModule Long ID of the module we want MCQ
     * @return ALl Mcq with the given idModule
     */
    @GetMapping("/module/{idModule}")
    public List<Mcq> getMcqByIdModule(@PathVariable Long idModule) {
        return mcqService.getMcqByIdModule(idModule);
    }

    /**
     * Method deleteMcqById
     * @param id Long ID of the Mcq to delete
     * Delete Mcq entry in function of the given ID
     */
    @DeleteMapping("/{id}")
    public void deleteMcqById(@PathVariable Long id) {
        mcqService.deleteMcqById(id);
    }

    /**
     * Method deleteMcqByIdModule
     * @param idModule Long ID of the module we want to delete the Mcq
     * Delete the Mcq entry in function of the given idModule
     */
    @DeleteMapping("/module/{idModule}")
    public void deleteMcqByIdModule(@PathVariable Long idModule) {
        mcqService.deleteMcqByIdModule(idModule);
    }
}
