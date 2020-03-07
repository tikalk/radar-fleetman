package com.tikal.workshop.fleetman;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.tikal.workshop.fleetman.model.LocationData;
import com.tikal.workshop.fleetman.model.SpeedData;
import io.quarkus.runtime.StartupEvent;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import java.time.Instant;

import static java.time.temporal.ChronoUnit.MILLIS;
import static java.util.concurrent.TimeUnit.SECONDS;

@ApplicationScoped
public class SpeedService {
    private static final Logger logger = LoggerFactory.getLogger(SpeedService.class);

    @Inject
    SpeedCalculator speedCalculator;


    @ConfigProperty(name = "cache.expiresAfterWriteInSec", defaultValue = "10")
    long cacheExpiresAfterWriteInSec;

    @ConfigProperty(name = "cache.maxSize", defaultValue = "30000")
    long cacheMaxSize;

    Cache<String, LocationData> lastGpsCache;





    void onStart(@Observes StartupEvent ev) {
        lastGpsCache = Caffeine.newBuilder()
                .expireAfterWrite(cacheExpiresAfterWriteInSec, SECONDS)
                .maximumSize(cacheMaxSize)
                .build();
    }

    public SpeedData getSpeedData(LocationData currentLocation) {
        logger.debug("Processing currentLocation {} at {}",currentLocation,Instant.now());
        String imei = currentLocation.getImei();
        LocationData previousLocation = lastGpsCache.getIfPresent(imei);
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
        lastGpsCache.put(imei,currentLocation);
        logger.debug("CurrentLocationJson {}",currentLocation);
        return speedData;
    }


}
