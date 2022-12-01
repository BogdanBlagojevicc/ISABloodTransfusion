package com.example.isa.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "complaints")
public class Complaint implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String text;

    @Column
    private String response;

    @OneToOne(fetch = FetchType.LAZY)
    private Center centerCO; 

    @OneToOne(fetch = FetchType.LAZY)
    private CenterAdministrator centerAdministrator; 

    @ManyToOne(fetch = FetchType.LAZY)
    private RegularUser regularUser;

    @ManyToOne(fetch = FetchType.LAZY)
    private SystemAdministrator systemAdministrator;

    public Complaint(){

    }

    public Complaint(Long id, String text, String response) {
        this.id = id;
        this.text = text;
        this.response = response;
    }

    public Complaint(String text, String response){
        this.text = text;
        this.response = response;
    }
}

