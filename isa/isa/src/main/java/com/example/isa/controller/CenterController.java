package com.example.isa.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

@RestController
@RequestMapping(value = "/api/centers")
public class CenterController {

    private final CenterService centerService;
    private final CenterAdministratorService centerAdministratorService;

    @Autowired
    public CenterController(CenterService centerService, CenterAdministratorService centerAdministratorService){
        this.centerService = centerService;
        this.centerAdministratorService = centerAdministratorService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CenterDTO>> getCenters(){
        List<Center> centers = this.centerService.findAll();

        List<CenterDTO> centerDTOS = new ArrayList<>();

        for(Center center : centers){
            CenterDTO centerDTO = new CenterDTO(center.getId(), center.getName(), center.getAddress(), center.getDescription(), center.getAverageGrade(),
            center.getCountry(), center.getStartTime(), center.getEndTime());
            centerDTOS.add(centerDTO);
        }

        return new ResponseEntity<>(centerDTOS, HttpStatus.OK);
        
    }

    @GetMapping("/nameASC")
    public ResponseEntity<List<CenterDTO>> getCentersSortedByNameASC(){
        List<Center> centers = this.centerService.findByOrderByNameAsc();

        List<CenterDTO> centerDTOS = new ArrayList<>();

        for(Center center : centers){
            CenterDTO centerDTO = new CenterDTO(center.getId(), center.getName(), center.getAddress(),center.getDescription(), center.getAverageGrade(),
            center.getCountry(), center.getStartTime(), center.getEndTime());
            centerDTOS.add(centerDTO);
        }

        return new ResponseEntity<>(centerDTOS, HttpStatus.OK);
    }

    
    @GetMapping("/nameDESC")
    public ResponseEntity<List<CenterDTO>> getCentersSortedByNameDESC(){
        List<Center> centers = this.centerService.findByOrderByNameDesc();

        List<CenterDTO> centerDTOS = new ArrayList<>();

        for(Center center : centers){
            CenterDTO centerDTO = new CenterDTO(center.getId(), center.getName(), center.getAddress(),center.getDescription(), center.getAverageGrade(),
            center.getCountry(), center.getStartTime(), center.getEndTime());
            centerDTOS.add(centerDTO);
        }

        return new ResponseEntity<>(centerDTOS, HttpStatus.OK);
    }

    @GetMapping("/averageGradeASC")
    public ResponseEntity<List<CenterDTO>> getCentersSortedByAverageGradeASC(){
        List<Center> centers = this.centerService.findByOrderByAverageGradeAsc();

        List<CenterDTO> centerDTOS = new ArrayList<>();

        for(Center center : centers){
            CenterDTO centerDTO = new CenterDTO(center.getId(), center.getName(), center.getAddress(),center.getDescription(), center.getAverageGrade(),
            center.getCountry(), center.getStartTime(), center.getEndTime());
            centerDTOS.add(centerDTO);
        }

        return new ResponseEntity<>(centerDTOS, HttpStatus.OK);
    }

    
    @GetMapping("/averageGradeDESC")
    public ResponseEntity<List<CenterDTO>> getCentersSortedByAverageGradeDESC(){
        List<Center> centers = this.centerService.findByOrderByAverageGradeDesc();

        List<CenterDTO> centerDTOS = new ArrayList<>();

        for(Center center : centers){
            CenterDTO centerDTO = new CenterDTO(center.getId(), center.getName(), center.getAddress(),center.getDescription(), center.getAverageGrade(),
            center.getCountry(), center.getStartTime(), center.getEndTime());
            centerDTOS.add(centerDTO);
        }

        return new ResponseEntity<>(centerDTOS, HttpStatus.OK);
    }

    
    @GetMapping("/countryASC")
    public ResponseEntity<List<CenterDTO>> getCentersSortedByCountryASC(){
        List<Center> centers = this.centerService.findByOrderByCountryAsc();

        List<CenterDTO> centerDTOS = new ArrayList<>();

        for(Center center : centers){
            CenterDTO centerDTO = new CenterDTO(center.getId(), center.getName(), center.getAddress(),center.getDescription(), center.getAverageGrade(),
            center.getCountry(), center.getStartTime(), center.getEndTime());
            centerDTOS.add(centerDTO);
        }

        return new ResponseEntity<>(centerDTOS, HttpStatus.OK);
    }

    @GetMapping("/countryDESC")
    public ResponseEntity<List<CenterDTO>> getCentersSortedByCountryDESC(){
        List<Center> centers = this.centerService.findByOrderByCountryDesc();

        List<CenterDTO> centerDTOS = new ArrayList<>();

        for(Center center : centers){
            CenterDTO centerDTO = new CenterDTO(center.getId(), center.getName(), center.getAddress(),center.getDescription(), center.getAverageGrade(),
            center.getCountry(), center.getStartTime(), center.getEndTime());
            centerDTOS.add(centerDTO);
        }

        return new ResponseEntity<>(centerDTOS, HttpStatus.OK);
    }

    @PutMapping(value = "/{adminCenterId}/{centerId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CenterDTO> update(@PathVariable Long adminCenterId, @PathVariable Long centerId, @RequestBody CenterDTO centerDTO) throws Exception{

        CenterAdministrator centerAdministrator = this.centerAdministratorService.findOne(adminCenterId);
        if(centerAdministrator == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Center center = new Center(centerDTO.getName(), centerDTO.getAddress(), centerDTO.getDescription(), centerDTO.getAverageGrade(), centerDTO.getCountry(), centerDTO.getStartTime(), centerDTO.getEndTime());

        center.setId(centerId);

        Center updatedCenter = centerService.update(center);

        CenterDTO updatedCenterDTO = new CenterDTO(updatedCenter.getId(), updatedCenter.getName(), updatedCenter.getAddress(), updatedCenter.getDescription(), updatedCenter.getAverageGrade(), updatedCenter.getCountry(), updatedCenter.getStartTime(), updatedCenter.getEndTime());

        return new ResponseEntity<>(updatedCenterDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/grade/{AverageGrade}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CenterDTO> getAVG(@PathVariable("AverageGrade") Double averageGrade){
         
        Center center = this.centerService.findByGrade(averageGrade);
 
        CenterDTO centerDTO = new CenterDTO(center.getId(), center.getName(), center.getDescription(), center.getAverageGrade(),
        center.getCountry(), center.getStartTime(), center.getEndTime(), center.getAddress());
        
 
 
         return new ResponseEntity<>(centerDTO, HttpStatus.OK);
 
    } 
}

