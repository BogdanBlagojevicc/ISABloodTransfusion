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

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @OneToOne
    private Center centerComplaint;

    @OneToOne
    private User userComplaint;

    public Complaint(){

    }

    public Complaint(Long id, String text) {
        this.id = id;
        this.text = text;
    }
}

