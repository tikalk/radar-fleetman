package com.tikal.workshop.fleetman;

import com.tikal.workshop.fleetman.model.LocationData;
import com.tikal.workshop.fleetman.model.SpeedData;
import io.vertx.core.json.JsonObject;
import org.checkerframework.checker.units.qual.Speed;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/")
public class SpeedResource {

    @Inject
    SpeedService speedService;

    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public SpeedData getSpeedData(LocationData[] locations){
        return speedService.getSpeedData(locations);
    }
}