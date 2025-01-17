package com.example.eiffelskills_back.services;

import com.example.eiffelskills_back.DAO.AwnserDAO;
import com.example.eiffelskills_back.models.Awnsers;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AwnserService {
    private final AwnserDAO awnserDAO;
    private final QuestionService questionService;

    @Transactional
    public List<Awnsers> addByList(List<String> stringAwnsers, Long idQuestion) {
        List<Awnsers> addedAwnsers = new ArrayList<>();
        for (String stringAwnser : stringAwnsers) {
            addedAwnsers.add(awnserDAO.save(new Awnsers(stringAwnser,false,idQuestion)));
        }
        return addedAwnsers;
    }

    @Transactional
    public void updateGoodAwnser(Long idAwnser) {
        awnserDAO.updateGoodAwnser(idAwnser);
    }

    @Transactional
    public List<Awnsers> getAllAwnsers() {
        return awnserDAO.findAll();
    }

    @Transactional
    public List<Awnsers> getAwnsersByIdQuestion(Long idQuestion) {
        List<Awnsers> allAwnsers = getAllAwnsers();
        List<Awnsers> awnsers = new ArrayList<>();
        for (Awnsers awnser : allAwnsers) {
            if (awnser.getIdQuestion().equals(idQuestion)) {
                awnsers.add(awnser);
            }
        }
        return awnsers;
    }

    @Transactional
    public Boolean checkAwnser(Long idAwnser) {
        Optional<Awnsers> awnsers = awnserDAO.findById(idAwnser);
        return awnsers.get().isGood();
    }

    @Transactional
    public void checkListAwnser(List<Long> allIdAwnsers, Long idStudent) {
        for (Long id : allIdAwnsers) {
            Awnsers awnser = awnserDAO.findById(id).get();
            questionService.updateResult(awnser.getId(),idStudent,awnser.isGood());
        }
    }
}
