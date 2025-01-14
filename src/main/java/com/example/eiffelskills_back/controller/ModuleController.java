package com.example.eiffelskills_back.controller;

import com.example.eiffelskills_back.models.Modules;
import com.example.eiffelskills_back.services.ModuleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("module")
public class ModuleController {
    private final ModuleService moduleService;

    @GetMapping("")
    public List<Modules> getAllModules() {return moduleService.getAllModules();}

    @PostMapping("")
    public void addModule(@RequestBody Modules module) {moduleService.saveModule(module);}

    @GetMapping("/{id}")
    public Modules getModuleById(@PathVariable Long id) {
        return moduleService.getModuleById(id);
    }

    @GetMapping("/major/{major}")
    public List<Modules> getModuleByMajor(@PathVariable String major) {return moduleService.getModulesByMajor(major);}
}