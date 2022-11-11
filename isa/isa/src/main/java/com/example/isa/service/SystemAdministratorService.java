package com.example.isa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.isa.model.SystemAdministrator;
import com.example.isa.repository.SystemAdministratorRepository;

@Service
public class SystemAdministratorService {
    
    private final SystemAdministratorRepository systemAdministratorRepository;

    @Autowired
    public SystemAdministratorService(SystemAdministratorRepository systemAdministratorRepository){
        this.systemAdministratorRepository = systemAdministratorRepository;
    }

    public SystemAdministrator findOne(Long id){
        return this.systemAdministratorRepository.findBySystemAdministratorId(id);
    }

    public SystemAdministrator create(SystemAdministrator systemAdministrator) throws Exception{
        if(systemAdministrator.getId() != null){
            throw new Exception("ID must be null");
        }
        return this.systemAdministratorRepository.save(systemAdministrator);
    }
}
