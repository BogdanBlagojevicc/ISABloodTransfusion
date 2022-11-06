package com.example.isa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.isa.model.Center;

public interface CenterRepository extends JpaRepository<Center, Long> {
    
}
