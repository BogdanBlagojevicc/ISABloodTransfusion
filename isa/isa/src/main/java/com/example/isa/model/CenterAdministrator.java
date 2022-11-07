package com.example.isa.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

enum Gender {MALE, FEMALE}

@Entity
@Getter
@Setter
@Table(name = "centeradministrators")
public class CenterAdministrator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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


    @OneToOne(mappedBy = "centerAdministrator")
    private Complaint complaint;

    @OneToOne
    private Term term;

    

    @ManyToOne(fetch= FetchType.LAZY)
    private Center center;

    public CenterAdministrator(){

    }

    public CenterAdministrator(Long id, String email, String password, String firstName, String lastName,
            String address, String city, String country, String phoneNumber, String jmbg, Gender gender,
            String profession, String education) {
        this.id = id;
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
    }
    
    
    
}

