package com.example.isa.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
import com.example.isa.model.RegularUser;
import com.example.isa.model.Term;
import com.example.isa.model.dto.CenterAdministratorDTO;
import com.example.isa.model.dto.Gender;
import com.example.isa.model.dto.UserDTO;
import com.example.isa.service.CenterAdministratorService;
import com.example.isa.service.SystemAdministratorService;
import com.example.isa.service.UserService;
import com.example.isa.service.RegularUserService;
import com.example.isa.service.TermService;

//@CrossOrigin(origins = "http://localhost:63342")
@CrossOrigin
@RestController
@RequestMapping(value = "/api/centerAdministrators")
public class CenterAdministratorController {

    private final CenterAdministratorService centerAdministratorService;
    private final SystemAdministratorService systemAdministratorService;
    private final RegularUserService regularUserService;
    private final UserService userService;
    private final TermService termService;

    @Autowired
    public CenterAdministratorController(CenterAdministratorService centerAdministratorService, SystemAdministratorService systemAdministratorService, UserService userService,
    RegularUserService regularUserService, TermService termService){
        this.centerAdministratorService = centerAdministratorService;
        this.systemAdministratorService = systemAdministratorService;
        this.userService = userService;
        this.regularUserService = regularUserService;
        this.termService = termService;
    }

    @PutMapping(value="/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CenterAdministratorDTO> update(@PathVariable Long id, @RequestBody CenterAdministratorDTO centerAdministratorDTO) throws Exception{

        CenterAdministrator updatedCenterAdministrator = this.centerAdministratorService.update(centerAdministratorDTO);

        CenterAdministratorDTO updatedCenterAdministratorDTO = new CenterAdministratorDTO(
            updatedCenterAdministrator.getBaseUserCA().getId(),
            updatedCenterAdministrator.getBaseUserCA().getUsername(),
            updatedCenterAdministrator.getBaseUserCA().getPassword(),
            updatedCenterAdministrator.getBaseUserCA().getFirstName(),
            updatedCenterAdministrator.getBaseUserCA().getLastName(),
            updatedCenterAdministrator.getBaseUserCA().getAddress(),
            updatedCenterAdministrator.getBaseUserCA().getCity(),
            updatedCenterAdministrator.getBaseUserCA().getCountry(),
            updatedCenterAdministrator.getBaseUserCA().getPhoneNumber(),
            updatedCenterAdministrator.getBaseUserCA().getJmbg(),
            updatedCenterAdministrator.getBaseUserCA().getGender(),
            updatedCenterAdministrator.getBaseUserCA().getProfession(),
            updatedCenterAdministrator.getBaseUserCA().getEducation()
        );

        return new ResponseEntity<>(updatedCenterAdministratorDTO, HttpStatus.OK);

    }

    @PutMapping(value = "/updatePassword/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('ROLE_CENTER_ADMINISTRATOR')")
    public ResponseEntity<CenterAdministratorDTO> updatePassword(@PathVariable Long id, @RequestBody CenterAdministratorDTO centerAdministratorDTO) throws Exception{

        CenterAdministrator updatedCenterAdministrator = this.centerAdministratorService.updatePassword(centerAdministratorDTO);



        CenterAdministratorDTO updatedCenterAdministratorDTO = new CenterAdministratorDTO(
            updatedCenterAdministrator.getBaseUserCA().getId(),
            updatedCenterAdministrator.getBaseUserCA().getUsername(),
            updatedCenterAdministrator.getBaseUserCA().getPassword(),
            updatedCenterAdministrator.getBaseUserCA().getFirstName(), 
            updatedCenterAdministrator.getBaseUserCA().getLastName(), 
            updatedCenterAdministrator.getBaseUserCA().getAddress(), 
            updatedCenterAdministrator.getBaseUserCA().getCity(), 
            updatedCenterAdministrator.getBaseUserCA().getCountry(), 
            updatedCenterAdministrator.getBaseUserCA().getPhoneNumber(), 
            updatedCenterAdministrator.getBaseUserCA().getJmbg(),
            updatedCenterAdministrator.getBaseUserCA().getGender(),
            updatedCenterAdministrator.getBaseUserCA().getProfession(),
            updatedCenterAdministrator.getBaseUserCA().getEducation() 
        );

        return new ResponseEntity<>(updatedCenterAdministratorDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/getOne/{centerAdministratorId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CenterAdministratorDTO> getOne(@PathVariable Long centerAdministratorId) throws Exception {

        CenterAdministrator centerAdministrator = this.centerAdministratorService.findOne(centerAdministratorId);

        CenterAdministratorDTO centerAdministratorDTO = new CenterAdministratorDTO(
            centerAdministrator.getBaseUserCA().getId(), 
            centerAdministrator.getBaseUserCA().getUsername(),
            centerAdministrator.getBaseUserCA().getPassword(),
            centerAdministrator.getBaseUserCA().getFirstName(),
            centerAdministrator.getBaseUserCA().getLastName(),
            centerAdministrator.getBaseUserCA().getAddress(), 
            centerAdministrator.getBaseUserCA().getCity(), 
            centerAdministrator.getBaseUserCA().getCountry(), 
            centerAdministrator.getBaseUserCA().getPhoneNumber(), 
            centerAdministrator.getBaseUserCA().getJmbg(), 
            centerAdministrator.getBaseUserCA().getGender(), 
            centerAdministrator.getBaseUserCA().getProfession(), 
            centerAdministrator.getBaseUserCA().getEducation());

        return new ResponseEntity<>(centerAdministratorDTO, HttpStatus.OK);
    }

    @PostMapping(value = "/createNewCenterAdmin/{SystemAdminId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CenterAdministratorDTO> createCenterAdmin(@PathVariable("SystemAdminId") Long systemAdminId, @RequestBody UserDTO userDTO) throws Exception{
        // if(systemAdministratorService.findOne(systemAdminId) == null){
        //     return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        // }
                
        User user = new User(userDTO.getUsername(), userDTO.getPassword(), userDTO.getFirstName(), userDTO.getLastName(), userDTO.getAddress(),
        userDTO.getCity(), userDTO.getCountry(), userDTO.getPhoneNumber(), userDTO.getJmbg(), Gender.valueOf(userDTO.getGender()), userDTO.getProfession(), userDTO.getEducation());
        
        User newUser = this.userService.create(user);

        CenterAdministrator centerAdministrator = new CenterAdministrator(newUser);

        CenterAdministrator newCenterAdministrator = this.centerAdministratorService.create(centerAdministrator);

        CenterAdministratorDTO newCenterAdministratorDTO = new CenterAdministratorDTO(
            newCenterAdministrator.getBaseUserCA().getId(),
            newCenterAdministrator.getBaseUserCA().getUsername(), 
            newCenterAdministrator.getBaseUserCA().getPassword(), 
            newCenterAdministrator.getBaseUserCA().getFirstName(), 
            newCenterAdministrator.getBaseUserCA().getLastName(),
            newCenterAdministrator.getBaseUserCA().getAddress(), 
            newCenterAdministrator.getBaseUserCA().getCity(), 
            newCenterAdministrator.getBaseUserCA().getCountry(),
            newCenterAdministrator.getBaseUserCA().getPhoneNumber(),
            newCenterAdministrator.getBaseUserCA().getJmbg(), 
            newCenterAdministrator.getBaseUserCA().getGender(), 
            newCenterAdministrator.getBaseUserCA().getProfession(), 
            newCenterAdministrator.getBaseUserCA().getEducation()
        );

        return new ResponseEntity<>(newCenterAdministratorDTO, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{centerId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('ROLE_CENTER_ADMINISTRATOR')")
    public ResponseEntity<List<CenterAdministratorDTO>> getCenterAdministratorsByCenterId(@PathVariable Long centerId) {

        List<CenterAdministrator> centerAdministratorList = this.centerAdministratorService.findAllByCenterId(centerId);

        List<CenterAdministratorDTO> centerAdministratorDTOs = new ArrayList<CenterAdministratorDTO>();

        for(CenterAdministrator centerAdministrator : centerAdministratorList){
            CenterAdministratorDTO centerAdministratorDTO = new CenterAdministratorDTO(
                centerAdministrator.getBaseUserCA().getId(),
                centerAdministrator.getBaseUserCA().getUsername(),
                centerAdministrator.getBaseUserCA().getPassword(), 
                centerAdministrator.getBaseUserCA().getFirstName(),
                centerAdministrator.getBaseUserCA().getLastName(), 
                centerAdministrator.getBaseUserCA().getAddress(), 
                centerAdministrator.getBaseUserCA().getCity(), 
                centerAdministrator.getBaseUserCA().getCountry(), 
                centerAdministrator.getBaseUserCA().getPhoneNumber(), 
                centerAdministrator.getBaseUserCA().getJmbg(), 
                centerAdministrator.getBaseUserCA().getGender(), 
                centerAdministrator.getBaseUserCA().getProfession(), 
                centerAdministrator.getBaseUserCA().getEducation()
            );
            centerAdministratorDTOs.add(centerAdministratorDTO);
        }

        return new ResponseEntity<>(centerAdministratorDTOs, HttpStatus.OK);
    }

    @GetMapping(value = "/complaint/{regUserUsername}", produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('ROLE_REGULAR_USER')")
    public ResponseEntity<List<CenterAdministratorDTO>> getCenterAdministratorsComplaint(@PathVariable String regUserUsername) throws Exception{
        User user = this.userService.findByUsername(regUserUsername);

        RegularUser regularUser = this.regularUserService.findOne(user.getId());

        List<Term> terms = this.termService.findScheduledTerms(regularUser.getId());

        List<CenterAdministrator> centerAdministrators = this.centerAdministratorService.findAll();

        List<CenterAdministrator> ret_val = new ArrayList<CenterAdministrator>();

        for(Term t : terms){
            for(CenterAdministrator c :centerAdministrators){
                if(t.getId() == c.getTerm().getId()){
                    ret_val.add(c);
                }
            }
        }

        Set<CenterAdministrator> temp = new HashSet<>(ret_val);
        ret_val.clear();
        ret_val.addAll(temp);

        List<CenterAdministratorDTO> centerAdministratorDTOs = new ArrayList<CenterAdministratorDTO>();

        for(CenterAdministrator centerAdministrator : ret_val){
            CenterAdministratorDTO centerAdministratorDTO = new CenterAdministratorDTO(
                centerAdministrator.getBaseUserCA().getId(),
                centerAdministrator.getBaseUserCA().getUsername(),
                centerAdministrator.getBaseUserCA().getPassword(), 
                centerAdministrator.getBaseUserCA().getFirstName(),
                centerAdministrator.getBaseUserCA().getLastName(), 
                centerAdministrator.getBaseUserCA().getAddress(), 
                centerAdministrator.getBaseUserCA().getCity(), 
                centerAdministrator.getBaseUserCA().getCountry(), 
                centerAdministrator.getBaseUserCA().getPhoneNumber(), 
                centerAdministrator.getBaseUserCA().getJmbg(), 
                centerAdministrator.getBaseUserCA().getGender(), 
                centerAdministrator.getBaseUserCA().getProfession(), 
                centerAdministrator.getBaseUserCA().getEducation()
            );
            centerAdministratorDTOs.add(centerAdministratorDTO);
        }

        return new ResponseEntity<>(centerAdministratorDTOs, HttpStatus.OK);
    }
}
