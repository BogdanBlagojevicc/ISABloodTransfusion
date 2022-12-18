package com.example.isa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.isa.model.Questionnaire;

public interface QuestionnaireRepository extends JpaRepository<Questionnaire, Long> {

    @Query("select q from Questionnaire q join RegularUser r on q.regularUser.id = r.id where r.id=?1")
    Questionnaire findByUserId(Long id);

}
