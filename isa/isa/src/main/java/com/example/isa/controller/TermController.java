package com.example.isa.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
    public TermController(TermService termService, CenterService centerService) {
        this.termService = termService;
        this.centerService = centerService;
    }

    @PostMapping(value = "/{centerId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('ROLE_CENTER_ADMINISTRATOR')")
    public ResponseEntity<TermDTO> createNewTerm(@PathVariable("centerId") Long centerId, @RequestBody TermDTO termDTO)
            throws Exception {

        Center center = this.centerService.findOne(centerId);

        if (center == null) {
            throw new Exception("This center does not exist");
        }

        List<Term> terms = termService.findAll();
        if (!termService.checkTerm(terms, termDTO.getDateTerm())) {
            throw new Exception("Term already exist");
        }

        Term term = new Term(termDTO.getDateTerm(), termDTO.getDuration());
        term.setCenterTerm(center);

        Term newTerm = this.termService.create(term);

        TermDTO newTermDTO = new TermDTO(newTerm.getId(), newTerm.getDateTerm(), newTerm.getDuration());

        return new ResponseEntity<>(newTermDTO, HttpStatus.CREATED);

    }

    @DeleteMapping(value = "/{termId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('ROLE_REGULAR_USER')")
    public ResponseEntity<TermDTO> deleteTerm(@PathVariable("termId") Long termId) throws Exception{ // mozda bude problem jer pise consumes a nemam request body

        Term term = this.termService.findOne(termId);

        if(term == null){
            throw new Exception("This term does not exist!");
        }

        this.termService.delete(term);

        Term tempTerm = new Term(term.getDateTerm(), term.getDuration());
        tempTerm.setCenterTerm(term.getCenterTerm());

        Term newTerm = this.termService.create(tempTerm);

        TermDTO newTermDTO = new TermDTO(newTerm.getId(), newTerm.getDateTerm(), newTerm.getDuration());

        return new ResponseEntity<>(newTermDTO, HttpStatus.CREATED);

    }   

}