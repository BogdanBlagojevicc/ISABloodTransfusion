package com.example.isa.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


enum BloodType {ZERO, A, B, AB}
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

}

