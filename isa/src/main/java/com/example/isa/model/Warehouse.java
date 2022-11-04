package com.example.isa.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter

public class Warehouse implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @OneToOne
    private Center center;

    @Column
    private Integer bloodQuantityA;

    @Column
    private Integer bloodQuantityB;

    @Column
    private Integer bloodQuantityAB;

    @Column
    private Integer bloodQuantity0;

    @Column
    private Integer needles;

    @Column
    private Integer testTubes;

    @Column
    private Integer bandage;

    public Warehouse() {
    }

    public Warehouse(Long id, Center center, Integer bloodQuantityA, Integer bloodQuantityB, Integer bloodQuantityAB, Integer bloodQuantity0, Integer needles, Integer testTubes, Integer bandage) {
        Id = id;
        this.center = center;
        this.bloodQuantityA = bloodQuantityA;
        this.bloodQuantityB = bloodQuantityB;
        this.bloodQuantityAB = bloodQuantityAB;
        this.bloodQuantity0 = bloodQuantity0;
        this.needles = needles;
        this.testTubes = testTubes;
        this.bandage = bandage;
    }
}

