package com.example.isa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.isa.model.SystemAdministrator;

@Repository
public interface SystemAdministratorRepository extends JpaRepository<SystemAdministrator, Long> {
    SystemAdministrator findByBaseUserId(Long id);
}
