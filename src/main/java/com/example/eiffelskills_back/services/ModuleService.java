package com.example.eiffelskills_back.services;

import com.example.eiffelskills_back.DAO.ModuleDAO;
import com.example.eiffelskills_back.models.Modules;
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

    public List<Modules> getAllModules() {
        Iterator<Modules> all = (Iterator<Modules>) moduleDAO.findAll();
        List<Modules> modules = new ArrayList<>();
        all.forEachRemaining(modules::add);
        return modules;
    }

    public Modules getModuleById(Long id) {
        return moduleDAO.getReferenceById(id);
    }

    public List<Modules> getModulesByMajor(String major) {
        Iterator<Modules> all = (Iterator<Modules>) moduleDAO.findAll();
        List<Modules> modules = new ArrayList<>();
        while (all.hasNext()) {
            Modules module = all.next();
            if (module.getMajor().equals(major)) {
                modules.add(module);
            }
        }
        return modules;
    }

    public void saveModule(Modules module) {moduleDAO.save(module);}
}
