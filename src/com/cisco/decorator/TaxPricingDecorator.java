package com.cisco.decorator;

import com.cisco.beans.Location;
import com.cisco.enums.Rating;
import com.cisco.strategy.PricingStrategy;

// TaxPricingDecorator.java
public class TaxPricingDecorator extends PricingDecorator {
    public TaxPricingDecorator(PricingStrategy strategy) {
        super(strategy);
    }

    @Override
    public double calculatePrice(Location src, Location dest, Rating riderRating, Rating driverRating) {
        double basePrice = pricingStrategy.calculatePrice(src, dest, riderRating, driverRating);
        return basePrice + 20;
    }
}
