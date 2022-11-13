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

    public CenterAdministrator findOne(Long id){
        CenterAdministrator centerAdministrator = this.centerAdministratorRepository.getOne(id);
        return centerAdministrator;
    }

    public CenterAdministrator update(CenterAdministrator centerAdministrator) throws Exception{

        CenterAdministrator centerAdministratorToUpdate = this.centerAdministratorRepository.getOne(centerAdministrator.getId());
        if(centerAdministratorToUpdate == null){
            throw new Exception("Center Administrator doesn't exist");
        }

        if(!centerAdministrator.getEmail().equals("")){
            centerAdministratorToUpdate.setEmail(centerAdministrator.getEmail());
        }

        if(!centerAdministrator.getFirstName().equals("")){
            centerAdministratorToUpdate.setFirstName(centerAdministrator.getFirstName());
        }

        if(!centerAdministrator.getLastName().equals("")){
            centerAdministratorToUpdate.setLastName(centerAdministrator.getLastName());
        }

        if(!centerAdministrator.getAddress().equals("")){
            centerAdministratorToUpdate.setAddress(centerAdministrator.getAddress());
        }

        if(!centerAdministrator.getCity().equals("")){
            centerAdministratorToUpdate.setCity(centerAdministrator.getCity());
        }

        if(!centerAdministrator.getCountry().equals("")){
            centerAdministratorToUpdate.setCountry(centerAdministrator.getCountry());
        }

        if(!centerAdministrator.getPhoneNumber().equals("")){
            centerAdministratorToUpdate.setPhoneNumber(centerAdministrator.getPhoneNumber());
        }

        if(!centerAdministrator.getProfession().equals("")){
            centerAdministratorToUpdate.setProfession(centerAdministrator.getProfession());
        }

        if(!centerAdministrator.getEducation().equals("")){
            centerAdministratorToUpdate.setEducation(centerAdministrator.getEducation());
        }

        CenterAdministrator savedCenterAdministrator = this.centerAdministratorRepository.save(centerAdministratorToUpdate);
        return savedCenterAdministrator;
    }

    public CenterAdministrator updatePassword(CenterAdministrator centerAdministrator) throws Exception{

        CenterAdministrator centerAdministratorToUpdate = this.centerAdministratorRepository.getOne(centerAdministrator.getId());
        if(centerAdministratorToUpdate == null){
            throw new Exception("Center Administrator doesn't exist");
        }

        if(!centerAdministrator.getPassword().equals("")){
            centerAdministratorToUpdate.setPassword(centerAdministrator.getPassword());
        }

        CenterAdministrator savedCenterAdministrator = this.centerAdministratorRepository.save(centerAdministratorToUpdate);
        return savedCenterAdministrator;
    }

    public CenterAdministrator create(CenterAdministrator centerAdministrator) throws Exception{
        if(centerAdministrator.getId() != null){
            throw new Exception("ID must be null");
        }
        return this.centerAdministratorRepository.save(centerAdministrator);
    }

    public List<CenterAdministrator> findAllByCenterId(Long centerId){
        return this.centerAdministratorRepository.findAllByCenterId(centerId);
    }
}
