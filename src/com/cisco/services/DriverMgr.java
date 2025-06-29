package com.cisco.services;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import com.cisco.beans.Driver;

public class DriverMgr {
    private static final DriverMgr instance = new DriverMgr();
    private ConcurrentHashMap<String, Driver> drivers = new ConcurrentHashMap<>();
    private DriverMgr() {}

    public static DriverMgr getInstance() {
        return instance;
    }

    public void addDriver(Driver driver) {
        if (driver != null && driver.getEmail() != null) {
            drivers.put(driver.getEmail(), driver);
        }
    }

    public Driver getDriver(String email) {
        return drivers.get(email);
    }

    public ConcurrentMap<String, Driver> getDrivers() {
        return drivers;
    }
}
