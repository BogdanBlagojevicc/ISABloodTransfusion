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
    private User baseUser;

    @OneToOne(mappedBy = "centerAdministrator")
    private Complaint complaint;

    @OneToOne
    private Term term;

    @ManyToOne(fetch= FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "center_id")
    private Center center;

    public CenterAdministrator(){

    }

    public CenterAdministrator(User baseUser){
        this.baseUser = baseUser;
    }


    
}

