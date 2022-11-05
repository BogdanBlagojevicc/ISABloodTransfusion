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

    @OneToOne
    private Center centerComplaint;

    @OneToOne
    private User userComplaint;


    @ManyToOne(fetch = FetchType.LAZY)
    private RegularUser regularUser;

    public Complaint(){

    }

    public Complaint(Long id, String text, String response) {
        this.id = id;
        this.text = text;
        this.response = response;
    }
}

