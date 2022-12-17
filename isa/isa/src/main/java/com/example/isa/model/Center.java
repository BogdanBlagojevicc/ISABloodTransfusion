package com.example.isa.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "centers")
public class Center implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String address;

    @Column
    private String description;

    @Column
    private Double averageGrade;

    @Column
    private String country;

    @Column
    // @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private LocalTime startTime;

    @Column
    // @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private LocalTime endTime;

    @OneToOne(mappedBy = "centerWH", fetch = FetchType.LAZY)
    private Warehouse wareHouse;

    @OneToOne(mappedBy = "centerGR", fetch = FetchType.LAZY)
    private Grade grade;

    @OneToOne(mappedBy = "centerCO", fetch = FetchType.LAZY)
    private Complaint complaint;

    @OneToMany(mappedBy = "centerCAS", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CenterAdministrator> administrators;

    // slobodni termini za rezervaciju
    @OneToMany(mappedBy = "centerTerm", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Term> terms;

    public Center() {

    }

    public Center(String name, String address, String description, Double averageGrade, String country,
            LocalTime startTime,
            LocalTime endTime) {
        this.name = name;
        this.address = address;
        this.description = description;
        this.averageGrade = averageGrade;
        this.country = country;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Center(Long id, String name, String address, String description, Double averageGrade, String country,
            LocalTime startTime, LocalTime endTime, List<CenterAdministrator> administrators, List<Term> terms) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.description = description;
        this.averageGrade = averageGrade;
        this.country = country;
        this.startTime = startTime;
        this.endTime = endTime;
        this.administrators = administrators;
        this.terms = terms;
    }

}
