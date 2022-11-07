package com.example.isa.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

enum Gender {MALE, FEMALE}

@Entity
@Getter
@Setter
@Table(name="systemadministrators")
public class SystemAdministrator {

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

    @OneToOne(mappedBy = "systemAdministrator")
    private User user;
    
    public SystemAdministrator(){

    }

    

} 