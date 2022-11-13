package com.example.isa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.isa.model.Center;
import org.springframework.stereotype.Repository;

@Repository
public interface CenterRepository extends JpaRepository<Center, Long> {

    List<Center> findByOrderByAverageGradeAsc();

    List<Center> findByOrderByAverageGradeDesc();

    List<Center> findByOrderByNameAsc();

    @Query("select c from Center c where c.averageGrade>=?1 and c.averageGrade<=?2")
    List<Center> filterByGrade(Double firstnumber, Double  secondnumber);

    List<Center> findByOrderByNameDesc();

    List<Center> findByOrderByCountryAsc();

    List<Center> findByOrderByCountryDesc();

    Center findByName(String name);

    Center findByAddress(String address);

    List<Center> findAll();

    Center findByAverageGrade(Double averageGrade);
   

}
