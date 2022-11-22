package com.example.isa.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import java.util.List;

enum Gender {MALE, FEMALE}

@Entity 
@Getter
@Setter
@Table(name="systemadministrators")
public class SystemAdministrator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "userId")
    private User baseUser;

    @OneToMany(mappedBy = "systemAdministrator", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Complaint> complaints;
    
    public SystemAdministrator(){

    }

    public SystemAdministrator(User baseUser){
        this.baseUser = baseUser;
    }

} 