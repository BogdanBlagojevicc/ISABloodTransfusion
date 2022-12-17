package com.example.isa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.isa.model.Questionnaire;

public interface QuestionnaireRepository extends JpaRepository<Questionnaire, Long> {
    
}
