package com.example.eiffelskills_back.controller;

import com.example.eiffelskills_back.models.Resources;
import com.example.eiffelskills_back.services.ResourceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Class ResourceController
 * Resources given by teachers are managed through this controller
 */
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("resource")
public class ResourcesController {
    private final ResourceService resourceService;

    /**
     * Method getAllResources
     * @return All Resources entries
     */
    @GetMapping("")
    public List<Resources> getAllResources() {
        return resourceService.getAllResources();
    }

    /**
     * Method createResource
     * @param resources Resources Object to add in Resources entries
     * Add the given Resources object in entries
     */
    @PostMapping("")
    public void createResource(@RequestBody Resources resources) {
        resourceService.addResource(resources);
    }

    /**
     * Method getResourceById
     * @param id Long ID of the searched entry
     * @return The Resources entry in function of the given ID
     */
    @GetMapping("/{id}")
    public Resources getResourceById(@PathVariable Long id) {
        return resourceService.getResourceById(id);
    }

    /**
     * Method getResourcesByModule
     * @param idModule Long ID of the Modules we search Resources
     * @return All Resources entries in function of the given idModule
     */
    @GetMapping("/module/{idModule}")
    public List<Resources> getResourcesByModule(@PathVariable Long idModule) {
        return resourceService.getResourcesByIdModule(idModule);
    }

    /**
     * Method deleteResource
     * @param id Long ID of the entry to delete
     * Delete the Resources entry in function of the given ID
     */
    @DeleteMapping("/{id}")
    public void deleteResource(@PathVariable Long id) {
        resourceService.deleteResourceById(id);
    }
}
