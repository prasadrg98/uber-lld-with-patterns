package com.cisco.decorator;

import com.cisco.beans.Location;
import com.cisco.enums.Rating;
import com.cisco.strategy.PricingStrategy;

public class SurgePricingDecorator extends PricingDecorator {

    public SurgePricingDecorator(PricingStrategy pricingStrategy) {
        super(pricingStrategy);
    }

    @Override
    public double calculatePrice(Location src, Location dest, Rating riderRating, Rating driverRating) {
        double basePrice = pricingStrategy.calculatePrice(src, dest, riderRating, driverRating);
        // Apply surge pricing multiplier
        return basePrice * 1.5; // 50% surge pricing
    }

}
