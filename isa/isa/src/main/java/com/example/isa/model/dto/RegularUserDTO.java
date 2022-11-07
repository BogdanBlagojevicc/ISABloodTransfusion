package com.example.isa.model.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class RegularUserDTO {
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

    private String loyalty;

    private Integer points;

    private Integer penalties;

    public RegularUserDTO(){

    }

    public RegularUserDTO(Long id, String email, String password, String firstName, String lastName, String address,
            String city, String country, String phoneNumber, String jmbg, Gender gender2, String profession,
            String education, LoyaltyProgram loyaltyProgram, Integer points, Integer penalties) {
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
        this.gender = String.valueOf(gender2);
        this.profession = profession;
        this.education = education;
        this.loyalty = String.valueOf(loyaltyProgram);
        this.points = points;
        this.penalties = penalties;
    }

    


}
