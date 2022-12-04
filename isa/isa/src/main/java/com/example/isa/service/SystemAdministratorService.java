package com.example.isa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.isa.model.SystemAdministrator;
import com.example.isa.model.User;
import com.example.isa.model.dto.SystemAdministratorDTO;
import com.example.isa.repository.SystemAdministratorRepository;
import com.example.isa.repository.UserRepository;

@Service
public class SystemAdministratorService {
    
    private final SystemAdministratorRepository systemAdministratorRepository;
    private final UserRepository userRepository;

    @Autowired
    public SystemAdministratorService(SystemAdministratorRepository systemAdministratorRepository, UserRepository userRepository){
        this.systemAdministratorRepository = systemAdministratorRepository;
        this.userRepository = userRepository;
    }
    public SystemAdministrator findOne(Long id){
        return this.systemAdministratorRepository.getOne(id);
    }

    public SystemAdministrator create(SystemAdministrator systemAdministrator) throws Exception{
        if(systemAdministrator.getBaseUserSA().getId() != null){
            throw new Exception("ID must be null");
        }
        return this.systemAdministratorRepository.save(systemAdministrator);
    }

    public SystemAdministrator updatePassword(SystemAdministratorDTO systemAdministratorDTO) throws Exception{
        
        SystemAdministrator systemAdministratorToUpdate = this.systemAdministratorRepository.findByBaseUserSAId(systemAdministratorDTO.getId());
        if(systemAdministratorToUpdate == null){
            throw new Exception("System administrator doesn't exist");
        }

        if(!systemAdministratorDTO.getPassword().equals("")){
            systemAdministratorToUpdate.getBaseUserSA().setPassword(systemAdministratorDTO.getPassword());
        }

        User userToUpdate = this.userRepository.getOne(systemAdministratorDTO.getId());
        userToUpdate.setPassword(systemAdministratorDTO.getPassword());

        User updatedUser = this.userRepository.save(userToUpdate);

        systemAdministratorToUpdate.setBaseUserSA(updatedUser);

        //mozda ne treba
        //this.systemAdministratorRepository.save(systemAdministratorToUpdate);

        return systemAdministratorToUpdate;
    }

}
