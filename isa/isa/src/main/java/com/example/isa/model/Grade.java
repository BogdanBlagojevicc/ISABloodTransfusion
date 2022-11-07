package com.example.isa.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "grades")
public class Grade implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer grade;

    @OneToOne
    private RegularUser regularUser;

    @OneToOne
    private Center center;

    public Grade() {
    }

    public Grade(Long id, Integer grade) {
        this.id = id;
        this.grade = grade;
    }
}

