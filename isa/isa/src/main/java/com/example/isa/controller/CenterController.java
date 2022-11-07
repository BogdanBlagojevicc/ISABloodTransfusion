package com.example.isa.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.isa.model.Center;
import com.example.isa.model.dto.CenterDTO;
import com.example.isa.service.CenterService;

@RestController
@RequestMapping(value = "/api/centers")
public class CenterController {
    private final CenterService centerService;

    @Autowired
    public CenterController(CenterService centerService){
        this.centerService = centerService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CenterDTO>> getCenters(){
        List<Center> centers = this.centerService.findAll();

        List<CenterDTO> centerDTOS = new ArrayList<>();

        for(Center center : centers){
            CenterDTO centerDTO = new CenterDTO(center.getId(), center.getName(), center.getDescription(), center.getAverageGrade(),
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
            CenterDTO centerDTO = new CenterDTO(center.getId(), center.getName(), center.getDescription(), center.getAverageGrade(),
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
            CenterDTO centerDTO = new CenterDTO(center.getId(), center.getName(), center.getDescription(), center.getAverageGrade(),
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
            CenterDTO centerDTO = new CenterDTO(center.getId(), center.getName(), center.getDescription(), center.getAverageGrade(),
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
            CenterDTO centerDTO = new CenterDTO(center.getId(), center.getName(), center.getDescription(), center.getAverageGrade(),
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
            CenterDTO centerDTO = new CenterDTO(center.getId(), center.getName(), center.getDescription(), center.getAverageGrade(),
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
            CenterDTO centerDTO = new CenterDTO(center.getId(), center.getName(), center.getDescription(), center.getAverageGrade(),
            center.getCountry(), center.getStartTime(), center.getEndTime());
            centerDTOS.add(centerDTO);
        }

        return new ResponseEntity<>(centerDTOS, HttpStatus.OK);
    }

}

