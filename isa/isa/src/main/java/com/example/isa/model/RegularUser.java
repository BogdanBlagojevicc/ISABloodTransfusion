package com.example.isa.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import com.example.isa.model.dto.Gender;

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

    @Column(unique = true)
    private String email;

    @Column
    private String password;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String address;

    @Column
    private String city;

    @Column
    private String country;

    @Column(unique = true)
    private String phoneNumber;

    @Column(unique = true)
    private String jmbg;

    @Column
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column
    private String profession;

    @Column
    private String education;

    @Column
    private Integer points;

    @Column
    private Integer penalties;

    @OneToOne(mappedBy = "regularUser")
    private Questionnaire questionnaire;

    @OneToOne(mappedBy = "regularUser")
    private Grade grade;

    @OneToMany(mappedBy = "regular_user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Term> terms;
    
    @OneToMany(mappedBy = "regularUser", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Complaint> complaints;

    public RegularUser(){

    }

    public RegularUser(Long id, com.example.isa.model.dto.LoyaltyProgram loyalty, String email, String password,
            String firstName, String lastName, String address, String city, String country, String phoneNumber,
            String jmbg, Gender gender, String profession, String education, Integer points, Integer penalties) {
        this.id = id;
        this.loyalty = loyalty;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.country = country;
        this.phoneNumber = phoneNumber;
        this.jmbg = jmbg;
        this.gender = gender;
        this.profession = profession;
        this.education = education;
        this.points = points;
        this.penalties = penalties;
    }

    public RegularUser(com.example.isa.model.dto.LoyaltyProgram loyalty, String email, String password,
            String firstName, String lastName, String address, String city, String country, String phoneNumber,
            String jmbg, com.example.isa.model.dto.Gender gender2, String profession, String education, Integer points, Integer penalties) {
        this.loyalty = loyalty;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.country = country;
        this.phoneNumber = phoneNumber;
        this.jmbg = jmbg;
        this.gender = gender2;
        this.profession = profession;
        this.education = education;
        this.points = points;
        this.penalties = penalties;
    }
}

