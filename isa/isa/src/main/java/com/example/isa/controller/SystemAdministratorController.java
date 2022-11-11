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
import com.example.isa.model.dto.Gender;
import com.example.isa.model.dto.SystemAdministratorDTO;
import com.example.isa.service.SystemAdministratorService;

//@CrossOrigin(origins = "http://localhost:63342")
@CrossOrigin
@RestController
@RequestMapping(value = "api/systemAdministrator")
public class SystemAdministratorController {

    private final SystemAdministratorService systemAdministratorService;
    
    @Autowired
    public SystemAdministratorController(SystemAdministratorService systemAdministratorService){
        this.systemAdministratorService = systemAdministratorService;
    }

    @PostMapping(value = "/createSystemAdmin/{SystemAdminId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SystemAdministratorDTO> createSystemAdmin(@PathVariable("SystemAdminId") Long systemAdminId, @RequestBody SystemAdministratorDTO systemAdministratorDTO) throws Exception{

        if(systemAdministratorService.findOne(systemAdminId) == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        SystemAdministrator systemAdministrator = new SystemAdministrator(systemAdministratorDTO.getEmail(), systemAdministratorDTO.getPassword(), systemAdministratorDTO.getFirstName(), systemAdministratorDTO.getLastName(), systemAdministratorDTO.getAddress(), systemAdministratorDTO.getCity(), systemAdministratorDTO.getCountry(), systemAdministratorDTO.getPhoneNumber(), systemAdministratorDTO.getJmbg(), Gender.valueOf(systemAdministratorDTO.getGender()));

        SystemAdministrator newSystemAdministrator = this.systemAdministratorService.create(systemAdministrator);

        SystemAdministratorDTO newSystemAdministratorDTO = new SystemAdministratorDTO(newSystemAdministrator.getId(), newSystemAdministrator.getEmail(), newSystemAdministrator.getPassword(), newSystemAdministrator.getFirstName(), newSystemAdministrator.getLastName(), newSystemAdministrator.getAddress(), newSystemAdministrator.getCity(), newSystemAdministrator.getCountry(), newSystemAdministrator.getPhoneNumber(), newSystemAdministrator.getJmbg(), newSystemAdministrator.getGender().toString(), newSystemAdministrator.getProfession(), newSystemAdministrator.getEducation());

        return new ResponseEntity<>(newSystemAdministratorDTO, HttpStatus.CREATED);
    }

    @PutMapping(value = "/updatePassword/{SystemAdminId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SystemAdministratorDTO> updatePassword(@PathVariable("SystemAdminId") Long systemAdminId, @RequestBody SystemAdministratorDTO systemAdministratorDTO) throws Exception{

        SystemAdministrator systemAdministratorToUpdate = this.systemAdministratorService.findOne(systemAdminId);
        if(systemAdministratorToUpdate == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        systemAdministratorToUpdate.setPassword(systemAdministratorDTO.getPassword());

        SystemAdministrator updatedSystemAdministrator = this.systemAdministratorService.updatePassword(systemAdministratorToUpdate);

        SystemAdministratorDTO updatedSystemAdministratorDTO = new SystemAdministratorDTO(updatedSystemAdministrator.getId(), updatedSystemAdministrator.getEmail(), updatedSystemAdministrator.getPassword(), updatedSystemAdministrator.getFirstName(), updatedSystemAdministrator.getLastName(), updatedSystemAdministrator.getAddress(), updatedSystemAdministrator.getCity(), updatedSystemAdministrator.getCountry(), updatedSystemAdministrator.getPhoneNumber(), updatedSystemAdministrator.getJmbg(), updatedSystemAdministrator.getGender().toString(), updatedSystemAdministrator.getProfession(), updatedSystemAdministrator.getEducation());

        return new ResponseEntity<>(updatedSystemAdministratorDTO, HttpStatus.OK);
       
    }
}
