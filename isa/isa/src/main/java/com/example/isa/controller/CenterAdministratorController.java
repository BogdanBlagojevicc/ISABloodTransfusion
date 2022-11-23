package com.example.isa.controller;

import java.util.ArrayList;
import java.util.List;

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
import com.example.isa.model.User;
import com.example.isa.model.dto.CenterAdministratorDTO;
import com.example.isa.model.dto.Gender;
import com.example.isa.model.dto.UserDTO;
import com.example.isa.service.CenterAdministratorService;
import com.example.isa.service.SystemAdministratorService;
import com.example.isa.service.UserService;

//@CrossOrigin(origins = "http://localhost:63342")
@CrossOrigin
@RestController
@RequestMapping(value = "/api/centerAdministrators")
public class CenterAdministratorController {

    private final CenterAdministratorService centerAdministratorService;
    private final SystemAdministratorService systemAdministratorService;
    private final UserService userService;

    @Autowired
    public CenterAdministratorController(CenterAdministratorService centerAdministratorService, SystemAdministratorService systemAdministratorService, UserService userService){
        this.centerAdministratorService = centerAdministratorService;
        this.systemAdministratorService = systemAdministratorService;
        this.userService = userService;
    }

    @PutMapping(value="/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CenterAdministratorDTO> update(@PathVariable Long id, @RequestBody CenterAdministratorDTO centerAdministratorDTO) throws Exception{

        CenterAdministrator updatedCenterAdministrator = this.centerAdministratorService.update(centerAdministratorDTO);

        CenterAdministratorDTO updatedCenterAdministratorDTO = new CenterAdministratorDTO(
            updatedCenterAdministrator.getBaseUser().getId(),
            updatedCenterAdministrator.getBaseUser().getEmail(),
            updatedCenterAdministrator.getBaseUser().getPassword(),
            updatedCenterAdministrator.getBaseUser().getFirstName(),
            updatedCenterAdministrator.getBaseUser().getLastName(),
            updatedCenterAdministrator.getBaseUser().getAddress(),
            updatedCenterAdministrator.getBaseUser().getCity(),
            updatedCenterAdministrator.getBaseUser().getCountry(),
            updatedCenterAdministrator.getBaseUser().getPhoneNumber(),
            updatedCenterAdministrator.getBaseUser().getJmbg(),
            updatedCenterAdministrator.getBaseUser().getGender(),
            updatedCenterAdministrator.getBaseUser().getProfession(),
            updatedCenterAdministrator.getBaseUser().getEducation()
        );

        return new ResponseEntity<>(updatedCenterAdministratorDTO, HttpStatus.OK);

    }

    @PutMapping(value = "/updatePassword/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CenterAdministratorDTO> updatePassword(@PathVariable Long id, @RequestBody CenterAdministratorDTO centerAdministratorDTO) throws Exception{

        CenterAdministrator updatedCenterAdministrator = this.centerAdministratorService.updatePassword(centerAdministratorDTO);



        CenterAdministratorDTO updatedCenterAdministratorDTO = new CenterAdministratorDTO(
            updatedCenterAdministrator.getBaseUser().getId(),
            updatedCenterAdministrator.getBaseUser().getEmail(),
            updatedCenterAdministrator.getBaseUser().getPassword(),
            updatedCenterAdministrator.getBaseUser().getFirstName(), 
            updatedCenterAdministrator.getBaseUser().getLastName(), 
            updatedCenterAdministrator.getBaseUser().getAddress(), 
            updatedCenterAdministrator.getBaseUser().getCity(), 
            updatedCenterAdministrator.getBaseUser().getCountry(), 
            updatedCenterAdministrator.getBaseUser().getPhoneNumber(), 
            updatedCenterAdministrator.getBaseUser().getJmbg(),
            updatedCenterAdministrator.getBaseUser().getGender(),
            updatedCenterAdministrator.getBaseUser().getProfession(),
            updatedCenterAdministrator.getBaseUser().getEducation() 
        );

        return new ResponseEntity<>(updatedCenterAdministratorDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/getOne/{centerAdministratorId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CenterAdministratorDTO> getOne(@PathVariable Long centerAdministratorId) throws Exception {

        CenterAdministrator centerAdministrator = this.centerAdministratorService.findOne(centerAdministratorId);

        CenterAdministratorDTO centerAdministratorDTO = new CenterAdministratorDTO(
            centerAdministrator.getBaseUser().getId(), 
            centerAdministrator.getBaseUser().getEmail(),
            centerAdministrator.getBaseUser().getPassword(),
            centerAdministrator.getBaseUser().getFirstName(),
            centerAdministrator.getBaseUser().getLastName(),
            centerAdministrator.getBaseUser().getAddress(), 
            centerAdministrator.getBaseUser().getCity(), 
            centerAdministrator.getBaseUser().getCountry(), 
            centerAdministrator.getBaseUser().getPhoneNumber(), 
            centerAdministrator.getBaseUser().getJmbg(), 
            centerAdministrator.getBaseUser().getGender(), 
            centerAdministrator.getBaseUser().getProfession(), 
            centerAdministrator.getBaseUser().getEducation());

        return new ResponseEntity<>(centerAdministratorDTO, HttpStatus.OK);
    }

    @PostMapping(value = "/createNewCenterAdmin/{SystemAdminId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CenterAdministratorDTO> createCenterAdmin(@PathVariable("SystemAdminId") Long systemAdminId, @RequestBody UserDTO userDTO) throws Exception{
        // if(systemAdministratorService.findOne(systemAdminId) == null){
        //     return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        // }
                
        User user = new User(userDTO.getEmail(), userDTO.getPassword(), userDTO.getFirstName(), userDTO.getLastName(), userDTO.getAddress(),
        userDTO.getCity(), userDTO.getCountry(), userDTO.getPhoneNumber(), userDTO.getJmbg(), Gender.valueOf(userDTO.getGender()), userDTO.getProfession(), userDTO.getEducation());
        
        User newUser = this.userService.create(user);

        CenterAdministrator centerAdministrator = new CenterAdministrator(newUser);

        CenterAdministrator newCenterAdministrator = this.centerAdministratorService.create(centerAdministrator);

        CenterAdministratorDTO newCenterAdministratorDTO = new CenterAdministratorDTO(
            newCenterAdministrator.getBaseUser().getId(),
            newCenterAdministrator.getBaseUser().getEmail(), 
            newCenterAdministrator.getBaseUser().getPassword(), 
            newCenterAdministrator.getBaseUser().getFirstName(), 
            newCenterAdministrator.getBaseUser().getLastName(),
            newCenterAdministrator.getBaseUser().getAddress(), 
            newCenterAdministrator.getBaseUser().getCity(), 
            newCenterAdministrator.getBaseUser().getCountry(),
            newCenterAdministrator.getBaseUser().getPhoneNumber(),
            newCenterAdministrator.getBaseUser().getJmbg(), 
            newCenterAdministrator.getBaseUser().getGender(), 
            newCenterAdministrator.getBaseUser().getProfession(), 
            newCenterAdministrator.getBaseUser().getEducation()
        );

        return new ResponseEntity<>(newCenterAdministratorDTO, HttpStatus.CREATED);
    }

    //vraca jedan objekat ne vraca listu
    @GetMapping(value = "/{centerId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CenterAdministratorDTO>> getCenterAdministratorsByCenterId(@PathVariable Long centerId) {

        List<CenterAdministrator> centerAdministratorList = this.centerAdministratorService.findAllByCenterId(centerId);

        List<CenterAdministratorDTO> centerAdministratorDTOs = new ArrayList<CenterAdministratorDTO>();

        for(CenterAdministrator centerAdministrator : centerAdministratorList){
            System.out.println(centerAdministrator.getBaseUser().getId() + " ******************************");
            CenterAdministratorDTO centerAdministratorDTO = new CenterAdministratorDTO(
                centerAdministrator.getBaseUser().getId(),
                centerAdministrator.getBaseUser().getEmail(),
                centerAdministrator.getBaseUser().getPassword(), 
                centerAdministrator.getBaseUser().getFirstName(),
                centerAdministrator.getBaseUser().getLastName(), 
                centerAdministrator.getBaseUser().getAddress(), 
                centerAdministrator.getBaseUser().getCity(), 
                centerAdministrator.getBaseUser().getCountry(), 
                centerAdministrator.getBaseUser().getPhoneNumber(), 
                centerAdministrator.getBaseUser().getJmbg(), 
                centerAdministrator.getBaseUser().getGender(), 
                centerAdministrator.getBaseUser().getProfession(), 
                centerAdministrator.getBaseUser().getEducation()
            );
            centerAdministratorDTOs.add(centerAdministratorDTO);
        }

        return new ResponseEntity<>(centerAdministratorDTOs, HttpStatus.OK);
    }

}
