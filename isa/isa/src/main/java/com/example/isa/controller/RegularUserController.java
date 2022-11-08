package com.example.isa.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.isa.model.dto.Gender;
import com.example.isa.model.dto.LoyaltyProgram;
import com.example.isa.model.dto.RegularUserDTO;
import com.example.isa.model.RegularUser;
import com.example.isa.service.RegularUserService;

@RestController
@RequestMapping(value = "api/regularUsers/")
public class RegularUserController {
    
    private final RegularUserService regularUserService;

    @Autowired
    public RegularUserController(RegularUserService regularUserService){
        this.regularUserService = regularUserService;
    }
 
    @PostMapping(value = "/regularUserRegistration", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RegularUserDTO> createRegularUser(@RequestBody RegularUserDTO regularUserDTO) throws Exception{

 

        RegularUser regularUser = new RegularUser(LoyaltyProgram.valueOf(regularUserDTO.getLoyalty()), regularUserDTO.getEmail(), regularUserDTO.getPassword(),
        regularUserDTO.getFirstName(), regularUserDTO.getLastName(), regularUserDTO.getAddress(), regularUserDTO.getCity(), regularUserDTO.getCountry(), regularUserDTO. getPhoneNumber(),
        regularUserDTO.getJmbg(), Gender.valueOf(regularUserDTO.getGender()), regularUserDTO.getProfession(), regularUserDTO.getEducation(), regularUserDTO.getPoints(),
        regularUserDTO.getPenalties());

        RegularUser newRegularUser = regularUserService.create(regularUser);
        
    

        RegularUserDTO newRegularUserDTO = new RegularUserDTO(newRegularUser.getId(), newRegularUser.getEmail(), newRegularUser.getPassword(),
        newRegularUser.getFirstName(), newRegularUser.getLastName(), newRegularUser.getAddress(), newRegularUser.getCity(),
        newRegularUser.getCountry(), newRegularUser.getPhoneNumber(), newRegularUser.getJmbg(), newRegularUser.getGender(),
        newRegularUser.getProfession(), newRegularUser.getEducation(), newRegularUser.getLoyalty(), newRegularUser.getPoints(),
        newRegularUser.getPenalties());

        return new ResponseEntity<>(newRegularUserDTO, HttpStatus.CREATED);
    }

   @GetMapping(value = "/{Id}", produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<RegularUserDTO> getRegularUser(@PathVariable("Id") Long Id){
        
       RegularUser regularUser = this.regularUserService.findOne(Id);

       RegularUserDTO regularUserDTO = new RegularUserDTO(regularUser.getId(), regularUser.getEmail(), regularUser.getPassword(), regularUser.getFirstName(),regularUser.getLastName() ,
       regularUser.getAddress(), regularUser.getCity(), regularUser.getCountry(), regularUser.getPhoneNumber(), regularUser.getJmbg(), regularUser.getGender(), regularUser.getProfession(),
       regularUser.getEducation(), regularUser.getLoyalty(), regularUser.getPoints(), regularUser.getPenalties());


        return new ResponseEntity<>(regularUserDTO, HttpStatus.OK);

   } 

   @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE,
	            produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<RegularUserDTO> updateRegularUser(@PathVariable Long id, @RequestBody RegularUserDTO regularUserDTO) throws Exception {
            RegularUser regularUser = new RegularUser(regularUserDTO.getId(), LoyaltyProgram.valueOf( regularUserDTO.getLoyalty()), regularUserDTO.getEmail(), regularUserDTO.getPassword(), regularUserDTO.getFirstName(),regularUserDTO.getLastName() ,
            regularUserDTO.getAddress(), regularUserDTO.getCity(), regularUserDTO.getCountry(), regularUserDTO.getPhoneNumber(), regularUserDTO.getJmbg(), Gender.valueOf(regularUserDTO.getGender()), regularUserDTO.getProfession(),
            regularUserDTO.getEducation(), regularUserDTO.getPoints(), regularUserDTO.getPenalties());
	        
	       regularUser.setId(id);
           RegularUser updatedEm = regularUserService.update(regularUser);
	       
	       RegularUserDTO updatedEmDTO = new RegularUserDTO(updatedEm.getId(), updatedEm.getEmail(), updatedEm.getPassword(), updatedEm.getFirstName(),updatedEm.getLastName() ,
           updatedEm.getAddress(), updatedEm.getCity(), updatedEm.getCountry(), updatedEm.getPhoneNumber(), updatedEm.getJmbg(), updatedEm.getGender(), updatedEm.getProfession(),
           updatedEm.getEducation(), updatedEm.getLoyalty(), updatedEm.getPoints(), updatedEm.getPenalties());
	        
	        return new ResponseEntity<>(updatedEmDTO, HttpStatus.OK);
	    }

}