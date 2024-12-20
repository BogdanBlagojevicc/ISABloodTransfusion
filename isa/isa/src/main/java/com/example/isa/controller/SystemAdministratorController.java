package com.example.isa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.isa.model.SystemAdministrator;
import com.example.isa.model.User;
import com.example.isa.model.dto.Gender;
import com.example.isa.model.dto.SystemAdministratorDTO;
import com.example.isa.model.dto.UserDTO;
import com.example.isa.service.SystemAdministratorService;
import com.example.isa.service.UserService;

//@CrossOrigin(origins = "http://localhost:63342")
@CrossOrigin
@RestController
@RequestMapping(value = "api/systemAdministrator")
public class SystemAdministratorController {

    private final SystemAdministratorService systemAdministratorService;

    private final UserService userService;
    
    @Autowired
    public SystemAdministratorController(SystemAdministratorService systemAdministratorService,UserService userService){
        this.systemAdministratorService = systemAdministratorService;
        this.userService = userService;
    }

    @PostMapping(value = "/createSystemAdmin/{SystemAdminId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SystemAdministratorDTO> createSystemAdmin(@PathVariable("SystemAdminId") Long systemAdminId, @RequestBody UserDTO userDTO) throws Exception{

        // if(systemAdministratorService.findOne(systemAdminId) == null){
        //     return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        // }
        
        User user = new User(userDTO.getUsername(), userDTO.getPassword(), userDTO.getFirstName(), userDTO.getLastName(), userDTO.getAddress(),
        userDTO.getCity(), userDTO.getCountry(), userDTO.getPhoneNumber(), userDTO.getJmbg(), Gender.valueOf(userDTO.getGender()), userDTO.getProfession(), userDTO.getEducation());
        
        User newUser = this.userService.create(user);

        SystemAdministrator systemAdministrator = new SystemAdministrator(newUser);

        SystemAdministrator newSystemAdministrator = this.systemAdministratorService.create(systemAdministrator);

        SystemAdministratorDTO newSystemAdministratorDTO = new SystemAdministratorDTO(
                newSystemAdministrator.getBaseUserSA().getId(),
                newSystemAdministrator.getBaseUserSA().getUsername(),
                newSystemAdministrator.getBaseUserSA().getPassword(),
                newSystemAdministrator.getBaseUserSA().getFirstName(),
                newSystemAdministrator.getBaseUserSA().getLastName(), 
                newSystemAdministrator.getBaseUserSA().getAddress(),
                newSystemAdministrator.getBaseUserSA().getCity(), 
                newSystemAdministrator.getBaseUserSA().getCountry(),
                newSystemAdministrator.getBaseUserSA().getPhoneNumber(),
                newSystemAdministrator.getBaseUserSA().getJmbg(),
                newSystemAdministrator.getBaseUserSA().getGender(), 
                newSystemAdministrator.getBaseUserSA().getProfession(),
                newSystemAdministrator.getBaseUserSA().getEducation()
        );

        return new ResponseEntity<>(newSystemAdministratorDTO, HttpStatus.CREATED);
    }

    @PutMapping(value = "/updatePassword/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SystemAdministratorDTO> updatePassword(@PathVariable Long id, @RequestBody SystemAdministratorDTO systemAdministratorDTO) throws Exception{

        SystemAdministrator updatedSystemAdministrator = this.systemAdministratorService.updatePassword(systemAdministratorDTO);

        SystemAdministratorDTO updatedSystemAdministratorDTO = new SystemAdministratorDTO(
            updatedSystemAdministrator.getBaseUserSA().getId(),
            updatedSystemAdministrator.getBaseUserSA().getUsername(),
            updatedSystemAdministrator.getBaseUserSA().getPassword(),
            updatedSystemAdministrator.getBaseUserSA().getFirstName(), 
            updatedSystemAdministrator.getBaseUserSA().getLastName(), 
            updatedSystemAdministrator.getBaseUserSA().getAddress(), 
            updatedSystemAdministrator.getBaseUserSA().getCity(), 
            updatedSystemAdministrator.getBaseUserSA().getCountry(), 
            updatedSystemAdministrator.getBaseUserSA().getPhoneNumber(), 
            updatedSystemAdministrator.getBaseUserSA().getJmbg(),
            updatedSystemAdministrator.getBaseUserSA().getGender(),
            updatedSystemAdministrator.getBaseUserSA().getProfession(),
            updatedSystemAdministrator.getBaseUserSA().getEducation() 
        );

        return new ResponseEntity<>(updatedSystemAdministratorDTO, HttpStatus.OK);
       
    }



}
