package com.example.isa.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.isa.model.Term;

import java.util.List;

public interface TermRepository extends JpaRepository<Term,Long> {
    
    @Query("select t from Term t join Center c on t.centerTerm.id = c.id where c.id=?1 order by t.dateTerm asc")
    List<Term> findByCenterIdOrderByDateTerm(Long id);
   
    List<Term> findAll();

    List<Term> findAllByRegularUserId(Long id);

    List<Term> findByRegularUserIdOrderByDateTermAsc(Long id);

    List<Term> findByRegularUserIdOrderByDateTermDesc(Long id);
}
