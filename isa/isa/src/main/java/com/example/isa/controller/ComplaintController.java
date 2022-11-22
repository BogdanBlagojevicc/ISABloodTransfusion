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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.isa.model.Complaint;
import com.example.isa.model.dto.ComplaintDTO;
import com.example.isa.service.ComplaintService;
import com.example.isa.service.SystemAdministratorService;

//@CrossOrigin(origins = "http://localhost:63342")
@CrossOrigin
@RestController
@RequestMapping(value = "api/complaint")
public class ComplaintController {
    
    private final ComplaintService complaintService;
    private final SystemAdministratorService systemAdministratorService;

    @Autowired
    public ComplaintController(ComplaintService complaintService, SystemAdministratorService systemAdministratorService){
        this.complaintService = complaintService;
        this.systemAdministratorService = systemAdministratorService;
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
}
