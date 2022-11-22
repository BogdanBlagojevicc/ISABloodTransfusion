package com.example.isa.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.example.isa.model.dto.Gender;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
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

    @OneToOne(mappedBy = "baseUser")
    private CenterAdministrator centerAdministrator;

    @OneToOne(mappedBy = "user")
    private RegularUser regularUser;

    @OneToOne(mappedBy = "baseUser")
    private SystemAdministrator systemAdministrator;

    public User() {
    }

    public User(Long id, String email, String password, String firstName, String lastName, String address, String city,
            String country, String phoneNumber, String jmbg, Gender gender, String profession, String education) {
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

    public User(String email, String password, String firstName, String lastName, String address, String city,
    String country, String phoneNumber, String jmbg, Gender gender, String profession, String education) {
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
