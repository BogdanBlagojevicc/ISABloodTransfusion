package com.example.isa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.isa.model.CenterAdministrator;
import com.example.isa.model.User;
import com.example.isa.model.dto.CenterAdministratorDTO;
import com.example.isa.model.dto.Gender;
import com.example.isa.repository.CenterAdministratorRepository;
import com.example.isa.repository.UserRepository;

@Service
public class CenterAdministratorService {

    private final CenterAdministratorRepository centerAdministratorRepository;
    private final UserRepository userRepository;

    @Autowired
    public CenterAdministratorService(CenterAdministratorRepository centerAdministratorRepository, UserRepository userRepository){
        this.centerAdministratorRepository = centerAdministratorRepository;
        this.userRepository = userRepository;
    }

    public CenterAdministrator findOne(Long id) throws Exception{
        CenterAdministrator centerAdministrator = this.centerAdministratorRepository.findByBaseUserId(id);
        if (centerAdministrator == null){
            throw new Exception("User does not exist");
        }
        return centerAdministrator;
    }

    public CenterAdministrator update(CenterAdministratorDTO centerAdministratorDTO) throws Exception{

        CenterAdministrator centerAdministratorToUpdate = this.centerAdministratorRepository.findByBaseUserId(centerAdministratorDTO.getId());
        if(centerAdministratorToUpdate == null){
            throw new Exception("Center Administrator doesn't exist");
        }

        if(!centerAdministratorDTO.getEmail().equals("")){
            centerAdministratorToUpdate.getBaseUser().setEmail(centerAdministratorDTO.getEmail());
        }

        if(!centerAdministratorDTO.getFirstName().equals("")){
            centerAdministratorToUpdate.getBaseUser().setFirstName(centerAdministratorDTO.getFirstName());
        }

        if(!centerAdministratorDTO.getLastName().equals("")){
            centerAdministratorToUpdate.getBaseUser().setLastName(centerAdministratorDTO.getLastName());
        }

        if(!centerAdministratorDTO.getAddress().equals("")){
            centerAdministratorToUpdate.getBaseUser().setAddress(centerAdministratorDTO.getAddress());
        }

        if(!centerAdministratorDTO.getCity().equals("")){
            centerAdministratorToUpdate.getBaseUser().setCity(centerAdministratorDTO.getCity());
        }

        if(!centerAdministratorDTO.getCountry().equals("")){
            centerAdministratorToUpdate.getBaseUser().setCountry(centerAdministratorDTO.getCountry());
        }

        if(!centerAdministratorDTO.getPhoneNumber().equals("")){
            centerAdministratorToUpdate.getBaseUser().setPhoneNumber(centerAdministratorDTO.getPhoneNumber());
        }

        if(!centerAdministratorDTO.getProfession().equals("")){
            centerAdministratorToUpdate.getBaseUser().setProfession(centerAdministratorDTO.getProfession());
        }

        if(!centerAdministratorDTO.getEducation().equals("")){
            centerAdministratorToUpdate.getBaseUser().setEducation(centerAdministratorDTO.getEducation());
        }

        User updatedUser = new User(
            centerAdministratorDTO.getId(),
            centerAdministratorDTO.getEmail(),
            centerAdministratorDTO.getPassword(),
            centerAdministratorDTO.getFirstName(),
            centerAdministratorDTO.getLastName(),
            centerAdministratorDTO.getAddress(),
            centerAdministratorDTO.getCity(),
            centerAdministratorDTO.getCountry(),
            centerAdministratorDTO.getPhoneNumber(),
            centerAdministratorDTO.getJmbg(),
            Gender.valueOf(centerAdministratorDTO.getGender()),
            centerAdministratorDTO.getProfession(),
            centerAdministratorDTO.getEducation()
        );

        User savedUser = this.userRepository.save(updatedUser);

        centerAdministratorToUpdate.setBaseUser(savedUser);

        return centerAdministratorToUpdate;        
    }

    public CenterAdministrator updatePassword(CenterAdministratorDTO centerAdministratorDTO) throws Exception{

        CenterAdministrator centerAdministratorToUpdate = this.centerAdministratorRepository.findByBaseUserId(centerAdministratorDTO.getId());
        if(centerAdministratorToUpdate == null){
            throw new Exception("Center Administrator doesn't exist");
        }

        if(!centerAdministratorDTO.getPassword().equals("")){
            centerAdministratorToUpdate.getBaseUser().setPassword(centerAdministratorDTO.getPassword());
        }

        User userToUpdate = this.userRepository.getOne(centerAdministratorDTO.getId());
        userToUpdate.setPassword(centerAdministratorDTO.getPassword());

        User updatedUser = this.userRepository.save(userToUpdate);

        centerAdministratorToUpdate.setBaseUser(updatedUser);

        //mozda ne treba
        //this.centerAdministratorRepository.save(centerAdministratorToUpdate);

        
        return centerAdministratorToUpdate;
    }

    public CenterAdministrator create(CenterAdministrator centerAdministrator) throws Exception{
        if(centerAdministrator.getBaseUser().getId() != null){
            throw new Exception("ID must be null");
        }
        return this.centerAdministratorRepository.save(centerAdministrator);
    }

    public List<CenterAdministrator> findAllByCenterId(Long centerId){
        return this.centerAdministratorRepository.findAllCenterAdministrators(centerId);
    }
}
