package com.example.isa.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import com.example.isa.model.dto.Gender;
import com.example.isa.model.dto.LoyaltyProgram;


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
    public LoyaltyProgram loyalty;

    @Column
    private Integer points;

    @Column
    private Integer penalties;

    @OneToOne(mappedBy = "regularUser", fetch = FetchType.LAZY)
    private Questionnaire questionnaire;

    @OneToOne(mappedBy = "regularUser", fetch = FetchType.LAZY)
    private Grade grade;

    @OneToMany(mappedBy = "regularUser", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Term> terms;
    
    @OneToMany(mappedBy = "regularUser", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Complaint> complaints;

    @OneToOne
    @JoinColumn(name = "userId")
    private User baseUserRU;

    public RegularUser(){

    }

    public RegularUser(LoyaltyProgram loyalty, Integer points, Integer penalties, User baseUserRU) {
        this.loyalty = loyalty;
        this.points = points;
        this.penalties = penalties;
        this.baseUserRU = baseUserRU;
    }

    





}

