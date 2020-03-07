package com.tikal.workshop.fleetman.springspeedservice;


import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.tikal.workshop.fleetman.springspeedservice.model.LocationData;
import com.tikal.workshop.fleetman.springspeedservice.model.SpeedData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.Instant;

import static java.time.temporal.ChronoUnit.MILLIS;
import static java.util.concurrent.TimeUnit.SECONDS;

@Service
public class SpeedService {
    private static final Logger logger = LoggerFactory.getLogger(SpeedService.class);

    @Autowired
    SpeedCalculator speedCalculator;


    @Value("10")
    long cacheExpiresAfterWriteInSec;

    @Value("1000")
    long cacheMaxSize;

    Cache<String, LocationData> lastGpsCache;



    @PostConstruct
    void onStart() {
        lastGpsCache = Caffeine.newBuilder()
                .expireAfterWrite(cacheExpiresAfterWriteInSec, SECONDS)
                .maximumSize(cacheMaxSize)
                .build();
    }

    public SpeedData getSpeedData(LocationData currentLocation) {
        logger.debug("Processing currentLocation {} at {}",currentLocation,Instant.now());
        String imei = currentLocation.getImei();
        LocationData previousLocation = lastGpsCache.getIfPresent(imei);
        SpeedData speedData = null;
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
        lastGpsCache.put(imei,currentLocation);
        logger.debug("CurrentLocationJson {}",currentLocation);
        return speedData;
    }


}
