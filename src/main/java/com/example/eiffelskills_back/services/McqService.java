package com.example.eiffelskills_back.services;

import com.example.eiffelskills_back.DAO.McqDAO;
import com.example.eiffelskills_back.models.Mcq;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class McqService {
    private final McqDAO mcqDAO;

    @Transactional
    public Mcq saveMcq(Mcq mcq) {
        mcqDAO.deleteByIdModule(mcq.getIdModule());
        return mcqDAO.save(mcq);
    }

    @Transactional
    public List<Mcq> getAllMcqs() {
        return mcqDAO.findAll();
    }

    @Transactional
    public Optional<Mcq> getMcqById(Long id) {
        return mcqDAO.findById(id);
    }

    @Transactional
    public List<Mcq> getMcqByIdModule(Long idModule) {
        List<Mcq> allMcqs = mcqDAO.findAll();
        for (Mcq mcq : allMcqs) {
            if (!mcq.getIdModule().equals(idModule)) {
                allMcqs.remove(mcq);
            }
        }
        return allMcqs;
    }

    @Transactional
    public Mcq updateMcqByIdModule(Mcq mcq) {
        if (this.getMcqByIdModule(mcq.getIdModule()).isEmpty()) {
            return saveMcq(mcq);
        } else {
            return mcqDAO.updateByIdModule(mcq.getDescription(),mcq.getIdModule());
        }
    }

    @Transactional
    public void deleteMcqById(Long id) {
        mcqDAO.deleteById(id);
    }

    @Transactional
    public void deleteMcqByIdModule(Long idModule) {
        mcqDAO.deleteByIdModule(idModule);
    }
}
