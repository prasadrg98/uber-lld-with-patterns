package com.cisco.strategy;

import com.cisco.beans.Driver;
import com.cisco.beans.Location;
import com.cisco.beans.Rider;
import com.cisco.services.DriverMgr;

public class NearestDriverMatchingStrategy implements DriverMatchingStrategy {

    @Override
    public Driver matchDriver(Rider rider, Location src, Location dest) {
       for (Driver driver: DriverMgr.getInstance().getDrivers().values()) {
            if (driver.getLocation().equals(src) && driver.isAvailable()) {
                // Assuming the driver is available and matches the rider's requirements
                return driver;
            }
        }
        // If no driver is found, return null or throw an exception based on your design choice
        return null;
    }
    
}
