package com.example.isa.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ComplaintDTO {
    
    private Long id;

    private String text;

    private String response;

    public ComplaintDTO(){

    }

    public ComplaintDTO(Long id, String text, String response){
        this.id = id;
        this.text = text;
        this.response = response;
    }

}
