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
import com.example.isa.model.RegularUser;
import com.example.isa.model.User;
import com.example.isa.model.dto.BloodType;
import com.example.isa.model.dto.QuestionnaireDTO;
import com.example.isa.service.QuestionnaireService;
import com.example.isa.service.RegularUserService;
import com.example.isa.service.UserService;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/questionnaire")
public class QuestionnaireController {
    private final QuestionnaireService questionnaireService;
    private final RegularUserService regularUserService;
    private final UserService userService;

    @Autowired
    public QuestionnaireController(QuestionnaireService questionnaireService, RegularUserService regularUserService, UserService userService){
        this.questionnaireService = questionnaireService;
        this.regularUserService = regularUserService;
        this.userService = userService;
    }

    @PostMapping(value = "/new/{regUserUsername}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAnyRole('ROLE_REGULAR_USER', 'ROLE_CENTER_ADMINISTRATOR')")
    public ResponseEntity<QuestionnaireDTO> createNewQuestionnaire(@RequestBody QuestionnaireDTO questionnaireDTO, @PathVariable String regUserUsername) throws Exception{

        Questionnaire questionnaire = new Questionnaire(questionnaireDTO.getPreviousTransfusions(), questionnaireDTO.getWeight(), questionnaireDTO.getIsFeelsGood(),
        questionnaireDTO.getIsSkinChanged(), questionnaireDTO.getHighBloodPressure(), questionnaireDTO.getLowBloodPressure(),
        questionnaireDTO.getIsPreviousTherapyMoreThanSixDays(), questionnaireDTO.getIsUnderRegularMonthlyCycle(),
        questionnaireDTO.getIsPreviousDentalInterventionMoreThanSixDays(), questionnaireDTO.getIsPreviousSurgicalInterventionOrBloodDonationMoreThanSixMonths(),
         BloodType.valueOf(questionnaireDTO.getBloodType()));

        User user = this.userService.findByUsername(regUserUsername);

        RegularUser regularUser = this.regularUserService.findOne(user.getId());

        questionnaire.setRegularUser(regularUser);

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
