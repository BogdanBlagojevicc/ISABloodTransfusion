package com.example.isa.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
@Getter
@Setter
public class CenterAdministrator extends User implements Serializable {
    public CenterAdministrator(){

    }
}
