package com.cisco.strategy;

import com.cisco.decorator.SurgePricingDecorator;
import com.cisco.decorator.TaxPricingDecorator;

public class StrategyMgr {
    private static StrategyMgr instance;

    private StrategyMgr() {
        // Private constructor to prevent instantiation
    }

    public static StrategyMgr getInstance() {
        if (instance == null) {
            instance = new StrategyMgr();
        }
        return instance;
    }

    public PricingStrategy getPricingStrategy(String strategyType) {
        PricingStrategy basePricingStrategy = new BasePricingStrategy();
        PricingStrategy decoratedStrategy = new SurgePricingDecorator(basePricingStrategy);

        if ("SURGE".equalsIgnoreCase(strategyType)) {
            return decoratedStrategy;
        }

        // Add more strategies as needed
        return new TaxPricingDecorator(decoratedStrategy);
    }

    public DriverMatchingStrategy getDriverMatchingStrategy() {
        // Implement driver matching strategy
        return new NearestDriverMatchingStrategy();
    }

}
