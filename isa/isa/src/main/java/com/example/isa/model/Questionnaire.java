package com.example.isa.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import com.example.isa.model.dto.BloodType;

import java.io.Serializable;


@Entity
@Getter
@Setter
@Table(name = "questionnaries")
public class Questionnaire implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Enumerated(EnumType.STRING)
    private BloodType bloodType;

    @OneToOne
    private RegularUser regularUser;

    public Questionnaire() {
    }

    public Questionnaire(Long id, BloodType bloodType) {
        this.id = id;
        this.bloodType = bloodType;
    }

    public Questionnaire(BloodType bloodType) {
        this.bloodType = bloodType;
    }

}

