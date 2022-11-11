package com.example.isa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.isa.model.CenterAdministrator;
import com.example.isa.repository.CenterAdministratorRepository;

@Service
public class CenterAdministratorService {

    private final CenterAdministratorRepository centerAdministratorRepository;

    @Autowired
    public CenterAdministratorService(CenterAdministratorRepository centerAdministratorRepository){
        this.centerAdministratorRepository = centerAdministratorRepository;
    }

    public CenterAdministrator findOne(Long id){
        CenterAdministrator centerAdministrator = this.centerAdministratorRepository.findByCenterAdministratorId(id);
        return centerAdministrator;
    }

    public CenterAdministrator create(CenterAdministrator centerAdministrator) throws Exception{
        if(centerAdministrator.getId() != null){
            throw new Exception("ID must be null");
        }
        return this.centerAdministratorRepository.save(centerAdministrator);
    }
    
}
