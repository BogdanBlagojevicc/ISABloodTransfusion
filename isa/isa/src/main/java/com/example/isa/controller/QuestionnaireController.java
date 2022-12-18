package com.example.isa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping(value = "/api/questionnaire")
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

        QuestionnaireDTO newQuestionnaireDTO  = new QuestionnaireDTO(
            newQuestionnaire.getId(),
            newQuestionnaire.getBloodType().toString(),
            newQuestionnaire.getCurrentDateTime().toString(),
            newQuestionnaire.getPreviousTransfusions(),
            newQuestionnaire.getWeight(),
            newQuestionnaire.getIsFeelsGood(),
            newQuestionnaire.getIsSkinChanged(),
            newQuestionnaire.getHighBloodPressure(),
            newQuestionnaire.getLowBloodPressure(),
            newQuestionnaire.getIsPreviousTherapyMoreThanSixDays(),
            newQuestionnaire.getIsUnderRegularMonthlyCycle(),
            newQuestionnaire.getIsPreviousDentalInterventionMoreThanSixDays(),
            newQuestionnaire.getIsPreviousSurgicalInterventionOrBloodDonationMoreThanSixMonths()
        );

        return new ResponseEntity<>(newQuestionnaireDTO, HttpStatus.CREATED);
    }

    @GetMapping(value = "/getOneByRegularUserId/{regularUserId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<QuestionnaireDTO> getByRegularUserId(@PathVariable Long regularUserId) throws Exception {

        Questionnaire questionnaire = this.questionnaireService.findOneByRegularUserId(regularUserId);
        
        QuestionnaireDTO questionnaireDTO  = new QuestionnaireDTO(
            questionnaire.getId(),
            questionnaire.getBloodType().toString(),
            questionnaire.getCurrentDateTime().toString(),
            questionnaire.getPreviousTransfusions(),
            questionnaire.getWeight(),
            questionnaire.getIsFeelsGood(),
            questionnaire.getIsSkinChanged(),
            questionnaire.getHighBloodPressure(),
            questionnaire.getLowBloodPressure(),
            questionnaire.getIsPreviousTherapyMoreThanSixDays(),
            questionnaire.getIsUnderRegularMonthlyCycle(),
            questionnaire.getIsPreviousDentalInterventionMoreThanSixDays(),
            questionnaire.getIsPreviousSurgicalInterventionOrBloodDonationMoreThanSixMonths()
        );

        return new ResponseEntity<>(questionnaireDTO, HttpStatus.OK);
    }

    
}
