package com.example.isa.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.isa.model.Term;

public interface TermRepository extends JpaRepository<Term,Long> {
    
}
