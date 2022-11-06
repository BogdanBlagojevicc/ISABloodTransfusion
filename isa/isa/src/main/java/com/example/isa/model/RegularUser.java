package com.example.isa.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;



@Entity
@Getter
@Setter
@Table(name="regularusers")
public class RegularUser extends User {
    
    @Column
    @Enumerated(EnumType.STRING)
    private LoyaltyProgram loyalty;

    @Column
    private Integer points;

    @Column
    private Integer penalties;

    @OneToMany(mappedBy = "regular_user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Term> terms;

     
   @OneToMany(mappedBy = "regularUser", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Complaint> complaints;

    public RegularUser(){

    }



    public RegularUser(String email, String password, String firstName, String lastName, String address, String city,
            String country, String phoneNumber, String jmbg, Gender gender, String profession, String education,
            LoyaltyProgram loyalty, Integer points, Integer penalties) {
        super(email, password, firstName, lastName, address, city, country, phoneNumber, jmbg, gender, profession,
                education);
        this.loyalty = loyalty;
        this.points = points;
        this.penalties = penalties;
    }

   

    
}

