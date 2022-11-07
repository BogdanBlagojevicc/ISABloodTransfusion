package com.example.isa.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.isa.model.dto.RegularUserDTO;
import com.example.isa.model.RegularUser;
import com.example.isa.service.RegularUserService;

@RestController
@RequestMapping(value = "api/regularUsers")
public class RegularUserController {
    
    private final RegularUserService regularUserService;

    @Autowired
    public RegularUserController(RegularUserService regularUserService){
        this.regularUserService = regularUserService;
    }
 
    /*@PostMapping(value = "/regularUserRegistration", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RegularUserDTO> createRegularUser(@RequestBody RegularUserDTO regularUserDTO) throws Exception{

        RegularUser regularUser = new RegularUser(regularUserDTO.getEmail(), regularUserDTO.getPassword(), regularUserDTO.getFirstName(),
        regularUserDTO.getLastName(), regularUserDTO.getAddress(), regularUserDTO.getCity(), regularUserDTO.getCountry(),
        regularUserDTO.getPhoneNumber(), regularUserDTO.getJmbg(), regularUserDTO.getGender(), regularUserDTO.getProfession(),
        regularUserDTO.getEducation(), regularUserDTO.getLoyalty(), regularUserDTO.getPoints(), regularUserDTO.getPenalties());

        RegularUser newRegularUser = regularUserService.create(regularUser);

        RegularUserDTO newRegularUserDTO = new RegularUserDTO(newRegularUser.getId(), newRegularUser.getEmail(), newRegularUser.getPassword(),
        newRegularUser.getFirstName(), newRegularUser.getLastName(), newRegularUser.getAddress(), newRegularUser.getCity(),
        newRegularUser.getCountry(), newRegularUser.getPhoneNumber(), newRegularUser.getJmbg(), newRegularUser.getGender(),
        newRegularUser.getProfession(), newRegularUser.getEducation(), newRegularUser.getLoyalty(), newRegularUser.getPoints(),
        newRegularUser.getPenalties());

        return new ResponseEntity<>(newRegularUserDTO, HttpStatus.CREATED);
    }*/

    @GetMapping(value = "/{Id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RegularUserDTO> getRegularUser(@PathVariable("Id") Long Id){
        
        RegularUser regularUser = this.regularUserService.getOne(Id);

        /*RegularUserDTO regularUserDTO = new RegularUserDTO(regularUser.getId(), regularUser.getUserField().getEmail(), regularUser.getUserField().getPassword(), regularUser.getUserField().getFirstName(),  regularUser.getUserField().getLastName(), regularUser.getUserField().getAddress(), regularUser.getUserField().getCity(), regularUser.getUserField().getCountry(), regularUser.getUserField().getPhoneNumber(), regularUser.getUserField().getJmbg(), regularUser.getUserField().getGender().toString(), regularUser.getUserField().getProfession(), regularUser.getUserField().getEducation(), regularUser.getLoyalty(), regularUser.getPoints(), regularUser.getPenalties());*/


        //puca jer regularUser.getUserField().getEmail() je null
        RegularUserDTO regularUserDTO = new RegularUserDTO(regularUser.getId(), regularUser.getUserField().getEmail(), "121", "11", "11", "11", "11", "11", "11", "11", "11","11","11", regularUser.getLoyalty().toString(), regularUser.getPoints(), regularUser.getPenalties());
        

        return new ResponseEntity<>(regularUserDTO, HttpStatus.OK);

    }

}