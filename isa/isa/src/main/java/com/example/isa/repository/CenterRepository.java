package com.example.isa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.isa.model.Center;

public interface CenterRepository extends JpaRepository<Center, Long> {
    List<Center> findByOrderByAverageGradeAsc();

    List<Center> findByOrderByAverageGradeDesc();

    List<Center> findByOrderByNameAsc();

    List<Center> findByOrderByNameDesc();

    List<Center> findByOrderByCountryAsc();

    List<Center> findByOrderByCountryDesc();

    Center findByName(String name);

    Center findByAddress(String address);
   


}
