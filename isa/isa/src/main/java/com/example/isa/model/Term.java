package com.example.isa.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.OptimisticLockType;
import org.hibernate.annotations.OptimisticLocking;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "terms")
public class Term implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private LocalDateTime dateTerm;

    @Column
    private Integer duration;

    @Column
    private Integer price;

    @ManyToOne(fetch = FetchType.LAZY)
    private Center centerTerm;

    @Version
    @Column(name = "version", columnDefinition = "integer DEFAULT 0", nullable = false)
    private Long version;

    @ManyToOne(fetch = FetchType.LAZY)
    private RegularUser regularUser;

    @OneToOne(mappedBy = "term", fetch = FetchType.LAZY)
    private CenterAdministrator centerAdministrator;

    public Term() {

    }

    public Term(LocalDateTime date, Integer duration, Integer price) {
        this.dateTerm = date;
        this.duration = duration;
        this.price = price;
    }

    public Term(Long id, LocalDateTime dateTerm, Integer duration, Integer price) {
        this.id = id;
        this.dateTerm = dateTerm;
        this.duration = duration;
        this.price = price;
    }



}

