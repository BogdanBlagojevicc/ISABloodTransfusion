package com.example.isa.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Getter
@Setter
@Table(name = "terms")
public class Term implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column
    private Date dateTerm;

    @Column
    private Integer duration;

    @ManyToOne(fetch = FetchType.LAZY)
    private Center centerTerm;

    @ManyToOne(fetch = FetchType.LAZY)
    private RegularUser regular_user;

    @OneToOne(mappedBy = "term")
    private CenterAdministrator centerAdministrator;

    public Term() {

    }

    public Term(Long id, Date dateTerm, Integer duration) {
        Id = id;
        this.dateTerm = dateTerm;
        this.duration = duration;
    }

}

