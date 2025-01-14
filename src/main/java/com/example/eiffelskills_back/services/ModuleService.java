package com.example.eiffelskills_back.services;

import com.example.eiffelskills_back.DAO.ModuleDAO;
import com.example.eiffelskills_back.models.Modules;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ModuleService {
    private final ModuleDAO moduleDAO;

    @Transactional
    public List<Modules> getAllModules() {
        Iterator<Modules> all = (Iterator<Modules>) moduleDAO.findAll();
        List<Modules> modules = new ArrayList<>();
        all.forEachRemaining(modules::add);
        return modules;
    }

    @Transactional
    public Modules getModuleById(Long id) {
        return moduleDAO.getReferenceById(id);
    }

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

    @Transactional
    public void saveModule(Modules module) {moduleDAO.save(module);}

    @Transactional
    public void updateModule(Modules module, Long id) {
        if (moduleDAO.findById(id).isEmpty()) {
            moduleDAO.save(module);
        } else {
            moduleDAO.updateModuleById(id, module.getDescription(), module.getMajor());
        }
    }

    @Transactional
    public void deleteModuleById(Long id) {moduleDAO.deleteById(id);}
}
