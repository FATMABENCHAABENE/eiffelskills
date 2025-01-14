package com.example.eiffelskills_back.controller;

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
    public List<Module> getAllModules() {return moduleService.getAllModules();}

    @PostMapping("")
    public void addModule(@RequestBody Module module) {moduleService.saveModule(module);}

    @GetMapping("/{id}")
    public Module getModuleById(@PathVariable Long id) {
        return moduleService.getModuleById(id);
    }

    @GetMapping("/{major}")
    public List<Module> getModuleByMajor(@PathVariable String major) {moduleService.getModulesByMajor(major);}
}
