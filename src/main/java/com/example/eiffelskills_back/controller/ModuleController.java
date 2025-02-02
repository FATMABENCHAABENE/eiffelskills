package com.example.eiffelskills_back.controller;

import com.example.eiffelskills_back.models.Modules;
import com.example.eiffelskills_back.services.ModuleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Class ModuleController
 * Modules are inserted by the admin and managed through this controller
 */
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("module")
public class ModuleController {
    private final ModuleService moduleService;

    /**
     * Method getAllModules
     * @return All Modules entry
     */
    @GetMapping("")
    public List<Modules> getAllModules() {
        return moduleService.getAllModules();
    }

    /**
     * Method addModule
     * @param module Module The module to add in entries
     * Add the Modules object given in parameter
     */
    @PostMapping("")
    public void addModule(@RequestBody Modules module) {
        moduleService.saveModule(module);
    }

    /**
     * Method getModuleById
     * @param id Long ID of the searched Modules entry
     * @return The Modules entry with the given ID
     */
    @GetMapping("/{id}")
    public Optional<Modules> getModuleById(@PathVariable Long id) {
        return moduleService.getModuleById(id);
    }

    /**
     * Method getModuleByMajor
     * @param major String The major we are searching modules
     * @return All Modules entries with the given major
     */
    @GetMapping("/major/{major}")
    public List<Modules> getModuleByMajor(@PathVariable String major) {
        return moduleService.getModulesByMajor(major);
    }

    /**
     * Method getModulesByIdTeacher
     * @param id Long ID of the teacher we are searching modules
     * @return All modules with the given teacher ID
     */
    @GetMapping("/teacher/{id}")
    public List<Modules> getModulesByIdTeacher(@PathVariable Long id) {
        System.out.println("\nIn ModuleController");
        return moduleService.getModuleByIdTeacher(id);
    }

    /**
     * Method updateModuleById
     * @param id Long ID of the module to update
     * @param module Modules Object with attributes to update
     * Update the Modules entry having the given ID with attributes in the Modules object
     */
    @PostMapping("/{id}")
    public void updateModuleById(@PathVariable Long id, @RequestBody Modules module) {
        moduleService.updateModule(module, id);
    }

    /**
     * Method deleteModuleById
     * @param id ID of the Modules entry to delete
     * Delete the Modules entry in function of the given ID
     */
    @DeleteMapping("/{id}")
    public void deleteModuleById(@PathVariable Long id) {
        moduleService.deleteModuleById(id);
    }
}
