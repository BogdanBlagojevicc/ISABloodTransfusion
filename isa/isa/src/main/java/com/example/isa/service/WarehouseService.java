package com.example.isa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.isa.model.Questionnaire;
import com.example.isa.model.Term;
import com.example.isa.model.Warehouse;
import com.example.isa.repository.QuestionnaireRepository;
import com.example.isa.repository.WarehouseRepository;

@Service
public class WarehouseService {

    private final WarehouseRepository warehouseRepository;
    private final TermService termService;
    private final QuestionnaireService questionnaireService;

    @Autowired
    public WarehouseService(WarehouseRepository warehouseRepository, TermService termService, QuestionnaireService questionnaireService){
        this.warehouseRepository = warehouseRepository;
        this.termService = termService;
        this.questionnaireService = questionnaireService;
    }

    public Warehouse findOneByTermId(Long termId) throws Exception{

        Term term = termService.findOne(termId);

        Warehouse warehouse = warehouseRepository.findOneByCenterWHId(term.getCenterTerm().getId());

        return warehouse;
    }

    public Warehouse update(Warehouse warehouse) throws Exception{

        Warehouse warehouseToUpdate = this.warehouseRepository.getById(warehouse.getId());

        if(warehouseToUpdate == null){
            throw new Exception("Warehouse doesn't exist");
        }

        long id = 1;
        Questionnaire questionnaire = questionnaireService.findOne(id);

        if(questionnaire.getIsFeelsGood() == true && questionnaire.getWeight() > 50){
            warehouseToUpdate.setBloodQuantityA(warehouse.getBloodQuantityA());
            warehouseToUpdate.setBloodQuantityB(warehouse.getBloodQuantityB());
            warehouseToUpdate.setBloodQuantityAB(warehouse.getBloodQuantityAB());
            warehouseToUpdate.setBloodQuantity0(warehouse.getBloodQuantity0());
            warehouseToUpdate.setNeedles(warehouse.getNeedles());
            warehouseToUpdate.setTestTubes(warehouse.getTestTubes());
            warehouseToUpdate.setBandage(warehouse.getBandage());
        }

        Warehouse savedWarehouse = this.warehouseRepository.save(warehouseToUpdate);
        return savedWarehouse;
    }

}
