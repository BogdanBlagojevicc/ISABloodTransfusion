package com.example.isa.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;

enum LoyaltyProgram{REGULAR, SILVER, GOLD}

@Entity
@Getter
@Setter
public class RegularUser extends User implements Serializable{
    @Column
    private LoyaltyProgram loyalty;

    @Column
    private Integer points;

    @Column
    private Integer penalties;

    public RegularUser(){

    }

    public RegularUser(LoyaltyProgram loyalty, Integer points, Integer penalties) {
        this.loyalty = loyalty;
        this.points = points;
        this.penalties = penalties;
    }
}
