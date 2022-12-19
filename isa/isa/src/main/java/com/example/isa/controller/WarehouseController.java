package com.example.isa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.example.isa.model.Warehouse;
import com.example.isa.model.dto.WarehouseDTO;
import com.example.isa.service.WarehouseService;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/warehouse")
public class WarehouseController {

    private final WarehouseService warehouseService;

    @Autowired
    public WarehouseController(WarehouseService warehouseService){
        this.warehouseService = warehouseService;
    }

    @GetMapping(value = "/getOneByTermId/{termId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WarehouseDTO> getByTermId(@PathVariable Long termId) throws Exception {

        Warehouse warehouse = this.warehouseService.findOneByTermId(termId);

        WarehouseDTO warehouseDTO = new WarehouseDTO(
            warehouse.getBloodQuantityA(),
            warehouse.getBloodQuantityB(),
            warehouse.getBloodQuantityAB(),
            warehouse.getBloodQuantity0(),
            warehouse.getNeedles(),
            warehouse.getTestTubes(),
            warehouse.getBandage()
        );

        return new ResponseEntity<>(warehouseDTO, HttpStatus.OK);
    }

    @PutMapping(value = "/update/{wareHouseId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WarehouseDTO> update(@PathVariable Long wareHouseId, @RequestBody WarehouseDTO warehouseDTO) throws Exception {

        Warehouse warehouse = new Warehouse(
            warehouseDTO.getBloodQuantityA(),
            warehouseDTO.getBloodQuantityB(),
            warehouseDTO.getBloodQuantityAB(),
            warehouseDTO.getBloodQuantity0(),
            warehouseDTO.getNeedles(),
            warehouseDTO.getTestTubes(),
            warehouseDTO.getBandage()
        );

        warehouse.setId(wareHouseId);

        Warehouse updatedWarehouse = warehouseService.update(warehouse);

        WarehouseDTO updatedWarehouseDTO = new WarehouseDTO(
            updatedWarehouse.getBloodQuantityA(),
            updatedWarehouse.getBloodQuantityB(),
            updatedWarehouse.getBloodQuantityAB(),
            updatedWarehouse.getBloodQuantity0(),
            updatedWarehouse.getNeedles(),
            updatedWarehouse.getTestTubes(),
            updatedWarehouse.getBandage()
        );
        
        return new ResponseEntity<>(updatedWarehouseDTO, HttpStatus.OK);
    }



    
}
