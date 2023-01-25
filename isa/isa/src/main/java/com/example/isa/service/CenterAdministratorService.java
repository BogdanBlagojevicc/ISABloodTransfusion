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
        CenterAdministrator centerAdministrator = this.centerAdministratorRepository.findByBaseUserCAId(id);
        if (centerAdministrator == null){
            throw new Exception("User does not exist");
        }
        return centerAdministrator;
    }

    // public CenterAdministrator getOne(Long id) throws Exception{
    //     CenterAdministrator centerAdministrator = this.centerAdministratorRepository.findById(id);

    //     if(centerAdministrator == null){
    //         throw new Exception("Invalid id");
    //     }

    //     return centerAdministrator;
    // }

    public List<CenterAdministrator> findAll() throws Exception{
        return this.centerAdministratorRepository.findAll();
    }

    public CenterAdministrator update(CenterAdministratorDTO centerAdministratorDTO) throws Exception{

        CenterAdministrator centerAdministratorToUpdate = this.centerAdministratorRepository.findByBaseUserCAId(centerAdministratorDTO.getId());
        if(centerAdministratorToUpdate == null){
            throw new Exception("Center Administrator doesn't exist");
        }

        if(!centerAdministratorDTO.getUsername().equals("")){
            centerAdministratorToUpdate.getBaseUserCA().setUsername(centerAdministratorDTO.getUsername());
        }

        if(!centerAdministratorDTO.getFirstName().equals("")){
            centerAdministratorToUpdate.getBaseUserCA().setFirstName(centerAdministratorDTO.getFirstName());
        }

        if(!centerAdministratorDTO.getLastName().equals("")){
            centerAdministratorToUpdate.getBaseUserCA().setLastName(centerAdministratorDTO.getLastName());
        }

        if(!centerAdministratorDTO.getAddress().equals("")){
            centerAdministratorToUpdate.getBaseUserCA().setAddress(centerAdministratorDTO.getAddress());
        }

        if(!centerAdministratorDTO.getCity().equals("")){
            centerAdministratorToUpdate.getBaseUserCA().setCity(centerAdministratorDTO.getCity());
        }

        if(!centerAdministratorDTO.getCountry().equals("")){
            centerAdministratorToUpdate.getBaseUserCA().setCountry(centerAdministratorDTO.getCountry());
        }

        if(!centerAdministratorDTO.getPhoneNumber().equals("")){
            centerAdministratorToUpdate.getBaseUserCA().setPhoneNumber(centerAdministratorDTO.getPhoneNumber());
        }

        if(!centerAdministratorDTO.getProfession().equals("")){
            centerAdministratorToUpdate.getBaseUserCA().setProfession(centerAdministratorDTO.getProfession());
        }

        if(!centerAdministratorDTO.getEducation().equals("")){
            centerAdministratorToUpdate.getBaseUserCA().setEducation(centerAdministratorDTO.getEducation());
        }

        User updatedUser = new User(
            centerAdministratorDTO.getId(),
            centerAdministratorDTO.getUsername(),
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

        centerAdministratorToUpdate.setBaseUserCA(savedUser);

        return centerAdministratorToUpdate;        
    }

    public CenterAdministrator updatePassword(CenterAdministratorDTO centerAdministratorDTO) throws Exception{

        CenterAdministrator centerAdministratorToUpdate = this.centerAdministratorRepository.findByBaseUserCAId(centerAdministratorDTO.getId());
        if(centerAdministratorToUpdate == null){
            throw new Exception("Center Administrator doesn't exist");
        }

        if(!centerAdministratorDTO.getPassword().equals("")){
            centerAdministratorToUpdate.getBaseUserCA().setPassword(centerAdministratorDTO.getPassword());
        }

        User userToUpdate = this.userRepository.getOne(centerAdministratorDTO.getId());
        userToUpdate.setPassword(centerAdministratorDTO.getPassword());

        User updatedUser = this.userRepository.save(userToUpdate);

        centerAdministratorToUpdate.setBaseUserCA(updatedUser);

        //mozda ne treba
        //this.centerAdministratorRepository.save(centerAdministratorToUpdate);

        
        return centerAdministratorToUpdate;
    }

    public CenterAdministrator create(CenterAdministrator centerAdministrator) throws Exception{
        if(centerAdministrator.getBaseUserCA().getId() != null){
            throw new Exception("ID must be null");
        }
        return this.centerAdministratorRepository.save(centerAdministrator);
    }

    public List<CenterAdministrator> findAllByCenterId(Long centerId){
        return this.centerAdministratorRepository.findAllByCenterCASId(centerId);
    }
}
