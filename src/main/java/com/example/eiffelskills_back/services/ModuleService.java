package com.example.eiffelskills_back.services;

import com.example.eiffelskills_back.DAO.ModuleDAO;
import com.example.eiffelskills_back.models.Modules;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Class ModuleService
 */
@Service
@RequiredArgsConstructor
public class ModuleService {
    private final ModuleDAO moduleDAO;

    /**
     * Method getAllModules
     * @return All Modules entries
     */
    @Transactional
    public List<Modules> getAllModules() {
        return moduleDAO.findAll();
    }

    /**
     * Method getModuleById
     * @param id Long ID of the searched entry
     * @return The Modules entry in function of the given ID
     */
    @Transactional
    public Optional<Modules> getModuleById(Long id) {
        return moduleDAO.findById(id);
    }

    /**
     * Method getModulesByMajor
     * @param major String Major we are searching all modules
     * @return All Modules entries in function of the major
     */
    @Transactional
    public List<Modules> getModulesByMajor(String major) {
        List<Modules> all = moduleDAO.findAll();
        List<Modules> modules = new ArrayList<>();
        for (Modules module : all) {
            if (module.getMajor().equals(major)) {
                modules.add(module);
            }
        }
        return modules;
    }

    /**
     * Method getModuleByIdTeacher
     * @param teacherId ID of the teacher we are searching entries
     * @return All Modules entries in function of the given idTeacher
     */
    @Transactional
    public List<Modules> getModuleByIdTeacher(Long teacherId) {
        List<Modules> all = moduleDAO.findAll();
        List<Modules> modules = new ArrayList<>();
        for (Modules module : all) {
            if (module.getIdTeacher().equals(teacherId)) {
                modules.add(module);
            }
        }
        return modules;
    }

    /**
     * Method saveModule
     * @param module Modules Object to save in entries
     * Save the given object in Modules entries
     */
    @Transactional
    public void saveModule(Modules module) {
        moduleDAO.save(module);
    }

    /**
     * Method updateModule
     * @param module Object with attributes to change in entries
     * @param id ID of the entry to change attributes
     * Update Modules entry in function of the given ID with attributes of the given object
     */
    @Transactional
    public void updateModule(Modules module, Long id) {
        if (moduleDAO.findById(id).isEmpty()) {
            moduleDAO.save(module);
        } else {
            moduleDAO.updateModuleById(id, module.getDescription(), module.getMajor());
        }
    }

    /**
     * Method deleteModuleById
     * @param id Long ID of the entry to delete
     * Delete the Modules entry in function of the given ID
     */
    @Transactional
    public void deleteModuleById(Long id) {
        moduleDAO.deleteById(id);
    }
}
