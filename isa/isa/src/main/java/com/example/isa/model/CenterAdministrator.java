package com.example.isa.model;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Entity 
@Getter
@Setter
@Table(name = "centeradministrators")
public class CenterAdministrator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "userId")
    private User baseUserCA;

    @OneToOne(mappedBy = "centerAdministrator", fetch = FetchType.LAZY)
    private Complaint complaint;

    @OneToOne(fetch = FetchType.LAZY)
    private Term term;

    @ManyToOne(fetch= FetchType.LAZY, cascade = CascadeType.ALL)
    private Center centerCAS;

    public CenterAdministrator(){

    }

    public CenterAdministrator(User baseUserCA){
        this.baseUserCA = baseUserCA;
    }


    
}

