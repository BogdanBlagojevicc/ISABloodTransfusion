package com.example.isa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.isa.model.Center;
import com.example.isa.repository.CenterRepository;

@Service
public class CenterService {
    
    private final CenterRepository centerRepository;

    @Autowired
    public CenterService(CenterRepository centerRepository){
        this.centerRepository = centerRepository;
    }

    public List<Center> findAll(){
        return this.centerRepository.findAll();
    }

    public List<Center> findByOrderByNameAsc(){
        return this.centerRepository.findByOrderByNameAsc();
    }

    public List<Center> findByOrderByNameDesc(){
        return this.centerRepository.findByOrderByNameDesc();
    }

    public List<Center> findByOrderByCountryAsc(){
        return this.centerRepository.findByOrderByCountryAsc();
    }

    public List<Center> findByOrderByCountryDesc(){ 
        return this.centerRepository.findByOrderByCountryDesc();
    }

    public List<Center> findByOrderByAverageGradeAsc(){
        return this.centerRepository.findByOrderByAverageGradeAsc();
    }

    public List<Center> findByOrderByAverageGradeDesc(){
        return this.centerRepository.findByOrderByAverageGradeDesc();
    }

}
