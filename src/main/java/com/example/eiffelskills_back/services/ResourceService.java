package com.example.eiffelskills_back.services;

import com.example.eiffelskills_back.DAO.ResourcesDAO;
import com.example.eiffelskills_back.models.Resources;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ResourceService {
    private final ResourcesDAO resourcesDAO;

    @Transactional
    public List<Resources> getAllResources() {
        return resourcesDAO.findAll();
    }

    @Transactional
    public Resources getResourceById(Long id) {
        return resourcesDAO.findById(id).orElse(null);
    }

    @Transactional
    public void addResource(Resources resources) {
        resourcesDAO.save(resources);
    }

    @Transactional
    public void deleteResourceById(Long id) {
        resourcesDAO.deleteById(id);
    }
}
