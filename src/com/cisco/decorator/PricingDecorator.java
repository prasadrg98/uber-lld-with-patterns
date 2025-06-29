package com.cisco.decorator;

import com.cisco.strategy.PricingStrategy;

public abstract class PricingDecorator extends PricingStrategy {
    protected PricingStrategy pricingStrategy;

    protected PricingDecorator(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

}
