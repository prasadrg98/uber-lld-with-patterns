package com.cisco.strategy;

import com.cisco.beans.Location;
import com.cisco.enums.Rating;

public class BasePricingStrategy extends PricingStrategy {

    @Override
    public double calculatePrice(Location src, Location dest, Rating riderRating, Rating driverRating) {
        // Basic pricing logic: distance + ratings adjustment
        int basePrice = 30;
        double distance = calculateDistance(src, dest);
        return distance * 10  + basePrice; 
    }
    
}
