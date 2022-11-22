package com.example.isa.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private Long id;

    private String email;

    private String password;

    private String firstName;

    private String lastName;

    private String address;

    private String city;

    private String country;

    private String phoneNumber;

    private String jmbg;

    private String gender;

    private String profession;

    private String education;


    private UserDTO(){

    }

    public UserDTO(Long id, String email, String password, String firstName, String lastName, String address,
            String city, String country, String phoneNumber, String jmbg, String gender, String profession,
            String education) {
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

    public UserDTO(String email, String password, String firstName, String lastName, String address,
            String city, String country, String phoneNumber, String jmbg, String gender, String profession,
            String education) {
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
