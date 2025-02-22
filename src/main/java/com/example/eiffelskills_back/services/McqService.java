package com.example.eiffelskills_back.services;

import com.example.eiffelskills_back.DAO.McqDAO;
import com.example.eiffelskills_back.models.Mcq;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Class McqService
 */
@Service
@RequiredArgsConstructor
public class McqService {
    private final McqDAO mcqDAO;

    /**
     * Method saveMcq
     * @param mcq Object to add in entries
     * @return Saved and single Mcq entry for a module
     */
    @Transactional
    public Mcq saveMcq(Mcq mcq) {
        if (!this.getMcqByIdModule(mcq.getIdModule()).isEmpty()) {
            mcqDAO.deleteByIdModule(mcq.getIdModule());
        }
        return mcqDAO.save(mcq);
    }

    /**
     * Method getAllMcqs
     * @return All Mcq entries
     */
    @Transactional
    public List<Mcq> getAllMcqs() {
        return mcqDAO.findAll();
    }

    /**
     * Method getMcqById
     * @param id Long ID of the searched entry
     * @return The Mcq entry in function of the given ID
     */
    @Transactional
    public Optional<Mcq> getMcqById(Long id) {
        return mcqDAO.findById(id);
    }

    /**
     * Method getMcqByIdModule
     * @param idModule ID of the module we are searching all entries
     * @return All entries in function of the given idModule
     */
    @Transactional
    public List<Mcq> getMcqByIdModule(Long idModule) {
        List<Mcq> allMcqs = mcqDAO.findAll();
        List<Mcq> mcqs = new ArrayList<>();
        for (Mcq mcq : allMcqs) {
            if (mcq.getIdModule().equals(idModule)) {
                mcqs.add(mcq);
            }
        }
        return mcqs;
    }

    /**
     * Method deleteMcqById
     * @param id Long ID of the entry to delete
     * Delete the Mcq entry in function of the given ID
     */
    @Transactional
    public void deleteMcqById(Long id) {
        mcqDAO.deleteById(id);
    }

    /**
     * Method deleteMcqByIdModule
     * @param idModule Long ID of the module we want to delete refered entries
     * Delete Mcq entries in function of the given idModule
     */
    @Transactional
    public void deleteMcqByIdModule(Long idModule) {
        mcqDAO.deleteByIdModule(idModule);
    }
}
