package com.tikal.workshop.fleetman;

import com.tikal.workshop.fleetman.model.LocationData;
import com.tikal.workshop.fleetman.model.SpeedData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.time.Instant;

import static java.time.temporal.ChronoUnit.MILLIS;

@ApplicationScoped
public class SpeedService {
    private static final Logger logger = LoggerFactory.getLogger(SpeedService.class);

    @Inject
    SpeedCalculator speedCalculator;



    public SpeedData getSpeedData(LocationData[] locations) {
        return getSpeedData(locations[0],locations[1]);
    }

    public SpeedData getSpeedData(LocationData previousLocation, LocationData currentLocation) {
        logger.debug("Processing currentLocation {} at {}",currentLocation,Instant.now());
        String imei = currentLocation.getImei();
        SpeedData speedData = new SpeedData();
        if(previousLocation==null){
            logger.debug("There is no previous location for imei {}. Will not be able to calc speed and azimuth...",imei);
        }else{
            double distance = speedCalculator.distance(previousLocation.getLat(), previousLocation.getLon(), currentLocation.getLat(), currentLocation.getLon(), "K");
            logger.debug("distance:{}",distance);

            double deltaTimeMillis = Instant.parse(previousLocation.getSentTime()).until(Instant.parse(currentLocation.getSentTime()), MILLIS);
            logger.debug("deltaTimeMillis:{}",deltaTimeMillis);

            int speed = (int)(distance/(deltaTimeMillis/(3600d*1000d)));
            int beam = (int) speedCalculator.beamFromCoordinate(previousLocation.getLat(), previousLocation.getLon(), currentLocation.getLat(), currentLocation.getLon());
            speedData = new SpeedData(speed,beam);
        }
        logger.debug("CurrentLocationJson {}",currentLocation);
        return speedData;
    }


}
