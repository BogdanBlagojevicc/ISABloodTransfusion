package com.example.isa.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import org.hibernate.query.criteria.internal.predicate.BooleanExpressionPredicate;

import com.example.isa.model.dto.BloodType;

import java.io.Serializable;
import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@Table(name = "questionnaries")
public class Questionnaire implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private LocalDateTime currentDateTime;

    @Column
    private Integer previousTransfusions;

    @Column 
    private Integer weight;

    @Column
    private Boolean isFeelsGood;

    @Column
    private Boolean isSkinChanged;

    @Column
    private Integer highBloodPressure;

    @Column
    private Integer lowBloodPressure;

    @Column
    private Boolean isPreviousTherapyMoreThanSixDays;

    @Column
    private Boolean isUnderRegularMonthlyCycle;

    @Column
    private Boolean isPreviousDentalInterventionMoreThanSixDays;

    @Column
    private Boolean isPreviousSurgicalInterventionOrBloodDonationMoreThanSixMonths;

    @Column
    @Enumerated(EnumType.STRING)
    private BloodType bloodType;

    @OneToOne(fetch = FetchType.LAZY)
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

