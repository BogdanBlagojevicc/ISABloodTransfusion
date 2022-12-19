package com.example.isa.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.isa.model.Center;
import com.example.isa.model.RegularUser;
import com.example.isa.model.Term;
import com.example.isa.model.User;
import com.example.isa.model.dto.CenterDTO;
import com.example.isa.model.dto.TermDTO;
import com.example.isa.service.CenterService;
import com.example.isa.service.QuestionnaireService;
import com.example.isa.service.RegularUserService;
import com.example.isa.service.TermService;
import com.example.isa.service.UserService;
import com.example.isa.util.TokenUtils;


@CrossOrigin
@RestController
@RequestMapping(value = "/api/terms")
public class TermController {

    private final TermService termService;
    private final CenterService centerService;
    private final QuestionnaireService questionnaireService;
    private final RegularUserService regularUserService;
    private final UserService userService;
    @Autowired
	private  TokenUtils tokenUtils;

    @Autowired
    public TermController(TermService termService, CenterService centerService, QuestionnaireService questionnaireService, RegularUserService regularUserService, UserService userService) {
        this.termService = termService;
        this.regularUserService = regularUserService;
        this.centerService = centerService;
        this.questionnaireService = questionnaireService;
        this.userService = userService;
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
        if (!termService.checkTerm(terms, LocalDateTime.parse(termDTO.getDateTerm()))) {
            throw new Exception("Term already exist");
        }

        Term term = new Term(LocalDateTime.parse(termDTO.getDateTerm()), termDTO.getDuration());
        term.setCenterTerm(center);

        Term newTerm = this.termService.create(term);

        TermDTO newTermDTO = new TermDTO(newTerm.getId(), newTerm.getDateTerm(), newTerm.getDuration());

        return new ResponseEntity<>(newTermDTO, HttpStatus.CREATED);

    }


    @PostMapping(value = "/assign/{termId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAnyRole('ROLE_REGULAR_USER')")
    public ResponseEntity<TermDTO> assignRegularUser(@PathVariable("termId") Long termId, @RequestBody String token) throws Exception {

        Term term = this.termService.findOne(termId);
        if(term == null){
            throw new Exception("This term does not exist");
        }
        System.out.println("***************************************************");
        System.out.println(token);
        System.out.println("***************************************************");

        String username = tokenUtils.getUsernameFromToken(token);


        System.out.println("***************************************************");
        System.out.println(username);
        System.out.println("***************************************************");

        
        User user = this.userService.findByUsername("yy");
        RegularUser regularUser = this.regularUserService.findOne(user.getId());

        term.setRegularUser(regularUser);

        this.termService.update(term);

        TermDTO newTermDTO = new TermDTO();

        return new ResponseEntity<>(newTermDTO, HttpStatus.CREATED);

    }


    @DeleteMapping(value = "/{termId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('ROLE_REGULAR_USER')")
    public ResponseEntity<TermDTO> deleteTerm(@PathVariable("termId") Long termId) throws Exception {

        Term term = this.termService.findOne(termId);

        if (term == null) {
            throw new Exception("This term does not exist!");
        }

        this.termService.delete(term);

        Term tempTerm = new Term(term.getDateTerm(), term.getDuration());
        tempTerm.setCenterTerm(term.getCenterTerm());

        Term newTerm = this.termService.create(tempTerm);

        TermDTO newTermDTO = new TermDTO(newTerm.getId(), newTerm.getDateTerm(), newTerm.getDuration());

        return new ResponseEntity<>(newTermDTO, HttpStatus.CREATED);

    }

    @GetMapping("/order/{centerTerm}")
    @PreAuthorize("hasAnyRole('ROLE_CENTER_ADMINISTRATOR', 'ROLE_REGULAR_USER')")
    public ResponseEntity<List<TermDTO>> findterms(@PathVariable("centerTerm") Long centerTerm) {
        List<Term> terms = this.termService.findByCenterIdOrderByDateTerm(centerTerm);

        List<TermDTO> termDTOS = new ArrayList<>();

        for (Term term : terms) {
            TermDTO termDTO = new TermDTO(term.getId(), term.getDateTerm(), term.getDuration());
            termDTOS.add(termDTO);
        }

        return new ResponseEntity<>(termDTOS, HttpStatus.OK);
    }
    
    @GetMapping(value = "/getAllTermsByRegUserId/{regUserId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TermDTO>> getAllTermsByRegularUserId(@PathVariable Long regUserId){

        List<Term> terms = this.termService.findAllByRegularUserId(regUserId);
        List<TermDTO> termDTOs = new ArrayList<>();

        for(Term term : terms){
            TermDTO termDTO = new TermDTO(
                term.getId(),
                term.getDateTerm(),
                term.getDuration()
            );
            termDTOs.add(termDTO);
        }
        return new ResponseEntity<>(termDTOs, HttpStatus.OK);
    }

    @GetMapping("/availableTerms/{dateTerm}")
    @PreAuthorize("hasAnyRole('ROLE_CENTER_ADMINISTRATOR','ROLE_REGULAR_USER')")
    public ResponseEntity<List<CenterDTO>> checkIfAvailable(@PathVariable("dateTerm") String stringDateTerm) {
        LocalDateTime dateTerm = LocalDateTime.parse(stringDateTerm);

        List<CenterDTO> centerDTOs = new ArrayList<>();
        List<Center> allCenters = centerService.findAll();
        for (Center c : allCenters) {
            List<Term> allTerms = termService.findByCenterIdOrderByDateTerm(c.getId());
            if (termService.checkTerm(allTerms, dateTerm)) {
                centerDTOs.add(
                        new CenterDTO(c.getId(), c.getName(), c.getAddress(), c.getDescription(), c.getAverageGrade(),
                                c.getCountry(), c.getStartTime(), c.getEndTime()));
            }
        }
        return new ResponseEntity<>(centerDTOs, HttpStatus.OK);
    }


    @PostMapping(value = "/scheduleTerm/{centerId}/{dateTerm}/{regUserId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAnyRole('ROLE_REGULAR_USER','ROLE_CENTER_ADMINISTRATOR')")
    public ResponseEntity<TermDTO> createNewTerm(@PathVariable("centerId") Long centerId, @PathVariable("dateTerm") String stringDateTerm,
    @PathVariable("regUserId") Long regUserId)
            throws Exception {

        Center center = centerService.findOne(centerId);

        if (center == null) {
            throw new Exception("This center does not exist");
        }

        if(questionnaireService.findOneByRegularUserId(regUserId) == null){
            throw new Exception("Questionnaire is not filled");
        }
        if(questionnaireService.findOneByRegularUserId(regUserId).getIsPreviousSurgicalInterventionOrBloodDonationMoreThanSixMonths()){
            throw new Exception("User cannot schedule term beacuse he donate blood in previous six months ");
        }
        Term term = new Term(LocalDateTime.parse(stringDateTerm),1);
        term.setCenterTerm(center);

       

        RegularUser regularUser= this.regularUserService.findOne(Long.valueOf(1));
        term.setRegularUser(regularUser);
        Term newTerm = termService.create(term);

        TermDTO newTermDTO = new TermDTO(newTerm.getId(), newTerm.getDateTerm(), newTerm.getDuration());
        return new ResponseEntity<>(newTermDTO, HttpStatus.CREATED);

    }

}
