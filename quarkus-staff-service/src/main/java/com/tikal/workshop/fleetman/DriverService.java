package com.tikal.workshop.fleetman;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;


@Path("/")
@Transactional
public class DriverService {

    @Inject
    DataPopulatorService dataPopulatorService;

    @GET
    @Produces(APPLICATION_JSON)
    public Driver getDriver(@QueryParam("vehicleId") int vehicleId){
        return Driver.findByVehicleId(vehicleId);
    }

    @PUT
    @Path("/init")
    public void init(){
        Driver.deleteAll();
        dataPopulatorService.populateIfNeeded();
    }

}
