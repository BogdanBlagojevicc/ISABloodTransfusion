package com.example.isa.model.dto;

import java.time.LocalTime;

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

    private LocalTime startTime;

    private LocalTime endTime;

    public CenterDTO() {

    }

    public CenterDTO(Long id, String name, String address, String description, Double averageGrade, String country,
            LocalTime startTime,
            LocalTime endTime) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.description = description;
        this.averageGrade = averageGrade;
        this.country = country;
        this.startTime = startTime;
        this.endTime = endTime;
        this.address = address;
    }


}
