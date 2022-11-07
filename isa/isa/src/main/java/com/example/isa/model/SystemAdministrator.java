package com.example.isa.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;

@Entity
@Getter
@Setter
@Table(name="systemadministrators")
public class SystemAdministrator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private User userField;

    @OneToOne(mappedBy = "systemAdministrator")
    private User user;
    
    public SystemAdministrator(){

    }

    public SystemAdministrator(Long id, User userField) {
        this.id = id;
        this.userField = userField;
    }

} 