package com.example.eiffelskills_back.services;

import com.example.eiffelskills_back.DAO.AwnserDAO;
import com.example.eiffelskills_back.models.Awnsers;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AwnserService {
    private final AwnserDAO awnserDAO;

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
}
