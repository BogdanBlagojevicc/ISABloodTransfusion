package com.example.isa.service;

import java.util.List;

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

    // public CenterAdministrator findOne(Long id){
    //     CenterAdministrator centerAdministrator = this.centerAdministratorRepository.getOne(id);
    //     return centerAdministrator;
    // }

    // public CenterAdministrator update(CenterAdministrator centerAdministrator) throws Exception{

    //     CenterAdministrator centerAdministratorToUpdate = this.centerAdministratorRepository.getOne(centerAdministrator.getId());
    //     if(centerAdministratorToUpdate == null){
    //         throw new Exception("Center Administrator doesn't exist");
    //     }

    //     if(!centerAdministrator.getBaseUser().getEmail().equals("")){
    //         centerAdministratorToUpdate.getBaseUser().setEmail(centerAdministrator.getBaseUser().getEmail());
    //     }

    //     if(!centerAdministrator.getBaseUser().getFirstName().equals("")){
    //         centerAdministratorToUpdate.getBaseUser().setFirstName(centerAdministrator.getBaseUser().getFirstName());
    //     }

    //     if(!centerAdministrator.getBaseUser().getLastName().equals("")){
    //         centerAdministratorToUpdate.getBaseUser().setLastName(centerAdministrator.getBaseUser().getLastName());
    //     }

    //     if(!centerAdministrator.getBaseUser().getAddress().equals("")){
    //         centerAdministratorToUpdate.getBaseUser().setAddress(centerAdministrator.getBaseUser().getAddress());
    //     }

    //     if(!centerAdministrator.getBaseUser().getCity().equals("")){
    //         centerAdministratorToUpdate.getBaseUser().setCity(centerAdministrator.getBaseUser().getCity());
    //     }

    //     if(!centerAdministrator.getBaseUser().getCountry().equals("")){
    //         centerAdministratorToUpdate.getBaseUser().setCountry(centerAdministrator.getBaseUser().getCountry());
    //     }

    //     if(!centerAdministrator.getBaseUser().getPhoneNumber().equals("")){
    //         centerAdministratorToUpdate.getBaseUser().setPhoneNumber(centerAdministrator.getBaseUser().getPhoneNumber());
    //     }

    //     if(!centerAdministrator.getBaseUser().getProfession().equals("")){
    //         centerAdministratorToUpdate.getBaseUser().setProfession(centerAdministrator.getBaseUser().getProfession());
    //     }

    //     if(!centerAdministrator.getBaseUser().getEducation().equals("")){
    //         centerAdministratorToUpdate.getBaseUser().setEducation(centerAdministrator.getBaseUser().getEducation());
    //     }

    //     CenterAdministrator savedCenterAdministrator = this.centerAdministratorRepository.save(centerAdministratorToUpdate);
    //     return savedCenterAdministrator;
    // }

    // public CenterAdministrator updatePassword(CenterAdministrator centerAdministrator) throws Exception{

    //     CenterAdministrator centerAdministratorToUpdate = this.centerAdministratorRepository.getOne(centerAdministrator.getId());
    //     if(centerAdministratorToUpdate == null){
    //         throw new Exception("Center Administrator doesn't exist");
    //     }

    //     if(!centerAdministrator.getPassword().equals("")){
    //         centerAdministratorToUpdate.setPassword(centerAdministrator.getPassword());
    //     }

    //     CenterAdministrator savedCenterAdministrator = this.centerAdministratorRepository.save(centerAdministratorToUpdate);
    //     return savedCenterAdministrator;
    // }

    public CenterAdministrator create(CenterAdministrator centerAdministrator) throws Exception{
        if(centerAdministrator.getBaseUser().getId() != null){
            throw new Exception("ID must be null");
        }
        return this.centerAdministratorRepository.save(centerAdministrator);
    }

    // public List<CenterAdministrator> findAllByCenterId(Long centerId){
    //     return this.centerAdministratorRepository.findAllByCenterId(centerId);
    // }
}
