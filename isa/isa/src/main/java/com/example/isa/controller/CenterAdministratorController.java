package com.example.isa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.isa.model.CenterAdministrator;
import com.example.isa.model.dto.CenterAdministratorDTO;
import com.example.isa.model.dto.Gender;
import com.example.isa.service.CenterAdministratorService;

@RestController
@RequestMapping(value = "/api/centerAdministrators")
public class CenterAdministratorController {

    private final CenterAdministratorService centerAdministratorService;

    @Autowired
    public CenterAdministratorController(CenterAdministratorService centerAdministratorService){
        this.centerAdministratorService = centerAdministratorService;
    }

    @PutMapping(value = "/{adminCenterId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CenterAdministratorDTO> update(@PathVariable Long adminCenterId, @RequestBody CenterAdministratorDTO centerAdministratorDTO) throws Exception{

        CenterAdministrator centerAdministrator2 = this.centerAdministratorService.findOne(adminCenterId);
        if(centerAdministrator2 == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        

        CenterAdministrator centerAdministrator = new CenterAdministrator(
            centerAdministratorDTO.getEmail(),
            centerAdministratorDTO.getPassword(), 
            centerAdministratorDTO.getFirstName(), 
            centerAdministratorDTO.getLastName(), 
            centerAdministratorDTO.getAddress(), 
            centerAdministratorDTO.getCity(), 
            centerAdministratorDTO.getCountry(), 
            centerAdministratorDTO.getPhoneNumber(), 
            centerAdministratorDTO.getJmbg(), 
            Gender.valueOf("FEMALE"), 
            centerAdministratorDTO.getProfession(), 
            centerAdministratorDTO.getEducation()
        );

        centerAdministrator.setId(adminCenterId);

        CenterAdministrator updatedCenterAdministrator = centerAdministratorService.update(centerAdministrator);

        CenterAdministratorDTO updatedCenterAdministratorDTO = new CenterAdministratorDTO(
            updatedCenterAdministrator.getId(),
            updatedCenterAdministrator.getEmail(),
            updatedCenterAdministrator.getPassword(),
            updatedCenterAdministrator.getFirstName(), 
            updatedCenterAdministrator.getLastName(), 
            updatedCenterAdministrator.getAddress(), 
            updatedCenterAdministrator.getCity(), 
            updatedCenterAdministrator.getCountry(), 
            updatedCenterAdministrator.getPhoneNumber(), 
            updatedCenterAdministrator.getJmbg(),
            updatedCenterAdministrator.getGender().toString(),
            updatedCenterAdministrator.getProfession(),
            updatedCenterAdministrator.getEducation() 
        );

        return new ResponseEntity<>(updatedCenterAdministratorDTO, HttpStatus.OK);
    }
}
