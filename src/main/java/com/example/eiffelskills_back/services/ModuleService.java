package com.example.eiffelskills_back.services;

import com.example.eiffelskills_back.DAO.ModuleDAO;
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

    public List<Module> getAllModules() {
        Iterator<Module> all = (Iterator<Module>) moduleDAO.findAll();
        List<Module> modules = new ArrayList<>();
        all.forEachRemaining(modules::add);
        return modules;
    }

    public Module getModuleById(Long id) {
        return moduleDAO.getReferenceById(id);
    }

    public List<Module> getModulesByMajor(String major) {
        Iterator<Module> all = moduleDAO.findByMajor(major);
        List<Module> modules = new ArrayList<>();
        all.forEachRemaining(modules::add);
        return modules;
    }

    public void saveModule(Module module) {moduleDAO.save(module);}
}
