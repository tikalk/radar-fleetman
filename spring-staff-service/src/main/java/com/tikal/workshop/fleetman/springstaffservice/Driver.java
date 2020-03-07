package com.tikal.workshop.fleetman.springstaffservice;

import javax.persistence.*;

@Entity
@Table(name = "drivers", indexes =
        { @Index(name="driver_name_idx",columnList = "name",unique = true),
            @Index(name="vehicleId_idx",columnList = "vehicleId",unique = true)
        })
public class Driver {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String photo;

    private Integer vehicleId;

    public Driver() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Integer getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Integer vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Driver(String name, String photo, Integer vehicleId) {
        this.name = name;
        this.photo = photo;
        this.vehicleId = vehicleId;
    }

}
