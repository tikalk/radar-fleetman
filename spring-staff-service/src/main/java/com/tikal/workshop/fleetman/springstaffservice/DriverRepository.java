package com.tikal.workshop.fleetman.springstaffservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver, Integer> {

//    @Query("select d from Driver d where d.vehicleId = ?1")
    Driver findByVehicleId(int vehicleId);
}
