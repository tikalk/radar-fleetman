package com.tikal.workshop.fleetman;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;

@Entity
@Table(name = "drivers", indexes =
        { @Index(name="driver_name_idx",columnList = "name",unique = true),
            @Index(name="vehicleId_idx",columnList = "vehicle_id",unique = true)
        })
public class Driver extends PanacheEntity {


    public String name;
    public String photo;

    @Column(name = "vehicle_id")
    public Integer vehicleId;

    public Driver() {
    }

    public Driver(String name, String photo, Integer vehicleId) {
        this.name = name;
        this.photo = photo;
        this.vehicleId = vehicleId;
    }

    public static Driver findByVehicleId(int vehicleId) {
        return Driver.find("vehicleId = ?1",vehicleId).singleResult();
    }
}
