package com.example.isa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.isa.model.Questionnaire;
import com.example.isa.repository.QuestionnaireRepository;

@Service
public class QuestionnaireService {
    private final QuestionnaireRepository questionnaireRepository;

    @Autowired
    public QuestionnaireService(QuestionnaireRepository questionnaireRepository){
        this.questionnaireRepository = questionnaireRepository;
    }

    public Questionnaire findOne(Long id){
        return this.questionnaireRepository.getById(id);
    }

    public Questionnaire create(Questionnaire questionnaire){
        return this.questionnaireRepository.save(questionnaire);
    }

}
