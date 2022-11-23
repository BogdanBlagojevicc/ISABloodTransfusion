package com.example.isa.repository;

import com.example.isa.model.CenterAdministrator;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CenterAdministratorRepository extends JpaRepository<CenterAdministrator, Long> {

    List<CenterAdministrator> findAllByCenterId(Long centerId);

    CenterAdministrator findByBaseUserId(Long id);

    List<Long> findAllUserIdByCenterId(Long id);

    //@Query("select c from CenterAdministrator c where c.center =?1")
    @Query(value = "SELECT * FROM centeradministrators u WHERE u.center_id = ?1", nativeQuery = true)
    List<CenterAdministrator> findAllCenterAdministrators(Long id);
    
}
