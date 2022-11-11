package com.example.isa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.isa.model.CenterAdministrator;

public interface CenterAdministratorRepository extends JpaRepository<CenterAdministrator, Long>{

    CenterAdministrator findByCenterAdministratorId(Long id); 
    
}
