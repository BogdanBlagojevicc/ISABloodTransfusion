package com.example.isa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.isa.model.CenterAdministrator;
import com.example.isa.model.dto.CenterAdministratorDTO;
import com.example.isa.service.CenterAdministratorService;

@RestController
@RequestMapping(value = "/api/centerAdministrators")
public class CenterAdministratorController {
    
    private final CenterAdministratorService centerAdministratorService;

    @Autowired
    public CenterAdministratorController(CenterAdministratorService centerAdministratorService){
        this.centerAdministratorService = centerAdministratorService;
    }

    @PostMapping(value = "/createCenterAdmin", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CenterAdministratorDTO> createCenterAdministrator(@RequestBody CenterAdministratorDTO centerAdministratorDTO) throws Exception{
        
        CenterAdministrator centerAdministrator = new CenterAdministrator(centerAdministratorDTO.getEmail(), centerAdministratorDTO.getPassword(), centerAdministratorDTO.getFirstName(), centerAdministratorDTO.getLastName(), centerAdministratorDTO.getAddress(), centerAdministratorDTO.getCity(), centerAdministratorDTO.getCountry(), centerAdministratorDTO.getPhoneNumber(), centerAdministratorDTO.getJmbg(), com.example.isa.model.dto.Gender.valueOf(centerAdministratorDTO.getGender()), centerAdministratorDTO.getProfession(), centerAdministratorDTO.getEducation());
        CenterAdministrator newCenterAdministrator = centerAdministratorService.create(centerAdministrator);
        CenterAdministratorDTO newCenterAdministratorDTO = new CenterAdministratorDTO(newCenterAdministrator.getId(), newCenterAdministrator.getEmail(), newCenterAdministrator.getPassword(), newCenterAdministrator.getFirstName(), newCenterAdministrator.getLastName(), newCenterAdministrator.getAddress(), newCenterAdministrator.getCity(), newCenterAdministrator.getCountry(), newCenterAdministrator.getPhoneNumber(), newCenterAdministrator.getJmbg(), newCenterAdministrator.getGender().toString(), newCenterAdministrator.getProfession(), newCenterAdministrator.getEducation());

        return new ResponseEntity<>(newCenterAdministratorDTO, HttpStatus.CREATED);
    }
}
