package com.example.isa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.isa.model.SystemAdministrator;

public interface SystemAdministratorRepository extends JpaRepository<SystemAdministrator, Long>{
    
    SystemAdministrator findBySystemAdministratorId(Long id);
}
