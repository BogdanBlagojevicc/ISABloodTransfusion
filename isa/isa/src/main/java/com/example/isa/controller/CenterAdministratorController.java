package com.example.isa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.isa.model.CenterAdministrator;
import com.example.isa.model.dto.CenterAdministratorDTO;
import com.example.isa.model.dto.Gender;
import com.example.isa.service.CenterAdministratorService;
import com.example.isa.service.SystemAdministratorService;

//@CrossOrigin(origins = "http://localhost:63342")
@CrossOrigin
@RestController
@RequestMapping(value = "/api/centerAdministrators")
public class CenterAdministratorController {

    private final CenterAdministratorService centerAdministratorService;
    private final SystemAdministratorService systemAdministratorService;

    @Autowired
    public CenterAdministratorController(CenterAdministratorService centerAdministratorService, SystemAdministratorService systemAdministratorService){
        this.centerAdministratorService = centerAdministratorService;
        this.systemAdministratorService = systemAdministratorService;
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

    @PutMapping(value = "/updatePassword/{adminCenterId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CenterAdministratorDTO> updatePassword(@PathVariable Long adminCenterId, @RequestBody CenterAdministratorDTO centerAdministratorDTO) throws Exception{

        CenterAdministrator centerAdministrator2 = this.centerAdministratorService.findOne(adminCenterId);
        if(centerAdministrator2 == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        CenterAdministrator centerAdministrator = new CenterAdministrator(
            centerAdministrator2.getEmail(),
            centerAdministratorDTO.getPassword(), 
            centerAdministrator2.getFirstName(), 
            centerAdministrator2.getLastName(), 
            centerAdministrator2.getAddress(), 
            centerAdministrator2.getCity(), 
            centerAdministrator2.getCountry(), 
            centerAdministrator2.getPhoneNumber(), 
            centerAdministrator2.getJmbg(), 
            Gender.valueOf("FEMALE"), 
            centerAdministrator2.getProfession(), 
            centerAdministrator2.getEducation()
        );

        centerAdministrator.setId(adminCenterId);

        CenterAdministrator updatedCenterAdministrator = centerAdministratorService.updatePassword(centerAdministrator);

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

    @GetMapping(value = "/{centerAdministratorId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CenterAdministratorDTO> getOne(@PathVariable Long centerAdministratorId) {

        CenterAdministrator centerAdministrator = this.centerAdministratorService.findOne(centerAdministratorId);

        CenterAdministratorDTO centerAdministratorDTO = new CenterAdministratorDTO(
            centerAdministrator.getId(), 
            centerAdministrator.getEmail(),
            centerAdministrator.getPassword(),
            centerAdministrator.getFirstName(),
            centerAdministrator.getLastName(),
            centerAdministrator.getAddress(), 
            centerAdministrator.getCity(), 
            centerAdministrator.getCountry(), 
            centerAdministrator.getPhoneNumber(), 
            centerAdministrator.getJmbg(), 
            centerAdministrator.getGender().toString(), 
            centerAdministrator.getProfession(), 
            centerAdministrator.getEducation());

        return new ResponseEntity<>(centerAdministratorDTO, HttpStatus.OK);
    }

    @PostMapping(value = "/createNewCenterAdmin/{SystemAdminId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CenterAdministratorDTO> createCenterAdmin(@PathVariable("SystemAdminId") Long systemAdminId, @RequestBody CenterAdministratorDTO centerAdministratorDTO) throws Exception{
        if(systemAdministratorService.findOne(systemAdminId) == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        CenterAdministrator centerAdministrator = new CenterAdministrator(centerAdministratorDTO.getEmail(), centerAdministratorDTO.getPassword(), centerAdministratorDTO.getFirstName(), centerAdministratorDTO.getLastName(), centerAdministratorDTO.getAddress(), centerAdministratorDTO.getCity(), centerAdministratorDTO.getCountry(), centerAdministratorDTO.getPhoneNumber(), centerAdministratorDTO.getJmbg(), Gender.valueOf(centerAdministratorDTO.getGender()), centerAdministratorDTO.getProfession(), centerAdministratorDTO.getEducation());
        
        CenterAdministrator newCenterAdministrator = this.centerAdministratorService.create(centerAdministrator);

        CenterAdministratorDTO newCenterAdministratorDTO = new CenterAdministratorDTO(newCenterAdministrator.getId(), newCenterAdministrator.getEmail(), newCenterAdministrator.getPassword(), newCenterAdministrator.getFirstName(), newCenterAdministrator.getLastName(), newCenterAdministrator.getAddress(), newCenterAdministrator.getCity(), newCenterAdministrator.getCountry(), newCenterAdministrator.getPhoneNumber(), newCenterAdministrator.getJmbg(), newCenterAdministrator.getGender().toString(), newCenterAdministrator.getProfession(), newCenterAdministrator.getEducation());

        return new ResponseEntity<>(newCenterAdministratorDTO, HttpStatus.CREATED);
    }

}
