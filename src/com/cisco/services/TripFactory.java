package com.cisco.services;

import com.cisco.beans.Driver;
import com.cisco.beans.Location;
import com.cisco.beans.Rider;
import com.cisco.beans.Trip;
import com.cisco.enums.TripStatus;
import com.cisco.strategy.PricingStrategy;
import com.cisco.strategy.StrategyMgr;

public class TripFactory {

    public Trip createTrip(Rider rider, Location src, Location dest) throws Exception {
        Driver driver = StrategyMgr.getInstance().getDriverMatchingStrategy().matchDriver(rider, src, dest);
        if (driver == null) {
            throw new Exception("No available driver found for the trip.");
        }

        PricingStrategy pricingStrategy = StrategyMgr.getInstance().getPricingStrategy(null);
        if (pricingStrategy == null) {
            throw new Exception("No pricing strategy available.");
        }

        double fare = pricingStrategy.calculatePrice(src, dest, rider.getRating(), driver.getRating());
        Trip trip = new Trip.TripBuilder()
                .setRider(rider)
                .setDriver(driver)
                .setStartLocation(src)
                .setEndLocation(dest)
                .setFare(fare)
                .setStatus(TripStatus.REQUESTED)
                .build();

        driver.setAvailable(false); // Mark driver as unavailable for this trip
        Logger.log("Trip created: " + trip.getTripId());
        NotificationMgr.getInstance().notifyObservers("Trip created: " + trip.getTripId());

        return trip;

    }

}
