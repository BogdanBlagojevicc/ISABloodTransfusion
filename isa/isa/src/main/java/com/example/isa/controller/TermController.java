package com.example.isa.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.isa.model.Center;
import com.example.isa.model.Term;
import com.example.isa.model.dto.TermDTO;
import com.example.isa.service.CenterService;
import com.example.isa.service.TermService;

@CrossOrigin
@RestController
@RequestMapping(value = "api/terms")
public class TermController {

    private final TermService termService;
    private final CenterService centerService;

    @Autowired
    public TermController(TermService termService, CenterService centerService){
        this.termService = termService;
        this.centerService = centerService;
    }

    @PostMapping(value = "/{centerId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('ROLE_CENTER_ADMINISTRATOR')")
    public ResponseEntity<TermDTO> createNewTerm(@PathVariable("centerId") Long centerId, @RequestBody TermDTO termDTO) throws Exception{

        Center center = this.centerService.findOne(centerId);

        if( center == null){
            throw new Exception("This center does not exist");
        }
       
        //SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Term term = new Term(termDTO.getDateTerm(), termDTO.getDuration());
        term.setCenterTerm(center);

        Term newTerm = this.termService.create(term);

        TermDTO newTermDTO = new TermDTO(newTerm.getId(), newTerm.getDateTerm(), newTerm.getDuration());
        System.out.println(newTerm.getRegular_user());
        return new ResponseEntity<>(newTermDTO, HttpStatus.CREATED);


    }
    
    
}
