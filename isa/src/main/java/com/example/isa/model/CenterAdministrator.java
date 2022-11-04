package com.example.isa.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
@Getter
@Setter
public class CenterAdministrator extends User implements Serializable {

    @ManyToOne(fetch= FetchType.LAZY)
    private Center center;


    public CenterAdministrator(){

    }
}
