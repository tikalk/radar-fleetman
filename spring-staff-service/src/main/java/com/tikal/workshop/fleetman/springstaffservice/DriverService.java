package com.tikal.workshop.fleetman.springstaffservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import javax.transaction.Transactional;


@RestController
@Transactional
public class DriverService {

    @Autowired
    DriverRepository driverRepository;

    @Autowired
    DataPopulatorService dataPopulatorService;


    @GetMapping
    public Driver getDriver(@RequestParam int vehicleId){
        return driverRepository.findByVehicleId(vehicleId);
    }

    @PutMapping("/init")
    public void init(){
        driverRepository.deleteAll();
        driverRepository.flush();
        dataPopulatorService.populateIfNeeded();
    }

}
