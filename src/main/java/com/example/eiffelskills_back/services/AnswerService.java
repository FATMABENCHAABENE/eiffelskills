package com.example.eiffelskills_back.services;

import com.example.eiffelskills_back.DAO.AnswerDAO;
import com.example.eiffelskills_back.models.Answers;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AnswerService {
    private final AnswerDAO answerDAO;
    private final QuestionService questionService;

    @Transactional
    public List<Answers> addByList(List<String> stringAwnsers, Long idQuestion) {
        List<Answers> addedAwnsers = new ArrayList<>();
        for (String stringAwnser : stringAwnsers) {
            addedAwnsers.add(answerDAO.save(new Answers(stringAwnser,false,idQuestion)));
        }
        return addedAwnsers;
    }

    @Transactional
    public void updateGoodAwnser(Long idAwnser) {
        answerDAO.updateGoodAwnser(idAwnser);
    }

    @Transactional
    public List<Answers> getAllAwnsers() {
        return answerDAO.findAll();
    }

    @Transactional
    public List<Answers> getAwnsersByIdQuestion(Long idQuestion) {
        List<Answers> allAwnsers = getAllAwnsers();
        List<Answers> awnsers = new ArrayList<>();
        for (Answers awnser : allAwnsers) {
            if (awnser.getIdQuestion().equals(idQuestion)) {
                awnsers.add(awnser);
            }
        }
        System.out.println(awnsers);
        return awnsers;
    }

    @Transactional
    public Boolean checkAwnser(Long idAwnser) {
        Optional<Answers> awnsers = answerDAO.findById(idAwnser);
        return awnsers.get().isGood();
    }

    @Transactional
    public void checkListAwnser(List<Long> allIdAwnsers, Long idStudent) {
        for (Long id : allIdAwnsers) {
            if (id!=null) {
                Answers awnser = answerDAO.findById(id).get();
                questionService.updateResult(awnser.getIdQuestion(),idStudent,awnser.isGood());
            }
        }
    }
}
