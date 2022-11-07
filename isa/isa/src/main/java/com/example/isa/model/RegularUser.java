package com.example.isa.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

enum LoyaltyProgram {REGULAR, SILVER, GOLD}

@Entity
@Getter
@Setter
@Table(name="regularusers")
public class RegularUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column
    @Enumerated(EnumType.STRING)
    public com.example.isa.model.dto.LoyaltyProgram loyalty;

    @Column
    private Integer points;

    @Column
    private Integer penalties;

    @Column
    private User userField;

    @OneToOne(mappedBy = "regularUser")
    private Questionnaire questionnaire;

    @OneToOne(mappedBy = "regularUser")
    private Grade grade;

    @OneToOne(mappedBy = "regularUser")
    private User user;

    @OneToMany(mappedBy = "regular_user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Term> terms;
     
    @OneToMany(mappedBy = "regularUser", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Complaint> complaints;

    public RegularUser(){

    }

    public RegularUser(Long id, com.example.isa.model.dto.LoyaltyProgram loyalty, Integer points, Integer penalties, User userField) {
        this.id = id;
        this.loyalty = loyalty;
        this.points = points;
        this.penalties = penalties;
        this.userField = userField;
    }


    
}

