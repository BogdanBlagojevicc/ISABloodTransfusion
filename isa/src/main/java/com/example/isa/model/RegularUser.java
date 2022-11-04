package com.example.isa.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

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

    @OneToMany(mappedBy = "regular_user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Term> terms;

    public RegularUser(){

    }

    public RegularUser(LoyaltyProgram loyalty, Integer points, Integer penalties) {
        this.loyalty = loyalty;
        this.points = points;
        this.penalties = penalties;
    }
}
