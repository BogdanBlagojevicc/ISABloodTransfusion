package com.example.isa.model;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "centeradministrators")
public class CenterAdministrator extends User  {

    @ManyToOne(fetch= FetchType.LAZY)
    private Center center;


    public CenterAdministrator(){

    }
}

