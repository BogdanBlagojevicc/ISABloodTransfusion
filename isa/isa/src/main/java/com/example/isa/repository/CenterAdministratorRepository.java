package com.example.isa.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.isa.model.CenterAdministrator;

@Repository
public interface CenterAdministratorRepository extends JpaRepository<CenterAdministrator, Long>{
    
}
