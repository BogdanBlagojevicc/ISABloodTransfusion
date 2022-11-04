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
    private LocalTime start;

    @Column
    private LocalTime end;

    @OneToMany(mappedBy = "center", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<CenterAdministrator> administrators;

    @OneToMany(mappedBy = "centerTerm", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Term> terms;

    public Center(){

    }

    public Center(Long id, String name, String address, String description, Double averageGrade, String country, LocalTime start, LocalTime end, List<CenterAdministrator> administrators, List<Term> terms) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.description = description;
        this.averageGrade = averageGrade;
        this.country = country;
        this.start = start;
        this.end = end;
        this.administrators = administrators;
        this.terms = terms;
    }
}
