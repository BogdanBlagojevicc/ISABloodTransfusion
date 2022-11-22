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
    // public SystemAdministrator findOne(Long id){
    //     return this.systemAdministratorRepository.getOne(id);
    // }

    public SystemAdministrator create(SystemAdministrator systemAdministrator) throws Exception{
        if(systemAdministrator.getBaseUser().getId() != null){
            throw new Exception("ID must be null");
        }
        return this.systemAdministratorRepository.save(systemAdministrator);
    }

    // public SystemAdministrator updatePassword(SystemAdministrator systemAdministrator) throws Exception{
        
    //     SystemAdministrator systemAdministratorToUpade = this.systemAdministratorRepository.getOne(systemAdministrator.getId());
    //     if(systemAdministratorToUpade == null){
    //         throw new Exception("System administrator doesn't exist");
    //     }

    //     if(!systemAdministrator.getPassword().equals("")){
    //         systemAdministratorToUpade.setPassword(systemAdministrator.getPassword());
    //     }

    //     return this.systemAdministratorRepository.save(systemAdministratorToUpade);
    // }
}
