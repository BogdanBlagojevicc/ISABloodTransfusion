package com.example.isa.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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

    private User userField;

    @OneToOne(mappedBy = "centerAdministrator")
    private Complaint complaint;

    @OneToOne
    private Term term;

    @OneToOne(mappedBy = "centerAdministrator")
    private User user;

    @ManyToOne(fetch= FetchType.LAZY)
    private Center center;

    public CenterAdministrator(){

    }
    
    public CenterAdministrator(Long id, User userField){
        this.id = id;
        this.userField = userField;
    }
}

