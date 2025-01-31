package com.example.eiffelskills_back.controller;

import com.example.eiffelskills_back.models.Modules;
import com.example.eiffelskills_back.services.ModuleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * ModuleController :
 * Modules are inserted by the admin and managed through this controller
 */
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("module")
public class ModuleController {
    private final ModuleService moduleService;

    @GetMapping("")
    public List<Modules> getAllModules() {
        return moduleService.getAllModules();
    }

    @PostMapping("")
    public void addModule(@RequestBody Modules module) {
        moduleService.saveModule(module);
    }

    @GetMapping("/{id}")
    public Optional<Modules> getModuleById(@PathVariable Long id) {
        return moduleService.getModuleById(id);
    }

    @GetMapping("/major/{major}")
    public List<Modules> getModuleByMajor(@PathVariable String major) {
        return moduleService.getModulesByMajor(major);
    }

    @GetMapping("/teacher/{id}")
    public List<Modules> getModulesByIdTeacher(@PathVariable Long id) {
        System.out.println("\nIn ModuleController");
        return moduleService.getModuleByIdTeacher(id);
    }

    @PostMapping("/{id}")
    public void updateModuleById(@PathVariable Long id, @RequestBody Modules module) {
        moduleService.updateModule(module, id);
    }

    @DeleteMapping("/{id}")
    public void deleteModuleById(@PathVariable Long id) {
        moduleService.deleteModuleById(id);
    }
}
