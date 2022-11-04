package com.example.isa.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter

public class Term implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column
    private Date date;

    @Column
    private Integer duration;

    @OneToMany(mappedBy = "term", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<User> users;

    @ManyToOne(fetch = FetchType.LAZY)
    private Center centerTerm;

    @ManyToOne(fetch = FetchType.LAZY)
    private RegularUser regular_user;

    @OneToOne
    private CenterAdministrator centerAdministrator;

    public Term() {

    }

    public Term(Long id, Date date, Integer duration) {
        Id = id;
        this.date = date;
        this.duration = duration;
    }

}
