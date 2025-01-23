package com.example.eiffelskills_back.controller;

import com.example.eiffelskills_back.models.Resources;
import com.example.eiffelskills_back.services.ResourceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("resource")
public class ResourcesController {
    private final ResourceService resourceService;

    @GetMapping("")
    public List<Resources> getAllResources() {
        return resourceService.getAllResources();
    }

    @PostMapping("")
    public void createResource(@RequestBody Resources resources) {
        resourceService.addResource(resources);
    }

    @GetMapping("/{id}")
    public Resources getResourceById(@PathVariable Long id) {
        return resourceService.getResourceById(id);
    }

    @GetMapping("/module/{idModule}")
    public List<Resources> getResourcesByModule(@PathVariable Long idModule) {
        return resourceService.getResourcesByIdModule(idModule);
    }

    @DeleteMapping("/{id}")
    public void deleteResource(@PathVariable Long id) {
        resourceService.deleteResourceById(id);
    }
}
