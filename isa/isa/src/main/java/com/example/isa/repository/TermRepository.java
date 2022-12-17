package com.example.isa.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.isa.model.Term;

import java.util.List;

public interface TermRepository extends JpaRepository<Term,Long> {
    
    List<Term> findByOrderByDateTerm();
    
    List<Term> findAll();
}
