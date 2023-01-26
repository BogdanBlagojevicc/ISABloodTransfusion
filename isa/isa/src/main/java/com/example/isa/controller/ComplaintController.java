package com.example.isa.controller;

import java.util.ArrayList;
import java.util.List;

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

import com.example.isa.model.Complaint;
import com.example.isa.model.Center;
import com.example.isa.model.CenterAdministrator;
import com.example.isa.model.User;
import com.example.isa.model.RegularUser;
import com.example.isa.model.dto.ComplaintDTO;
import com.example.isa.service.ComplaintService;
import com.example.isa.service.SystemAdministratorService;
import com.example.isa.service.UserService;
import com.example.isa.service.RegularUserService;
import com.example.isa.service.CenterAdministratorService;
import com.example.isa.service.CenterService;

//@CrossOrigin(origins = "http://localhost:63342")
@CrossOrigin
@RestController
@RequestMapping(value = "api/complaint")
public class ComplaintController {
    
    private final ComplaintService complaintService;
    private final SystemAdministratorService systemAdministratorService;
    private final UserService userService;
    private final RegularUserService regularUserService;
    private final CenterAdministratorService centerAdministratorService;
    private final CenterService centerService;

    @Autowired
    public ComplaintController(ComplaintService complaintService, SystemAdministratorService systemAdministratorService, UserService userService, 
    RegularUserService regularUserService, CenterAdministratorService centerAdministratorService, CenterService centerService){
        this.complaintService = complaintService;
        this.systemAdministratorService = systemAdministratorService;
        this.userService = userService;
        this.regularUserService = regularUserService;
        this.centerAdministratorService = centerAdministratorService;
        this.centerService = centerService;
    }

    @PutMapping(value = "/updateComplaint/{SystemAdminId}/{ComplaintId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ComplaintDTO> updateComplaint(@PathVariable("SystemAdminId") Long systemAdminId, @PathVariable("ComplaintId") Long complaintId, @RequestBody ComplaintDTO complaintDTO) throws Exception{
        
        // if(systemAdministratorService.findOne(systemAdminId) == null){
        //     return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        // }

        Complaint complaint = new Complaint(complaintDTO.getText(), complaintDTO.getResponse());
        complaint.setId(complaintId);

        Complaint updatedComplaint = this.complaintService.update(complaint);

        ComplaintDTO updatedComplaintDTO = new ComplaintDTO(updatedComplaint.getId(), updatedComplaint.getText(), updatedComplaint.getResponse());

        return new ResponseEntity<>(updatedComplaintDTO, HttpStatus.OK);
    }

    @PostMapping(value = "/center/{regUserUsername}/{centerId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('ROLE_REGULAR_USER')")
    public ResponseEntity<ComplaintDTO> createCenterComplaint(@PathVariable String regUserUsername,@PathVariable Long centerId, @RequestBody ComplaintDTO complaintDTO) throws Exception{
        User user = this.userService.findByUsername(regUserUsername);

        Center center = this.centerService.findOne(centerId);


        RegularUser regularUser = this.regularUserService.findOne(user.getId());

        Complaint complaint = new Complaint(complaintDTO.getText(), complaintDTO.getResponse());
        complaint.setRegularUser(regularUser);
        complaint.setCenterCO(center);

        Complaint newComplaint = this.complaintService.create(complaint);

        ComplaintDTO newComplaintDTO = new ComplaintDTO(newComplaint.getId(), newComplaint.getText(), newComplaint.getResponse());

        return new ResponseEntity<>(newComplaintDTO, HttpStatus.OK);
    }

    @PostMapping(value = "/centerAdmin/{regUserUsername}/{centerAdminUsername}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('ROLE_REGULAR_USER')")
    public ResponseEntity<ComplaintDTO> createCenterAdminComplaint(@PathVariable String regUserUsername,@PathVariable String centerAdminUsername, @RequestBody ComplaintDTO complaintDTO) throws Exception{
        User user = this.userService.findByUsername(regUserUsername);
        User user2 = this.userService.findByUsername(centerAdminUsername);
        CenterAdministrator centerAdministrator = this.centerAdministratorService.findOne(user2.getId());

        RegularUser regularUser = this.regularUserService.findOne(user.getId());

        Complaint complaint = new Complaint(complaintDTO.getText(), complaintDTO.getResponse());
        complaint.setRegularUser(regularUser);

        complaint.setCenterAdministrator(centerAdministrator);

        Complaint newComplaint = this.complaintService.create(complaint);

        ComplaintDTO newComplaintDTO = new ComplaintDTO(newComplaint.getId(), newComplaint.getText(), newComplaint.getResponse());

        return new ResponseEntity<>(newComplaintDTO, HttpStatus.OK);
    }


    @GetMapping(value = "/allComplaints", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ComplaintDTO>> getAllComplaints(){

        List<Complaint> complaints = this.complaintService.findAll();
        List<ComplaintDTO> complaintDTOs = new ArrayList<>();

        for (Complaint complaint : complaints) {
            ComplaintDTO complaintDTO = new ComplaintDTO(complaint.getId(), complaint.getText(), complaint.getResponse());
            complaintDTOs.add(complaintDTO);
        }
        return new ResponseEntity<>(complaintDTOs, HttpStatus.OK);
    }

    //TODO funkcija koja pronalazi sve termine u buducnosti koji za reg_usera imaju null
    //TODO funkcija koja prima reg_user_username i zakazuje termin za tog usera, prvo proverava jel popunio upitnik, jel dao krv u prethodnih 6 meseci i jel ima 3 penala
    //TODO funkcija koja iz liste zakazanih termina za poslatog korisnika otkazuje termin, dodaje ga u listu termina mogucih za zakazivanje i korisniku poveceva broj penala
}
