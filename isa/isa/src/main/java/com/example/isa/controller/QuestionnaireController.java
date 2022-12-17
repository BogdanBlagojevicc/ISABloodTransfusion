package com.example.isa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;

import com.example.isa.model.Questionnaire;
import com.example.isa.model.dto.BloodType;
import com.example.isa.model.dto.QuestionnaireDTO;
import com.example.isa.service.QuestionnaireService;

@CrossOrigin
@RestController
@RequestMapping(value = "api/questionnaire")
public class QuestionnaireController {
    private final QuestionnaireService questionnaireService;

    @Autowired
    public QuestionnaireController(QuestionnaireService questionnaireService){
        this.questionnaireService = questionnaireService;
    }

    @PostMapping(value = "/new", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('ROLE_REGULAR_USER')")
    public ResponseEntity<QuestionnaireDTO> createNewQuestionnaire(@RequestBody QuestionnaireDTO questionnaireDTO) throws Exception{

        Questionnaire questionnaire = new Questionnaire(BloodType.valueOf(questionnaireDTO.getBloodType()));

        Questionnaire newQuestionnaire = this.questionnaireService.create(questionnaire);

        QuestionnaireDTO newQuestionnaireDTO = new QuestionnaireDTO(newQuestionnaire.getId(), newQuestionnaire.getBloodType().toString());

        return new ResponseEntity<>(newQuestionnaireDTO, HttpStatus.CREATED);
    }

    
}
