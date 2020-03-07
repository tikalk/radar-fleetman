package com.tikal.workshop.fleetman.springspeedservice;


import com.tikal.workshop.fleetman.springspeedservice.model.LocationData;
import com.tikal.workshop.fleetman.springspeedservice.model.SpeedData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController("/")
public class SpeedResource {

    @Autowired
    SpeedService speedService;

    @PostMapping
    public SpeedData getSpeedData(@RequestBody LocationData locationData){
        return speedService.getSpeedData(locationData);
    }
}