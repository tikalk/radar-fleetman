package com.tikal.workshop.fleetman;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.Arrays;

@ApplicationScoped
@Transactional
public class DataPopulatorService {

    private static final Logger logger = LoggerFactory.getLogger(DataPopulatorService.class);


    public void populateIfNeeded() {
        Driver.persist(
                new Driver("Kimberly Eaton","https://fleetman-drivers-photos.s3.eu-west-2.amazonaws.com/1.jpeg",1),
                new Driver("Vera Barnett","https://fleetman-drivers-photos.s3.eu-west-2.amazonaws.com/10.jpeg",10),
                new Driver("Jewel Mitchell","https://fleetman-drivers-photos.s3.eu-west-2.amazonaws.com/11.jpeg",11),
                new Driver("Tammie Hassett","https://fleetman-drivers-photos.s3.eu-west-2.amazonaws.com/12.jpeg",12),
                new Driver("Elise Griglen","https://fleetman-drivers-photos.s3.eu-west-2.amazonaws.com/13.jpeg",13),
                new Driver("Paul Alfano","https://fleetman-drivers-photos.s3.eu-west-2.amazonaws.com/14.jpeg",14),
                new Driver("Virgil Quiggle","https://fleetman-drivers-photos.s3.eu-west-2.amazonaws.com/15.jpeg",15),
                new Driver("Virginia Bryant","https://fleetman-drivers-photos.s3.eu-west-2.amazonaws.com/16.jpeg",16),
                new Driver("Tyrone Pearson","https://fleetman-drivers-photos.s3.eu-west-2.amazonaws.com/17.jpeg",17),
                new Driver("Dorothy Armstrong","https://fleetman-drivers-photos.s3.eu-west-2.amazonaws.com/18.jpeg",18),
                new Driver("Michelle Wilder","https://fleetman-drivers-photos.s3.eu-west-2.amazonaws.com/19.jpeg",19),
                new Driver("Sergio Houghtelling","https://fleetman-drivers-photos.s3.eu-west-2.amazonaws.com/2.jpeg",2),
                new Driver("Ida Montgomery","https://fleetman-drivers-photos.s3.eu-west-2.amazonaws.com/20.jpeg",20),
                new Driver("Ruth Wiggins","https://fleetman-drivers-photos.s3.eu-west-2.amazonaws.com/21.jpeg",21),
                new Driver("Frank Tanner","https://fleetman-drivers-photos.s3.eu-west-2.amazonaws.com/22.jpeg",22),
                new Driver("Bobbie Williamson","https://fleetman-drivers-photos.s3.eu-west-2.amazonaws.com/23.jpeg",23),
                new Driver("Wanda Honeycutt","https://fleetman-drivers-photos.s3.eu-west-2.amazonaws.com/24.jpeg",24),
                new Driver("Ethel Jackson","https://fleetman-drivers-photos.s3.eu-west-2.amazonaws.com/25.jpeg",25),
                new Driver("Elizabeth Barlow","https://fleetman-drivers-photos.s3.eu-west-2.amazonaws.com/26.jpeg",26),
                new Driver("Bessie Engstrom","https://fleetman-drivers-photos.s3.eu-west-2.amazonaws.com/27.jpeg",27),
                new Driver("John Davis","https://fleetman-drivers-photos.s3.eu-west-2.amazonaws.com/28.jpeg",28),
                new Driver("Connie Trivino","https://fleetman-drivers-photos.s3.eu-west-2.amazonaws.com/29.jpeg",29),
                new Driver("Robert Moore","https://fleetman-drivers-photos.s3.eu-west-2.amazonaws.com/3.jpeg",3),
                new Driver("Shanna Krogstad","https://fleetman-drivers-photos.s3.eu-west-2.amazonaws.com/30.jpeg",30),
                new Driver("Kimberly Gray","https://fleetman-drivers-photos.s3.eu-west-2.amazonaws.com/31.jpeg",31),
                new Driver("Robert Morgia","https://fleetman-drivers-photos.s3.eu-west-2.amazonaws.com/32.jpeg",32),
                new Driver("Terrance Reagan","https://fleetman-drivers-photos.s3.eu-west-2.amazonaws.com/33.jpeg",33),
                new Driver("Maria Kittredge","https://fleetman-drivers-photos.s3.eu-west-2.amazonaws.com/34.jpeg",34),
                new Driver("Christopher Smith","https://fleetman-drivers-photos.s3.eu-west-2.amazonaws.com/35.jpeg",35),
                new Driver("Erika Miyata","https://fleetman-drivers-photos.s3.eu-west-2.amazonaws.com/36.jpeg",36),
                new Driver("Irma Thayer","https://fleetman-drivers-photos.s3.eu-west-2.amazonaws.com/37.jpeg",37),
                new Driver("Ruby Pearce","https://fleetman-drivers-photos.s3.eu-west-2.amazonaws.com/38.jpeg",38),
                new Driver("Jack Robinson","https://fleetman-drivers-photos.s3.eu-west-2.amazonaws.com/39.jpeg",39),
                new Driver("Edward Lipscomb","https://fleetman-drivers-photos.s3.eu-west-2.amazonaws.com/4.jpeg",4),
                new Driver("Joan White","https://fleetman-drivers-photos.s3.eu-west-2.amazonaws.com/40.jpeg",40),
                new Driver("Margaret Johnson","https://fleetman-drivers-photos.s3.eu-west-2.amazonaws.com/5.jpeg",5),
                new Driver("Thomas Hofmann","https://fleetman-drivers-photos.s3.eu-west-2.amazonaws.com/6.jpeg",6),
                new Driver("Paul Martinez","https://fleetman-drivers-photos.s3.eu-west-2.amazonaws.com/7.jpeg",7),
                new Driver("Alice Muni","https://fleetman-drivers-photos.s3.eu-west-2.amazonaws.com/8.jpeg",8),
                new Driver("Chad Mathews","https://fleetman-drivers-photos.s3.eu-west-2.amazonaws.com/9.jpeg",9)
        );
    }
}
