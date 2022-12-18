package com.example.isa.service;

import com.example.isa.model.Center;
import com.example.isa.model.Term;
import com.example.isa.repository.CenterRepository;
import com.example.isa.repository.TermRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CenterService {

    private final CenterRepository centerRepository;
    private final TermService termService;

    @Autowired
    public CenterService(CenterRepository centerRepository, TermService termService){
        this.centerRepository = centerRepository;
        this.termService = termService;
    }

    public List<Center> findAll() {
        return this.centerRepository.findAll();
    }

    public List<Center> findByOrderByNameAsc() {
        return this.centerRepository.findByOrderByNameAsc();
    }

    public List<Center> findByOrderByNameDesc() {
        return this.centerRepository.findByOrderByNameDesc();
    }

    public List<Center> findByOrderByCountryAsc() {
        return this.centerRepository.findByOrderByCountryAsc();
    }

    public List<Center> findByOrderByCountryDesc() {
        return this.centerRepository.findByOrderByCountryDesc();
    }

    public List<Center> findByOrderByAverageGradeAsc() {
        return this.centerRepository.findByOrderByAverageGradeAsc();
    }

    public List<Center> findByOrderByAverageGradeDesc() {
        return this.centerRepository.findByOrderByAverageGradeDesc();
    }

    public Center update(Center center) throws Exception {

        Center centerToUpdate = this.centerRepository.getOne(center.getId());

        if (centerToUpdate == null) {
            throw new Exception("Center doesn't exist");
        }

        if (!center.getName().equals("")) {
            centerToUpdate.setName(center.getName());
        }

        if (!center.getAddress().equals("")) {
            centerToUpdate.setAddress(center.getAddress());
        }

        if (!center.getDescription().equals("")) {
            centerToUpdate.setDescription(center.getDescription());
        }

        if (!center.getCountry().equals("")) {
            centerToUpdate.setCountry(center.getCountry());
        }

        if (center.getStartTime() != null) {
            centerToUpdate.setStartTime(center.getStartTime());
        }

        if (center.getEndTime() != null) {
            centerToUpdate.setEndTime(center.getEndTime());
        }

        Center savedCenter = this.centerRepository.save(centerToUpdate);

        return savedCenter;
    }

    public Center findOne(Long id) {
        Center center = this.centerRepository.getOne(id);
        return center;
    }

    public Center findByNamee(String name) {
        return this.centerRepository.findByName(name);
    }

    public Center findByAddresss(String address) {
        return this.centerRepository.findByAddress(address);
    }

    public Center findByGrade(Double averageGrade) {
        return this.centerRepository.findByAverageGrade(averageGrade);
    }

    public Center create(Center center) throws Exception {
        if (center.getId() != null) {
            throw new Exception("ID must be null");
        }
        return this.centerRepository.save(center);
    }

    public List<Center> filterByGrade(Double firstnumber, Double secondnumber) {
        return this.centerRepository.filterByGrade(firstnumber, secondnumber);
    }

    public Center findOneByTermId(Long termId) throws Exception{
        Term term = this.termService.findOne(termId);
        Center center = this.centerRepository.getById(term.getCenterTerm().getId());
        return center;
    }

}
