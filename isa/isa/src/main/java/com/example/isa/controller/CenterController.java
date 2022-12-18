package com.example.isa.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.isa.model.Center;
import com.example.isa.model.CenterAdministrator;
import com.example.isa.model.dto.CenterDTO;
import com.example.isa.service.CenterAdministratorService;
import com.example.isa.service.CenterService;
import com.example.isa.service.SystemAdministratorService;

import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;

//@CrossOrigin(origins = "http://localhost:63342")
@CrossOrigin
@RestController
@RequestMapping(value = "/api/centers")
public class CenterController {

    private final CenterService centerService;
    private final CenterAdministratorService centerAdministratorService;
    private final SystemAdministratorService systemAdministratorService;

    @Autowired
    public CenterController(CenterService centerService, CenterAdministratorService centerAdministratorService,
            SystemAdministratorService systemAdministratorService) {
        this.centerService = centerService;
        this.centerAdministratorService = centerAdministratorService;
        this.systemAdministratorService = systemAdministratorService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CenterDTO>> getCenters() {
        List<Center> centers = this.centerService.findAll();

        List<CenterDTO> centerDTOS = new ArrayList<>();

        for (Center center : centers) {
            CenterDTO centerDTO = new CenterDTO(center.getId(), center.getName(), center.getAddress(),
                    center.getDescription(), center.getAverageGrade(),
                    center.getCountry(), center.getStartTime(), center.getEndTime());
            centerDTOS.add(centerDTO);
        }

        return new ResponseEntity<>(centerDTOS, HttpStatus.OK);

    }

    @GetMapping("/nameASC")
    @PreAuthorize("hasRole('ROLE_CENTER_ADMINISTRATOR')")
    public ResponseEntity<List<CenterDTO>> getCentersSortedByNameASC() {
        List<Center> centers = this.centerService.findByOrderByNameAsc();

        List<CenterDTO> centerDTOS = new ArrayList<>();

        for (Center center : centers) {
            CenterDTO centerDTO = new CenterDTO(center.getId(), center.getName(), center.getAddress(),
                    center.getDescription(), center.getAverageGrade(),
                    center.getCountry(), center.getStartTime(), center.getEndTime());
            centerDTOS.add(centerDTO);
        }

        return new ResponseEntity<>(centerDTOS, HttpStatus.OK);
    }

    @GetMapping("/nameDESC")
    public ResponseEntity<List<CenterDTO>> getCentersSortedByNameDESC() {
        List<Center> centers = this.centerService.findByOrderByNameDesc();

        List<CenterDTO> centerDTOS = new ArrayList<>();

        for (Center center : centers) {
            CenterDTO centerDTO = new CenterDTO(center.getId(), center.getName(), center.getAddress(),
                    center.getDescription(), center.getAverageGrade(),
                    center.getCountry(), center.getStartTime(), center.getEndTime());
            centerDTOS.add(centerDTO);
        }

        return new ResponseEntity<>(centerDTOS, HttpStatus.OK);
    }

    @GetMapping("/averageGradeASC")
    public ResponseEntity<List<CenterDTO>> getCentersSortedByAverageGradeASC() {
        List<Center> centers = this.centerService.findByOrderByAverageGradeAsc();

        List<CenterDTO> centerDTOS = new ArrayList<>();

        for (Center center : centers) {
            CenterDTO centerDTO = new CenterDTO(center.getId(), center.getName(), center.getAddress(),
                    center.getDescription(), center.getAverageGrade(),
                    center.getCountry(), center.getStartTime(), center.getEndTime());
            centerDTOS.add(centerDTO);
        }

        return new ResponseEntity<>(centerDTOS, HttpStatus.OK);
    }

    @GetMapping("/averageGradeDESC")
    public ResponseEntity<List<CenterDTO>> getCentersSortedByAverageGradeDESC() {
        List<Center> centers = this.centerService.findByOrderByAverageGradeDesc();

        List<CenterDTO> centerDTOS = new ArrayList<>();

        for (Center center : centers) {
            CenterDTO centerDTO = new CenterDTO(center.getId(), center.getName(), center.getAddress(),
                    center.getDescription(), center.getAverageGrade(),
                    center.getCountry(), center.getStartTime(), center.getEndTime());
            centerDTOS.add(centerDTO);
        }

        return new ResponseEntity<>(centerDTOS, HttpStatus.OK);
    }

    @GetMapping("/countryASC")
    public ResponseEntity<List<CenterDTO>> getCentersSortedByCountryASC() {
        List<Center> centers = this.centerService.findByOrderByCountryAsc();

        List<CenterDTO> centerDTOS = new ArrayList<>();

        for (Center center : centers) {
            CenterDTO centerDTO = new CenterDTO(center.getId(), center.getName(), center.getAddress(),
                    center.getDescription(), center.getAverageGrade(),
                    center.getCountry(), center.getStartTime(), center.getEndTime());
            centerDTOS.add(centerDTO);
        }

        return new ResponseEntity<>(centerDTOS, HttpStatus.OK);
    }

    @GetMapping("/countryDESC")
    public ResponseEntity<List<CenterDTO>> getCentersSortedByCountryDESC() {
        List<Center> centers = this.centerService.findByOrderByCountryDesc();

        List<CenterDTO> centerDTOS = new ArrayList<>();

        for (Center center : centers) {
            CenterDTO centerDTO = new CenterDTO(center.getId(), center.getName(), center.getAddress(),
                    center.getDescription(), center.getAverageGrade(),
                    center.getCountry(), center.getStartTime(), center.getEndTime());
            centerDTOS.add(centerDTO);
        }

        return new ResponseEntity<>(centerDTOS, HttpStatus.OK);
    }

    @PutMapping(value = "/{adminCenterId}/{centerId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CenterDTO> update(@PathVariable Long adminCenterId, @PathVariable Long centerId,
            @RequestBody CenterDTO centerDTO) throws Exception {

        CenterAdministrator centerAdministrator = this.centerAdministratorService.findOne(adminCenterId);
        if (centerAdministrator == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Center center = new Center(
                centerDTO.getName(),
                centerDTO.getAddress(),
                centerDTO.getDescription(),
                centerDTO.getAverageGrade(),
                centerDTO.getCountry(),
                centerDTO.getStartTime(),
                centerDTO.getEndTime());

        center.setId(centerId);

        Center updatedCenter = centerService.update(center);

        CenterDTO updatedCenterDTO = new CenterDTO(updatedCenter.getId(), updatedCenter.getName(),
                updatedCenter.getAddress(), updatedCenter.getDescription(), updatedCenter.getAverageGrade(),
                updatedCenter.getCountry(), updatedCenter.getStartTime(), updatedCenter.getEndTime());

        return new ResponseEntity<>(updatedCenterDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/grade/{AverageGrade}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CenterDTO> getAVG(@PathVariable("AverageGrade") Double averageGrade) {

        Center center = this.centerService.findByGrade(averageGrade);

        CenterDTO centerDTO = new CenterDTO(center.getId(), center.getName(), center.getAddress(),
                center.getDescription(), center.getAverageGrade(),
                center.getCountry(), center.getStartTime(), center.getEndTime());

        return new ResponseEntity<>(centerDTO, HttpStatus.OK);

    }

    @PostMapping(value = "/createNewCenter/{SystemAdminId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CenterDTO> createCenter(@PathVariable("SystemAdminId") Long systemAdminId,
            @RequestBody CenterDTO centerDTO) throws Exception {
        if (systemAdministratorService.findOne(systemAdminId) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Center center = new Center(centerDTO.getName(), centerDTO.getAddress(), centerDTO.getDescription(),
                centerDTO.getAverageGrade(), centerDTO.getCountry(), centerDTO.getStartTime(), centerDTO.getEndTime());

        Center newCenter = this.centerService.create(center);

        CenterDTO newCenterDTO = new CenterDTO(newCenter.getId(), newCenter.getName(), newCenter.getAddress(),
                newCenter.getDescription(), newCenter.getAverageGrade(), newCenter.getCountry(),
                newCenter.getStartTime(), newCenter.getEndTime());

        return new ResponseEntity<>(newCenterDTO, HttpStatus.CREATED);
    }

    @GetMapping(value = "/getOneByCentersAdministratorId/{centerAdministratorId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CenterDTO> getByCentersAdministratorId(@PathVariable Long centerAdministratorId)
            throws Exception {

        Center center = this.centerAdministratorService.findOne(centerAdministratorId).getCenterCAS();

        CenterDTO centerDTO = new CenterDTO(
                center.getId(),
                center.getName(),
                center.getAddress(),
                center.getDescription(),
                center.getAverageGrade(),
                center.getCountry(),
                center.getStartTime(),
                center.getEndTime());

        return new ResponseEntity<>(centerDTO, HttpStatus.OK);
    }

    @GetMapping("/filter/{firstnumber}/{secondnumber}")
    public ResponseEntity<List<CenterDTO>> filterCenters(@PathVariable("firstnumber") Double firstnumber,
            @PathVariable("secondnumber") Double secondnumber) {
        List<Center> centers = this.centerService.filterByGrade(firstnumber, secondnumber);

        List<CenterDTO> centerDTOS = new ArrayList<>();

        for (Center center : centers) {
            CenterDTO centerDTO = new CenterDTO(center.getId(), center.getName(), center.getAddress(),
                    center.getDescription(), center.getAverageGrade(),
                    center.getCountry(), center.getStartTime(), center.getEndTime());
            centerDTOS.add(centerDTO);
        }

        return new ResponseEntity<>(centerDTOS, HttpStatus.OK);
    }

}
