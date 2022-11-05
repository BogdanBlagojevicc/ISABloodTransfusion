package com.example.isa.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name="systemadministrators")
public class SystemAdministrator extends User  {
    
    public SystemAdministrator(){

    }
} 