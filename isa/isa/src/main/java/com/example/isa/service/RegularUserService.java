package com.example.isa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.isa.model.RegularUser;
import com.example.isa.repository.RegularUserRepository;


@Service
public class RegularUserService {

    private final RegularUserRepository regularUserRepository;

    @Autowired
    public RegularUserService(RegularUserRepository regularUserRepository){
        this.regularUserRepository = regularUserRepository;
    }

    
    public RegularUser create(RegularUser regularUser) throws Exception{
        if(regularUser.getId() != null){
            throw new Exception("ID must be null");
        }
        RegularUser newRegularUser = this.regularUserRepository.save(regularUser);
        return newRegularUser;
    }
    

    public RegularUser findOne(Long id){
        RegularUser regularUser = this.regularUserRepository.findRegularUserById(id);
        return regularUser;
    }

    public RegularUser update(RegularUser regularUser) throws Exception{
        if(regularUser.getId() == null){
            throw new Exception("ID can not be null");
        }
        return this.regularUserRepository.save(regularUser);
    }
    
    public List<RegularUser> findAll(){
        return regularUserRepository.findAll();
    }

}