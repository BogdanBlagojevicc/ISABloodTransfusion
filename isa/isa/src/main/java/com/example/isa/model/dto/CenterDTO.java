package com.example.isa.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CenterDTO {
    
    private Long id;

    private String name;

    private String address;

    private String description;

    private Double averageGrade;

    private String country;

    private String startTime;

    private String endTime; 

    public CenterDTO(){

    }

    public CenterDTO(Long id, String name, String address, String description, Double averageGrade, String country, String startTime,
            String endTime) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.description = description;
        this.averageGrade = averageGrade;
        this.country = country;
        this.startTime = startTime;
        this.endTime = endTime;
        this.address=address;
    }


    

}
