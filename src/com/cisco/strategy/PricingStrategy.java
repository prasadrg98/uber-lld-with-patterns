package com.cisco.strategy;

import com.cisco.beans.Location;
import com.cisco.enums.Rating;

public abstract class PricingStrategy {
    public abstract double calculatePrice(Location src, Location dest, Rating riderRating, Rating driverRating);

    protected double calculateDistance(Location src, Location dest) {
        // Placeholder for actual distance calculation logic
        return Math.sqrt(Math.pow(dest.getLattitude() - src.getLattitude(), 2) +
                         Math.pow(dest.getLongitude() - src.getLongitude(), 2));
    }
}
