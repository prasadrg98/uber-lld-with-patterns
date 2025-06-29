package com.cisco.strategy;

import com.cisco.beans.Location;
import com.cisco.enums.Rating;

public class RatingBasedStrategy extends PricingStrategy {

    @Override
    public double calculatePrice(Location src, Location dest, Rating riderRating, Rating driverRating) {
        // Base price calculation
        double basePrice = 10.0; // Base fare
        double distance = calculateDistance(src, dest); // Assume this method calculates distance between two locations

        // Adjust price based on ratings
        // double ratingFactor = (riderRating.getValue() + driverRating.getValue()) / 2.0;
        double ratingFactor = 1.2;
        return basePrice + (distance * ratingFactor);
    }
    
}
