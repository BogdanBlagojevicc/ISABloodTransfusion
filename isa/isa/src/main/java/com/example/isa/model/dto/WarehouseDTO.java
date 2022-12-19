package com.example.isa.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WarehouseDTO {

    private Integer bloodQuantityA;

    private Integer bloodQuantityB;

    private Integer bloodQuantityAB;

    private Integer bloodQuantity0; 

    private Integer needles;

    private Integer testTubes;

    private Integer bandage;

    public WarehouseDTO() {
    }

    public WarehouseDTO(Integer bloodQuantityA, Integer bloodQuantityB, Integer bloodQuantityAB, Integer bloodQuantity0,
            Integer needles, Integer testTubes, Integer bandage) {
        this.bloodQuantityA = bloodQuantityA;
        this.bloodQuantityB = bloodQuantityB;
        this.bloodQuantityAB = bloodQuantityAB;
        this.bloodQuantity0 = bloodQuantity0;
        this.needles = needles;
        this.testTubes = testTubes;
        this.bandage = bandage;
    }

    
    
}
