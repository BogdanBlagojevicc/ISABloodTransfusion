package com.example.isa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.isa.model.Complaint;
import com.example.isa.repository.ComplaintRepository;

@Service
public class ComplaintService {
    
    private final ComplaintRepository complaintRepository;

    @Autowired
    public ComplaintService(ComplaintRepository complaintRepository){
        this.complaintRepository = complaintRepository;
    }

    public Complaint update(Complaint complaint) throws Exception{
        if(complaint.getId() == null){
            throw new Exception("ID can not be null");
        }
        return this.complaintRepository.save(complaint);
    }
}
