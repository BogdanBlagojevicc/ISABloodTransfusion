package com.example.isa.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

enum Role {USER, CENTER_ADMINISTRATOR, SYSTEM_ADMINISTRATOR}
enum Gender {MALE, FEMALE}

enum LoyalityProgram{REGULAR, SILVER, GOLD}

@Entity
@Getter
@Setter
public class User implements Serializable {

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

    @Column
    private Integer penalties;

    @Column
    private LoyalityProgram loyalityProgram;

    @Column
    private Integer points;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Center center;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Term term;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Complaint> complaints;

    public User() {
    }

    public User(Long id, String email, String password, String firstName, String lastName, String address, String city, String country, String phoneNumber, String jmbg, Gender gender, String profession, String education, Integer penalties) {
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
        this.penalties = penalties;
    }
}
