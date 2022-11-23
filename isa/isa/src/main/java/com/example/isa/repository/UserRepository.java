package com.example.isa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.isa.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
}