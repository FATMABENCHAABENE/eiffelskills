package com.example.eiffelskills_back.services;

import com.example.eiffelskills_back.DAO.ResourcesDAO;
import com.example.eiffelskills_back.models.Resources;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Class ResourceService
 */
@Service
@RequiredArgsConstructor
public class ResourceService {
    private final ResourcesDAO resourcesDAO;

    /**
     * Method getAllResources
     * @return All Resources entries
     */
    @Transactional
    public List<Resources> getAllResources() {
        return resourcesDAO.findAll();
    }

    /**
     * Method getResourceById
     * @param id Long ID of the searched entry
     * @return The Resources entry in function of the given ID
     */
    @Transactional
    public Resources getResourceById(Long id) {
        return resourcesDAO.findById(id).orElse(null);
    }

    /**
     * Method getResourcesByIdModule
     * @param id Long ID of the Modules we are searching entries
     * @return All Resources entries in function of the given idModule
     */
    @Transactional
    public List<Resources> getResourcesByIdModule(Long id) {
        List<Resources> all = this.getAllResources();
        List<Resources> resources= new ArrayList<>();
        for (Resources resource : all) {
            if (resource.getIdModule().equals(id)) {
                resources.add(resource);
            }
        }
        return resources;
    }

    /**
     * Method addResource
     * @param resources Resources Object to add in entries
     * Add the given object in Resources entries
     */
    @Transactional
    public void addResource(Resources resources) {
        resourcesDAO.save(resources);
    }

    /**
     * Method deleteResourceById
     * @param id Long ID of the entry to delete
     * Delete the Resources entry in function of the given ID
     */
    @Transactional
    public void deleteResourceById(Long id) {
        resourcesDAO.deleteById(id);
    }
}
