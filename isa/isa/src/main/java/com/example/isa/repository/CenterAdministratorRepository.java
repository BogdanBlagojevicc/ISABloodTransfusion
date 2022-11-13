package com.example.isa.repository;

import com.example.isa.model.CenterAdministrator;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CenterAdministratorRepository extends JpaRepository<CenterAdministrator, Long> {

    List<CenterAdministrator> findAllByCenterId(Long centerId);
    
}
