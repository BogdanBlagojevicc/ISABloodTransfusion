package com.example.isa.model.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CenterDTO {
    private Long id;

    private String name;

    private String description;

    private Double averageGrade;

    private String country;

    private Date startTime;

    private Date endTime;

    public CenterDTO(){

    }

    public CenterDTO(Long id, String name, String description, Double averageGrade, String country, Date startTime,
            Date endTime) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.averageGrade = averageGrade;
        this.country = country;
        this.startTime = startTime;
        this.endTime = endTime;
    }


    

}
