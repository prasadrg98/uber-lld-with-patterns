package com.cisco.strategy;

import com.cisco.beans.Driver;
import com.cisco.beans.Location;
import com.cisco.beans.Rider;

public interface DriverMatchingStrategy {
    public Driver matchDriver(Rider rider, Location src, Location dest);
}
