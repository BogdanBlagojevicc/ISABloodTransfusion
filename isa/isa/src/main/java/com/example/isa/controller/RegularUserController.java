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

import com.example.isa.model.dto.Gender;
import com.example.isa.model.dto.LoyaltyProgram;
import com.example.isa.model.dto.RegularUserDTO;
import com.example.isa.model.dto.UserDTO;
import com.example.isa.model.RegularUser;
import com.example.isa.model.User;
import com.example.isa.service.CenterAdministratorService;
import com.example.isa.service.RegularUserService;
import com.example.isa.service.SystemAdministratorService;
import com.example.isa.service.UserService;

//@CrossOrigin(origins = "http://localhost:63342")
@CrossOrigin
@RestController
@RequestMapping(value = "/api/regularUsers")
public class RegularUserController {
    
    private final RegularUserService regularUserService;
    private final SystemAdministratorService systemAdministratorService;
    private final CenterAdministratorService centerAdministratorService;
    private final UserService userService;

    @Autowired
    public RegularUserController(RegularUserService regularUserService, SystemAdministratorService systemAdministratorService, CenterAdministratorService centerAdministratorService, UserService userService){
        this.regularUserService = regularUserService;
        this.systemAdministratorService = systemAdministratorService;
        this.centerAdministratorService = centerAdministratorService;
        this.userService = userService;
    }
 
    @PostMapping(value = "/regularUserRegistration", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RegularUserDTO> createRegularUser(@RequestBody UserDTO userDTO) throws Exception{

        User user = new User(userDTO.getUsername(), userDTO.getPassword(), userDTO.getFirstName(), userDTO.getLastName(), userDTO.getAddress(),
        userDTO.getCity(), userDTO.getCountry(), userDTO.getPhoneNumber(), userDTO.getJmbg(), Gender.valueOf(userDTO.getGender()), userDTO.getProfession(), userDTO.getEducation());
        
        User newUser = this.userService.create(user);

        RegularUser regularUser = new RegularUser(LoyaltyProgram.REGULAR, 0, 0, newUser);

        RegularUser newRegularUser = regularUserService.create(regularUser);

        RegularUserDTO newRegularUserDTO = new RegularUserDTO(
            newRegularUser.getBaseUserRU().getUsername(),
            newRegularUser.getBaseUserRU().getFirstName(),
            newRegularUser.getBaseUserRU().getLastName(), 
            newRegularUser.getBaseUserRU().getAddress(),
            newRegularUser.getBaseUserRU().getCity(),
            newRegularUser.getBaseUserRU().getCountry(),
            newRegularUser.getBaseUserRU().getPhoneNumber(),
            newRegularUser.getBaseUserRU().getJmbg(),
            newRegularUser.getBaseUserRU().getGender(),
            newRegularUser.getBaseUserRU().getProfession(),
            newRegularUser.getBaseUserRU().getEducation(),
            newRegularUser.getLoyalty(),
            newRegularUser.getPoints(),
            newRegularUser.getPenalties()
        );
             

        return new ResponseEntity<>(newRegularUserDTO, HttpStatus.CREATED);
    }

   @GetMapping(value = "/{regUserUsername}", produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<RegularUserDTO> getRegularUser(@PathVariable String regUserUsername) throws Exception{

        User user = userService.findByUsername(regUserUsername);
        System.out.println("TUUU SAM "+user.getId());
        
       RegularUser regularUser = this.regularUserService.findOne(user.getId());

       RegularUserDTO regularUserDTO = new RegularUserDTO(
        user.getId(),
        user.getUsername(), 
        user.getPassword(), 
        user.getFirstName(),
        user.getLastName() ,
        user.getAddress(), 
        user.getCity(), 
        user.getCountry(), 
        user.getPhoneNumber(), 
        user.getJmbg(), 
        user.getGender(), 
        user.getProfession(),
        user.getEducation(), 
        regularUser.getLoyalty(), 
        regularUser.getPoints(), 
        regularUser.getPenalties()
        );


        return new ResponseEntity<>(regularUserDTO, HttpStatus.OK);

   } 

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RegularUserDTO> updateRegularUser(@PathVariable Long id, @RequestBody RegularUserDTO regularUserDTO) throws Exception {
        RegularUser updatedRegularUser = this.regularUserService.update(id, regularUserDTO);


        RegularUserDTO updatedRegularUserDTO = new RegularUserDTO(
            updatedRegularUser.getBaseUserRU().getId(),
            updatedRegularUser.getBaseUserRU().getUsername(),
            updatedRegularUser.getBaseUserRU().getPassword(),
            updatedRegularUser.getBaseUserRU().getFirstName(),
            updatedRegularUser.getBaseUserRU().getLastName(),
            updatedRegularUser.getBaseUserRU().getAddress(),
            updatedRegularUser.getBaseUserRU().getCity(),
            updatedRegularUser.getBaseUserRU().getCountry(),
            updatedRegularUser.getBaseUserRU().getPhoneNumber(),
            updatedRegularUser.getBaseUserRU().getJmbg(),
            updatedRegularUser.getBaseUserRU().getGender(),
            updatedRegularUser.getBaseUserRU().getProfession(),
            updatedRegularUser.getBaseUserRU().getEducation(),
            updatedRegularUser.getLoyalty(),
            updatedRegularUser.getPoints(),
            updatedRegularUser.getPenalties()
        );


        return new ResponseEntity<>(updatedRegularUserDTO, HttpStatus.OK);
        
    }

    @GetMapping(value = "/getAllRegularUsers", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RegularUserDTO>> getAllRegularUsers(){

        List<RegularUser> regularUsers = this.regularUserService.findAll();
        List<RegularUserDTO> regularUserDTOs = new ArrayList<>();

        for(RegularUser regularUser : regularUsers){
            RegularUserDTO regularUserDTO = new RegularUserDTO(
                regularUser.getId(), 
                regularUser.getBaseUserRU().getUsername(),
                regularUser.getBaseUserRU().getPassword(), 
                regularUser.getBaseUserRU().getFirstName(), 
                regularUser.getBaseUserRU().getLastName(), 
                regularUser.getBaseUserRU().getAddress(), 
                regularUser.getBaseUserRU().getCity(), 
                regularUser.getBaseUserRU().getCountry(), 
                regularUser.getBaseUserRU().getPhoneNumber(), 
                regularUser.getBaseUserRU().getJmbg(), 
                regularUser.getBaseUserRU().getGender(), 
                regularUser.getBaseUserRU().getProfession(), 
                regularUser.getBaseUserRU().getEducation(), 
                regularUser.getLoyalty(), 
                regularUser.getPoints(), 
                regularUser.getPenalties()
            );
            regularUserDTOs.add(regularUserDTO);
        }
        return new ResponseEntity<>(regularUserDTOs, HttpStatus.OK);
    }

    @PutMapping(value = "/updatePenalty/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RegularUserDTO> updatePenalty(@PathVariable Long id, @RequestBody RegularUserDTO regularUserDTO) throws Exception {

        // RegularUser updatedRegularUser = this.regularUserService.update(id, regularUserDTO);

        RegularUser updatedRegularUser = this.regularUserService.updatePenalty(id);

        RegularUserDTO updatedRegularUserDTO = new RegularUserDTO(
            updatedRegularUser.getBaseUserRU().getId(),
            updatedRegularUser.getBaseUserRU().getUsername(),
            updatedRegularUser.getBaseUserRU().getPassword(),
            updatedRegularUser.getBaseUserRU().getFirstName(),
            updatedRegularUser.getBaseUserRU().getLastName(),
            updatedRegularUser.getBaseUserRU().getAddress(),
            updatedRegularUser.getBaseUserRU().getCity(),
            updatedRegularUser.getBaseUserRU().getCountry(),
            updatedRegularUser.getBaseUserRU().getPhoneNumber(),
            updatedRegularUser.getBaseUserRU().getJmbg(),
            updatedRegularUser.getBaseUserRU().getGender(),
            updatedRegularUser.getBaseUserRU().getProfession(),
            updatedRegularUser.getBaseUserRU().getEducation(),
            updatedRegularUser.getLoyalty(),
            updatedRegularUser.getPoints(),
            updatedRegularUser.getPenalties()
        );


        return new ResponseEntity<>(updatedRegularUserDTO, HttpStatus.OK);
        
    }

    // @GetMapping("/firstNameAsc")
    // public ResponseEntity<List<RegularUserDTO>> getRegularUsersSortedByFirstNameAsc() {
    //     List<RegularUser> users = this.regularUserService.findByOrderByFirstNameAsc();

    //     List<RegularUserDTO> userDTOS = new ArrayList<>();

    //     // for (Center center : centers) {
    //     //     CenterDTO centerDTO = new CenterDTO(center.getId(), center.getName(), center.getAddress(),
    //     //             center.getDescription(), center.getAverageGrade(),
    //     //             center.getCountry(), center.getStartTime(), center.getEndTime());
    //     //     centerDTOS.add(centerDTO);
    //     // }

    //     for (RegularUser user : users){
    //         RegularUserDTO userDTO = new RegularUserDTO(user.getId(), user.getBaseUserRU().getUsername(), user.getBaseUserRU().getPassword(), user.getBaseUserRU().getFirstName(), user.getBaseUserRU().getLastName(), user.getBaseUserRU().getAddress(), user.getBaseUserRU().getCity(), user.getBaseUserRU().getCountry(), user.getBaseUserRU().getPhoneNumber(), user.getBaseUserRU().getJmbg(), user.getBaseUserRU().getGender(), user.getBaseUserRU().getProfession(), user.getBaseUserRU().getEducation(), user.loyalty, user.getPoints(), user.getPenalties());
    //         userDTOS.add(userDTO);
    //     }

    //     return new ResponseEntity<>(userDTOS, HttpStatus.OK);
    // }



    //SESA METODA
    // @GetMapping(value = "/findByFirstNameAndLastName/{Id}/{FirstName}/{LastName}", produces = MediaType.APPLICATION_JSON_VALUE)
    // public ResponseEntity<List<RegularUserDTO>> getRegularUsersByFirstAndLastName(@PathVariable("Id") Long id, @PathVariable("FirstName") String firstName, @PathVariable("LastName") String lastName){

    //     if((systemAdministratorService.findOne(id) == null) && (centerAdministratorService.findOne(id) == null)){
    //         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    //     }

    //     List<RegularUser> regularUsers = regularUserService.findByFirstNameAndLastName(firstName, lastName);
    //     List<RegularUserDTO> regularUserDTOs = new ArrayList<>();

    //     for (RegularUser regularUser : regularUsers) {
    //         RegularUserDTO regularUserDTO = new RegularUserDTO(regularUser.getId(), regularUser.getEmail(), regularUser.getFirstName(), regularUser.getLastName(), regularUser.getAddress(), regularUser.getCity(), regularUser.getCountry(), regularUser.getPhoneNumber(), regularUser.getJmbg(), regularUser.getGender(), regularUser.getProfession(), regularUser.getEducation(), regularUser.getLoyalty(), regularUser.getPoints(), regularUser.getPenalties());
    //         regularUserDTOs.add(regularUserDTO);
    //     }
    //     return new ResponseEntity<>(regularUserDTOs, HttpStatus.OK);
    // }

}