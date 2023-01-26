package com.example.isa.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.isa.model.Term;

import java.util.List;
import java.util.Optional;

import javax.persistence.LockModeType;

public interface TermRepository extends CrudRepository<Term,Long> {
    
    @Query("select t from Term t join Center c on t.centerTerm.id = c.id where c.id=?1 order by t.dateTerm asc")
    List<Term> findByCenterIdOrderByDateTerm(Long id);
   
    @Lock(LockModeType.OPTIMISTIC_FORCE_INCREMENT)
    List<Term> findAll();

    List<Term> findAllByRegularUserId(Long id);

    List<Term> findByRegularUserIdOrderByDateTermAsc(Long id);

    List<Term> findByRegularUserIdOrderByDateTermDesc(Long id);

    List<Long> findAllRegularUserIdByCenterTermId(Long id);

   /*  @Lock(LockModeType.OPTIMISTIC_FORCE_INCREMENT)
    Optional<Term> findWithLockingById(Long id);*/

    /*@Lock(LockModeType.OPTIMISTIC_FORCE_INCREMENT)
    Optional<List<Term>> findAllWithLocking();*/

    //@Lock(LockModeType.PESSIMISTIC_WRITE)
    //Optional<Term> findWithLockingById(Long id);

}
