package com.example.isa.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionnaireDTO {
    private Long id;

    private String bloodType;
    
    public QuestionnaireDTO() {
        
    }

    public QuestionnaireDTO(Long id, String bloodType) {
        this.id = id;
        this.bloodType = bloodType;
    }

    public QuestionnaireDTO(String bloodType){
        this.bloodType = bloodType;
    }

}
